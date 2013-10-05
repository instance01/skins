package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
	
	
	
	//TODO:
	//FEATURES:
	// [HIGH] cover all colors (1.6 Mio to go)
	// [MEDIUM] directions
	// [MEDIUM] Smooth
	
	
	
	public String newline = System.getProperty("line.separator");
	
	
	public static HashMap<Player, Location> undo = new HashMap<Player, Location>();
	
	
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
					String action = args[0];
					if(action.equalsIgnoreCase("undo")){ // /skin undo
						Player p = null;
						try{
							p = (Player)sender;	
						}catch(Exception e){
							sender.sendMessage("§4Please execute this command ingame.");
						}
						
						if(p != null){
							if(undo.containsKey(p)){
								Location t = undo.get(p);
								undo(p, t, "east");
							}else{
								p.sendMessage("§4I don't have any skins you requested in memory!");
							}
						}
						
					}else if(action.equalsIgnoreCase("smooth")){ // /skin smooth
						//TODO: smooth
						//smooth();
					}else{
						if(args.length > 1){ // /skin [name] [direction]
							//TODO: DIRECTIONS
						}else{ // /skin [name]
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
						}
							
					}
					
				}else{
					sender.sendMessage("§3 -- Skins Help --");
					sender.sendMessage("§3 /skin [name] : §2Builds a skin in the EAST direction");
					sender.sendMessage("§3 /skin [name] [direction] : §2Builds a skin in the provided direction");
					sender.sendMessage("§3 /skin smooth : §2Smoothes the skin");
					sender.sendMessage("§3 /skin undo : §2Undoes the last skin");
					sender.sendMessage("§3 /colortest [start/status] : §2Runs a colortest to determine all currently supported colors");
				}
			}else{
				sender.sendMessage("§4You don't have permission.");
			}
			
			return true;
		}else if(cmd.getName().equalsIgnoreCase("colortest")){ // /colortest
			if(args.length > 0){
				if(args[0].equalsIgnoreCase("start")){ // /colortest start
					poscount = 0;
					negcount = 0;
					Runnable r = new Runnable() {
				        public void run() {
				        	colorTest();
				        }
				    };
				    new Thread(r).start();
				}else if(args[0].equalsIgnoreCase("status")){ // /colortest status
					sender.sendMessage("§2Pos count: " + Integer.toString(poscount));
					sender.sendMessage("§4Neg count: " + Integer.toString(negcount));
				}
			}else{
				sender.sendMessage("§3/colortest start");
				sender.sendMessage("§3/colortest status");
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
	
	
	
	
	private void undo(Player p, Location t, String direction){
		undo.remove(p);
		
		if(direction.equalsIgnoreCase("east")){
			// leg1
			SkinUndo.undoPartOfImageEast(t,  0, 4, 20, 32, "leg1_left");
			SkinUndo.undoPartOfImageEast(t, 4, 8, 20, 32, "leg1_front");
			//buildPartOfImageEast(p, Image2, 8, 12, 20, 32, "leg1_right"); // no need, is IN the statue, not seen from outside
			SkinUndo.undoPartOfImageEast(t, 12, 16, 20, 32, "leg1_behind");
			// leg2
			SkinUndo.undoPartOfImageEast(t, 0, 4, 20, 32, "leg2_left");
			SkinUndo.undoPartOfImageEast(t, 4, 8, 20, 32, "leg2_front");
			//buildPartOfImageEast(p, Image2, 8, 12, 20, 32, "leg2_right");
			SkinUndo.undoPartOfImageEast(t,  0, 4, 20, 32, "leg2_right");
			SkinUndo.undoPartOfImageEast(t,  12, 16, 20, 32, "leg2_behind");
			// body
			SkinUndo.undoPartOfImageEast(t, 16, 20, 20, 32, "body_left");
			SkinUndo.undoPartOfImageEast(t, 20, 28, 20, 32, "body_front");
			SkinUndo.undoPartOfImageEast(t, 28, 32, 20, 32, "body_right");
			SkinUndo.undoPartOfImageEast(t, 32, 40, 20, 32, "body_behind");
			// arm1
			SkinUndo.undoPartOfImageEast(t, 48, 52, 16, 20, "arm1_bottom");
			SkinUndo.undoPartOfImageEast(t, 44, 48, 16, 20, "arm1_top");
			SkinUndo.undoPartOfImageEast(t, 40, 44, 20, 32, "arm1_left");
			SkinUndo.undoPartOfImageEast(t, 44, 48, 20, 32, "arm1_front");
			SkinUndo.undoPartOfImageEast(t, 48, 52, 20, 32, "arm1_right");
			SkinUndo.undoPartOfImageEast(t, 52, 56, 20, 32, "arm1_behind");
			// arm2
			SkinUndo.undoPartOfImageEast(t, 48, 52, 16, 20, "arm2_bottom");
			SkinUndo.undoPartOfImageEast(t, 44, 48, 16, 20, "arm2_top");
			SkinUndo.undoPartOfImageEast(t, 40, 44, 20, 32, "arm2_left");
			SkinUndo.undoPartOfImageEast(t, 44, 48, 20, 32, "arm2_front");
			SkinUndo.undoPartOfImageEast(t, 48, 52, 20, 32, "arm2_right");
			SkinUndo.undoPartOfImageEast(t, 52, 56, 20, 32, "arm2_behind");
			// head
			SkinUndo.undoPartOfImageEast(t, 0, 8, 8, 16, "head_left");
			SkinUndo.undoPartOfImageEast(t, 8, 16, 8, 16, "head_front");
			SkinUndo.undoPartOfImageEast(t, 16, 24, 8, 16, "head_right");
			SkinUndo.undoPartOfImageEast(t, 24, 32, 8, 16, "head_behind");
			SkinUndo.undoPartOfImageEast(t, 8, 16, 0, 8, "head_top");
			SkinUndo.undoPartOfImageEast(t, 16, 24, 0, 8, "head_bottom");
			// hat layers
			SkinUndo.undoPartOfImageEast(t, 32, 40, 8, 16, "hat_left");
			SkinUndo.undoPartOfImageEast(t, 40, 48, 8, 16, "hat_front");
			SkinUndo.undoPartOfImageEast(t, 48, 56, 8, 16, "hat_right");
			SkinUndo.undoPartOfImageEast(t, 56, 64, 8, 16, "hat_behind");
			SkinUndo.undoPartOfImageEast(t, 40, 48, 0, 8, "hat_top");
			//buildPartOfImageEast(p, Image2, 48, 56, 0, 8, "hat_bottom");	// this looks like crap
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
		
		p.sendMessage("§2Undo successful.");
	}
	
	
	private void build(Player p, BufferedImage Image2, String direction){
		undo.put(p, p.getLocation());
		
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
			// hat layers
			buildPartOfImageEast(p, Image2, 32, 40, 8, 16, "hat_left");
			buildPartOfImageEast(p, Image2, 40, 48, 8, 16, "hat_front");
			buildPartOfImageEast(p, Image2, 48, 56, 8, 16, "hat_right");
			buildPartOfImageEast(p, Image2, 56, 64, 8, 16, "hat_behind");
			buildPartOfImageEast(p, Image2, 40, 48, 0, 8, "hat_top");
			//buildPartOfImageEast(p, Image2, 48, 56, 0, 8, "hat_bottom");	// this looks like crap
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
		
		p.sendMessage("§2Finished building the skin!");
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
		
		
		
		
		
		
		if(component.equalsIgnoreCase("hat_left")){
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
		    		
		    		if(!isTransparent(bi, i, j)){
			    		Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 8,end.getBlockY() - j + max_y,p.getLocation().getBlockZ() - 1);
						//getLogger().info(change.getLocation().toString());
			    		change.setType(Material.WOOL);
						change.setData(DyeColor.BLACK.getData());
						change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("hat_front")){
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
		    		
		    		if(!isTransparent(bi, i, j)){
			    		Block change = p.getWorld().getBlockAt(start.getBlockX() - 1,end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
						//getLogger().info(change.getLocation().toString());
			    		change.setType(Material.WOOL);
			    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());	
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("hat_right")){
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
		    		
		    		if(!isTransparent(bi, i, j)){
			    		Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x - 7,end.getBlockY() - j + max_y,start.getBlockZ() + 1);
						//getLogger().info(change.getLocation().toString());
			    		change.setType(Material.WOOL);
			    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());	
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("hat_behind")){
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
		    		
		    		if(!isTransparent(bi, i, j)){
			    		Block change = p.getWorld().getBlockAt(start.getBlockX() + 1,end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
						//getLogger().info(change.getLocation().toString());
			    		change.setType(Material.WOOL);
			    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());	
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("hat_top")){
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
		    		
		    		if(!isTransparent(bi, i, j)){
			    		Block change = p.getWorld().getBlockAt(start.getBlockX()- j + max_y,end.getBlockY() + 1, start.getBlockZ() + i - min_x);
						//getLogger().info(change.getLocation().toString());
			    		change.setType(Material.WOOL);
			    		change.setData(DyeColor.valueOf(getStringFromColor(c)).getData());	
		    		}
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
		}else if(s > 0.4 && v < 0.51 && v > 0.1 && h > 0.1138888888 && h < 0.1916666666){ // new
			ret = "BROWN";
		}else if(s > 0.4 && v > 0.2 && v < 0.81 && h > 0.1916666666 && h < 0.3805555555){
			ret = "GREEN";
		}else if(s > 0.4 && v > 0.5 && h > 0.1916666666 && h < 0.3805555555){
			ret = "LIME";
		}else if(s > 0.2 && v > 0.75 && h > 0.1916666666 && h < 0.3805555555){
			ret = "LIME";
		}else if(s > 0.4 && v > 0.6 && h > 0.3805555555 && h < 0.5194444444){ // v > 0.4
			ret = "LIGHT_BLUE";
		}else if(s > 0.4 && v < 0.61 && v > 0.2 && h > 0.3805555555 && h < 0.6027777777){ // new
			ret = "CYAN";
		}else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
			ret = "CYAN";
		}else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
			ret = "BLUE";
		}else if(s > 0.2 && s < 0.6 && v > 0.1 && h > 0.6027777777 && h < 0.6944444444){ // new
			ret = "LIGHT_BLUE";
		}else if(s > 0.6 && v > 0.1 && h > 0.6027777777 && h < 0.6944444444){
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
		}else if(v < 0.1){ // 0.05
			ret = "BLACK";
		}else if(s > 0.29 && s < 0.8 && v < 0.11){
			ret = "GRAY";
		}else if(s > 0.29 && s < 0.6 && v < 0.2){
			ret = "GRAY";
		}else{
			ret = "WHITE"; // nothing matched
			//getLogger().info(Float.toString(h) + " " + Float.toString(s) + " " + Float.toString(v));
		}
		
		return ret;
	}
	
	
	int poscount;
	int negcount;


	public void colorTest(){
		for(int r = 0; r <= 255; r++){
			for(int g = 0; g <= 255; g++){
				for(int b = 0; b <= 255; b++){
					Color c = new Color(r, g, b);
					if(getStringFromColorTEST(c)){
						poscount += 1;
					}else{
						negcount += 1;
					}
				}
			}
		}
		
		getLogger().info("Colortest finished.");
	}
	
	
	
	public void colorTestLog(){
		File log = new File("colors.txt");
        if (!log.exists()){
        	try {
        		log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

		for(int r = 0; r <= 255; r++){
			for(int g = 0; g <= 255; g++){
				for(int b = 0; b <= 255; b++){
					Color c = new Color(r, g, b);
					if(getStringFromColorTEST(c)){
						poscount += 1;
					}else{
						negcount += 1;
												
						float[] hsb = new float[3];
						c.RGBtoHSB(r, g, b, hsb);
						
						float h = hsb[0]; // HUE
						float s = hsb[1]; // SATURATION
						float v = hsb[2]; // BRIGHTNESS
						
						try {
							java.io.PrintWriter pw = new PrintWriter(new FileWriter(log, true));
							pw.write("[RGB]" + Integer.toString(c.getRed()) + "|" + Integer.toString(c.getGreen()) + "|" + Integer.toString(c.getBlue()) + "[HSB]" + Float.toString(h) + "|" + Float.toString(s) + "|" + Float.toString(v) + newline);
							pw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		getLogger().info("Colortest finished.");
	}
	
	
	public boolean getStringFromColorTEST(Color c){
		boolean ret = false;

		Integer r = c.getRed(); // RED
		Integer g = c.getGreen(); // GREEN
		Integer b = c.getBlue(); // BLUE
		
		float[] hsb = new float[3];
		c.RGBtoHSB(r, g, b, hsb);
		
		float h = hsb[0]; // HUE
		float s = hsb[1]; // SATURATION
		float v = hsb[2]; // BRIGHTNESS
		
		if(s > 0.4 && v > 0.2 && h < 0.03333333333){
			ret = true;
		}else if(s > 0.4 && v > 0.5 && h > 0.0333333333 && h < 0.1138888888){
			ret = true;
		}else if(s > 0.4 && v < 0.5 && v > 0.2 && h > 0.02 && h < 0.15){
			ret = true;
		}else if(s > 0.4 && v < 0.35 && v > 0.2 && h > 0.969){
			ret = true;
		}else if(s > 0.4 && v < 0.2 && v > 0.1 && h > 0.079999999 && h < 0.1222222){
			ret = true;
		}else if(s > 0.8 && v < 0.15 && v > 0.05 && h > 0.079999999 && h < 0.1222222){
			ret = true;
		}else if(s > 0.4 && v > 0.5 && h > 0.1138888888 && h < 0.1916666666){
			ret = true;
		}else if(s > 0.4 && v < 0.51 && v > 0.1 && h > 0.1138888888 && h < 0.1916666666){ // new
			ret = true;
		}else if(s > 0.4 && v > 0.2 && v < 0.81 && h > 0.1916666666 && h < 0.3805555555){
			ret = true;
		}else if(s > 0.4 && v > 0.5 && h > 0.1916666666 && h < 0.3805555555){
			ret = true;
		}else if(s > 0.2 && v > 0.75 && h > 0.1916666666 && h < 0.3805555555){
			ret = true;
		}else if(s > 0.4 && v > 0.6 && h > 0.3805555555 && h < 0.5194444444){
			ret = true;
		}else if(s > 0.4 && v < 0.61 && v > 0.2 && h > 0.3805555555 && h < 0.6027777777){ // new
			ret = true;
		}else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
			ret = true;
		}else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
			ret = true;
		}else if(s > 0.6 && v > 0.1 && h > 0.6027777777 && h < 0.6944444444){
			ret = true;
		}else if(s > 0.2 && s < 0.6 && v > 0.1 && h > 0.6027777777 && h < 0.6944444444){ // new
			ret = true;
		}else if(s > 0.4 && v > 0.3 && h > 0.6944444444 && h < 0.8305555555){
			ret = true;
		}else if(s > 0.4 && v > 0.4 && h > 0.8305555555 && h < 0.8777777777){
			ret = true;
		}else if(s > 0.3 && v > 0.4 && h > 0.8777777777 && h < 0.9611111111){
			ret = true;
		}else if(s > 0.4 && v > 0.4 && h > 0.9361111111 && h < 1.0000000001){
			ret = true;
		}else if(s < 0.1 && v > 0.9){
			ret = true;
		}else if(s < 0.1 && v < 0.91 && v > 0.7){
			ret = true;
		}else if(s < 0.1 && v < 0.71 && v > 0.2){
			ret = true;
		}else if(s < 0.1 && v < 0.21){
			ret = true;
		}else if(s < 0.3 && v < 0.3 && v > 0.1){
			ret = true;
		}else if(s < 0.3 && v < 0.11){
			ret = true;
		}else if(s < 0.7 && v < 0.6){
			ret = true;
		}else if(v < 0.1){
			ret = true;
		}else if(s > 0.29 && s < 0.8 && v < 0.11){
			ret = true;
		}else if(s > 0.29 && s < 0.6 && v < 0.2){
			ret = true;
		}else{
			ret = false; // nothing matched
			//getLogger().info(Float.toString(h) + " " + Float.toString(s) + " " + Float.toString(v));
		}
		
		return ret;
	}
	
	
	public boolean isTransparent(BufferedImage img, int x, int y) {
		int pixel = img.getRGB(x, y);
		if ((pixel >> 24) == 0x00) {
			return true;
		}
		return false;
	}
	
}
