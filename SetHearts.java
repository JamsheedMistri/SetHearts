package com.mistri.plugin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class SetHearts extends JavaPlugin {
	Logger log = Bukkit.getLogger();

	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String prefix = (ChatColor.DARK_GRAY + "[" + ChatColor.RED + "❤" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY);
		String error = (ChatColor.DARK_RED + "");
		String heart = (ChatColor.RED + "❤");

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("sethearts.*")) {
				if (commandLabel.equalsIgnoreCase("sethearts")) {
					if (args.length == 1) {
						try {
							p.setHealthScale(Double.parseDouble(args[0]) * 2);
							p.sendMessage(prefix + "Set your hearts to " + heart + (Double.parseDouble(args[0])));
						}
						catch(NumberFormatException exception) {
							p.sendMessage(prefix + error + args[0] + " is not a valid number.");
						}

					}
					else if (args.length == 2) {
						if (Bukkit.getPlayer(args[0]) != null) {
							try {
								Player target = Bukkit.getPlayer(args[0]);
								target.setHealthScale(Double.parseDouble(args[1]) * 2);
								p.sendMessage(prefix + "Set the amount of hearts of " + args[0] + " to " + heart + (Double.parseDouble(args[1])));
							}
							catch(NumberFormatException exception) {
								p.sendMessage(prefix + error + args[0] + " is not a number.");
							}

						}

					}
					else if (args.length == 0) {
						p.sendMessage(prefix + "SetHearts v1.0 made by " + error + ChatColor.BOLD + "MISTRI\n" + prefix + "Usage: " + ChatColor.RED + "/sethearts [player] <amount>");

					}
					else p.sendMessage(prefix + error + "Improper usage.\n" + prefix + "Correct usage: " + ChatColor.BLUE + "/sethearts [player] <amount>");

				}
			}


		}



		return true;
	}

}
