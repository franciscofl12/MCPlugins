package org.popixisko.listeners;

import org.bukkit.plugin.java.JavaPlugin;
import org.popixisko.listeners.join.JoinListener;

public class Main extends JavaPlugin {
	 
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new JoinListener(this);
	}

}
