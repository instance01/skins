package com.comze_instancelabs.skins;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Chicken {

	public static void buildChicken(Location start, String direction){
		buildLegs(start, direction);
		buildBody(start, direction);
		buildHead(start, direction);
	}
	
	public static void buildLegs(Location start, String d){
		for(int i = 0; i < 6; i++){
			Block b;
			if(d.equalsIgnoreCase("west")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY(), start.getBlockZ() - i));	
			}else if(d.equalsIgnoreCase("east")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY(), start.getBlockZ() + i));	
			}else if(d.equalsIgnoreCase("north")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i, start.getBlockY(), start.getBlockZ() - 1));	
			}else if(d.equalsIgnoreCase("south")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i, start.getBlockY(), start.getBlockZ() + 1));	
			}else{
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i, start.getBlockY(), start.getBlockZ() + 1));
			}
			b.setType(Material.WOOL);
			b.setData((byte)4);
		}
		for(int i = 0; i < 6; i++){
			Block b;
			if(d.equalsIgnoreCase("west")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 2, start.getBlockY(), start.getBlockZ() - i));
			}else if(d.equalsIgnoreCase("east")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 2, start.getBlockY(), start.getBlockZ() + i));
			}else if(d.equalsIgnoreCase("north")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i, start.getBlockY(), start.getBlockZ() - 2));
			}else if(d.equalsIgnoreCase("south")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i, start.getBlockY(), start.getBlockZ() + 2));
			}else{
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 2, start.getBlockY(), start.getBlockZ() - i));
			}
			b.setType(Material.WOOL);
			b.setData((byte)4);
		}
		
		if(d.equalsIgnoreCase("west")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 3, start.getBlockY(), start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)4, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 3, start.getBlockY(), start.getBlockZ() - 4)).setTypeIdAndData(35, (byte)4, true);
		}else if(d.equalsIgnoreCase("east")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 3, start.getBlockY(), start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)4, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 3, start.getBlockY(), start.getBlockZ() + 4)).setTypeIdAndData(35, (byte)4, true);
		}else if(d.equalsIgnoreCase("north")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY(), start.getBlockZ() - 3)).setTypeIdAndData(35, (byte)4, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 4, start.getBlockY(), start.getBlockZ() - 3)).setTypeIdAndData(35, (byte)4, true);
		}else if(d.equalsIgnoreCase("south")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY(), start.getBlockZ() + 3)).setTypeIdAndData(35, (byte)4, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 4, start.getBlockY(), start.getBlockZ() + 3)).setTypeIdAndData(35, (byte)4, true);
		}else{
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 3, start.getBlockY(), start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)4, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 3, start.getBlockY(), start.getBlockZ() - 4)).setTypeIdAndData(35, (byte)4, true);
		}
		
		
		for(int i = 0; i < 6; i++){
			Block b;
			if(d.equalsIgnoreCase("west")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 4, start.getBlockY() + i, start.getBlockZ() - 1));
			}else if(d.equalsIgnoreCase("east")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 4, start.getBlockY() + i, start.getBlockZ() + 1));
			}else if(d.equalsIgnoreCase("north")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + i, start.getBlockZ() - 4));
			}else if(d.equalsIgnoreCase("south")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + i, start.getBlockZ() + 4));
			}else{
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 4, start.getBlockY() + i, start.getBlockZ() - 1));
			}
			b.setType(Material.WOOL);
			b.setData((byte)4);
		}
		for(int i = 0; i < 6; i++){
			Block b;
			if(d.equalsIgnoreCase("west")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 4, start.getBlockY() + i, start.getBlockZ() - 4));
			}else if(d.equalsIgnoreCase("east")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 4, start.getBlockY() + i, start.getBlockZ() + 4));
			}else if(d.equalsIgnoreCase("north")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 4, start.getBlockY() + i, start.getBlockZ() - 4));
			}else if(d.equalsIgnoreCase("south")){
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 4, start.getBlockY() + i, start.getBlockZ() + 4));
			}else{
				b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 4, start.getBlockY() + i, start.getBlockZ() - 4));
			}
			b.setType(Material.WOOL);
			b.setData((byte)4);
		}
	}
	
	public static void buildBody(Location start, String d){
		for(int i__ = 0; i__ < 8; i__++){
			for(int i_ = 0; i_ < 6; i_++){
				for(int i = 0; i < 6; i++){
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
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i + 6, start.getBlockZ() - i_));
					}
					b.setType(Material.WOOL);
					b.setData((byte)0);
				}
			}	
		}
		
		for(int i_ = 0; i_ < 4; i_++){
			for(int i = 0; i < 6; i++){
				Block b;
				if(d.equalsIgnoreCase("west")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i - 1, start.getBlockY() + 8 + i_, start.getBlockZ() + 1));
				}else if(d.equalsIgnoreCase("east")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i + 1, start.getBlockY() + 8 + i_, start.getBlockZ() - 1));
				}else if(d.equalsIgnoreCase("north")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 8 + i_, start.getBlockZ() - i - 1));
				}else if(d.equalsIgnoreCase("south")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 8 + i_, start.getBlockZ() + i + 1));
				}else{
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i - 1, start.getBlockY() + 8 + i_, start.getBlockZ() + 1));
				}
				b.setType(Material.WOOL);
				b.setData((byte)0);
			}
		}
		for(int i_ = 0; i_ < 4; i_++){
			for(int i = 0; i < 6; i++){
				Block b;
				if(d.equalsIgnoreCase("west")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i - 1, start.getBlockY() + 8 + i_, start.getBlockZ() - 6));
				}else if(d.equalsIgnoreCase("east")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i + 1, start.getBlockY() + 8 + i_, start.getBlockZ() + 6));
				}else if(d.equalsIgnoreCase("north")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 6, start.getBlockY() + 8 + i_, start.getBlockZ() - i - 1));
				}else if(d.equalsIgnoreCase("south")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 6, start.getBlockY() + 8 + i_, start.getBlockZ() + i + 1));
				}else{
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i - 1, start.getBlockY() + 8 + i_, start.getBlockZ() - 6));
				}
				b.setType(Material.WOOL);
				b.setData((byte)0);
			}
		}
	}

	public static void buildHead(Location start, String d){
		for(int i__ = 0; i__ < 3; i__++){
			for(int i_ = 0; i_ < 4; i_++){
				for(int i = 0; i < 6; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__, start.getBlockY() + i + 10, start.getBlockZ() - i_ - 1));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__, start.getBlockY() + i + 10, start.getBlockZ() + i_ + 1));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_ + 1 , start.getBlockY() + i + 10, start.getBlockZ() + i__));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_ - 1, start.getBlockY() + i + 10, start.getBlockZ() - i__));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__, start.getBlockY() + i + 10, start.getBlockZ() - i_ - 1));
					}
					b.setType(Material.WOOL);
					b.setData((byte)0);
				}
			}	
		}
		
		//eyes:
		if(d.equalsIgnoreCase("west")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 2, start.getBlockY() + 14, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 2, start.getBlockY() + 14, start.getBlockZ() - 4)).setTypeIdAndData(35, (byte)15, true);
		}else if(d.equalsIgnoreCase("east")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 2, start.getBlockY() + 14, start.getBlockZ() + 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 2, start.getBlockY() + 14, start.getBlockZ() + 4)).setTypeIdAndData(35, (byte)15, true);
		}else if(d.equalsIgnoreCase("north")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 1, start.getBlockY() + 14, start.getBlockZ() - 2)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 4, start.getBlockY() + 14, start.getBlockZ() - 2)).setTypeIdAndData(35, (byte)15, true);
		}else if(d.equalsIgnoreCase("south")){
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 1, start.getBlockY() + 14, start.getBlockZ() + 2)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 4, start.getBlockY() + 14, start.getBlockZ() + 2)).setTypeIdAndData(35, (byte)15, true);
		}else{
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 2, start.getBlockY() + 14, start.getBlockZ() - 1)).setTypeIdAndData(35, (byte)15, true);
			start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 2, start.getBlockY() + 14, start.getBlockZ() - 4)).setTypeIdAndData(35, (byte)15, true);
		}
			
		
		for(int i__ = 0; i__ < 2; i__++){
			for(int i_ = 0; i_ < 4; i_++){
				for(int i = 0; i < 2; i++){
					Block b;
					if(d.equalsIgnoreCase("west")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ + 4, start.getBlockY() + i + 12, start.getBlockZ() - i_ - 1));
					}else if(d.equalsIgnoreCase("east")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i__ - 4, start.getBlockY() + i + 12, start.getBlockZ() + i_ + 1));
					}else if(d.equalsIgnoreCase("north")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i_ + 1, start.getBlockY() + i + 12, start.getBlockZ() - i__ + 4));
					}else if(d.equalsIgnoreCase("south")){
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i_ - 1, start.getBlockY() + i + 12, start.getBlockZ() + i__ - 4));
					}else{
						b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i__ + 4, start.getBlockY() + i + 12, start.getBlockZ() - i_ - 1));
					}
					b.setType(Material.WOOL);
					b.setData((byte)4);
				}
			}	
		}
		
		// red thingy
		for(int i_ = 0; i_ < 2; i_++){
			for(int i = 0; i < 2; i++){
				Block b;
				if(d.equalsIgnoreCase("west")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 3, start.getBlockY() + 10 + i_, start.getBlockZ() - i - 2));
				}else if(d.equalsIgnoreCase("east")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - 3, start.getBlockY() + 10 + i_, start.getBlockZ() + i + 2));
				}else if(d.equalsIgnoreCase("north")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + i + 2, start.getBlockY() + 10 + i_, start.getBlockZ() + 3));
				}else if(d.equalsIgnoreCase("south")){
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() - i - 2, start.getBlockY() + 10 + i_, start.getBlockZ() - 3));
				}else{
					b = start.getWorld().getBlockAt(new Location(start.getWorld(), start.getBlockX() + 3, start.getBlockY() + 10 + i_, start.getBlockZ() - i - 2));
				}
				b.setType(Material.WOOL);
				b.setData((byte)14);
			}
		}
	}
	
}
