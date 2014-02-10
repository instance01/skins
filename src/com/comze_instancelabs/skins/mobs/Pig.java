package com.comze_instancelabs.skins.mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Pig {
	public static void buildPig(Location start, String direction){
		buildLegs(start, direction);
		buildBody(start, direction);
		buildHead(start, direction);
	}
	
	public static void buildLegs(Location start, String d){
		for(int i__ = 0; i__ < 4; i__++){
			for(int i_ = 0; i_ < 4; i_++){
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
					b.setData((byte)6);
				}
			}	
		}
		
		for(int i__ = 0; i__ < 4; i__++){
			for(int i_ = 0; i_ < 4; i_++){
				for(int i = 0; i < 6; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i, start.getBlockZ() - i_ - 6));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 1, start.getBlockY() + i, start.getBlockZ() + i_ + 6));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_ + 6, start.getBlockY() + i, start.getBlockZ() - i__ - 1));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_ - 6, start.getBlockY() + i, start.getBlockZ() + i__ + 1));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 1, start.getBlockY() + i, start.getBlockZ() - i_ - 6));
					}
					b.setType(Material.WOOL);
					b.setData((byte)6);
				}
			}	
		}
		
		
		
		for(int i__ = 0; i__ < 4; i__++){
			for(int i_ = 0; i_ < 4; i_++){
				for(int i = 0; i < 6; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 13, start.getBlockY() + i, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 13, start.getBlockY() + i, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i, start.getBlockZ() - i__ - 13));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i, start.getBlockZ() + i__ + 13));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 13, start.getBlockY() + i, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					b.setData((byte)6);
				}
			}	
		}
		
		for(int i__ = 0; i__ < 4; i__++){
			for(int i_ = 0; i_ < 4; i_++){
				for(int i = 0; i < 6; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 13, start.getBlockY() + i, start.getBlockZ() - i_ - 6));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ + 13, start.getBlockY() + i, start.getBlockZ() + i_ + 6));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_ + 6, start.getBlockY() + i, start.getBlockZ() - i__ - 13));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_ - 6, start.getBlockY() + i, start.getBlockZ() + i__ + 13));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ - 13, start.getBlockY() + i, start.getBlockZ() - i_ - 6));
					}
					b.setType(Material.WOOL);
					b.setData((byte)6);
				}
			}	
		}
	}
	
	
	public static void buildBody(Location start, String d){
		for(int i__ = 0; i__ < 16; i__++){
			for(int i_ = 0; i_ < 10; i_++){
				for(int i = 0; i < 8; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i + 6, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__, start.getBlockY() + i + 6, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_, start.getBlockY() + i + 6, start.getBlockZ() - i__));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_, start.getBlockY() + i + 6, start.getBlockZ() + i__));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i + 6, start.getBlockZ() - i_ + 1));
					}
					b.setType(Material.WOOL);
					b.setData((byte)6);
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
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ + 6, start.getBlockY() + i + 8, start.getBlockZ() - i_ - 1));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ - 6, start.getBlockY() + i + 8, start.getBlockZ() + i_ + 1));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_ + 1, start.getBlockY() + i + 8, start.getBlockZ() - i__ + 6));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_ - 1, start.getBlockY() + i + 8, start.getBlockZ() + i__ - 6));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ + 6, start.getBlockY() + i + 8, start.getBlockZ() - i_ - 1));
					}
					b.setType(Material.WOOL);
					b.setData((byte)6);
				}
			}
		}
		
		
		for(int i__ = 0; i__ < 3; i__++){
			for(int i_ = 0; i_ < 4; i_++){
				Block b;
				if(d.equalsIgnoreCase("west")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 7, start.getBlockY() + i__ + 9, start.getBlockZ() - i_ - 3));
				}else if(d.equalsIgnoreCase("east")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 7, start.getBlockY() + i__ + 9, start.getBlockZ() + i_ + 3));
				}else if(d.equalsIgnoreCase("north")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_ + 3, start.getBlockY() + i__ + 9, start.getBlockZ() + 7));
				}else if(d.equalsIgnoreCase("south")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_ - 3, start.getBlockY() + i__ + 9, start.getBlockZ() - 7));
				}else{
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 7, start.getBlockY() + i__ + 8, start.getBlockZ() - i_ - 1));
				}
				b.setType(Material.WOOL);
				b.setData((byte)6);
			}
		}
		
		
		// eyes
		if(d.equalsIgnoreCase("west")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 2)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 7)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 8)).setTypeIdAndData(35, (byte)15, true);
		}else if(d.equalsIgnoreCase("east")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 6, start.getBlockY() + 12, start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 6, start.getBlockY() + 12, start.getBlockZ() + 2)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 6, start.getBlockY() + 12, start.getBlockZ() + 7)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 6, start.getBlockY() + 12, start.getBlockZ() + 8)).setTypeIdAndData(35, (byte)15, true);
		}else if(d.equalsIgnoreCase("north")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 12, start.getBlockZ() + 6)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 2, start.getBlockY() + 12, start.getBlockZ() + 6)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 7, start.getBlockY() + 12, start.getBlockZ() + 6)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 8, start.getBlockY() + 12, start.getBlockZ() + 6)).setTypeIdAndData(35, (byte)15, true);
		}else if(d.equalsIgnoreCase("south")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 12, start.getBlockZ() - 6)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 2, start.getBlockY() + 12, start.getBlockZ() - 6)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 7, start.getBlockY() + 12, start.getBlockZ() - 6)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 8, start.getBlockY() + 12, start.getBlockZ() - 6)).setTypeIdAndData(35, (byte)15, true);
		}else{
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 2)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 7)).setTypeIdAndData(35, (byte)0, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 12, start.getBlockZ() - 8)).setTypeIdAndData(35, (byte)15, true);
		}
	}
	
	public static void undoPig(Location start, String d){
		World w = start.getWorld();
		for(int i__ = 0; i__ < 24; i__++){
			for(int i_ = 0; i_ < 10; i_++){
				for(int i = 0; i < 16; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() - i__ + 7, start.getBlockY() + i, start.getBlockZ() - i_));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() + i__ - 7, start.getBlockY() + i, start.getBlockZ() + i_));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() + i_, start.getBlockY() + i, start.getBlockZ() - i__ + 7));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() - i_, start.getBlockY() + i, start.getBlockZ() + i__ - 7));
					}else{
						b = start.getWorld().getBlockAt(new Location(w, start.getBlockX() - i__ + 7, start.getBlockY() + i, start.getBlockZ() - i_));
					}
					if(b.getType() == Material.WOOL){
						b.setType(Material.AIR);
					}
				}
			}	
		}
	}
}
