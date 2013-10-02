package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;


import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
//import org.bukkit.material.Sign;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;





/**
 * 
 * @author instancelabs
 *
 */

public class Main extends JavaPlugin implements Listener {
	
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		
		getConfig().addDefault("config.auto_updating", true);
		getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			// Failed to submit the stats :(
		}
		
		if(getConfig().getBoolean("config.auto_updating")){
        	Updater updater = new Updater(this, "skin-statue-builder", this.getFile(), Updater.UpdateType.DEFAULT, false);
        }
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("skin") && sender.hasPermission("skins.build")){
			if(args.length > 0){
				sender.sendMessage("§3Please don't move for 3 seconds while the skin is being built.");
				BufferedImage Image1 = null;
				boolean cont = true;
				try {
				    URL url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + args[0] + ".png");
				    Image1 = ImageIO.read(url);
				} catch (IOException e) {
					cont = false;
				}
				
				Player p = (Player)sender;
				if(cont){
					BufferedImage Image2;
					Image2 = ConvertUtil.convert4(Image1);
					build(p, Image2);
				}else{
					p.sendMessage("§4Playername not found!");
				}
				
				/*try {
					Image2 = ConvertUtil.convert4(Image1);
					//File outputfile = new File(args[0] + "_.png");
				    //ImageIO.write(Image2, "png", outputfile);
				    build(p, Image2);
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}else{ // just for testing purposes
				Player p = (Player)sender;
				BufferedImage Image1;
				BufferedImage Image2;
				try {					
					Image1 = ImageIO.read(new File("ped4.png"));
					Image2 = ConvertUtil.convert8(Image1);
					
					File outputfile = new File("ped4_.png");
				    ImageIO.write(Image2, "png", outputfile);

				    
				    // build skin
				    build(p, Image2);
				    
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			
			
			return true;
		}
		return false;
	}
	
	
	private void build(Player p, BufferedImage Image2){
		// leg1
		buildPartOfImage(p, Image2, 0, 4, 20, 32, "leg1_left");
		buildPartOfImage(p, Image2, 4, 8, 20, 32, "leg1_front");
		//buildPartOfImage(p, Image2, 8, 12, 20, 32, "leg1_right"); // no need, is IN the statue, not seen from outside
		buildPartOfImage(p, Image2, 12, 16, 20, 32, "leg1_behind");
		// leg2
		buildPartOfImage(p, Image2, 0, 4, 20, 32, "leg2_left");
		buildPartOfImage(p, Image2, 4, 8, 20, 32, "leg2_front");
		//buildPartOfImage(p, Image2, 8, 12, 20, 32, "leg2_right");
		buildPartOfImage(p, Image2, 0, 4, 20, 32, "leg2_right");
		buildPartOfImage(p, Image2, 12, 16, 20, 32, "leg2_behind");
		// body
		buildPartOfImage(p, Image2, 16, 20, 20, 32, "body_left");
		buildPartOfImage(p, Image2, 20, 28, 20, 32, "body_front");
		buildPartOfImage(p, Image2, 28, 32, 20, 32, "body_right");
		buildPartOfImage(p, Image2, 32, 40, 20, 32, "body_behind");
		// arm1
		buildPartOfImage(p, Image2, 40, 44, 20, 32, "arm1_left");
		buildPartOfImage(p, Image2, 44, 48, 20, 32, "arm1_front");
		buildPartOfImage(p, Image2, 48, 52, 20, 32, "arm1_right");
		buildPartOfImage(p, Image2, 52, 56, 20, 32, "arm1_behind");
		// arm2
		buildPartOfImage(p, Image2, 40, 44, 20, 32, "arm2_left");
		buildPartOfImage(p, Image2, 44, 48, 20, 32, "arm2_front");
		buildPartOfImage(p, Image2, 48, 52, 20, 32, "arm2_right");
		buildPartOfImage(p, Image2, 52, 56, 20, 32, "arm2_behind");
		// head
		buildPartOfImage(p, Image2, 0, 8, 8, 16, "head_left");
		buildPartOfImage(p, Image2, 8, 16, 8, 16, "head_front");
		buildPartOfImage(p, Image2, 16, 24, 8, 16, "head_right");
		buildPartOfImage(p, Image2, 24, 32, 8, 16, "head_behind");
		buildPartOfImage(p, Image2, 8, 16, 0, 8, "head_top");
		buildPartOfImage(p, Image2, 16, 24, 0, 8, "head_bottom");
	}
	
	private void buildPartOfImage(Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component){
		if(component.equalsIgnoreCase("leg1_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 11, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ());;
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,p.getLocation().getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg1_front")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() - 12, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 4);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg1_right")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 11, p.getLocation().getBlockZ() + 3);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 3);;
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,start.getBlockZ() );
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("leg1_behind")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 12, p.getLocation().getBlockZ() + 3);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 7);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}
		
		
		if(component.equalsIgnoreCase("leg2_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 11, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 4);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,p.getLocation().getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("leg2_front")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() - 12, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x + 3);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg2_right")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 11, p.getLocation().getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 7);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y, start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg2_behind")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 12, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}
		

		
		if(component.equalsIgnoreCase("body_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ());;
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,p.getLocation().getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("body_front")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 4);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("body_right")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 7);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("body_behind")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm1_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() - 4);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY() - j + max_y,start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_front")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ());
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm1_right")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() - 1);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x,end.getBlockY() - j + max_y,start.getBlockZ() );
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm1_behind")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 3);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm2_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 11);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY() - j + max_y,start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm2_front")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 8);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 12);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x + 3);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_right")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 8);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x - 3,end.getBlockY() - j + max_y, start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_behind")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 8);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 12);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}
		
		
		
		
		
		if(component.equalsIgnoreCase("head_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());;
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,p.getLocation().getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("head_front")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_right")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 7);;
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x - 7,end.getBlockY() - j + max_y,start.getBlockZ() );
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("head_behind")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_top")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX()- j + max_y,end.getBlockY(), start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_bottom")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ() + 8);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[3]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX()- j + max_y,end.getBlockY(), start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}

	}
	
	
	public String getStringFromColor4(Color c){
		String ret = "";

		if(c.equals(Color.BLACK)){
			ret = "BLACK";
		}else if(c.equals(Color.RED)){
			ret = "RED";
		}else if(c.equals(Color.YELLOW)){
			ret = "YELLOW";
		}else if(c.equals(Color.GREEN)){
			ret = "GREEN";
		}else if(c.equals(Color.BLUE)){
			ret = "BLUE";
		}else if(c.equals(Color.CYAN)){
			ret = "CYAN";
		}else if(c.equals(Color.ORANGE)){
			ret = "ORANGE";
		}else if(c.equals(Color.PINK)){
			ret = "PINK";
		}else if(c.equals(new Color(128, 0, 0))){ // DARK RED
			ret = "RED";
		}else{
			ret = "WHITE";
		}
		
		return ret;
	}
	
	
	
	public String getStringFromColor(Color c){
		String ret = "";

		Integer r = c.getRed();
		Integer g = c.getGreen();
		Integer b = c.getBlue();
		
		float[] hsbvals = new float[3];
		c.RGBtoHSB(r, g, b, hsbvals);
		getLogger().info(Float.toString(hsbvals[0]) + " " + Float.toString(hsbvals[1]) + " " + Float.toString(hsbvals[2]));
		
		
		if(r.equals(0) && g.equals(0) && b > 0){
			ret = "BLUE";
		}else if(r.equals(0) && g > 0 && b.equals(0)){
			ret = "GREEN";
		}else{
			ret = "WHITE";
		}
		
		return ret;
	}
	
}
