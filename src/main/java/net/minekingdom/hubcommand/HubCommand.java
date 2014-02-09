package net.minekingdom.hubcommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HubCommand extends JavaPlugin {
	
	private static HubCommand instance;
	
	@Override
	public void onEnable() {
		instance = this;
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static HubCommand getInstance() {
		return instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("hub")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("GTFO THIS IS A PLAYER COMMAND.");
			} else {
				Player player = (Player) sender;
				player.sendMessage("Connecting you to the hub");
				BungeeUtils.connect(player,"lobby");
			}
			return true;
		}
		return false;
	}
}
