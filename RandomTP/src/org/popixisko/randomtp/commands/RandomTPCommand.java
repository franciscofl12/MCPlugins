package org.popixisko.randomtp.commands;

import org.popixisko.randomtp.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTPCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	
	public  RandomTPCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("randomtp").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Solo jugadores con este permiso pueden usar el comando!");
			return true;
		}
		Player p = (Player) sender;
		
		if (p.hasPermission("randomtp.use")) {
			p.sendMessage("Vas a ser teletransportado a unas cordenadas.");
			return true;
		} else {
			p.sendMessage("No tienes permisos topo.");
		}
		return false;
	}

}
