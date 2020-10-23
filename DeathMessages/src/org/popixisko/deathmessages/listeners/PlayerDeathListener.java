package org.popixisko.deathmessages.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.popixisko.deathmessages.Main;
import org.popixisko.deathmessages.utils.Utils;

public class PlayerDeathListener implements Listener {

		private static Main plugin;
		
		public PlayerDeathListener (Main plugin) {
			this.plugin = plugin;
			
			Bukkit.getPluginManager().registerEvents(this, plugin);
			
		}
		
		@EventHandler
		public void onDeath(EntityDeathEvent e) {
			if (e.getEntity().getKiller() instanceof Player) {
				
				Player killer = e.getEntity().getKiller();
				Player p = (Player) e.getEntity();
				
				if (killer != p) {
					killer.sendMessage(Utils.chat(plugin.getConfig().getString("killer_message".replace("<player>", p.getName()))));
					p.sendMessage(Utils.chat(plugin.getConfig().getString("playerdeath_message").replace("<killer>",killer.getName())));
				}
				
				((PlayerDeathEvent) e).setDeathMessage(null);
				Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("death_message").replace("<player>", p.getName())));
				return;
				
			}
			else {
				Player p = (Player) e.getEntity();
				Player killer = e.getEntity().getKiller();
				if (p instanceof Player) {
	                String pName = ((Player) p).getName();
	                String mobKilledPlayerMessage = plugin.getConfig().getString("mobdeath_message");
	                String killerName = killer.getType().getName();
	                mobKilledPlayerMessage.replaceAll("<mob>", killerName);
	                mobKilledPlayerMessage.replaceAll("<player", pName);
	
	                plugin.getServer().broadcastMessage(mobKilledPlayerMessage);
	            }
        }
			
		}
}
