package com.instancedev.skins.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.worldcretornica.plotme.Plot;
import com.worldcretornica.plotme.PlotManager;
import com.worldcretornica.plotme.PlotMe;

public class PlotMeSupport {

	public static PlotMe getPlotMe() {
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PlotMe");

		if (plugin == null || !(plugin instanceof PlotMe)) {
			return null;
		}

		return (PlotMe) plugin;
	}
	
	public static boolean canBuildPlotMe(Player p, Location l) {
		String id = PlotManager.getPlotId(l);
		if (!id.equalsIgnoreCase("")) {
			Plot plot = PlotManager.getMap(p).plots.get(id);
			if (plot == null) {
				if (!p.isOp()) {
					return false;
				}
			} else if (!plot.isAllowed(p.getUniqueId())) {
				if (!p.isOp()) {
					return false;
				}
			}
		} else {
			if (!p.isOp()) {
				return false;
			}
		}

		return true;
	}
}
