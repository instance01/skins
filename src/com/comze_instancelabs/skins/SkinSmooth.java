package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SkinSmooth {
	
	
	static Main main;
	
	public static void smoothPartOfImageEast(Main m, Location t, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component){
		main = m;
		if(component.equalsIgnoreCase("leg1_left")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ());;
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,t.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg1_front")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() - 12, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() + 4);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg1_right")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ() + 3);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ() + 3);;
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,start.getBlockZ() );
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("leg1_behind")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 12, t.getBlockZ() + 3);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 7);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}
		
		
		if(component.equalsIgnoreCase("leg2_left")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ() + 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ() + 4);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,t.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("leg2_front")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() - 12, t.getBlockZ() + 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x + 3);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg2_right")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 11, t.getBlockZ() + 7);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY(), t.getBlockZ() + 7);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y, start.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("leg2_behind")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() - 12, t.getBlockZ() + 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}
		

		
		if(component.equalsIgnoreCase("body_left")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 1, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ());;
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,t.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("body_front")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 1, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 12, t.getBlockZ() + 4);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("body_right")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 1, t.getBlockZ() + 7);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() + 7);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + min_x,end.getBlockY() - j + max_y,start.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("body_behind")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 12, t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm1_bottom")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 13, t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 13, t.getBlockZ());
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() - j + max_y - 1);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_top")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 24, t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 24, t.getBlockZ());
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() - j + max_y - 1);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_left")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() - 4);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY() - j + max_y,start.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm1_front")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() - 4);
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 12, t.getBlockZ());
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm1_right")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() - 1);
			Location end = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 12, t.getBlockZ() - 1);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + i - min_x,end.getBlockY() - j + max_y,start.getBlockZ() );
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm1_behind")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() - 1);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 12, t.getBlockZ() + 3);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}
		
		
		
		if(component.equalsIgnoreCase("arm2_bottom")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 13, t.getBlockZ() + 11);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 13, t.getBlockZ() + 11);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() + j - max_y);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_top")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 24, t.getBlockZ() + 11);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 24, t.getBlockZ() + 11);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY(),start.getBlockZ() + j - max_y);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_left")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 11);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() + 11);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4,end.getBlockY() - j + max_y,start.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("arm2_front")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY(), t.getBlockZ() + 8);
			Location end = new Location(t.getWorld(), t.getBlockX() + 2, t.getBlockY() + 12, t.getBlockZ() + 12);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() - i + min_x + 3);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_right")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 8);
			Location end = new Location(t.getWorld(), t.getBlockX() + 1, t.getBlockY() + 12, t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + i - min_x - 3,end.getBlockY() - j + max_y, start.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("arm2_behind")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY(), t.getBlockZ() + 8);
			Location end = new Location(t.getWorld(), t.getBlockX() + 5, t.getBlockY() + 12, t.getBlockZ() + 12);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}
		
		
		
		
		
		if(component.equalsIgnoreCase("head_left")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 24, t.getBlockZ());;
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() - i,end.getBlockY() - j + max_y,t.getBlockZ());
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("head_front")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX(), t.getBlockY() + 12, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX(), t.getBlockY() + 24, t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_right")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 12, t.getBlockZ() + 7);
			Location end = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 24, t.getBlockZ() + 7);;
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + i - min_x - 7,end.getBlockY() - j + max_y,start.getBlockZ() );
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }
		}else if(component.equalsIgnoreCase("head_behind")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY(), t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 7, t.getBlockY() + 24, t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX(),end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_top")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 32, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 6, t.getBlockY() + 32, t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX()- j + max_y,end.getBlockY(), start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}else if(component.equalsIgnoreCase("head_bottom")){
			Location current = t;
			//getLogger().info("Building " + component);
			Location start = new Location(t.getWorld(), t.getBlockX() - 1, t.getBlockY() + 25, t.getBlockZ());
			Location end = new Location(t.getWorld(), t.getBlockX() + 6, t.getBlockY() + 25, t.getBlockZ() + 8);
			
			////getLogger().info(start.toString());
			////getLogger().info(end.toString());
			
			int[] pixel;
			for(int i = min_x; i < max_x; i++){
		    	for(int j = min_y; j < max_y; j++){
		    		pixel = bi.getRaster().getPixel(i, j, new int[6]);
		    		Color c = new Color(bi.getRGB(i, j));
		    		
		    		Block change = t.getWorld().getBlockAt(start.getBlockX() + j - max_y + 9,end.getBlockY(), start.getBlockZ() + i - min_x);
					////getLogger().info(change.getLocation().toString());
		    		if(m.isHumanSkin(c)){
		    			change.setType(Material.WOOD);
		    			change.setData((byte)2);
		    		}
		    	}
		    }	
		}

	}
	

	
	public static boolean isTransparent(BufferedImage img, int x, int y) {
		int pixel = img.getRGB(x, y);
		if ((pixel >> 24) == 0x00) {
			return true;
		}
		return false;
	}
}
