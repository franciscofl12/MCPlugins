package org.popixisko.randomtp;

import org.bukkit.plugin.java.JavaPlugin;
import org.popixisko.randomtp.commands.RandomTPCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new RandomTPCommand(this);
	} 
	

}
