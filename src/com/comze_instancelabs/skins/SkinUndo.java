package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SkinUndo {
	public static void undoPartOfImageEast(Location t, int min_x, int max_x, int min_y, int max_y, String component){
		if(component.equalsIgnoreCase("leg1_left")){
			Location current = t;
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ());;

			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,t.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg1_front")){
			Location current = t;
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() - 12, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() + 4);

			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg1_right")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ() + 3);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ() + 3);;

			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,start.getBlockZ() );
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    	}
		    }
		}else if(component.equalsIgnoreCase("leg1_behind")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 12, t.getBlockZ() + 3);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 7);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}
		
		
		if(component.equalsIgnoreCase("leg2_left")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ() + 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ() + 4);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,t.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }
		}else if(component.equalsIgnoreCase("leg2_front")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() - 12, t.getBlockZ() + 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() + 8);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x + 3);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg2_right")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ() + 7);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ() + 7);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y, start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg2_behind")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 12, t.getBlockZ() + 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 8);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}
		

		
		if(component.equalsIgnoreCase("body_left")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 1, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ());;
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,t.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("body_front")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 1, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 12, t.getBlockZ() + 4);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}else if(component.equalsIgnoreCase("body_right")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 1, t.getBlockZ() + 7);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() + 7);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }
		}else if(component.equalsIgnoreCase("body_behind")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 12, t.getBlockZ() + 8);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm1_bottom")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 13, t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 13, t.getBlockZ());
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() - j + max_y - 1);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_top")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 24, t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 24, t.getBlockZ());
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() - j + max_y - 1);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_left")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() - 4);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY() - j + max_y,start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_front")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 12, t.getBlockZ());
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm1_right")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() - 1);
			Location end = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 12, t.getBlockZ() - 1);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + i - min_x,end.getBlockY() - j + max_y,start.getBlockZ() );
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm1_behind")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() - 1);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 12, t.getBlockZ() + 3);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm2_bottom")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 13, t.getBlockZ() + 11);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 13, t.getBlockZ() + 11);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() + j - max_y);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_top")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 24, t.getBlockZ() + 11);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 24, t.getBlockZ() + 11);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() + j - max_y);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_left")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 11);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() + 11);
			
			//
			//
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		
		    		
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY() - j + max_y,start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm2_front")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() + 8);
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 12, t.getBlockZ() + 12);

			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x + 3);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_right")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 8);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() + 8);
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + i - min_x - 3,end.getBlockY() - j + max_y, start.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_behind")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 8);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 12, t.getBlockZ() + 12);
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}
		
		
		
		
		
		if(component.equalsIgnoreCase("head_left")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 24, t.getBlockZ());;
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,t.getBlockZ());
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
					
		    	}
		    }
		}else if(component.equalsIgnoreCase("head_front")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX(), t.getBlockY() + 12, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX(), t.getBlockY() + 24, t.getBlockZ() + 8);
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_right")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 12, t.getBlockZ() + 7);
			Location end = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 24, t.getBlockZ() + 7);;
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + i - min_x - 7,end.getBlockY() - j + max_y,start.getBlockZ() );
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }
		}else if(component.equalsIgnoreCase("head_behind")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 24, t.getBlockZ() + 8);
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_top")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 32, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 6, t.getBlockY() + 32, t.getBlockZ() + 8);
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX()- j + max_y,end.getBlockY(), start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_bottom")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 25, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 6, t.getBlockY() + 25, t.getBlockZ() + 8);

			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + j - max_y + 9,end.getBlockY(), start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    		
		    	}
		    }	
		}
		
		
		
		
		
		
		if(component.equalsIgnoreCase("hat_left")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 24, t.getBlockZ());;

			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 8,end.getBlockY() - j + max_y,t.getBlockZ() - 1);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
					change.setData(DyeColor.BLACK.getData());
		    	}
		    }
		}else if(component.equalsIgnoreCase("hat_front")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX(), t.getBlockY() + 12, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX(), t.getBlockY() + 24, t.getBlockZ() + 8);

			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - 1,end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);

		    	}
		    }	
		}else if(component.equalsIgnoreCase("hat_right")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 12, t.getBlockZ() + 7);
			Location end = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 24, t.getBlockZ() + 7);;

			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + i - min_x - 7,end.getBlockY() - j + max_y,start.getBlockZ() + 1);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    	}
		    }
		}else if(component.equalsIgnoreCase("hat_behind")){
			Location current = t;
			
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 24, t.getBlockZ() + 8);
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + 1,end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    	}
		    }	
		}else if(component.equalsIgnoreCase("hat_top")){
			Location current = t;
			Location start = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 32, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 6, t.getBlockY() + 32, t.getBlockZ() + 8);

			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		Block change = t.getWorld().getBlockAt(start.getBlockX()- j + max_y,end.getBlockY() + 1, start.getBlockZ() + i - min_x);
					//getLogger().info(change.getLocation().toString());
		    		change.setType(Material.AIR);
		    	}
		    }	
		}

	}
}
