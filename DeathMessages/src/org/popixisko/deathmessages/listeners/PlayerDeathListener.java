package org.popixisko.deathmessages.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
		public void onPlayerDeath(PlayerDeathEvent e) {
			if (e.getEntity().getKiller() instanceof Player) {
				
				Player killer = e.getEntity().getKiller();
				Player p= e.getEntity();
				
				killer.sendMessage(Utils.chat("&8[&a*&8] &7 Le has petado el culo a &6 " + p.getDisplayName()));
				p.sendMessage(Utils.chat("&8[&c*&8] &7 Tu culo ha sido petado por &c " + killer.getDisplayName()));
				e.setDeathMessage(null);
				Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("death_message").replace("<player>", p.getName())));
				return;
				
			}
		}
}
