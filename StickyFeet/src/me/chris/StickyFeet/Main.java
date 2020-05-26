package me.chris.StickyFeet;


import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.chris.StickyFeet.commands.CommandManager;
import net.md_5.bungee.api.ChatColor;


public class Main extends JavaPlugin {
	public final static Logger logger = Logger.getLogger("Minecraft");
	public static Main instance;
	public static boolean startPlugin;
	public static Plugin plugin;
	public static int leatherBootsDamagePerUse;
	public static int ironBootsDamagePerUse;
	public static int diamondBootsDamagePerUse;
	
	public static ItemMeta leatherStickyBootsMeta;
	public static ItemMeta ironStickyBootsMeta;
	public static ItemMeta chainmailStickyBootsMeta;
	public static ItemMeta diamondStickyBootsMeta;

	
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		instance = this;
		startPlugin = false;
		plugin = this;
		//syringeDelay = getConfig().getInt("syringeDelay");
		//setDustDelay = getConfig().getLong("setDelay");
		//syringeInitHealth = getConfig().getDouble("syringeInitHealth");
		//syringeLingerHealth = getConfig().getDouble("syringeLingerHealth");
		
		
		
		leatherBootsDamagePerUse = getConfig().getInt("leatherBootsDamagePerUse");
		ironBootsDamagePerUse = getConfig().getInt("ironBootsDamagePerUse");
		diamondBootsDamagePerUse = getConfig().getInt("diamondBootsDamagePerUse");
		Bukkit.addRecipe(getLeatherStickyBootsRecipe());
		Bukkit.addRecipe(getIronStickyBootsRecipe());
		Bukkit.addRecipe(getDiamondStickyBootsRecipe());
		getServer().getPluginManager().registerEvents(new ClimbWall(), this);
		
		getCommand("stickyfeet").setExecutor((new CommandManager()));
		getCommand("stickyfeet").setTabCompleter((new CommandManager()));
		
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion()
		+ " Has been enabled!");	

	}
	
	@Override
	public void onDisable() {
		this.saveConfig();
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info(pdfFile.getName() + " Has been disabled!");
		instance = null;
	}
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		player.discoverRecipe(getLeatherStickyBootsRecipe().getKey());
		player.discoverRecipe(getIronStickyBootsRecipe().getKey());
		player.discoverRecipe(getDiamondStickyBootsRecipe().getKey());
	}
	
	public ShapedRecipe getLeatherStickyBootsRecipe() {
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta meta = item.getItemMeta();
		leatherStickyBootsMeta = meta;
		
		
		
		meta.setDisplayName(ChatColor.GREEN + "Sticky Leather Boots");
		//meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
		meta.setLore(Arrays.asList(ChatColor.GOLD + "You can now climb up trees"));
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "leatherStickyBoots");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("L L", "L L", "S S");
		
		recipe.setIngredient('L', Material.LEATHER);
		recipe.setIngredient('S', Material.SLIME_BALL);
		
		return recipe;
		
	}
	
	public ShapedRecipe getIronStickyBootsRecipe() {
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();
		ironStickyBootsMeta = meta;
		
		
		
		meta.setDisplayName(ChatColor.GREEN + "Sticky Iron Boots");
		//meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
		meta.setLore(Arrays.asList(ChatColor.GOLD + "You can now climb up trees and stone"));
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "ironStickyBoots");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("L L", "L L", "S S");
		
		recipe.setIngredient('L', Material.IRON_INGOT);
		recipe.setIngredient('S', Material.SLIME_BALL);
		
		return recipe;
		
	}
	
	public ShapedRecipe getDiamondStickyBootsRecipe() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();
		diamondStickyBootsMeta = meta;
		
		
		
		meta.setDisplayName(ChatColor.GREEN + "Sticky Diamond Boots");
		//meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
		meta.setLore(Arrays.asList(ChatColor.GOLD + "You can now climb up anything!"));
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "diamondStickykBoots");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("L L", "L L", "S S");
		
		recipe.setIngredient('L', Material.DIAMOND);
		recipe.setIngredient('S', Material.SLIME_BALL);
		
		return recipe;
		
	}

	/*
	public ShapedRecipe getChainmailStickyBootRecipe() {
		ItemStack item = new ItemStack(Material.BAMBOO);
		ItemMeta meta = item.getItemMeta();
		chainmailStickyBootsMeta = meta;
		
		
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Sticky Chainmail Boots");
		//meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
		meta.setLore(Arrays.asList(ChatColor.RED + "You can now climb up trees"));
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "chainmailStickyBoots");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("L L", "L L", "S S");
		
		recipe.setIngredient('L', Material.LEATHER);
		recipe.setIngredient('S', Material.SLIME_BALL);
		
		return recipe;
		
	}
	*/
	
	//OLD COMMANDS/ WORKS 
	/*
	//**************************
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		
		
		if(label.equalsIgnoreCase("stickyfeetver")) {
			PluginDescriptionFile pdfFile = this.getDescription();
			player.sendMessage(pdfFile.getVersion()); {
				return true;
			}
		}
		
		if(label.equalsIgnoreCase("stickyfeetsetleatherdamagerperuse")) {
			if (isNum(args[0])) {
				// String userInput = label.substring(18);

				leatherBootsDamagePerUse = Integer.parseInt(args[0]);
				getConfig().set("leatherBootsDamagePerUse", leatherBootsDamagePerUse);
				this.saveConfig();
				saveDefaultConfig();

				player.sendMessage("Sticky leather boots now take " + ChatColor.BOLD + "" + ChatColor.BLUE
						+ leatherBootsDamagePerUse + ChatColor.RESET + "" + " durability per 2 ladders (default: 1)");
				{
					return true;
				}
			} else {
				player.sendMessage(ChatColor.RED + "Usage: /LeatherBootsDamagePerUse <number-value 0.0-inf>"); {
					return true;
				}
			}
		}
		
		if(label.equalsIgnoreCase("stickyfeetsetirondamagerperuse")) {
			if (isNum(args[0])) {
				// String userInput = label.substring(18);

				ironBootsDamagePerUse = Integer.parseInt(args[0]);
				getConfig().set("ironBootsDamagePerUse", ironBootsDamagePerUse);
				this.saveConfig();
				saveDefaultConfig();

				player.sendMessage("Sticky iron boots now take " + ChatColor.BOLD + "" + ChatColor.BLUE
						+ ironBootsDamagePerUse + ChatColor.RESET + "" + " durability per 2 ladders (default: 1)");
				{
					return true;
				}
			} else {
				player.sendMessage(ChatColor.RED + "Usage: /IronBootsDamagePerUse <number-value 0.0-inf>"); {
					return true;
				}
			}
		}
		
		if(label.equalsIgnoreCase("stickyfeetsetdiamonddamagerperuse")) {
			if (isNum(args[0])) {
				// String userInput = label.substring(18);

				diamondBootsDamagePerUse = Integer.parseInt(args[0]);
				getConfig().set("diamondBootsDamagePerUse", diamondBootsDamagePerUse);
				this.saveConfig();
				saveDefaultConfig();

				player.sendMessage("Sticky diamond boots now take " + ChatColor.BOLD + "" + ChatColor.BLUE
						+ leatherBootsDamagePerUse + ChatColor.RESET + "" + " durability per every other 2 ladders (default: 1)");
				{
					return true;
				}
			} else {
				player.sendMessage(ChatColor.RED + "Usage: /DiamondBootsDamagePerUse <number-value 0.0-inf>"); {
					return true;
				}
			}
		}
		
		if(label.equalsIgnoreCase("stickyfeetsetdefaultdamage")) {
			leatherBootsDamagePerUse = 1;
			getConfig().set("leatherBootsDamagePerUse", leatherBootsDamagePerUse);
			
			ironBootsDamagePerUse = 1;
			getConfig().set("ironBootsDamagePerUse", ironBootsDamagePerUse);
			
			diamondBootsDamagePerUse = 1;
			getConfig().set("diamondBootsDamagePerUse", diamondBootsDamagePerUse);
			
			
			this.saveConfig();
			saveDefaultConfig();
		}
		/*
		if(label.equalsIgnoreCase("syringesetdelay")) {
			
			if (player.isOp()) {
				if (isNum(args[0])) {
					// String userInput = label.substring(18);

					syringeDelay = Integer.parseInt(args[0]);
					getConfig().set("syringeDelay", syringeDelay);
					this.saveConfig();
					saveDefaultConfig();

					player.sendMessage("Syringe delay has been set to " + ChatColor.BOLD + "" + ChatColor.BLUE
							+ syringeDelay + ChatColor.RESET + "" + " (default: 2s ) ");
					{
						return true;
					}
				} else {
					player.sendMessage(ChatColor.RED + "Usage: /syringesetdelay <number-value 0-inf>"); {
						return true;
					}
				}
			} else {
				player.sendMessage(ChatColor.RED + "You do not have permission!"); {
					return true;
				}
			}
			
		}
		
		
		return false;	
	}
	//**************************
	*/
	
	
	
	
	public boolean isNum(String num) {
		try {
			Long.valueOf(num);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	
}
	

	
