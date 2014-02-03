package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SkinUpdate {

	static Main main;

	public static void buildPartOfImageEast(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;

		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 5, p.getBlockY() + 13, p.getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getBlockX() + 1, p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() - j + max_y - 1);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());

				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 5, p.getBlockY() + 24, p.getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getBlockX() + 1, p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() - j + max_y - 1);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 5, p.getBlockY() + 13, p.getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getBlockX() + 1, p.getBlockY() + 13, p.getBlockZ() + 11);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() + j - max_y);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 5, p.getBlockY() + 24, p.getBlockZ() + 11);
			Location end = new Location(p.getWorld(), p.getBlockX() + 1, p.getBlockY() + 24, p.getBlockZ() + 11);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() + j - max_y);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 25, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 25, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 9, end.getBlockY(), start.getBlockZ() + i - min_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 32, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			// //getLogger().info(start.toString());
			// //getLogger().info(end.toString());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - min_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("hat_left")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY(), p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 8, end.getBlockY() - j + max_y, p.getBlockZ() - 1);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_front")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 12, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 24, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - 1, end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_right")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY() + 12, p.getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 24, p.getBlockZ() + 7);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x - 7, end.getBlockY() - j + max_y, start.getBlockZ() + 1);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_behind")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY(), p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY() + 24, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + 1, end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 32, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY() + 1, start.getBlockZ() + i - min_x);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		}

	}

	public static void buildPartOfImageSouth(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ() + 5);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 24, p.getBlockZ() + 5);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 7, p.getBlockY() + 13, p.getBlockZ() + 1);
			Location end = new Location(p.getWorld(), p.getBlockX() - 11, p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y, end.getBlockY(), start.getBlockZ() - i + max_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 11, p.getBlockY() + 24, p.getBlockZ() + 6);
			Location end = new Location(p.getWorld(), p.getBlockX() - 11, p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 25, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 25, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 1, end.getBlockY(), start.getBlockZ() + i - min_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 32, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			// //getLogger().info(start.toString());
			// //getLogger().info(end.toString());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - max_x + 1, end.getBlockY(), start.getBlockZ() - j + max_y - 1);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("hat_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 7, p.getBlockY() + 32, p.getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() + 1, start.getBlockZ() - j + max_y);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		}

	}

	public static void buildPartOfImageWest(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 6, p.getBlockY() + 13, p.getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 6, p.getBlockY() + 24, p.getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 13, p.getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getBlockX() - 11, p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y, end.getBlockY(), start.getBlockZ() + i - max_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 6, p.getBlockY() + 24, p.getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getBlockX() - 11, p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 8, p.getBlockY() + 25, p.getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 25, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 9, end.getBlockY(), start.getBlockZ() + i - min_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 7, p.getBlockY() + 32, p.getBlockZ() - 8);
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			// //getLogger().info(start.toString());
			// //getLogger().info(end.toString());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY(), start.getBlockZ() - j + max_y);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("hat_left")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY(), p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - 1, end.getBlockY() - j + max_y, p.getBlockZ() - i + max_x - 8);

						change.setType(Material.WOOL);
						change.setData(DyeColor.BLACK.getData());
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_front")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 12, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 24, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() - j + max_y, start.getBlockZ() - 1);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_right")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 12, p.getBlockZ() + 7);
			Location end = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 24, p.getBlockZ() + 7);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + 1, end.getBlockY() - j + max_y, start.getBlockZ() + i - min_x - 7);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_behind")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY(), p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY() + 24, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() - j + max_y, start.getBlockZ() + 1);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		} else if (component.equalsIgnoreCase("hat_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 8, p.getBlockY() + 32, p.getBlockZ() - 7);
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY() + 1, start.getBlockZ() + i - min_x);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		}

	}

	public static void buildPartOfImageNorth(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY() + 13, p.getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - max_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("arm1_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY() + 24, p.getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - max_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("arm2_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getBlockX() - 11, p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y, end.getBlockY(), start.getBlockZ() + i - max_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.BLACK.getData());
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("arm2_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 24, p.getBlockZ() - 6);
			Location end = new Location(p.getWorld(), p.getBlockX() - 11, p.getBlockY() + 24, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - max_x, end.getBlockY(), start.getBlockZ() - j + max_y);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 25, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 25, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + j - max_y + 1, end.getBlockY(), start.getBlockZ() + i - min_x);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 32, p.getBlockZ() + 1);
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			// //getLogger().info(start.toString());
			// //getLogger().info(end.toString());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);

					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}

		if (component.equalsIgnoreCase("hat_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 32, p.getBlockZ() - 8);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					if (!isTransparent(bi, i, j)) {
						Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY() + 1, start.getBlockZ() - j + max_y);

						change.setType(Material.WOOL);
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					}
				}
			}
		}

	}

	// EAST FRONT/BEHIND CUBOID
	public static void buildEastFront(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + i);
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				// }
			}
		}
	}

	// EAST FRONT/BEHIND CUBOID INVERTED
	public static void buildEastFrontInvert(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				// }
			}
		}
	}

	// EAST RIGHT/LEFT CUBOID
	public static void buildEastSide(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				// }
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID
	public static void buildWestFront(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - i);
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID INVERTED
	public static void buildWestFrontInvert(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSide(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID
	public static void buildWestFrontHAT(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - i);
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideHAT(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideHATInvert(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID
	public static void buildSouthFront(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX() - i, start.getBlockY() + height - j, start.getBlockZ());
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID INVERTED
	public static void buildSouthFrontInvert(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID
	public static void buildSouthSide(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID HAT LAYERS
	public static void buildSouthFrontHAT(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX() - i, start.getBlockY() + height - j, start.getBlockZ());
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID HAT LAYERS
	public static void buildSouthSideHAT(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}

			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID HAT LAYERS INVERTED
	public static void buildSouthSideHATInvert(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}

			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID
	public static void buildNorthFront(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX() + i, start.getBlockY() + height - j, start.getBlockZ());
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID INVERTED
	public static void buildNorthFrontInvert(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID
	public static void buildNorthSide(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				change.setType(Material.WOOL);
				change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID HAT LAYERS
	public static void buildNorthFrontHAT(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX() + i, start.getBlockY() + height - j, start.getBlockZ());
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID HAT LAYERS
	public static void buildNorthSideHAT(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				}

			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID HAT LAYERS INVERTED
	public static void buildNorthSideHATInvert(Main m, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = start.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
					change.setType(Material.WOOL);
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
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
