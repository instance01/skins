package com.comze_instancelabs.skins;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Creeper {

	public static void buildCreeper(Location start, String direction){
		buildLegs(start, direction);
		buildBody(start, direction);
		buildHead(start, direction);
	}
	
	public static void buildLegs(Location start, String d){
		for(int i__ = 0; i__ < 4; i__++){
			for(int i_ = 0; i_ < 8; i_++){
				for(int i = 0; i < 6; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 1, start.getBlockY() + i, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i, start.getBlockZ() - i__ - 1));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i, start.getBlockZ() + i__ + 1));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					b.setData((byte)5);
				}
			}	
		}
		
		for(int i__ = 0; i__ < 4; i__++){
			for(int i_ = 0; i_ < 8; i_++){
				for(int i = 0; i < 6; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 9, start.getBlockY() + i, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 9, start.getBlockY() + i, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i, start.getBlockZ() - i__ - 9));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i, start.getBlockZ() + i__ + 9));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					b.setData((byte)5);
				}
			}	
		}
	}
	
	public static void buildBody(Location start, String d){
		for(int i__ = 0; i__ < 4; i__++){
			for(int i_ = 0; i_ < 8; i_++){
				for(int i = 0; i < 12; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 5, start.getBlockY() + i + 6, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 5, start.getBlockY() + i + 6, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i + 6, start.getBlockZ() - i__ - 5));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i + 6, start.getBlockZ() + i__ + 5));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i + 6, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					b.setData((byte)5);
				}
			}	
		}
	}
	
	public static void buildHead(Location start, String d){
		for(int i__ = 0; i__ < 8; i__++){
			for(int i_ = 0; i_ < 8; i_++){
				for(int i = 0; i < 8; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 3, start.getBlockY() + i + 18, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 3, start.getBlockY() + i + 18, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i + 18, start.getBlockZ() - i__ - 3));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i + 18, start.getBlockZ() + i__ + 3));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i + 18, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					b.setData((byte)5);
				}
			}	
		}
	}
	
}
