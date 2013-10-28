package com.comze_instancelabs.skins;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.scheduler.BukkitTask;

import com.comze_instancelabs.skins.Metrics.Graph;

public class MyMetricsUNUSED {
	/*
	 * This is an own Metrics system I built with a little help of Hidendras.
	 * I made this decision because Hidendras host is often down and lagging/throwing errors on the server sometimes.
	 * As this is only one plugin with medium-low popularity, my current host should handle it without problems
	 * -> better plugin performance and better results
	 * 
	 */
	
    private volatile BukkitTask task = null;
    private static Plugin plugin;
    private static int interval = 15; // minutes
	private static String request_url = "http://instancelabs.eu5.org/send.php?";
	private static String request_url_ping = "http://instancelabs.eu5.org/ping.php?";
	public static String uuid = "";
	
	public boolean optout = false;
	
	private final YamlConfiguration configuration;
    private final File configurationFile;
    
	public MyMetricsUNUSED(Plugin p) throws IOException{
		plugin = p;
		
		configurationFile = getConfigFile();
        configuration = YamlConfiguration.loadConfiguration(configurationFile);
        
        configuration.addDefault("opt-out", false);
        configuration.addDefault("uuid", UUID.randomUUID().toString());
        
        if (configuration.get("uuid", null) == null) {
            configuration.options().header("MyMetrics").copyDefaults(true);
            configuration.save(configurationFile);
        }
        
        uuid = configuration.getString("uuid");
        optout = configuration.getBoolean("opt-out");
        
        // if it's not disabled, send info and start ping timer
        if(!optout){
	        send(getInfo(), false);
			start();	
        }

		p.getLogger().info("Initialized MyMetrics v1");
	}
	
	
	public String getInfo(){
		String params = "";
		
		// server specific
		PluginDescriptionFile description = plugin.getDescription();
        String pluginName;
        String pluginVersion;
        String serverVersion;
		try {
			pluginName = URLEncoder.encode(description.getName(), "UTF-8");
			serverVersion = URLEncoder.encode(Bukkit.getVersion(), "UTF-8");
			pluginVersion = URLEncoder.encode(description.getVersion(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			serverVersion = Bukkit.getVersion();
			pluginName = description.getName();
			pluginVersion = description.getVersion();
			plugin.getLogger().info("[MyMetrics] Error while encoding server specific part.");
		}
		
        // os specific
        String osname;
        String osversion;
        String java_version;
        
        try {
        	osname = URLEncoder.encode(System.getProperty("os.name"), "UTF-8");
        	osversion = URLEncoder.encode(System.getProperty("os.version"), "UTF-8");
        	java_version = URLEncoder.encode(System.getProperty("java.version"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			osname = System.getProperty("os.name");
			osversion = System.getProperty("os.version");
			java_version = System.getProperty("java.version");
			plugin.getLogger().info("[MyMetrics] Error while encoding os specific part.");
		}
        
        params = "uuid=" + uuid + "&plugin_name=" + pluginName + "&java_v=" + java_version + "&plugin_v=" + pluginVersion + "&os_name=" + osname + "&os_v=" + osversion + "&game_v=" + serverVersion;
        
		return params;
	}
	
	public String getPlayersInfo(){
		PluginDescriptionFile description = plugin.getDescription();
        String pluginName = description.getName();
        
		int playersOnline = Bukkit.getServer().getOnlinePlayers().length;
		return "uuid=" + uuid + "&players=" + Integer.toString(playersOnline) + "&plugin_name=" + pluginName;
	}
	
    public File getConfigFile() {
        File pluginsFolder = plugin.getDataFolder().getParentFile();
        return new File(new File(pluginsFolder, "MyMetrics"), "config.yml");
    }
	
	private boolean isMineshafterPresent() {
		try {
			Class.forName("mineshafter.MineServer");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*public static byte[] gzip(String input) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzos = null;

        try {
            gzos = new GZIPOutputStream(baos);
            gzos.write(input.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzos != null) try {
                gzos.close();
            } catch (IOException ignore) {
            }
        }

        return baos.toByteArray();
    }*/
	
	
	public void send(String params, boolean ping){
		String request = "";
		if(ping){
			request = this.request_url_ping;
		}else{
			request = this.request_url;
		}
		
		try {
			sendGet(request, params.replace(" ", "%20"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private final String USER_AGENT = "MyMetrics_skins/1.0";
	private void sendGet(String base, String url) throws Exception {
		URL obj = new URL(base + url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + base + url);
		//System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//System.out.println(response.toString());
	}
	
	
	public boolean start() {
            if (task != null) {
                return true;
            }

            task = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new Runnable(){
                public void run() {
                    send(getPlayersInfo(), true);
                }
            }, 0, interval * 1200);

            return true;
    }
	
}
