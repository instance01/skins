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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
	// [HIGH] cover all colors (1.12 Mio to go)
	
	
	
	public String newline = System.getProperty("line.separator");
	
	
	public static HashMap<Player, Location> undoloc = new HashMap<Player, Location>();
	public static HashMap<Player, String> undoskin = new HashMap<Player, String>();
	public static HashMap<Player, String> undodir = new HashMap<Player, String>();
	
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
		
		
		// own metrics system, still in testing
		// will replace Hidendras metrics system (above) with this one, if it works
		try {
			MyMetrics m = new MyMetrics(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(getConfig().getBoolean("config.auto_updating")){
        	Updater updater = new Updater(this, 66523, this.getFile(), Updater.UpdateType.DEFAULT, false);
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
							if(undoloc.containsKey(p)){
								Location t = undoloc.get(p);
								String direction = undodir.get(p);
								undo(p, t, direction);
							}else{
								p.sendMessage("§4I don't have any skins you requested in memory!");
							}
						}
						
					}else if(action.equalsIgnoreCase("smooth")){ // /skin smooth
						if(args.length > 1){
							if(args[1].equalsIgnoreCase("clay")){ // skin smooth clay
								Player p = null;
								try{
									p = (Player)sender;
								}catch(Exception e){
									sender.sendMessage("§4Please execute this command ingame.");
								}
								
								if(p != null){
									if(undoloc.containsKey(p)){
										Location t = undoloc.get(p);
										String skin = undoskin.get(p);
										String dir = undodir.get(p);
										boolean cont = true;
										BufferedImage Image1 = null;
										try {
										    URL url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + skin + ".png");
										    Image1 = ImageIO.read(url);
										} catch (IOException e) {
											cont = false;
										}
		
										if(cont){
											buildclay(p, Image1, skin, dir);
										}else{
											p.sendMessage("§4Playername not found!");
										}
										
									}
								}		
							}else{
								sender.sendMessage("§2Possible smooth types: [clay]. Usage: §3/skin mooth §4or §3/skin smooth clay");
							}
						}else{
							Player p = null;
							try{
								p = (Player)sender;
							}catch(Exception e){
								sender.sendMessage("§4Please execute this command ingame.");
							}
							
							if(p != null){
								if(undoloc.containsKey(p)){
									Location t = undoloc.get(p);
									String skin = undoskin.get(p);
									String dir = undodir.get(p);
									boolean cont = true;
									BufferedImage Image1 = null;
									try {
									    URL url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + skin + ".png");
									    Image1 = ImageIO.read(url);
									} catch (IOException e) {
										cont = false;
									}
	
									if(cont){
										smooth(t, Image1, dir);
									}else{
										p.sendMessage("§4Playername not found!");
									}
									
								}
							}	
						}
						
						
					}else{
						if(args.length > 1){ // /skin [name] [direction]
							Player p = null;
							try{
								p = (Player)sender;	
							}catch(Exception e){
								sender.sendMessage("§4Please execute this command ingame.");
								return true;
							}
							
							String direction = args[1];
							String name = args[0];
							sender.sendMessage("§3Please don't move for§4 3 §3seconds while the skin is being built.");
							BufferedImage Image1 = null;
							boolean cont = true;
							try {
								URL url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + args[0] + ".png");
							    /*if(name.equalsIgnoreCase("steve")){
							    	url = new URL("http://minecraft.net/images/char.png");
							    }else{
							    	url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + args[0] + ".png");
							    }*/
								
							    Image1 = ImageIO.read(url);
							} catch (IOException e) {
								cont = false;
							}
							
							if(cont){
								List<String> places = Arrays.asList("east", "west", "south", "north", "e", "w", "s", "n");
								if(places.contains(direction)){
									build(p, Image1, args[0], direction);
								}else{
									sender.sendMessage("§2Usage: /skins [name] [direction: east, west, north, south]. §3Example: /skin InstanceLabs south");
								}
							}else{
								p.sendMessage("§4Playername not found!");
							}
						}else{ // /skin [name]
							Player p = null;
							try{
								p = (Player)sender;	
							}catch(Exception e){
								sender.sendMessage("§4Please execute this command ingame.");
								return true;
							}
							
							String name = args[0];
							sender.sendMessage("§3Please don't move for 3 seconds while the skin is being built.");
							BufferedImage Image1 = null;
							boolean cont = true;
							try {
								URL url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + args[0] + ".png");
								/*if(name.equalsIgnoreCase("steve")){
							    	url = new URL("http://minecraft.net/images/char.png");
							    }else{
							    	url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + args[0] + ".png");
							    }*/
							    
							    Image1 = ImageIO.read(url);
							} catch (IOException e) {
								cont = false;
							}
							
							if(cont){
								String look_direction = getDirection(p.getLocation().getYaw());
								if(look_direction != null){
									build(p, Image1, args[0], look_direction); // builds in direction player is facing
								}else{
									build(p, Image1, args[0], "east");
								}
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
				}else if(args[0].equalsIgnoreCase("startwithlog")){ // /colortest startwithlog
					poscount = 0;
					negcount = 0;
					Runnable r = new Runnable() {
				        public void run() {
				        	colorTestLog();
				        }
				    };
				    new Thread(r).start();
				}else if(args[0].equalsIgnoreCase("status")){ // /colortest status
					sender.sendMessage("§2Pos count: " + Integer.toString(poscount));
					sender.sendMessage("§4Neg count: " + Integer.toString(negcount));
				}else if(args[0].equalsIgnoreCase("punchcard")){ // /colortest punchcard
					sender.sendMessage("§3Building Punchcard . . .");
					Runnable r = new Runnable() {
				        public void run() {
				        	createPunchcard();
				        }
				    };
				    new Thread(r).start();
				}
			}else{
				sender.sendMessage("§3/colortest start");
				sender.sendMessage("§3/colortest status");
			}
			return true;
		}
		return false;
	}
	
	
	
	private void smooth(Location t, BufferedImage Image2, String direction){
		
		Location c = t;
		//this function only builds skin blocks (wood instead of orange wool)
		//needs the location of a skin
		
		if(direction.equalsIgnoreCase("east")){
			// leg1
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 0, 4, 20, 32, "leg1_left");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 4, 8, 20, 32, "leg1_front");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 12, 16, 20, 32, "leg1_behind");
			// leg2
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 0, 4, 20, 32, "leg2_left");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 4, 8, 20, 32, "leg2_front");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 0, 4, 20, 32, "leg2_right");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 12, 16, 20, 32, "leg2_behind");
			// body
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 16, 20, 20, 32, "body_left");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 20, 28, 20, 32, "body_front");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 28, 32, 20, 32, "body_right");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 32, 40, 20, 32, "body_behind");
			// arm1
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 44, 48, 16, 20, "arm1_top");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 40, 44, 20, 32, "arm1_left");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 44, 48, 20, 32, "arm1_front");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 48, 52, 20, 32, "arm1_right");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 52, 56, 20, 32, "arm1_behind");
			// arm2
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 44, 48, 16, 20, "arm2_top");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 40, 44, 20, 32, "arm2_left");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 44, 48, 20, 32, "arm2_front");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 48, 52, 20, 32, "arm2_right");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 52, 56, 20, 32, "arm2_behind");
			// head
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 0, 8, 8, 16, "head_left");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 16, 24, 8, 16, "head_right");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 24, 32, 8, 16, "head_behind");
			//SkinSmooth.smoothPartOfImageEast(this, t, Image2, 8, 16, 0, 8, "head_top");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 16, 24, 0, 8, "head_bottom");
			SkinSmooth.smoothPartOfImageEast(this, t, Image2, 8, 16, 8, 16, "head_front");
		}else if(direction.equalsIgnoreCase("west")){
			// leg1_left
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 0, 4, 20, 32, new Location(c.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ()));
			// leg1_front
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 4, 8, 20, 32, new Location(c.getWorld(), c.getBlockX() - 2, c.getBlockY(), c.getBlockZ()));
			// leg1_ behind
			SkinSmooth.smoothWestFrontInvert(this, c.getWorld(), Image2, 12, 16, 20, 32, new Location(c.getWorld(), c.getBlockX() - 5, c.getBlockY(), c.getBlockZ() + 1));
			// leg2
			// leg2_right
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 0, 4, 20, 32, new Location(c.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ() - 7));
			// leg2_ front
			SkinSmooth.smoothWestFrontInvert(this, c.getWorld(), Image2, 4, 8, 20, 32, new Location(c.getWorld(), c.getBlockX() - 2, c.getBlockY(), c.getBlockZ() - 3));
			// leg2_behind
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 12, 16, 20, 32, new Location(c.getWorld(), c.getBlockX() - 5, c.getBlockY(), c.getBlockZ() - 4));
			// body
			// body_front
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 20, 28, 20, 32, new Location(c.getWorld(), c.getBlockX() -+ 2, c.getBlockY() + 12, c.getBlockZ()));
			// body_behind
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 32, 40, 20, 32, new Location(c.getWorld(), c.getBlockX() -+ 5, c.getBlockY() + 12, c.getBlockZ()));
			// arm1
			SkinSmooth.smoothPartOfImageWest(this, t, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinSmooth.smoothPartOfImageWest(this, t, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 40, 44, 20, 32, new Location(c.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm1_front
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 44, 48, 20, 32, new Location(c.getWorld(), c.getBlockX() - 2, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm1_right
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 48, 52, 20, 32, new Location(c.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_behind
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 52, 56, 20, 32, new Location(c.getWorld(), c.getBlockX() - 5, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm2
			SkinSmooth.smoothPartOfImageWest(this, t, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinSmooth.smoothPartOfImageWest(this, t, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 40, 44, 20, 32, new Location(c.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 11));
			// arm2_front
			SkinSmooth.smoothWestFrontInvert(this, c.getWorld(), Image2, 44, 48, 20, 32, new Location(c.getWorld(), c.getBlockX() - 2, c.getBlockY() + 12, c.getBlockZ() - 7));
			// arm2_right
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 48, 52, 20, 32, new Location(c.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 8));
			// arm2_behind
			SkinSmooth.smoothWestFrontInvert(this, c.getWorld(), Image2, 52, 56, 20, 32, new Location(c.getWorld(), c.getBlockX() - 5, c.getBlockY() + 12, c.getBlockZ() - 7));
			// head
			// head_left
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 0, 8, 8, 16, new Location(c.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ()));
			// head_right
			SkinSmooth.smoothWestSide(this, c.getWorld(), Image2, 16, 24, 8, 16, new Location(c.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ() - 7));
			// head_behind
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 24, 32, 8, 16, new Location(c.getWorld(), c.getBlockX() - 7, c.getBlockY() + 24, c.getBlockZ()));
			// head_top and head_bottom
			SkinSmooth.smoothPartOfImageWest(this, t, Image2, 8, 16, 0, 8, "head_top");
			SkinSmooth.smoothPartOfImageWest(this, t, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinSmooth.smoothWestFront(this, c.getWorld(), Image2, 8, 16, 8, 16, new Location(c.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
		}else if(direction.equalsIgnoreCase("south")){
			// leg1_left
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 0, 4, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() + 1));
			// leg1_front
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 4, 8, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() + 2));
			// leg1_ behind
			SkinSmooth.smoothSouthFrontInvert(this, t.getWorld(), Image2, 12, 16, 20, 32, new Location(t.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ() + 5));
			// leg2
			// leg2_right
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 0, 4, 20, 32, new Location(t.getWorld(), c.getBlockX() - 7, c.getBlockY(), c.getBlockZ() + 1));
			// leg2_ front
			SkinSmooth.smoothSouthFrontInvert(this, t.getWorld(), Image2, 4, 8, 20, 32, new Location(t.getWorld(), c.getBlockX() - 3, c.getBlockY(), c.getBlockZ() + 2));
			// leg2_behind
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 12, 16, 20, 32, new Location(t.getWorld(), c.getBlockX() - 4, c.getBlockY(), c.getBlockZ() + 5));
			// body
			// body_front
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 20, 28, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() + 2));
			// body_behind
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 32, 40, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() + 5));
			// arm1
			SkinSmooth.smoothPartOfImageSouth(this, t, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinSmooth.smoothPartOfImageSouth(this, t, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 40, 44, 20, 32, new Location(t.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_front
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 44, 48, 20, 32, new Location(t.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 2));
			// arm1_right
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 48, 52, 20, 32, new Location(t.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_behind
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 52, 56, 20, 32, new Location(t.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 5));
			// arm2
			SkinSmooth.smoothPartOfImageSouth(this, t, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinSmooth.smoothPartOfImageSouth(this, t, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 40, 44, 20, 32, new Location(t.getWorld(), c.getBlockX() - 11, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm2_front
			SkinSmooth.smoothSouthFrontInvert(this, t.getWorld(), Image2, 44, 48, 20, 32, new Location(t.getWorld(), c.getBlockX() - 7, c.getBlockY() + 12, c.getBlockZ() + 2));
			// arm2_right
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 48, 52, 20, 32, new Location(t.getWorld(), c.getBlockX() - 8, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm2_behind
			SkinSmooth.smoothSouthFrontInvert(this, t.getWorld(), Image2, 52, 56, 20, 32, new Location(t.getWorld(), c.getBlockX() - 7, c.getBlockY() + 12, c.getBlockZ() + 5));
			// head
			// head_left
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 0, 8, 8, 16, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 1));
			// head_right
			SkinSmooth.smoothSouthSide(this, t.getWorld(), Image2, 16, 24, 8, 16, new Location(t.getWorld(), c.getBlockX() - 7, c.getBlockY() + 24, c.getBlockZ() - 1));
			// head_behind
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 24, 32, 8, 16, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 7));
			SkinSmooth.smoothPartOfImageSouth(this, t, Image2, 8, 16, 0, 8, "head_top");
			SkinSmooth.smoothPartOfImageSouth(this, t, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinSmooth.smoothSouthFront(this, t.getWorld(), Image2, 8, 16, 8, 16, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
		}else if(direction.equalsIgnoreCase("north")){
			// leg1_left
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 0, 4, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() - 1));
			// leg1_front
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 4, 8, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() - 2));
			// leg1_behind
			SkinSmooth.smoothNorthFrontInvert(this, t.getWorld(), Image2, 12, 16, 20, 32, new Location(t.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ() - 5));
			// leg2
			// leg2_right
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 0, 4, 20, 32, new Location(t.getWorld(), c.getBlockX() + 7, c.getBlockY(), c.getBlockZ() - 1));
			// leg2_ front
			SkinSmooth.smoothNorthFrontInvert(this, t.getWorld(), Image2, 4, 8, 20, 32, new Location(t.getWorld(), c.getBlockX() + 3, c.getBlockY(), c.getBlockZ() - 2));
			// leg2_behind
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 12, 16, 20, 32, new Location(t.getWorld(), c.getBlockX() + 4, c.getBlockY(), c.getBlockZ() - 5));
			// body
			// body_front
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 20, 28, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() - 2));
			// body_behind
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 32, 40, 20, 32, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() - 5));
			// arm1
			// arm1_bottom and arm1_top
			SkinSmooth.smoothPartOfImageNorth(this, t, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinSmooth.smoothPartOfImageNorth(this, t, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 40, 44, 20, 32, new Location(t.getWorld(), c.getBlockX() - 4, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_front
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 44, 48, 20, 32, new Location(t.getWorld(), c.getBlockX()  - 4, c.getBlockY() + 12, c.getBlockZ() - 2));
			// arm1_right
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 48, 52, 20, 32, new Location(t.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_behind
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 52, 56, 20, 32, new Location(t.getWorld(), c.getBlockX()  - 4, c.getBlockY() + 12, c.getBlockZ() - 5));
			// arm2
			// arm2_bottom and arm2_top
			SkinSmooth.smoothPartOfImageNorth(this, t, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinSmooth.smoothPartOfImageNorth(this, t, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 40, 44, 20, 32, new Location(t.getWorld(), c.getBlockX() + 11, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm2_front
			SkinSmooth.smoothNorthFrontInvert(this, t.getWorld(), Image2, 44, 48, 20, 32, new Location(t.getWorld(), c.getBlockX() + 7, c.getBlockY() + 12, c.getBlockZ() - 2));
			// arm2_right
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 48, 52, 20, 32, new Location(t.getWorld(), c.getBlockX() + 8, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm2_behind
			SkinSmooth.smoothNorthFrontInvert(this, t.getWorld(), Image2, 52, 56, 20, 32, new Location(t.getWorld(), c.getBlockX() + 7, c.getBlockY() + 12, c.getBlockZ() - 5));
			// head
			// head_left
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 0, 8, 8, 16, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 1));
			// head_right
			SkinSmooth.smoothNorthSide(this, t.getWorld(), Image2, 16, 24, 8, 16, new Location(t.getWorld(), c.getBlockX() + 7, c.getBlockY() + 24, c.getBlockZ() + 1));
			// head_behind
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 24, 32, 8, 16, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 7));
			// head_top
			SkinSmooth.smoothPartOfImageNorth(this, t, Image2, 8, 16, 0, 8, "head_top");
			// head_front
			SkinSmooth.smoothNorthFront(this, t.getWorld(), Image2, 8, 16, 8, 16, new Location(t.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
		}
	}
	
	
	
	
	
	
	
	private void undo(Player p, Location t, String direction){
		undoloc.remove(p);
		undoskin.remove(p);
		undodir.remove(p);
		
		Location c = t;
		
		if(direction.equalsIgnoreCase("east")){
			// leg1
			SkinUndo.undoPartOfImageEast(t,  0, 4, 20, 32, "leg1_left");
			SkinUndo.undoPartOfImageEast(t, 4, 8, 20, 32, "leg1_front");
			//SkinBuild.buildPartOfImageEast(this, p, Image2, 8, 12, 20, 32, "leg1_right"); // no need, is IN the statue, not seen from outside
			SkinUndo.undoPartOfImageEast(t, 12, 16, 20, 32, "leg1_behind");
			// leg2
			SkinUndo.undoPartOfImageEast(t, 0, 4, 20, 32, "leg2_left");
			SkinUndo.undoPartOfImageEast(t, 4, 8, 20, 32, "leg2_front");
			//SkinBuild.buildPartOfImageEast(this, p, Image2, 8, 12, 20, 32, "leg2_right");
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
			//SkinBuild.buildPartOfImageEast(this, p, Image2, 48, 56, 0, 8, "hat_bottom");	// this looks like crap
		}else if(direction.equalsIgnoreCase("west")){
			/*// leg1_left
			SkinUndo.undoWestSide(p, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ()));
			// leg1_front
			SkinUndo.undoEastFront(p, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY(), c.getBlockZ()));
			// leg1_ behind
			SkinUndo.undoWestFrontInvert(p, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY(), c.getBlockZ() - 1));
			// leg2
			//SkinBuild.buildPartOfImageEast(this, p, Image2, 8, 12, 20, 32, "leg2_right");
			// leg2_right
			SkinUndo.undoWestSide(p, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ() + 7));
			// leg2_ front
			SkinUndo.undoWestFrontInvert(p, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY(), c.getBlockZ() + 3));
			// leg2_behind
			SkinUndo.undoWestFront(p, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY(), c.getBlockZ() + 4));
			// body
			// body_front
			SkinUndo.undoWestFront(p, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ()));
			// body_behind
			SkinUndo.undoWestFront(p, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ()));
			// arm1
			SkinUndo.undoPartOfImageWest(t, 48, 52, 16, 20, "arm1_bottom");
			SkinUndo.undoPartOfImageWest(t, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinUndo.undoWestSide(p, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm1_front
			SkinUndo.undoWestFront(p, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm1_right
			SkinUndo.undoWestSide(p, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_behind
			SkinUndo.undoWestFront(p, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm2
			SkinUndo.undoPartOfImageWest(t, 48, 52, 16, 20, "arm2_bottom");
			SkinUndo.undoPartOfImageWest(t, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinUndo.undoWestSide(p, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 8));
			// arm2_front
			SkinUndo.undoWestFrontInvert(p, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ() + 7));
			// arm2_right
			SkinUndo.undoWestSide(p, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 11));
			// arm2_behind
			SkinUndo.undoWestFrontInvert(p, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ() + 7));
			// head
			// head_left
			SkinUndo.undoWestSide(p, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ()));
			// head_right
			SkinUndo.undoWestSide(p, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ() + 7));
			// head_behind
			SkinUndo.undoWestFront(p, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 24, c.getBlockZ()));
			SkinUndo.undoPartOfImageWest(t, 8, 16, 0, 8, "head_top");
			SkinUndo.undoPartOfImageWest(t, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinUndo.undoWestFront(p, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			SkinUndo.undoPartOfImageWest(t, 32, 40, 8, 16, "hat_left");
			SkinUndo.undoPartOfImageWest(t, 48, 56, 8, 16, "hat_right");
			SkinUndo.undoPartOfImageWest(t, 56, 64, 8, 16, "hat_behind");
			SkinUndo.undoPartOfImageWest(t, 40, 48, 8, 16, "hat_front");
			SkinUndo.undoPartOfImageWest(t, 40, 48, 0, 8, "hat_top");*/
			
			SkinUndo.undoFullWest(t);
		}else if(direction.equalsIgnoreCase("north")){
			SkinUndo.undoFullNorth(t);
		}else if(direction.equalsIgnoreCase("south")){
			SkinUndo.undoFullSouth(t);
		}
		
		p.sendMessage("§2Undo successful.");
	}

	
	
	private void buildclay(Player p, BufferedImage Image2, String skin, String direction){
		undoloc.put(p, p.getLocation());
		undoskin.put(p, skin);
		undodir.put(p, direction);
		
		Location c = p.getLocation();
		
		if(direction.equalsIgnoreCase("east") || direction.equalsIgnoreCase("e")){
			// leg1_left
			SkinBuildClay.buildEastSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ()));
			// leg1_front
			SkinBuildClay.buildEastFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY(), c.getBlockZ()));
			// leg1_ behind
			SkinBuildClay.buildEastFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY(), c.getBlockZ() - 1));
			// leg2
			//SkinBuildClay.buildPartOfImageEast(this, p, Image2, 8, 12, 20, 32, "leg2_right");
			// leg2_right
			SkinBuildClay.buildEastSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ() + 7));
			// leg2_ front
			SkinBuildClay.buildEastFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY(), c.getBlockZ() + 3));
			// leg2_behind
			SkinBuildClay.buildEastFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY(), c.getBlockZ() + 4));
			// body
			// body_front
			SkinBuildClay.buildEastFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ()));
			// body_behind
			SkinBuildClay.buildEastFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ()));
			// arm1
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuildClay.buildEastSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm1_front
			SkinBuildClay.buildEastFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm1_right
			SkinBuildClay.buildEastSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_behind
			SkinBuildClay.buildEastFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm2
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuildClay.buildEastSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 11));
			// arm2_front
			SkinBuildClay.buildEastFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ() + 7));
			// arm2_right
			SkinBuildClay.buildEastSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 8));
			// arm2_behind
			SkinBuildClay.buildEastFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ() + 7));
			// head
			// head_left
			SkinBuildClay.buildEastSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ()));
			// head_right
			SkinBuildClay.buildEastSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ() + 7));
			// head_behind
			SkinBuildClay.buildEastFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 24, c.getBlockZ()));
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 8, 16, 0, 8, "head_top");
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinBuildClay.buildEastFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 32, 40, 8, 16, "hat_left");
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 48, 56, 8, 16, "hat_right");
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 56, 64, 8, 16, "hat_behind");
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 40, 48, 8, 16, "hat_front");
			SkinBuildClay.buildPartOfImageEast(this, p, Image2, 40, 48, 0, 8, "hat_top");
			//SkinBuildClay.buildPartOfImageEast(this, p, Image2, 48, 56, 0, 8, "hat_bottom");	// this looks like crap
		}else if(direction.equalsIgnoreCase("south") || direction.equalsIgnoreCase("s")){
			// leg1_left
			SkinBuildClay.buildSouthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() + 1));
			// leg1_front
			SkinBuildClay.buildSouthFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() + 2));
			// leg1_ behind
			SkinBuildClay.buildSouthFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ() + 5));
			// leg2
			// leg2_right
			SkinBuildClay.buildSouthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY(), c.getBlockZ() + 1));
			// leg2_ front
			SkinBuildClay.buildSouthFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() - 3, c.getBlockY(), c.getBlockZ() + 2));
			// leg2_behind
			SkinBuildClay.buildSouthFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 4, c.getBlockY(), c.getBlockZ() + 5));
			// body
			// body_front
			SkinBuildClay.buildSouthFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() + 2));
			// body_behind
			SkinBuildClay.buildSouthFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() + 5));
			// arm1
			SkinBuildClay.buildPartOfImageSouth(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuildClay.buildPartOfImageSouth(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuildClay.buildSouthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_front
			SkinBuildClay.buildSouthFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 2));
			// arm1_right
			SkinBuildClay.buildSouthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_behind
			SkinBuildClay.buildSouthFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 5));
			// arm2
			SkinBuildClay.buildPartOfImageSouth(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuildClay.buildPartOfImageSouth(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuildClay.buildSouthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 11, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm2_front
			SkinBuildClay.buildSouthFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 12, c.getBlockZ() + 2));
			// arm2_right
			SkinBuildClay.buildSouthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm2_behind
			SkinBuildClay.buildSouthFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 12, c.getBlockZ() + 5));
			// head
			// head_left
			SkinBuildClay.buildSouthSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 1));
			// head_right
			SkinBuildClay.buildSouthSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 24, c.getBlockZ() - 1));
			// head_behind
			SkinBuildClay.buildSouthFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 7));
			SkinBuildClay.buildPartOfImageSouth(this, p, Image2, 8, 16, 0, 8, "head_top");
			SkinBuildClay.buildPartOfImageSouth(this, p, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinBuildClay.buildSouthFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			// hat_left
			SkinBuildClay.buildSouthSideHAT(this, p, Image2, 32, 40, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ() - 1));
			// hat_right
			SkinBuildClay.buildSouthSideHATInvert(this, p, Image2, 48, 56, 8, 16, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 24, c.getBlockZ() + 8));
			// hat_behind
			SkinBuildClay.buildSouthFrontHAT(this, p, Image2, 56, 64, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 8));
			// hat_front
			SkinBuildClay.buildSouthFrontHAT(this, p, Image2, 40, 48, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 1));
			// hat_top
			SkinBuildClay.buildPartOfImageSouth(this, p, Image2, 40, 48, 0, 8, "hat_top");
		}else if(direction.equalsIgnoreCase("west") || direction.equalsIgnoreCase("w")){
			// leg1_left
			SkinBuildClay.buildWestSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ()));
			// leg1_front
			SkinBuildClay.buildWestFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY(), c.getBlockZ()));
			// leg1_ behind
			SkinBuildClay.buildWestFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY(), c.getBlockZ() + 1));
			// leg2
			// leg2_right
			SkinBuildClay.buildWestSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ() - 7));
			// leg2_ front
			SkinBuildClay.buildWestFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY(), c.getBlockZ() - 3));
			// leg2_behind
			SkinBuildClay.buildWestFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY(), c.getBlockZ() - 4));
			// body
			// body_front
			SkinBuildClay.buildWestFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX() -+ 2, c.getBlockY() + 12, c.getBlockZ()));
			// body_behind
			SkinBuildClay.buildWestFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX() -+ 5, c.getBlockY() + 12, c.getBlockZ()));
			// arm1
			SkinBuildClay.buildPartOfImageWest(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuildClay.buildPartOfImageWest(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuildClay.buildWestSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm1_front
			SkinBuildClay.buildWestFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm1_right
			SkinBuildClay.buildWestSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_behind
			SkinBuildClay.buildWestFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm2
			SkinBuildClay.buildPartOfImageWest(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuildClay.buildPartOfImageWest(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuildClay.buildWestSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 11));
			// arm2_front
			SkinBuildClay.buildWestFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY() + 12, c.getBlockZ() - 7));
			// arm2_right
			SkinBuildClay.buildWestSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 8));
			// arm2_behind
			SkinBuildClay.buildWestFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY() + 12, c.getBlockZ() - 7));
			// head
			// head_left
			SkinBuildClay.buildWestSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ()));
			// head_right
			SkinBuildClay.buildWestSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ() - 7));
			// head_behind
			SkinBuildClay.buildWestFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 24, c.getBlockZ()));
			// head_top and head_bottom
			SkinBuildClay.buildPartOfImageWest(this, p, Image2, 8, 16, 0, 8, "head_top");
			SkinBuildClay.buildPartOfImageWest(this, p, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinBuildClay.buildWestFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			// hat_left
			SkinBuildClay.buildWestSideHAT(this, p, Image2, 32, 40, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ() + 1));
			// hat_right
			SkinBuildClay.buildWestSideHATInvert(this, p, Image2, 48, 56, 8, 16, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 24, c.getBlockZ() - 8));
			// hat_behind
			SkinBuildClay.buildWestFrontHAT(this, p, Image2, 56, 64, 8, 16, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 24, c.getBlockZ()));
			// hat_front
			SkinBuildClay.buildWestFrontHAT(this, p, Image2, 40, 48, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ()));
			// hat_top
			SkinBuildClay.buildPartOfImageWest(this, p, Image2, 40, 48, 0, 8, "hat_top");
		}else if(direction.equalsIgnoreCase("north") || direction.equalsIgnoreCase("n")){
			// leg1_left
			SkinBuildClay.buildNorthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() - 1));
			// leg1_front
			SkinBuildClay.buildNorthFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() - 2));
			// leg1_behind
			SkinBuildClay.buildNorthFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ() - 5));
			// leg2
			// leg2_right
			SkinBuildClay.buildNorthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY(), c.getBlockZ() - 1));
			// leg2_ front
			SkinBuildClay.buildNorthFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 3, c.getBlockY(), c.getBlockZ() - 2));
			// leg2_behind
			SkinBuildClay.buildNorthFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY(), c.getBlockZ() - 5));
			// body
			// body_front
			SkinBuildClay.buildNorthFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() - 2));
			// body_behind
			SkinBuildClay.buildNorthFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() - 5));
			// arm1
			// arm1_bottom and arm1_top
			SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuildClay.buildNorthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 4, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_front
			SkinBuildClay.buildNorthFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX()  - 4, c.getBlockY() + 12, c.getBlockZ() - 2));
			// arm1_right
			SkinBuildClay.buildNorthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_behind
			SkinBuildClay.buildNorthFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX()  - 4, c.getBlockY() + 12, c.getBlockZ() - 5));
			// arm2
			// arm2_bottom and arm2_top
			SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuildClay.buildNorthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 11, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm2_front
			SkinBuildClay.buildNorthFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 12, c.getBlockZ() - 2));
			// arm2_right
			SkinBuildClay.buildNorthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 8, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm2_behind
			SkinBuildClay.buildNorthFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 12, c.getBlockZ() - 5));
			// head
			// head_left
			SkinBuildClay.buildNorthSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 1));
			// head_right
			SkinBuildClay.buildNorthSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 24, c.getBlockZ() + 1));
			// head_behind
			SkinBuildClay.buildNorthFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 7));
			// head_top
			SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 8, 16, 0, 8, "head_top");
			// head_front
			SkinBuildClay.buildNorthFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			// hat_left:
			SkinBuildClay.buildNorthSideHAT(this, p, Image2, 32, 40, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ() + 1));
			// hat_right:
			SkinBuildClay.buildNorthSideHATInvert(this, p, Image2, 48, 56, 8, 16, new Location(p.getWorld(), c.getBlockX() + 8, c.getBlockY() + 24, c.getBlockZ() - 8));
			// hat_behind:
			SkinBuildClay.buildNorthFrontHAT(this, p, Image2, 56, 64, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 8));
			// hat_front:
			SkinBuildClay.buildNorthFrontHAT(this, p, Image2, 40, 48, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 1));
			//SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 32, 40, 8, 16, "hat_left");
			//SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 48, 56, 8, 16, "hat_right");
			//SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 56, 64, 8, 16, "hat_behind");
			//SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 40, 48, 8, 16, "hat_front");
			SkinBuildClay.buildPartOfImageNorth(this, p, Image2, 40, 48, 0, 8, "hat_top");
		}
		
		p.sendMessage("§2Finished building the skin!");
	}
	
	
	
	
	private void build(Player p, BufferedImage Image2, String skin, String direction){
		undoloc.put(p, p.getLocation());
		undoskin.put(p, skin);
		undodir.put(p, direction);
		
		Location c = p.getLocation();
		
		if(direction.equalsIgnoreCase("east") || direction.equalsIgnoreCase("e")){
			// leg1_left
			SkinBuild.buildEastSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ()));
			// leg1_front
			SkinBuild.buildEastFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY(), c.getBlockZ()));
			// leg1_ behind
			SkinBuild.buildEastFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY(), c.getBlockZ() - 1));
			// leg2
			//SkinBuild.buildPartOfImageEast(this, p, Image2, 8, 12, 20, 32, "leg2_right");
			// leg2_right
			SkinBuild.buildEastSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ() + 7));
			// leg2_ front
			SkinBuild.buildEastFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY(), c.getBlockZ() + 3));
			// leg2_behind
			SkinBuild.buildEastFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY(), c.getBlockZ() + 4));
			// body
			// body_front
			SkinBuild.buildEastFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ()));
			// body_behind
			SkinBuild.buildEastFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ()));
			// arm1
			SkinBuild.buildPartOfImageEast(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuild.buildPartOfImageEast(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuild.buildEastSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm1_front
			SkinBuild.buildEastFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm1_right
			SkinBuild.buildEastSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_behind
			SkinBuild.buildEastFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ() - 4));
			// arm2
			SkinBuild.buildPartOfImageEast(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuild.buildPartOfImageEast(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuild.buildEastSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 11));
			// arm2_front
			SkinBuild.buildEastFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 2, c.getBlockY() + 12, c.getBlockZ() + 7));
			// arm2_right
			SkinBuild.buildEastSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 8));
			// arm2_behind
			SkinBuild.buildEastFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 5, c.getBlockY() + 12, c.getBlockZ() + 7));
			// head
			// head_left
			SkinBuild.buildEastSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ()));
			// head_right
			SkinBuild.buildEastSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ() + 7));
			// head_behind
			SkinBuild.buildEastFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 24, c.getBlockZ()));
			SkinBuild.buildPartOfImageEast(this, p, Image2, 8, 16, 0, 8, "head_top");
			SkinBuild.buildPartOfImageEast(this, p, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinBuild.buildEastFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			SkinBuild.buildPartOfImageEast(this, p, Image2, 32, 40, 8, 16, "hat_left");
			SkinBuild.buildPartOfImageEast(this, p, Image2, 48, 56, 8, 16, "hat_right");
			SkinBuild.buildPartOfImageEast(this, p, Image2, 56, 64, 8, 16, "hat_behind");
			SkinBuild.buildPartOfImageEast(this, p, Image2, 40, 48, 8, 16, "hat_front");
			SkinBuild.buildPartOfImageEast(this, p, Image2, 40, 48, 0, 8, "hat_top");
			//SkinBuild.buildPartOfImageEast(this, p, Image2, 48, 56, 0, 8, "hat_bottom");	// this looks like crap
		}else if(direction.equalsIgnoreCase("south") || direction.equalsIgnoreCase("s")){
			// leg1_left
			SkinBuild.buildSouthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() + 1));
			// leg1_front
			SkinBuild.buildSouthFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() + 2));
			// leg1_ behind
			SkinBuild.buildSouthFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY(), c.getBlockZ() + 5));
			// leg2
			// leg2_right
			SkinBuild.buildSouthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY(), c.getBlockZ() + 1));
			// leg2_ front
			SkinBuild.buildSouthFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() - 3, c.getBlockY(), c.getBlockZ() + 2));
			// leg2_behind
			SkinBuild.buildSouthFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 4, c.getBlockY(), c.getBlockZ() + 5));
			// body
			// body_front
			SkinBuild.buildSouthFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() + 2));
			// body_behind
			SkinBuild.buildSouthFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() + 5));
			// arm1
			SkinBuild.buildPartOfImageSouth(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuild.buildPartOfImageSouth(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuild.buildSouthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_front
			SkinBuild.buildSouthFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 2));
			// arm1_right
			SkinBuild.buildSouthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_behind
			SkinBuild.buildSouthFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY() + 12, c.getBlockZ() + 5));
			// arm2
			SkinBuild.buildPartOfImageSouth(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuild.buildPartOfImageSouth(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuild.buildSouthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 11, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm2_front
			SkinBuild.buildSouthFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 12, c.getBlockZ() + 2));
			// arm2_right
			SkinBuild.buildSouthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm2_behind
			SkinBuild.buildSouthFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 12, c.getBlockZ() + 5));
			// head
			// head_left
			SkinBuild.buildSouthSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 1));
			// head_right
			SkinBuild.buildSouthSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 24, c.getBlockZ() - 1));
			// head_behind
			SkinBuild.buildSouthFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 7));
			SkinBuild.buildPartOfImageSouth(this, p, Image2, 8, 16, 0, 8, "head_top");
			SkinBuild.buildPartOfImageSouth(this, p, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinBuild.buildSouthFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			// hat_left
			SkinBuild.buildSouthSideHAT(this, p, Image2, 32, 40, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ() - 1));
			// hat_right
			SkinBuild.buildSouthSideHATInvert(this, p, Image2, 48, 56, 8, 16, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 24, c.getBlockZ() + 8));
			// hat_behind
			SkinBuild.buildSouthFrontHAT(this, p, Image2, 56, 64, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 8));
			// hat_front
			SkinBuild.buildSouthFrontHAT(this, p, Image2, 40, 48, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 1));
			// hat_top
			SkinBuild.buildPartOfImageSouth(this, p, Image2, 40, 48, 0, 8, "hat_top");
		}else if(direction.equalsIgnoreCase("west") || direction.equalsIgnoreCase("w")){
			// leg1_left
			SkinBuild.buildWestSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ()));
			// leg1_front
			SkinBuild.buildWestFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY(), c.getBlockZ()));
			// leg1_ behind
			SkinBuild.buildWestFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY(), c.getBlockZ() + 1));
			// leg2
			// leg2_right
			SkinBuild.buildWestSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ() - 7));
			// leg2_ front
			SkinBuild.buildWestFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY(), c.getBlockZ() - 3));
			// leg2_behind
			SkinBuild.buildWestFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY(), c.getBlockZ() - 4));
			// body
			// body_front
			SkinBuild.buildWestFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX() -+ 2, c.getBlockY() + 12, c.getBlockZ()));
			// body_behind
			SkinBuild.buildWestFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX() -+ 5, c.getBlockY() + 12, c.getBlockZ()));
			// arm1
			SkinBuild.buildPartOfImageWest(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuild.buildPartOfImageWest(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuild.buildWestSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm1_front
			SkinBuild.buildWestFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm1_right
			SkinBuild.buildWestSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() + 1));
			// arm1_behind
			SkinBuild.buildWestFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY() + 12, c.getBlockZ() + 4));
			// arm2
			SkinBuild.buildPartOfImageWest(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuild.buildPartOfImageWest(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuild.buildWestSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 11));
			// arm2_front
			SkinBuild.buildWestFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() - 2, c.getBlockY() + 12, c.getBlockZ() - 7));
			// arm2_right
			SkinBuild.buildWestSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 8));
			// arm2_behind
			SkinBuild.buildWestFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() - 5, c.getBlockY() + 12, c.getBlockZ() - 7));
			// head
			// head_left
			SkinBuild.buildWestSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ()));
			// head_right
			SkinBuild.buildWestSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ() - 7));
			// head_behind
			SkinBuild.buildWestFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX() - 7, c.getBlockY() + 24, c.getBlockZ()));
			// head_top and head_bottom
			SkinBuild.buildPartOfImageWest(this, p, Image2, 8, 16, 0, 8, "head_top");
			SkinBuild.buildPartOfImageWest(this, p, Image2, 16, 24, 0, 8, "head_bottom");
			// head_front
			SkinBuild.buildWestFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			// hat_left
			SkinBuild.buildWestSideHAT(this, p, Image2, 32, 40, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ() + 1));
			// hat_right
			SkinBuild.buildWestSideHATInvert(this, p, Image2, 48, 56, 8, 16, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 24, c.getBlockZ() - 8));
			// hat_behind
			SkinBuild.buildWestFrontHAT(this, p, Image2, 56, 64, 8, 16, new Location(p.getWorld(), c.getBlockX() - 8, c.getBlockY() + 24, c.getBlockZ()));
			// hat_front
			SkinBuild.buildWestFrontHAT(this, p, Image2, 40, 48, 8, 16, new Location(p.getWorld(), c.getBlockX() + 1, c.getBlockY() + 24, c.getBlockZ()));
			// hat_top
			SkinBuild.buildPartOfImageWest(this, p, Image2, 40, 48, 0, 8, "hat_top");
		}else if(direction.equalsIgnoreCase("north") || direction.equalsIgnoreCase("n")){
			// leg1_left
			SkinBuild.buildNorthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() - 1));
			// leg1_front
			SkinBuild.buildNorthFront(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY(), c.getBlockZ() - 2));
			// leg1_behind
			SkinBuild.buildNorthFrontInvert(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY(), c.getBlockZ() - 5));
			// leg2
			// leg2_right
			SkinBuild.buildNorthSide(this, p, Image2, 0, 4, 20, 32, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY(), c.getBlockZ() - 1));
			// leg2_ front
			SkinBuild.buildNorthFrontInvert(this, p, Image2, 4, 8, 20, 32, new Location(p.getWorld(), c.getBlockX() + 3, c.getBlockY(), c.getBlockZ() - 2));
			// leg2_behind
			SkinBuild.buildNorthFront(this, p, Image2, 12, 16, 20, 32, new Location(p.getWorld(), c.getBlockX() + 4, c.getBlockY(), c.getBlockZ() - 5));
			// body
			// body_front
			SkinBuild.buildNorthFront(this, p, Image2, 20, 28, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() - 2));
			// body_behind
			SkinBuild.buildNorthFront(this, p, Image2, 32, 40, 20, 32, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 12, c.getBlockZ() - 5));
			// arm1
			// arm1_bottom and arm1_top
			SkinBuild.buildPartOfImageNorth(this, p, Image2, 48, 52, 16, 20, "arm1_bottom");
			SkinBuild.buildPartOfImageNorth(this, p, Image2, 44, 48, 16, 20, "arm1_top");
			// arm1_left
			SkinBuild.buildNorthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() - 4, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_front
			SkinBuild.buildNorthFront(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX()  - 4, c.getBlockY() + 12, c.getBlockZ() - 2));
			// arm1_right
			SkinBuild.buildNorthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm1_behind
			SkinBuild.buildNorthFront(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX()  - 4, c.getBlockY() + 12, c.getBlockZ() - 5));
			// arm2
			// arm2_bottom and arm2_top
			SkinBuild.buildPartOfImageNorth(this, p, Image2, 48, 52, 16, 20, "arm2_bottom");
			SkinBuild.buildPartOfImageNorth(this, p, Image2, 44, 48, 16, 20, "arm2_top");
			// arm2_left
			SkinBuild.buildNorthSide(this, p, Image2, 40, 44, 20, 32, new Location(p.getWorld(), c.getBlockX() + 11, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm2_front
			SkinBuild.buildNorthFrontInvert(this, p, Image2, 44, 48, 20, 32, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 12, c.getBlockZ() - 2));
			// arm2_right
			SkinBuild.buildNorthSide(this, p, Image2, 48, 52, 20, 32, new Location(p.getWorld(), c.getBlockX() + 8, c.getBlockY() + 12, c.getBlockZ() - 1));
			// arm2_behind
			SkinBuild.buildNorthFrontInvert(this, p, Image2, 52, 56, 20, 32, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 12, c.getBlockZ() - 5));
			// head
			// head_left
			SkinBuild.buildNorthSide(this, p, Image2, 0, 8, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 1));
			// head_right
			SkinBuild.buildNorthSide(this, p, Image2, 16, 24, 8, 16, new Location(p.getWorld(), c.getBlockX() + 7, c.getBlockY() + 24, c.getBlockZ() + 1));
			// head_behind
			SkinBuild.buildNorthFront(this, p, Image2, 24, 32, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 7));
			// head_top
			SkinBuild.buildPartOfImageNorth(this, p, Image2, 8, 16, 0, 8, "head_top");
			// head_front
			SkinBuild.buildNorthFront(this, p, Image2, 8, 16, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ()));
			// hat layers
			// hat_left:
			SkinBuild.buildNorthSideHAT(this, p, Image2, 32, 40, 8, 16, new Location(p.getWorld(), c.getBlockX() - 1, c.getBlockY() + 24, c.getBlockZ() + 1));
			// hat_right:
			SkinBuild.buildNorthSideHATInvert(this, p, Image2, 48, 56, 8, 16, new Location(p.getWorld(), c.getBlockX() + 8, c.getBlockY() + 24, c.getBlockZ() - 8));
			// hat_behind:
			SkinBuild.buildNorthFrontHAT(this, p, Image2, 56, 64, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() - 8));
			// hat_front:
			SkinBuild.buildNorthFrontHAT(this, p, Image2, 40, 48, 8, 16, new Location(p.getWorld(), c.getBlockX(), c.getBlockY() + 24, c.getBlockZ() + 1));
			//SkinBuild.buildPartOfImageNorth(this, p, Image2, 32, 40, 8, 16, "hat_left");
			//SkinBuild.buildPartOfImageNorth(this, p, Image2, 48, 56, 8, 16, "hat_right");
			//SkinBuild.buildPartOfImageNorth(this, p, Image2, 56, 64, 8, 16, "hat_behind");
			//SkinBuild.buildPartOfImageNorth(this, p, Image2, 40, 48, 8, 16, "hat_front");
			SkinBuild.buildPartOfImageNorth(this, p, Image2, 40, 48, 0, 8, "hat_top");
		}
		
		p.sendMessage("§2Finished building the skin!");
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
		}else if(s > 0.6 && v > 0.7 && h > 0.0333333333 && h < 0.1138888888){ // s > 0.4 && v > 0.5
			ret = "ORANGE";
		}else if(s > 0.4 && v > 0.145 && h > 0.02 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
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
		}else if(s > 0.2 && v > 0.8 && h > 0.3805555555 && h < 0.5194444444){ // v > 0.4 adjusted 3
			ret = "LIGHT_BLUE";
		}else if(s > 0.1 && s < 0.21 && v > 0.9 && h > 0.3805555555 && h < 0.5194444444){ // new 3
			ret = "LIGHT_BLUE";
		}else if(s > 0.4 && v < 0.81 && v > 0.2 && h > 0.3805555555 && h < 0.6027777777){ // adjusted 3
			ret = "CYAN";
		}else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
			ret = "CYAN";
		}else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
			ret = "BLUE";
		}else if(s > 0.2 && s < 0.41 && v > 0.7 && h > 0.6027777777 && h < 0.6944444444){ // adjusted 3
			ret = "LIGHT_BLUE";
		}else if(s < 0.2 && v > 0.6 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = "BLUE";
		}else if(s > 0.1 && s < 0.2 && v > 0.6 && v < 0.91 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = "LIGHT_BLUE";
		}else if(s > 0.1 && s < 0.2 && v > 0.9 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = "BLUE";
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
		//TODO:NEW COLORS
		}else if(s > 0.6 && h > 0.5666666 && h < 0.602777 && v > 0.12 && v < 0.3){
			ret = "BLUE";
		}else if(h > 0.5 && h < 0.602777 && v < 0.13){
			ret = "BLACK";	
		}else if(h > 0.95833333 && s > 0.7 && v > 0.19 && v < 0.4){
			ret = "RED";
		}else if(h > 0.8 && h < 0.91666666 && s > 0.35 && v > 0.16 && v < 0.4){
			ret = "PURPLE";
		}else if(h > 0.3055555 && h < 0.3888888 && s < 0.35 && v > 0.6 && v < 0.8){
			ret = "CYAN";
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.7 && v < 0.95){
			ret = "LIGHT_BLUE";
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.5 && v < 0.71){
			ret = "BLUE";
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v > 0.7){
			ret = "LIGHT_BLUE";
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v < 0.71){
			ret = "BLUE";
		}else if(s < 0.31 && v < 0.16){
			ret = "BLACK";
		//TODO:NEW COLORS 2:
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
			ret = "BLACK";
		}else if(h > 0.53 && h < 0.7 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = "BLUE";
		}else if(h > 0.4 && h < 0.53 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = "CYAN";
		}else if(h < 0.4 && h > 0.2777777 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = "GREEN";
		}else if(h < 0.25 && h > 0.2 && s > 0.6 && v < 0.25 && v > 0.15){
			ret = "BROWN";
		}else if(h > 833333 && h < 94 && s > 0.6 && v < 0.4 && v > 0.15){
			ret = "PURPLE";
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v > 0.8){
			ret = "LIGHT_BLUE";
		}else if(h > 0.541 && h < 0.64 && s < 0.4 && s > 0.2 && v > 0.3){
			ret = "BLUE";
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v < 0.5 && v > 0.2){
			ret = "BLUE";
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
			ret = "GRAY";
		}else{
			ret = "WHITE"; // nothing matched
			//getLogger().info(Float.toString(h) + " " + Float.toString(s) + " " + Float.toString(v));
		}
		
		return ret;
	}
	
	
	
	//TODO: CHANGE COLORS
	public String getStringFromColorClay(Color c){
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
		}else if(s > 0.6 && v > 0.7 && h > 0.0333333333 && h < 0.1138888888){ // s > 0.4 && v > 0.5
			ret = "ORANGE";
		}else if(s > 0.4 && v > 0.145 && h > 0.02 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
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
		}else if(s > 0.2 && v > 0.8 && h > 0.3805555555 && h < 0.5194444444){ // v > 0.4 adjusted 3
			ret = "LIGHT_BLUE";
		}else if(s > 0.1 && s < 0.21 && v > 0.9 && h > 0.3805555555 && h < 0.5194444444){ // new 3
			ret = "LIGHT_BLUE";
		}else if(s > 0.4 && v < 0.81 && v > 0.2 && h > 0.3805555555 && h < 0.6027777777){ // adjusted 3
			ret = "CYAN";
		}else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
			ret = "CYAN";
		}else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
			ret = "BLUE";
		}else if(s > 0.2 && s < 0.41 && v > 0.7 && h > 0.6027777777 && h < 0.6944444444){ // adjusted 3
			ret = "LIGHT_BLUE";
		}else if(s < 0.2 && v > 0.6 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = "BLUE";
		}else if(s > 0.1 && s < 0.2 && v > 0.6 && v < 0.91 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = "LIGHT_BLUE";
		}else if(s > 0.1 && s < 0.2 && v > 0.9 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = "BLUE";
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
		}else if(s > 0.6 && h > 0.5666666 && h < 0.602777 && v > 0.12 && v < 0.3){
			ret = "BLUE";
		}else if(h > 0.5 && h < 0.602777 && v < 0.13){
			ret = "BLACK";	
		}else if(h > 0.95833333 && s > 0.7 && v > 0.19 && v < 0.4){
			ret = "RED";
		}else if(h > 0.8 && h < 0.91666666 && s > 0.35 && v > 0.16 && v < 0.4){
			ret = "PURPLE";
		}else if(h > 0.3055555 && h < 0.3888888 && s < 0.35 && v > 0.6 && v < 0.8){
			ret = "CYAN";
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.7 && v < 0.95){
			ret = "LIGHT_BLUE";
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.5 && v < 0.71){
			ret = "BLUE";
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v > 0.7){
			ret = "LIGHT_BLUE";
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v < 0.71){
			ret = "BLUE";
		}else if(s < 0.31 && v < 0.16){
			ret = "BLACK";
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
			ret = "BLACK";
		}else if(h > 0.53 && h < 0.7 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = "BLUE";
		}else if(h > 0.4 && h < 0.53 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = "CYAN";
		}else if(h < 0.4 && h > 0.2777777 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = "GREEN";
		}else if(h < 0.25 && h > 0.2 && s > 0.6 && v < 0.25 && v > 0.15){
			ret = "BROWN";
		}else if(h > 833333 && h < 94 && s > 0.6 && v < 0.4 && v > 0.15){
			ret = "PURPLE";
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v > 0.8){
			ret = "LIGHT_BLUE";
		}else if(h > 0.541 && h < 0.64 && s < 0.4 && s > 0.2 && v > 0.3){
			ret = "BLUE";
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v < 0.5 && v > 0.2){
			ret = "BLUE";
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
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
		}else if(s > 0.6 && v > 0.7 && h > 0.0333333333 && h < 0.1138888888){
			ret = true;
		}else if(s > 0.4 && v > 0.145 && h > 0.02 && h < 0.15){
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
		}else if(s > 0.2 && v > 0.8 && h > 0.3805555555 && h < 0.5194444444){ // v > 0.4 adjusted 3
			ret = true;
		}else if(s > 0.1 && s < 0.21 && v > 0.9 && h > 0.3805555555 && h < 0.5194444444){ // new 3
			ret = true;
		}else if(s > 0.4 && v < 0.81 && v > 0.2 && h > 0.3805555555 && h < 0.6027777777){ // adjusted 3
			ret = true;
		}else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
			ret = true;
		}else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
			ret = true;
		}else if(s > 0.2 && s < 0.41 && v > 0.7 && h > 0.6027777777 && h < 0.6944444444){ // adjusted 3
			ret = true;
		}else if(s < 0.2 && v > 0.6 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = true;
		}else if(s > 0.1 && s < 0.2 && v > 0.6 && v < 0.91 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = true;
		}else if(s > 0.1 && s < 0.2 && v > 0.9 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			ret = true;
		}else if(s > 0.6 && v > 0.1 && h > 0.6027777777 && h < 0.6944444444){
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
		}else if(h > 0.068 && h < 0.1194444 && s > 0.2 && s < 0.6 && v > 0.7){
			ret = true; // HUMAN SKIN
		}else if(h > 0.044 && h < 0.09 && s > 0.3 && s < 0.6 && v > 0.84){
			ret = true; // HUMAN SKIN
		}else if(h > 0.110 && h < 0.1389 && s < 0.6 && s > 0.3 && v > 0.74 && v < 0.91){
			ret = true; // HUMAN SKIN
		//TODO:NEW COLORS [TEST]
		}else if(s > 0.6 && h > 0.5666666 && h < 0.602777 && v > 0.12 && v < 0.3){
			ret = true;
		}else if(h > 0.5666666 && h < 0.602777 && v < 0.13){
			ret = true;	
		}else if(h > 0.95833333 && s > 0.7 && v > 0.19 && v < 0.4){
			ret = true;
		}else if(h > 0.8 && h < 0.91666666 && s > 0.35 && v > 0.16 && v < 0.4){
			ret = true;
		}else if(h > 0.3055555 && h < 0.3888888 && s < 0.35 && v > 0.6 && v < 0.8){
			ret = true;
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.7 && v < 0.95){
			ret = true;
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.5 && v < 0.71){
			ret = true;
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v > 0.7){
			ret = true;
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v < 0.71){
			ret = true;
		}else if(s < 0.31 && v < 0.16){
			ret = true;
		//TODO: NEW COLORS 2 [TEST]
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
			ret = true;
		}else if(h > 0.53 && h < 0.7 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = true;
		}else if(h > 0.4 && h < 0.53 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = true;
		}else if(h < 0.4 && h > 0.2777777 && s > 0.5 && v < 0.3 && v > 0.15){
			ret = true;
		}else if(h < 0.25 && h > 0.2 && s > 0.6 && v < 0.25 && v > 0.15){
			ret = true;
		}else if(h > 833333 && h < 94 && s > 0.6 && v < 0.4 && v > 0.15){
			ret = true;
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v > 0.8){
			ret = true;
		}else if(h > 0.541 && h < 0.64 && s < 0.4 && s > 0.2 && v > 0.3){
			ret = true;
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v < 0.5 && v > 0.2){
			ret = true;
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
			ret = true;
		}else{
			ret = false; // nothing matched
			//getLogger().info(Float.toString(h) + " " + Float.toString(s) + " " + Float.toString(v));
		}
		
		return ret;
	}
	
	
	
	public boolean isHumanSkin(Color c){
		boolean ret = false;

		Integer r = c.getRed(); // RED
		Integer g = c.getGreen(); // GREEN
		Integer b = c.getBlue(); // BLUE
		
		float[] hsb = new float[3];
		c.RGBtoHSB(r, g, b, hsb);
		
		float h = hsb[0]; // HUE
		float s = hsb[1]; // SATURATION
		float v = hsb[2]; // BRIGHTNESS
		
		if(h > 0.068 && h < 0.1194444 && s > 0.2 && s < 0.6 && v > 0.7){ // h > 0.722222
			ret = true;
		}else if(h > 0.044 && h < 0.09 && s > 0.3 && s < 0.6 && v > 0.84){ // NEW
			ret = true;
		}else if(h > 0.110 && h < 0.1389 && s < 0.6 && s > 0.3 && v > 0.74 && v < 0.91){ // NEW 2
			ret = true;
		}else{
			ret = false; // nothing matched
			//getLogger().info(Float.toString(h) + " " + Float.toString(s) + " " + Float.toString(v));
		}
		
		return ret;
	}
	
	
	public void createPunchcard(){
		for(int b = 0; b <= 255; b++){
			// for each brightness step:
			BufferedImage newb = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
			for(int r = 0; r <= 255; r++){
				for(int g = 0; g <= 255; g++){
					Color c = new Color(r, g, b);
					
					if(getStringFromColorTEST(c)){
						newb.setRGB(r, g, c.getRGB());
					}else{
						//newb.setRGB(r, g, Color.WHITE.getRGB());
					}
				}
			}
			
		    File outputfile = new File("plugins/Skins/" + Integer.toString(b) + ".png");
		    try {
				ImageIO.write(newb, "png", outputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		getLogger().info("Finished creating punchcard.");
		
		
		/*for(int r = 0; r <= 255; r++){
			for(int g = 0; g <= 255; g++){
				for(int b = 0; b <= 255; b++){
					Color c = new Color(r, g, b);
					
					if(getStringFromColorTEST(c)){
						
					}else{
						
					}
				}
			}
		}	

		for(int h = 0; h < 360; h++){ // hue
			for(int s = 0; s < 100; s++){ // saturation
				for(int b = 0; b < 100; b++){ // brightness
					Color c = Color.getHSBColor(h, s, b);
					
				}
			}
		}*/
		
	}

	
	public String getDirection(Float yaw)
	{
	    yaw = yaw / 90;
	    yaw = (float)Math.round(yaw);
	 
	    if (yaw == -4 || yaw == 0 || yaw == 4) {return "SOUTH";}
	    if (yaw == -1 || yaw == 3) {return "EAST";}
	    if (yaw == -2 || yaw == 2) {return "NORTH";}
	    if (yaw == -3 || yaw == 1) {return "WEST";}
	    return "";
	}
}
