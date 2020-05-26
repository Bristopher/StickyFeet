package me.chris.StickyFeet.commands.subcommands;


import java.util.List;

import org.bukkit.entity.Player;
import me.chris.StickyFeet.Main;
import me.chris.StickyFeet.commands.SubCommand;
import net.md_5.bungee.api.ChatColor;


public class DefaultDamagerPerUseCommand extends SubCommand {
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "defaultdamagerperusecommand";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "set the default durability for all boots";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return ChatColor.GOLD + "/StickyFeet DefaultDamagerPerUse" + ChatColor.RESET;
	}

	@Override
	public void perform(Player player, String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 1) {
			Main.leatherBootsDamagePerUse = 1;
			Main.getInstance().getConfig().set("leatherBootsDamagePerUse", Main.leatherBootsDamagePerUse);
			
			Main.ironBootsDamagePerUse = 1;
			Main.getInstance().getConfig().set("ironBootsDamagePerUse", Main.ironBootsDamagePerUse);
			
			Main.diamondBootsDamagePerUse = 1;
			Main.getInstance().getConfig().set("diamondBootsDamagePerUse", Main.diamondBootsDamagePerUse);
			
			
			Main.getInstance().saveConfig();
			Main.getInstance().saveDefaultConfig();

			
		} else if(args.length > 1) {
			player.sendMessage("This command doesnt args, your command didn't go through. Try it with no args.");
		}
	}

	@Override
	public List<String> getSubcommandArguements(Player player, String[] args) {
		return null;
	}
	

}
