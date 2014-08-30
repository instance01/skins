package com.comze_instancelabs.skins;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class SkinBuild {

	static Main main;

	public static void buildPartOfImageEast(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component, String type) {
		main = m;

		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 5, p.getBlockY() + 13, p.getBlockZ() - 4);
			Location end = new Location(p.getWorld(), p.getBlockX() + 1, p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x - 4, end.getBlockY(), start.getBlockZ() - j + max_y - 1);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 32, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - min_x);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
					}
				}
			}
		}

	}

	public static void buildPartOfImageSouth(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component, String type) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ() + 5);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 32, p.getBlockZ());
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - max_x + 1, end.getBlockY(), start.getBlockZ() - j + max_y - 1);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
					}
				}
			}
		}

	}

	public static void buildPartOfImageWest(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component, String type) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 6, p.getBlockY() + 13, p.getBlockZ() + 4);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() - i + max_x - 4);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 7, p.getBlockY() + 32, p.getBlockZ() - 8);
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() + i - min_x, end.getBlockY(), start.getBlockZ() - j + max_y);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
					}
				}
			}
		}

	}

	public static void buildPartOfImageNorth(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, String component, String type) {
		main = m;
		if (component.equalsIgnoreCase("arm1_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() + 7, p.getBlockY() + 13, p.getBlockZ() - 1);
			Location end = new Location(p.getWorld(), p.getBlockX(), p.getBlockY() + 13, p.getBlockZ());

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - j + max_y, end.getBlockY(), start.getBlockZ() + i - max_x);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}

		if (component.equalsIgnoreCase("head_bottom")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 25, p.getBlockZ() + 1);
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 25, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		} else if (component.equalsIgnoreCase("head_top")) {
			Location current = p;

			Location start = new Location(p.getWorld(), p.getBlockX() - 1, p.getBlockY() + 32, p.getBlockZ() + 1);
			Location end = new Location(p.getWorld(), p.getBlockX() + 6, p.getBlockY() + 32, p.getBlockZ() + 8);

			for (int i = min_x; i < max_x; i++) {
				for (int j = min_y; j < max_y; j++) {

					Color c = new Color(bi.getRGB(i, j));

					Block change = p.getWorld().getBlockAt(start.getBlockX() - i + max_x, end.getBlockY(), start.getBlockZ() + j - max_y);

					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
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

						if (type.equalsIgnoreCase("normal")) {
							change.setType(Material.WOOL); //
							change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
						} else if (type.equalsIgnoreCase("clay")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_CLAY);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("glass")) {
							if (!m.getStringFromColorClay(c).equals("NULL")) {
								change.setType(Material.STAINED_GLASS);
								change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
							}
						} else if (type.equalsIgnoreCase("all")) {
							int[] i_ = Main.getMaterialFromColor(c);
							change.setType(Material.getMaterial(i_[0]));
							change.setData((byte) i_[1]);
						}
					}
				}
			}
		}

	}

	// EAST FRONT/BEHIND CUBOID
	public static void buildEastFront(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
				// }
			}
		}
	}

	// EAST FRONT/BEHIND CUBOID INVERTED
	public static void buildEastFrontInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
				// }
			}
		}
	}

	// EAST RIGHT/LEFT CUBOID
	public static void buildEastSide(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// if(!isTransparent(bi, min_x + i, min_y + j)){
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
				// }
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID
	public static void buildWestFront(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID INVERTED
	public static void buildWestFrontInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSide(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// WEST FRONT/BEHIND CUBOID
	public static void buildWestFrontHAT(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - i);
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideHAT(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}
	}

	// WEST RIGHT/LEFT CUBOID
	public static void buildWestSideHATInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID
	public static void buildSouthFront(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() - i, start.getBlockY() + height - j, start.getBlockZ());
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID INVERTED
	public static void buildSouthFrontInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() - width + i, start.getBlockY() + height - j, start.getBlockZ());
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID
	public static void buildSouthSide(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID
	public static void buildSouthSideInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// SOUTH FRONT/BEHIND CUBOID HAT LAYERS
	public static void buildSouthFrontHAT(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() - i, start.getBlockY() + height - j, start.getBlockZ());
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID HAT LAYERS
	public static void buildSouthSideHAT(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}

			}
		}
	}

	// SOUTH RIGHT/LEFT CUBOID HAT LAYERS INVERTED
	public static void buildSouthSideHATInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}

			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID
	public static void buildNorthFront(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + i, start.getBlockY() + height - j, start.getBlockZ());
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID INVERTED
	public static void buildNorthFrontInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX() + width - i, start.getBlockY() + height - j, start.getBlockZ());
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID
	public static void buildNorthSide(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID
	public static void buildNorthSideInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color c = new Color(bi.getRGB(min_x + i, min_y + j));
				Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
				if (type.equalsIgnoreCase("normal")) {
					change.setType(Material.WOOL); //
					change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
				} else if (type.equalsIgnoreCase("clay")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_CLAY);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("glass")) {
					if (!m.getStringFromColorClay(c).equals("NULL")) {
						change.setType(Material.STAINED_GLASS);
						change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
					}
				} else if (type.equalsIgnoreCase("all")) {
					int[] i_ = Main.getMaterialFromColor(c);
					change.setType(Material.getMaterial(i_[0]));
					change.setData((byte) i_[1]);
				}
			}
		}
	}

	// NORTH FRONT/BEHIND CUBOID HAT LAYERS
	public static void buildNorthFrontHAT(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX() + i, start.getBlockY() + height - j, start.getBlockZ());
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}
			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID HAT LAYERS
	public static void buildNorthSideHAT(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() - width + i);
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
					}
				}

			}
		}
	}

	// NORTH RIGHT/LEFT CUBOID HAT LAYERS INVERTED
	public static void buildNorthSideHATInvert(Main m, Location p, BufferedImage bi, int min_x, int max_x, int min_y, int max_y, Location start, String type) {

		int width = max_x - min_x;
		int height = max_y - min_y;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!isTransparent(bi, min_x + i, min_y + j)) {
					Color c = new Color(bi.getRGB(min_x + i, min_y + j));
					Block change = p.getWorld().getBlockAt(start.getBlockX(), start.getBlockY() + height - j, start.getBlockZ() + width - i);
					if (type.equalsIgnoreCase("normal")) {
						change.setType(Material.WOOL); //
						change.setData(DyeColor.valueOf(m.getStringFromColor(c)).getData());
					} else if (type.equalsIgnoreCase("clay")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_CLAY);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("glass")) {
						if (!m.getStringFromColorClay(c).equals("NULL")) {
							change.setType(Material.STAINED_GLASS);
							change.setData(DyeColor.valueOf(m.getStringFromColorClay(c)).getData());
						}
					} else if (type.equalsIgnoreCase("all")) {
						int[] i_ = Main.getMaterialFromColor(c);
						change.setType(Material.getMaterial(i_[0]));
						change.setData((byte) i_[1]);
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
