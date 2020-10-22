package org.popixisko.deathmessages.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Monster;
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
			
			if (e.getEntity().getKiller() instanceof Monster) {
				Monster mob = (Monster) e.getEntity();
				Player p = e.getEntity();
				e.setDeathMessage(null);
				
				Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("mob_message").replace("<mob>", mob.getName().replace("<player>", p.getName()))));
			}
			if (e.getEntity().getKiller() instanceof Player) {
				
				Player killer = e.getEntity().getKiller();
				Player p= e.getEntity();
				
				if (killer != p) {
					killer.sendMessage(Utils.chat(plugin.getConfig().getString("killer_message".replace("<player>", p.getName()))));
					p.sendMessage(Utils.chat(plugin.getConfig().getString("playerdeath_message").replace("<killer>",killer.getName())));
				}
				
				e.setDeathMessage(null);
				Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("death_message").replace("<player>", p.getName())));
				return;
				
			}
		}
}
