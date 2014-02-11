package com.comze_instancelabs.skins.mobs;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Blaze {
	public static void buildBlaze(Location start, String direction){
		r = new Random();
		buildHead(start, direction);
		
		World w = start.getWorld();
		if(direction.equalsIgnoreCase("west")){
			buildThingy(new Location(w, start.getBlockX() + 2, start.getBlockY() + 8, start.getBlockZ()), direction);
			buildThingy(new Location(w, start.getBlockX() + 4, start.getBlockY() + 13, start.getBlockZ() - 3), direction);
			buildThingy(new Location(w, start.getBlockX() + 1, start.getBlockY() + 3, start.getBlockZ() - 8), direction);
			buildThingy(new Location(w, start.getBlockX() - 2, start.getBlockY() + 11, start.getBlockZ() - 12), direction);
			buildThingy(new Location(w, start.getBlockX() - 3, start.getBlockY() + 17, start.getBlockZ() - 15), direction);
			buildThingy(new Location(w, start.getBlockX() - 4, start.getBlockY() + 4, start.getBlockZ() - 10), direction);
			buildThingy(new Location(w, start.getBlockX() - 5, start.getBlockY() + 16, start.getBlockZ() - 12), direction);
			buildThingy(new Location(w, start.getBlockX() - 11, start.getBlockY() + 16, start.getBlockZ() - 7), direction);
			buildThingy(new Location(w, start.getBlockX() - 12, start.getBlockY() + 13, start.getBlockZ()), direction);
			buildThingy(new Location(w, start.getBlockX() - 8, start.getBlockY() + 10, start.getBlockZ() + 5), direction);
			buildThingy(new Location(w, start.getBlockX() - 4, start.getBlockY() + 16, start.getBlockZ() + 4), direction);
			buildThingy(new Location(w, start.getBlockX() - 1, start.getBlockY() + 3, start.getBlockZ() + 3), direction);
		}else if(direction.equalsIgnoreCase("east")){
			buildThingy(new Location(w, start.getBlockX() - 2, start.getBlockY() + 8, start.getBlockZ()), direction);
			buildThingy(new Location(w, start.getBlockX() - 4, start.getBlockY() + 13, start.getBlockZ() + 3), direction);
			buildThingy(new Location(w, start.getBlockX() - 1, start.getBlockY() + 3, start.getBlockZ() + 8), direction);
			buildThingy(new Location(w, start.getBlockX() + 2, start.getBlockY() + 11, start.getBlockZ() + 12), direction);
			buildThingy(new Location(w, start.getBlockX() + 3, start.getBlockY() + 17, start.getBlockZ() + 15), direction);
			buildThingy(new Location(w, start.getBlockX() + 4, start.getBlockY() + 4, start.getBlockZ() + 10), direction);
			buildThingy(new Location(w, start.getBlockX() + 5, start.getBlockY() + 16, start.getBlockZ() + 12), direction);
			buildThingy(new Location(w, start.getBlockX() + 11, start.getBlockY() + 16, start.getBlockZ() + 7), direction);
			buildThingy(new Location(w, start.getBlockX() + 12, start.getBlockY() + 13, start.getBlockZ()), direction);
			buildThingy(new Location(w, start.getBlockX() + 8, start.getBlockY() + 10, start.getBlockZ() - 5), direction);
			buildThingy(new Location(w, start.getBlockX() + 4, start.getBlockY() + 16, start.getBlockZ() - 4), direction);
			buildThingy(new Location(w, start.getBlockX() + 1, start.getBlockY() + 3, start.getBlockZ() - 3), direction);
		}else if(direction.equalsIgnoreCase("north")){
			buildThingy(new Location(w, start.getBlockX(), start.getBlockY() + 8, start.getBlockZ() + 2), direction);
			buildThingy(new Location(w, start.getBlockX() + 3, start.getBlockY() + 13, start.getBlockZ() + 4), direction);
			buildThingy(new Location(w, start.getBlockX() + 8, start.getBlockY() + 3, start.getBlockZ() + 1), direction);
			buildThingy(new Location(w, start.getBlockX() + 12, start.getBlockY() + 11, start.getBlockZ() - 2), direction);
			buildThingy(new Location(w, start.getBlockX() + 15, start.getBlockY() + 17, start.getBlockZ() - 3), direction);
			buildThingy(new Location(w, start.getBlockX() + 10, start.getBlockY() + 4, start.getBlockZ() - 4), direction);
			buildThingy(new Location(w, start.getBlockX() + 12, start.getBlockY() + 16, start.getBlockZ() - 5), direction);
			buildThingy(new Location(w, start.getBlockX() + 7, start.getBlockY() + 16, start.getBlockZ() - 11), direction);
			buildThingy(new Location(w, start.getBlockX(), start.getBlockY() + 13, start.getBlockZ() - 12), direction);
			buildThingy(new Location(w, start.getBlockX() - 5, start.getBlockY() + 10, start.getBlockZ() - 8), direction);
			buildThingy(new Location(w, start.getBlockX() - 4, start.getBlockY() + 16, start.getBlockZ() - 4), direction);
			buildThingy(new Location(w, start.getBlockX() - 3, start.getBlockY() + 3, start.getBlockZ() - 1), direction);
		}else if(direction.equalsIgnoreCase("south")){
			buildThingy(new Location(w, start.getBlockX(), start.getBlockY() + 8, start.getBlockZ() - 2), direction);
			buildThingy(new Location(w, start.getBlockX() - 3, start.getBlockY() + 13, start.getBlockZ() - 4), direction);
			buildThingy(new Location(w, start.getBlockX() - 8, start.getBlockY() + 3, start.getBlockZ() - 1), direction);
			buildThingy(new Location(w, start.getBlockX() - 12, start.getBlockY() + 11, start.getBlockZ() + 2), direction);
			buildThingy(new Location(w, start.getBlockX() - 15, start.getBlockY() + 17, start.getBlockZ() + 3), direction);
			buildThingy(new Location(w, start.getBlockX() - 10, start.getBlockY() + 4, start.getBlockZ() + 4), direction);
			buildThingy(new Location(w, start.getBlockX() - 12, start.getBlockY() + 16, start.getBlockZ() + 5), direction);
			buildThingy(new Location(w, start.getBlockX() - 7, start.getBlockY() + 16, start.getBlockZ() + 11), direction);
			buildThingy(new Location(w, start.getBlockX(), start.getBlockY() + 13, start.getBlockZ() + 12), direction);
			buildThingy(new Location(w, start.getBlockX() + 5, start.getBlockY() + 10, start.getBlockZ() + 8), direction);
			buildThingy(new Location(w, start.getBlockX() + 4, start.getBlockY() + 16, start.getBlockZ() + 4), direction);
			buildThingy(new Location(w, start.getBlockX() + 3, start.getBlockY() + 3, start.getBlockZ() + 1), direction);
		}
	}
	
	public static Random r;
	
	public static void buildHead(Location start, String d){
		for(int i__ = 0; i__ < 8; i__++){
			for(int i_ = 0; i_ < 8; i_++){
				for(int i = 0; i < 4; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i + 16, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 1, start.getBlockY() + i + 16, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i + 16, start.getBlockZ() - i__ - 1));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i + 16, start.getBlockZ() + i__ + 1));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i + 16, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					
					int c = r.nextInt(4);
					if(c == 0){
						b.setData((byte)14);
					}else if(c == 1){
						b.setData((byte)1);
					}else if(c == 2){
						b.setData((byte)15);
					}else if(c == 3){
						b.setData((byte)12);
					}else{
						b.setData((byte)4);
					}
					
				}
			}
		}
		
		
		for(int i__ = 0; i__ < 8; i__++){
			for(int i_ = 0; i_ < 8; i_++){
				for(int i = 0; i < 4; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i + 20, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 1, start.getBlockY() + i + 20, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i + 20, start.getBlockZ() - i__ - 1));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i + 20, start.getBlockZ() + i__ + 1));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i + 20, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					b.setData((byte)4);
				}
			}
		}
		

		// eyes
		if(d.equalsIgnoreCase("west")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 2)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 5)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 6)).setTypeIdAndData(35, (byte)0, true);
		}else if(d.equalsIgnoreCase("east")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 21, start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 21, start.getBlockZ() + 2)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 21, start.getBlockZ() + 5)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 21, start.getBlockZ() + 6)).setTypeIdAndData(35, (byte)0, true);
		}else if(d.equalsIgnoreCase("north")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 21, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 2, start.getBlockY() + 21, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 5, start.getBlockY() + 21, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 21, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)0, true);
		}else if(d.equalsIgnoreCase("south")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 2, start.getBlockY() + 21, start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 5, start.getBlockY() + 21, start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 6, start.getBlockY() + 21, start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)0, true);
		}else{
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 2)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 5)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 21, start.getBlockZ() - 6)).setTypeIdAndData(35, (byte)0, true);
		}
	}
	
	
	public static void buildThingy(Location start, String d){
		for(int i__ = 0; i__ < 2; i__++){
			for(int i_ = 0; i_ < 2; i_++){
				for(int i = 0; i < 8; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__, start.getBlockY() + i, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i, start.getBlockZ() - i__));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i, start.getBlockZ() + i__));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					
					int c = r.nextInt(100);
					if(c < 8){
						b.setData((byte)1);
					}else if(c > 7){
						b.setData((byte)4);
					}
				}
			}
		}
	}
	
	
	
	public static void undoBlaze(Location start, String d){
		World w = start.getWorld();
		for(int i__ = 0; i__ < 22; i__++){
			for(int i_ = 0; i_ < 22; i_++){
				for(int i = 0; i < 25; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() - i__ + 4, start.getBlockY() + i + 1, start.getBlockZ() - i_ + 5));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() + i__ - 4, start.getBlockY() + i + 1, start.getBlockZ() + i_ - 5));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() + i_ - 5, start.getBlockY() + i + 1, start.getBlockZ() - i__ + 4));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() - i_ + 5, start.getBlockY() + i + 1, start.getBlockZ() + i__ - 4));
					}else{
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() - i__ + 4, start.getBlockY() + i + 1, start.getBlockZ() - i_ + 5));
					}
					if(b.getType() == Material.WOOL){
						b.setType(Material.AIR);
					}
				}
			}	
		}
	}
}
