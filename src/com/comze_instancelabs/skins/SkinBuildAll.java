package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SkinBuildAll {

	static Main main;

	public static void buildPartOfImageEast(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;

		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() - j + max_y - 1);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() - j + max_y - 1);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() + 11);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() + j - max_y);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 5, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 11);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() + j - max_y);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 9, end.getBlockY(), start.getBlockZ() + i - min_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - min_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("hat_left")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 8, end.getBlockY() - j + max_y, p.getLocation().getBlockZ() - 1);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_front")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - 1, end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_right")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 7);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x - 7, end.getBlockY() - j + max_y, start.getBlockZ() + 1);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_behind")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + 1, end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY() + 1, start.getBlockZ() + i - min_x);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}

	}

	public static void buildPartOfImageSouth(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() + 5);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 5);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 7, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() + 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 11, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y, end.getBlockY(), start.getBlockZ() - i + max_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 11, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 6);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 11, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 1, end.getBlockY(), start.getBlockZ() + i - min_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - max_x + 1, end.getBlockY(), start.getBlockZ() - j + max_y - 1);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("hat_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 7, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() + 1, start.getBlockZ() - j + max_y);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}

	}

	public static void buildPartOfImageWest(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 6, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 6, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 11, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y, end.getBlockY(), start.getBlockZ() + i - max_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 6, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 11, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 8, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 9, end.getBlockY(), start.getBlockZ() + i - min_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 7, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() - 8);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY(), start.getBlockZ() - j + max_y);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("hat_left")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - 1, end.getBlockY() - j + max_y, p.getLocation().getBlockZ() - i + max_x - 8);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_front")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() - j + max_y, start.getBlockZ() - 1);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_right")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 12, p.getLocation().getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 7);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + 1, end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x - 7);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_behind")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() - j + max_y, start.getBlockZ() + 1);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 8, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY() + 1, start.getBlockZ() + i - min_x);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}

	}

	public static void buildPartOfImageNorth(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - max_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() + 7, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - max_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 11, p.getLocation().getBlockY() + 13, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y, end.getBlockY(), start.getBlockZ() + i - max_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ() - 6);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() - 11, p.getLocation().getBlockY() + 24, p.getLocation().getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - max_x, end.getBlockY(), start.getBlockZ() - j + max_y);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ());
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 25, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 1, end.getBlockY(), start.getBlockZ() + i - min_x);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX() - 1, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 1);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX() + 6, p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);
					
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}

		if (component.equalsIgnoreCase("hat_top")) {
			Location current = p.getLocation();

			Location start = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() - 8);
			Location end = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 32, p.getLocation().getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() + 1, start.getBlockZ() - j + max_y);
						
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}

	}

	// EAST FRONT/BEHIND CUBOID
	public static void buildEastFront(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
				// }
			}
		}
	}

	// EAST FRONT/BEHIND CUBOID INVERTED
	public static void buildEastFrontInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
				// }
			}
		}
	}

	// EAST RIGHT/LEFT CUBOID
	public static void buildEastSide(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
				// }
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID
	public static void buildWestFront(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID INVERTED
	public static void buildWestFrontInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSide(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID
	public static void buildWestFrontHAT(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - i);
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideHAT(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideHATInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID
	public static void buildSouthFront(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() - i, start.getBlockY() + height - j, start.getBlockZ());
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID INVERTED
	public static void buildSouthFrontInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID
	public static void buildSouthSide(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID
	public static void buildSouthSideInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID HAT LAYERS
	public static void buildSouthFrontHAT(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() - i, start.getBlockY() + height - j, start.getBlockZ());
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID HAT LAYERS
	public static void buildSouthSideHAT(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}

			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID HAT LAYERS INVERTED
	public static void buildSouthSideHATInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}

			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID
	public static void buildNorthFront(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + i, start.getBlockY() + height - j, start.getBlockZ());
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID INVERTED
	public static void buildNorthFrontInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID
	public static void buildNorthSide(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID
	public static void buildNorthSideInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				int[] i_ = Main.getMaterialFromColor(c);
				change.setType(Material.getMaterial(i_[0]));
				change.setData((byte) i_[1]);
			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID HAT LAYERS
	public static void buildNorthFrontHAT(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() + i, start.getBlockY() + height - j, start.getBlockZ());
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID HAT LAYERS
	public static void buildNorthSideHAT(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}

			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID HAT LAYERS INVERTED
	public static void buildNorthSideHATInvert(Main m, Player p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
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
