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
		if(cmd.getName().equalsIgnoreCase("skin") || cmd.getName().equalsIgnoreCase("statue")){
			
			if(sender.hasPermission("skins.build")){
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
						//BufferedImage Image2;
						//Image2 = ConvertUtil.convert4(Image1);
						//build(p, Image2);
						build(p, Image1, "east");
					}else{
						p.sendMessage("§4Playername not found!");
					}
				}/*else{ // just for testing purposes
					Player p = (Player)sender;
					BufferedImage Image1;
					BufferedImage Image2;
					try {					
						Image1 = ImageIO.read(new File("ped4.png"));
						//Image2 = ConvertUtil.convert32(Image1);
						
						//File outputfile = new File("ped4_.png");
					    //ImageIO.write(Image2, "png", outputfile);
	
					    
					    // build skin
					    build(p, Image1);
					    
					} catch (IOException e) {
						e.printStackTrace();
					}
				}*/	
			}else{
				sender.sendMessage("§4You don't have permission.");
			}
			
			return true;
		}
		return false;
	}
	
	
	
	private void smooth(Player p, BufferedImage Image2){
		
		//this function only builds skin blocks (wood instead of orange wool)
		//needs the location of a skin
		
		//TODO: smooth function
		/*
		 * /skin [name] -g smooth
		 * 
		 */
	}
	
	
	private void build(Player p, BufferedImage Image2, String direction){
		
		if(direction.equalsIgnoreCase("east")){
			// leg1
			buildPartOfImageEast(p, Image2, 0, 4, 20, 32, "leg1_left");
			buildPartOfImageEast(p, Image2, 4, 8, 20, 32, "leg1_front");
			//buildPartOfImageEast(p, Image2, 8, 12, 20, 32, "leg1_right"); // no need, is IN the statue, not seen from outside
			buildPartOfImageEast(p, Image2, 12, 16, 20, 32, "leg1_behind");
			// leg2
			buildPartOfImageEast(p, Image2, 0, 4, 20, 32, "leg2_left");
			buildPartOfImageEast(p, Image2, 4, 8, 20, 32, "leg2_front");
			//buildPartOfImageEast(p, Image2, 8, 12, 20, 32, "leg2_right");
			buildPartOfImageEast(p, Image2, 0, 4, 20, 32, "leg2_right");
			buildPartOfImageEast(p, Image2, 12, 16, 20, 32, "leg2_behind");
			// body
			buildPartOfImageEast(p, Image2, 16, 20, 20, 32, "body_left");
			buildPartOfImageEast(p, Image2, 20, 28, 20, 32, "body_front");
			buildPartOfImageEast(p, Image2, 28, 32, 20, 32, "body_right");
			buildPartOfImageEast(p, Image2, 32, 40, 20, 32, "body_behind");
			// arm1
			buildPartOfImageEast(p, Image2, 48, 52, 16, 20, "arm1_bottom");
			buildPartOfImageEast(p, Image2, 44, 48, 16, 20, "arm1_top");
			buildPartOfImageEast(p, Image2, 40, 44, 20, 32, "arm1_left");
			buildPartOfImageEast(p, Image2, 44, 48, 20, 32, "arm1_front");
			buildPartOfImageEast(p, Image2, 48, 52, 20, 32, "arm1_right");
			buildPartOfImageEast(p, Image2, 52, 56, 20, 32, "arm1_behind");
			// arm2
			buildPartOfImageEast(p, Image2, 48, 52, 16, 20, "arm2_bottom");
			buildPartOfImageEast(p, Image2, 44, 48, 16, 20, "arm2_top");
			buildPartOfImageEast(p, Image2, 40, 44, 20, 32, "arm2_left");
			buildPartOfImageEast(p, Image2, 44, 48, 20, 32, "arm2_front");
			buildPartOfImageEast(p, Image2, 48, 52, 20, 32, "arm2_right");
			buildPartOfImageEast(p, Image2, 52, 56, 20, 32, "arm2_behind");
			// head
			buildPartOfImageEast(p, Image2, 0, 8, 8, 16, "head_left");
			buildPartOfImageEast(p, Image2, 8, 16, 8, 16, "head_front");
			buildPartOfImageEast(p, Image2, 16, 24, 8, 16, "head_right");
			buildPartOfImageEast(p, Image2, 24, 32, 8, 16, "head_behind");
			buildPartOfImageEast(p, Image2, 8, 16, 0, 8, "head_top");
			buildPartOfImageEast(p, Image2, 16, 24, 0, 8, "head_bottom");	
		}else if(direction.equalsIgnoreCase("west")){
			
		}else if(direction.equalsIgnoreCase("north")){
			
		}else if(direction.equalsIgnoreCase("south")){
			
		}
		//TODO: directions
		/*
		 * /skin [name] -d NORTH/EAST/WEST/SOUTH
		 * /skin [name] -r 90/180/270/360
		 * 
		 */
	}
	
	private void buildPartOfImageEast(Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component){
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm1_bottom")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() - j + max_y - 1);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_top")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() - j + max_y - 1);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() - 4);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
		    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm2_bottom")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() + 11);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() + j - max_y);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_top")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 11);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() + j - max_y);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 11);
			
			//getLogger().info(start.toString());
			//getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
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
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 9,end.getBlockY(), start.getBlockZ() + i - min_x);
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

		Integer r = c.getRed(); // RED
		Integer g = c.getGreen(); // GREEN
		Integer b = c.getBlue(); // BLUE
		
		float[] hsb = new float[3];
		c.RGBtoHSB(r, g, b, hsb);
		
		float h = hsb[0]; // HUE
		float s = hsb[1]; // SATURATION
		float v = hsb[2]; // BRIGHTNESS
		
		if(s > 0.4 && v > 0.2 && h < 0.03333333333){
			ret = "RED";
		}else if(s > 0.4 && v > 0.5 && h > 0.0333333333 && h < 0.1138888888){
			ret = "ORANGE";
		}else if(s > 0.4 && v < 0.5 && v > 0.2 && h > 0.02 && h < 0.15){
			ret = "BROWN";
		}else if(s > 0.4 && v < 0.35 && v > 0.2 && h > 0.969){
			ret = "BROWN";
		}else if(s > 0.4 && v < 0.2 && v > 0.1 && h > 0.079999999 && h < 0.1222222){
			ret = "BROWN";
		}else if(s > 0.8 && v < 0.15 && v > 0.05 && h > 0.079999999 && h < 0.1222222){
			ret = "BROWN";
		}else if(s > 0.4 && v > 0.5 && h > 0.1138888888 && h < 0.1916666666){
			ret = "YELLOW";
		}else if(s > 0.4 && v > 0.2 && v < 0.81 && h > 0.1916666666 && h < 0.3805555555){
			ret = "GREEN";
		}else if(s > 0.4 && v > 0.5 && h > 0.1916666666 && h < 0.3805555555){
			ret = "LIME";
		}else if(s > 0.2 && v > 0.75 && h > 0.1916666666 && h < 0.3805555555){
			ret = "LIME";
		}else if(s > 0.4 && v > 0.4 && h > 0.3805555555 && h < 0.5194444444){
			ret = "LIGHT_BLUE";
		}else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
			ret = "CYAN";
		}else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
			ret = "BLUE";
		}else if(s > 0.6 && v > 0.2 && h > 0.6027777777 && h < 0.6944444444){
			ret = "BLUE";
		}else if(s > 0.4 && v > 0.3 && h > 0.6944444444 && h < 0.8305555555){
			ret = "PURPLE";
		}else if(s > 0.4 && v > 0.4 && h > 0.8305555555 && h < 0.8777777777){
			ret = "MAGENTA";
		}else if(s > 0.3 && v > 0.4 && h > 0.8777777777 && h < 0.9611111111){
			ret = "PINK";
		}else if(s > 0.4 && v > 0.4 && h > 0.9361111111 && h < 1.0000000001){
			ret = "RED";
		}else if(s < 0.1 && v > 0.9){
			ret = "WHITE";
		}else if(s < 0.1 && v < 0.91 && v > 0.7){
			ret = "SILVER";
		}else if(s < 0.1 && v < 0.71 && v > 0.2){
			ret = "SILVER";
		}else if(s < 0.1 && v < 0.21){
			ret = "BLACK";
		}else if(s < 0.3 && v < 0.3 && v > 0.1){
			ret = "GRAY";
		}else if(s < 0.3 && v < 0.11){
			ret = "BLACK";
		}else if(s < 0.7 && v < 0.6){
			ret = "BLACK";
		}else if(v < 0.05){
			ret = "BLACK";
		}else if(s > 0.29 && s < 0.8 && v < 0.11){
			ret = "GRAY";
		}else if(s > 0.29 && s < 0.6 && v < 0.2){
			ret = "GRAY";
		}else{
			ret = "WHITE"; // nothing matched
			getLogger().info(Float.toString(h) + " " + Float.toString(s) + " " + Float.toString(v));
		}
		
		return ret;
	}

	
}
