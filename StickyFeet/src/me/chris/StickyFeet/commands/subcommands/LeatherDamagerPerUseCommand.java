package me.chris.StickyFeet.commands.subcommands;


import java.util.List;

import org.bukkit.entity.Player;
import me.chris.StickyFeet.Main;
import me.chris.StickyFeet.commands.SubCommand;
import net.md_5.bungee.api.ChatColor;


public class LeatherDamagerPerUseCommand extends SubCommand {
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "leatherdamagerperusecommand";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "set the durability per 2 ladders placed (default 1)";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return ChatColor.GOLD + "/StickyFeet LeatherBootsDamagePerUse <number-value 0.0-inf>" + ChatColor.RESET;
	}

	@Override
	public void perform(Player player, String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length > 1) {
			//Player target = Bukkit.getPlayer(args[1]);
			
			// String userInput = label.substring(18);

			Main.leatherBootsDamagePerUse = Integer.parseInt(args[0]);
			Main.getInstance().getConfig().set("leatherBootsDamagePerUse", Main.leatherBootsDamagePerUse);
			Main.getInstance().saveConfig();
			Main.getInstance().saveDefaultConfig();

			player.sendMessage("Sticky leather boots now take " + ChatColor.BOLD + "" + ChatColor.BLUE
					+ Main.leatherBootsDamagePerUse + ChatColor.RESET + "" + " durability per 2 ladders (default: 1)");
		} else if(args.length == 1) {
			player.sendMessage("You didn't provide a number");
			player.sendMessage("Usage: /StickyFeet LeatherBootsDamagePerUse <number-value 0.0-inf>");
		}
	}

	@Override
	public List<String> getSubcommandArguements(Player player, String[] args) {
		return null;
	}
	
	
}
