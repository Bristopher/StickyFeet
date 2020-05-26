package me.chris.StickyFeet.commands.subcommands;


import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import me.chris.StickyFeet.Main;
import me.chris.StickyFeet.commands.SubCommand;
import net.md_5.bungee.api.ChatColor;


public class VersionCommand extends SubCommand {
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "version";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "gives you the current version of the plugin";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return ChatColor.GOLD + "/StickyFeet Version" + ChatColor.RESET;
	}

	@Override
	public void perform(Player player, String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 1) {
			PluginDescriptionFile pdfFile = Main.getInstance().getDescription();
			player.sendMessage(pdfFile.getVersion());
			
		} else if(args.length > 1) {
			player.sendMessage("This command has no args, your command didn't go through. Try it with no args.");
		}
	}

	@Override
	public List<String> getSubcommandArguements(Player player, String[] args) {
		return null;
	}
	
	
}
