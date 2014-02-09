package com.comze_instancelabs.skins.utils;

import java.awt.Color;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Blocks {
	
	// maybe for later use
	
	
	/*
	 * Hardened clay:
		955B42
		251711 black
		4A3B5B blue
		4C3223 brown
		555A5A cyan
		3B2C24 gray
		5C532A green
		706C8A light_blue
		677433 lime
		95586D magenta
		A05325 orange
		A45150 pink
		734454 purple
		8E3B2F red
		866A61 silver
		D1B1A1 white
		BD8824 yellow
		
		82E4E0 Diamond_block
		FFF144 Gold_BLOCK
	 */
	
	public static Color white_clay = new Color(221, 221, 221);
	public static Color orange_clay = new Color(219, 125, 62);
	public static Color magenta_clay = new Color(179, 80, 188);
	public static Color lightblue_clay = new Color(107, 138, 201);
	public static Color yellow_clay = new Color(177, 166, 39);
	public static Color lime_clay = new Color(65, 174, 56);
	public static Color pink_clay = new Color(208, 132, 153);
	public static Color gray_clay = new Color(64, 64, 64);
	public static Color lightgray_clay = new Color(154, 161, 161);
	public static Color cyan_clay = new Color(46, 110, 137);
	public static Color purple_clay = new Color(126, 61, 181);
	public static Color blue_clay = new Color(46, 56, 141);
	public static Color brow_clay = new Color(79, 50, 31);
	public static Color green_clay = new Color(53, 70, 27);
	public static Color red_clay = new Color(150, 52, 48);
	public static Color black_clay = new Color(25, 22, 22);
	
	public static Color diamond_block = new Color(150, 52, 48);
	public static Color gold_block = new Color(25, 22, 22);
	
	public static Color birch_wood = new Color(150, 52, 48);
	
	
	public static Color white_wool = new Color(221, 221, 221);
	public static Color orange_wool = new Color(219, 125, 62);
	public static Color magenta_wool = new Color(179, 80, 188);
	public static Color lightblue_wool = new Color(107, 138, 201);
	public static Color yellow_wool = new Color(177, 166, 39);
	public static Color lime_wool = new Color(65, 174, 56);
	public static Color pink_wool = new Color(208, 132, 153);
	public static Color gray_wool = new Color(64, 64, 64);
	public static Color lightgray_wool = new Color(154, 161, 161);
	public static Color cyan_wool = new Color(46, 110, 137);
	public static Color purple_wool = new Color(126, 61, 181);
	public static Color blue_wool = new Color(46, 56, 141);
	public static Color brown_wool = new Color(79, 50, 31);
	public static Color green_wool = new Color(53, 70, 27);
	public static Color red_wool = new Color(150, 52, 48);
	public static Color black_wool = new Color(25, 22, 22);
	
	public static HashMap<Color, Material> blockm = new HashMap<Color, Material>(); // material
	public static HashMap<Color, Integer> blockd = new HashMap<Color, Integer>(); // data
	
	public static void init(){
		blockm.put(white_wool, Material.WOOL);
		blockd.put(white_wool, 0);
		blockm.put(orange_wool, Material.WOOL);
		blockd.put(orange_wool, 1);
		blockm.put(magenta_wool, Material.WOOL);
		blockd.put(magenta_wool, 2);
		blockm.put(lightblue_wool, Material.WOOL);
		blockd.put(lightblue_wool, 3);
		blockm.put(yellow_wool, Material.WOOL);
		blockd.put(yellow_wool, 4);
		blockm.put(lime_wool, Material.WOOL);
		blockd.put(lime_wool, 5);
		blockm.put(pink_wool, Material.WOOL);
		blockd.put(pink_wool, 6);
		blockm.put(gray_wool, Material.WOOL);
		blockd.put(gray_wool, 7);
		blockm.put(lightgray_wool, Material.WOOL);
		blockd.put(lightgray_wool, 8);
		blockm.put(cyan_wool, Material.WOOL);
		blockd.put(cyan_wool, 9);
		blockm.put(purple_wool, Material.WOOL);
		blockd.put(purple_wool, 10);
		blockm.put(blue_wool, Material.WOOL);
		blockd.put(blue_wool, 11);
		blockm.put(brown_wool, Material.WOOL);
		blockd.put(brown_wool, 12);
		blockm.put(green_wool, Material.WOOL);
		blockd.put(green_wool, 13);
		blockm.put(red_wool, Material.WOOL);
		blockd.put(red_wool, 14);
		blockm.put(black_wool, Material.WOOL);
		blockd.put(black_wool, 15);
	}
	
}
