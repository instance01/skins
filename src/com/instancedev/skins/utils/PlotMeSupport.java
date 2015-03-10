package com.instancedev.skins.utils;

import com.worldcretornica.plotme_core.Plot;
import com.worldcretornica.plotme_core.PlotMeCoreManager;
import com.worldcretornica.plotme_core.api.IPlayer;
import com.worldcretornica.plotme_core.bukkit.PlotMe_CorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PlotMeSupport {

	public static PlotMe_CorePlugin getPlotMe() {
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PlotMe");

		if (plugin == null || !(plugin instanceof PlotMe_CorePlugin)) {
			return null;
		}

		return (PlotMe_CorePlugin) plugin;
	}
	
	public static boolean canBuildPlotMe(Player p, Location l) {
		final PlotMeCoreManager manager = PlotMeCoreManager.getInstance();
		IPlayer player = getPlotMe().wrapPlayer(p);
		String id = manager.getPlotId(player);
		if (!id.isEmpty()) {
			Plot plot = manager.getMap(player).getPlot(id);
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
