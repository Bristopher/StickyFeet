package me.chris.StickyFeet.commands;

import java.util.List;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    //name of the subcommand ex. /prank <subcommand> <-- that
    public abstract String getName();

    //ex. "This is a subcommand that let's a shark eat someone"
    public abstract String getDescription();

    //How to use command ex. /prank freeze <player>
    public abstract String getSyntax();

    //code for the subcommand
    public abstract void perform(Player player, String args[]);

    //Use if u want another sub command within command
    public abstract List<String> getSubcommandArguements(Player player, String args[]);
}
