package me.franciscofl12.privatemessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 
		if (cmd.getName().equalsIgnoreCase("msg")){
			
			//msg <jugador> <mensaje>
			@SuppressWarnings("deprecation")
		
			Player p = Bukkit.getPlayer(args[0]);
			
			if (p!=null) {
				
				String message = "";
				
				for(int i = 1; i != args.length; i++)
					message += args[i] + " ";
			
				p.sendMessage(ChatColor.GRAY + "(" + ChatColor.DARK_PURPLE + "Direct" + ChatColor.GRAY + ") " + ChatColor.WHITE + sender.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + message);
						
			}
			else 
				sender.sendMessage("Ese usuario no esta conectado.");
		}
		
		return true;
	}
}
