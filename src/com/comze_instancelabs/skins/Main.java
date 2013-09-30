package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
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

	
	
	//TODO: BUGS
	// right leg is identical to left one and not rotated -> fail
	
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("skin")){
			Player p = (Player)sender;
			BufferedImage Image1;
			BufferedImage Image2;
			try {
				//TODO download image;
				
				Image1 = ImageIO.read(new File("ped4.png"));
				
				Image2 = ConvertUtil.convert4(Image1);
				
				// test
				File outputfile = new File("ped4_.png");
			    ImageIO.write(Image2, "png", outputfile);
				// test
			    
				//int[][] result = convertTo2DWithoutUsingGetRGB(Image2);
			    /*int[] pixel = null;
			    ArrayList<Color> ac = new ArrayList<Color>();
			    for (int y = 0; y < Image2.getHeight(); y++) {
			        for (int x = 0; x < Image2.getWidth(); x++) {
			            pixel = Image2.getRaster().getPixel(x, y, new int[3]);
			            //System.out.println(pixel[0] + " - " + pixel[1] + " - " + pixel[2] + " - " + (Image2.getWidth() * y + x));
			            //System.out.print("\r" + (Image2.getWidth() * y + x));
			            Color c = new Color(Image2.getRGB(x, y));
			        }
			    }*/
			    
			    // build skin
			    build(p, Image2);
			    
				//Color c = new Color(result[9][9]);
				/*Block change = p.getWorld().getBlockAt(p.getLocation().getBlockX(),p.getLocation().getBlockY(),p.getLocation().getBlockZ());
				change.setType(Material.WOOL);
				change.setData(DyeColor.BLACK.getData());*/
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return true;
		}
		return false;
	}
	
	
	private void build(Player p, BufferedImage Image2){
		// leg1
		buildPartOfImage(p, Image2, 0, 4, 20, 32, "leg1_left");
		buildPartOfImage(p, Image2, 4, 8, 20, 32, "leg1_front");
		buildPartOfImage(p, Image2, 8, 12, 20, 32, "leg1_right");
		buildPartOfImage(p, Image2, 12, 16, 20, 32, "leg1_behind");
		// leg2
		buildPartOfImage(p, Image2, 0, 4, 20, 32, "leg2_left");
		buildPartOfImage(p, Image2, 4, 8, 20, 32, "leg2_front");
		buildPartOfImage(p, Image2, 8, 12, 20, 32, "leg2_right");
		buildPartOfImage(p, Image2, 12, 16, 20, 32, "leg2_behind");
		// body
		buildPartOfImage(p, Image2, 16, 20, 20, 32, "body_left");
		buildPartOfImage(p, Image2, 20, 28, 20, 32, "body_front");
		buildPartOfImage(p, Image2, 28, 32, 20, 32, "body_right");
		buildPartOfImage(p, Image2, 32, 40, 20, 32, "body_behind");
		// arm1
		
		// arm2
		
		// head
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
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 12, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 4);
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
		
		
		if(component.equalsIgnoreCase("leg2_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 11, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 4);
			
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
		}else if(component.equalsIgnoreCase("leg2_front")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY() - 12, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 2, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 8);
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
		}else if(component.equalsIgnoreCase("leg2_right")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 11, p.getLocation().getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 7);
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
		}else if(component.equalsIgnoreCase("leg2_behind")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() - 12, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY(), p.getLocation().getBlockZ() + 8);
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
		
		
		//TODO BODY
		if(component.equalsIgnoreCase("body_left")){
			Location current = p.getLocation();
			getLogger().info("Building " + component);
			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ());;
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
			
			getLogger().info(start.toString());
			getLogger().info(end.toString());
			
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
	}
	
	
	public String getStringFromColor(Color c){
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
		}else{
			ret = "WHITE";
		}
		
		return ret;
	}
	
	
	private static int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {

	      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	      final int width = image.getWidth();
	      final int height = image.getHeight();
	      final boolean hasAlphaChannel = image.getAlphaRaster() != null;

	      int[][] result = new int[height][width];
	      if (hasAlphaChannel) {
	         final int pixelLength = 4;
	         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
	            argb += ((int) pixels[pixel + 1] & 0xff); // blue
	            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
	            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
	            result[row][col] = argb;
	            col++;
	            if (col == width) {
	               col = 0;
	               row++;
	            }
	         }
	      } else {
	         final int pixelLength = 3;
	         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += -16777216; // 255 alpha
	            argb += ((int) pixels[pixel] & 0xff); // blue
	            argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
	            argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
	            result[row][col] = argb;
	            col++;
	            if (col == width) {
	               col = 0;
	               row++;
	            }
	         }
	      }

	      return result;
	   }
}
