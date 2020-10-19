package org.popixisko.deathmessages;

import org.bukkit.plugin.java.JavaPlugin;
import org.popixisko.deathmessages.listeners.PlayerDeathListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		new PlayerDeathListener (this);
	}

}
