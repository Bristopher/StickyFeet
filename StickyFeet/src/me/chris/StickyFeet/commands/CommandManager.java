package me.chris.StickyFeet.commands;


import me.chris.StickyFeet.commands.subcommands.DefaultDamagerPerUseCommand;
import me.chris.StickyFeet.commands.subcommands.DiamondDamagerPerUseCommand;
import me.chris.StickyFeet.commands.subcommands.IronDamagerPerUseCommand;
import me.chris.StickyFeet.commands.subcommands.LeatherDamagerPerUseCommand;
import me.chris.StickyFeet.commands.subcommands.VersionCommand;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;


public class CommandManager implements TabExecutor {

    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public CommandManager(){
        subcommands.add(new LeatherDamagerPerUseCommand());
        subcommands.add(new IronDamagerPerUseCommand());
        subcommands.add(new DiamondDamagerPerUseCommand());
        subcommands.add(new DefaultDamagerPerUseCommand());
        subcommands.add(new VersionCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length > 0){
                for (int i = 0; i < getSubcommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).perform(p, args);
                    }
                }
            }else if(args.length == 0){
                p.sendMessage(ChatColor.YELLOW + "--------------------------------" + ChatColor.RESET);
                p.sendMessage(ChatColor.BOLD +  "" + ChatColor.YELLOW + "Usage:" + ChatColor.RESET);
                for (int i = 0; i < getSubcommands().size(); i++){
                    p.sendMessage(getSubcommands().get(i).getSyntax());
                    p.sendMessage(" - " + getSubcommands().get(i).getDescription());
                }
                p.sendMessage(ChatColor.YELLOW + "--------------------------------" + ChatColor.RESET);
            }

        }


        return true;
    }

    public ArrayList<SubCommand> getSubcommands(){
        return subcommands;
    }

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		
		if(args.length == 1) { //Stickyfeet <subcommand> <target>
			ArrayList<String> subcommandsArguments = new ArrayList<String>();
			
			for (int i = 0; i < getSubcommands().size(); i++){ 
				subcommandsArguments.add(getSubcommands().get(i).getName());
			}
			
			return subcommandsArguments;
		}
		
		
		return null;
	}

}
