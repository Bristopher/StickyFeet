package me.chris.StickyFeet;


import java.util.ArrayList;
import java.util.HashMap;

//import java.util.HashMap;
//import java.util.logging.Logger;
//import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
//import org.bukkit.event.player.PlayerJoinEvent;
//import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
//import org.bukkit.plugin.Plugin;


//import net.md_5.bungee.api.ChatColor;

public class ClimbWall implements Listener {
	//private Plugin plugin = Main.getPlugin(Main.class);
	public HashMap<String, Integer> armorCheck = new HashMap<String, Integer>();
	public static ArrayList<Block> ladderObjectsOne = new ArrayList<Block>();
	public static ArrayList<Block> ladderObjectsTwo = new ArrayList<Block>();;
	public static ItemStack currentBoots;
	public static int diamondDuraCounter;
	

	
	
	@EventHandler
	(priority = EventPriority.NORMAL)
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		String cardinalDirection = getCardinalDirection(player);		
		if ((armorCheck.get(player.getName()) != null) && event != null) {
			boolean leatherBootsCheck = armorCheck.get(player.getName()).equals((Integer) 1);
			boolean ironBootsCheck = armorCheck.get(player.getName()).equals((Integer) 2);
			boolean diamondBootsCheck = armorCheck.get(player.getName()).equals((Integer) 5);
			//System.out.println("1");
		
			
			checkIfPlayerIsFar(event);

			if (leatherBootsCheck || ironBootsCheck || diamondBootsCheck) {
				//System.out.println("2");
	
	
				if (cardinalDirection != null && cardinalDirection.equals("N")) {
					//Block hereTheLadderShouldGo = event.getClickedBlock().getRelative(event.getBlockFace());
					
					//Material northBlock = player.getLocation().getBlock().getRelative(BlockFace.NORTH).getType();
					Material northBlock = player.getLocation().getBlock().getLocation().add(0, 1, -1).getBlock().getType();
					//System.out.println(player.getLocation().getBlock().getLocation().add(0, 1, -1));
					//System.out.println(northBlock);
					
					if ((leatherBootsCheck || ironBootsCheck) && (northBlock.name().toLowerCase().contains("log"))) {
						//System.out.println("3");
						

						
						//placingLadderBlock.setType(Material.LADDER);
						
						//placeLadder(player, BlockFace.SOUTH);
						//new LadderObjectsOne(player, BlockFace.SOUTH, ladderBlock.add(0, 0, 1));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.SOUTH);
						
						/*
		                BlockState state = placingLadderBlock.getState();
		                //Ladder ladder = new Ladder();
		                //Ladder ladder2 = new Ladder();
		                Ladder ladder = (Ladder) state;
		                ladder.setFacing(BlockFace.SOUTH);
		                //state.setData(ladder);
		                state.update();
						// Ladder ladder = (Ladder) block;
						 */
					}
					
					if((ironBootsCheck) && (northBlock.name().toLowerCase().contains("stone"))) {
						//new LadderObjectsOne(player, BlockFace.SOUTH, ladderBlock.add(0, 0, 1));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.SOUTH);
						
						//System.out.println("4");
					}
					
					if(diamondBootsCheck) {
						//new LadderObjectsOne(player, BlockFace.SOUTH, ladderBlock.add(0, 0, 1));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.SOUTH);
						
						//System.out.println("5");
					}
				}

				if (cardinalDirection != null && cardinalDirection.equals("E")) {
					
					Material eastBlock = player.getLocation().getBlock().getLocation().add(1, 1, 0).getBlock().getType();
					if ((leatherBootsCheck || ironBootsCheck) && (eastBlock.name().toLowerCase().contains("log"))) {

						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(1, 0, 0));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.WEST);
					}
					
					if((ironBootsCheck) && (eastBlock.name().toLowerCase().contains("stone"))) {
						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(1, 0, 0));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.WEST);
					}
					
					if(diamondBootsCheck) {
						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(1, 0, 0));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.WEST);
					}
				}

				if (cardinalDirection != null && cardinalDirection.equals("S")) {
					Material southBlock = player.getLocation().getBlock().getLocation().add(0, 1, 1).getBlock().getType();
					if ((leatherBootsCheck || ironBootsCheck) && (southBlock.name().toLowerCase().contains("log"))) {

						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(0, 0, -1));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.NORTH);
					}
					
					if((ironBootsCheck) && (southBlock.name().toLowerCase().contains("stone"))) {
						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(0, 0, -1));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.NORTH);
					}
					
					if(diamondBootsCheck) {
						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(0, 0, -1));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.NORTH);
					}
				}

				if (cardinalDirection != null && cardinalDirection.equals("W")) {
					Material westBlock = player.getLocation().getBlock().getLocation().add(-1, 1, 0).getBlock().getType();
					if ((leatherBootsCheck || ironBootsCheck) && (westBlock.name().toLowerCase().contains("log"))) {

						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(-1, 0, 0));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.EAST);
					}
					
					if((ironBootsCheck) && (westBlock.name().toLowerCase().contains("stone"))) {
						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(-1, 0, 0));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.EAST);
					}
					
					if(diamondBootsCheck) {
						//new LadderObjectsOne(player, BlockFace.WEST, ladderBlock.add(-1, 0, 0));
						newPlaceBothLadder(player, cardinalDirection, BlockFace.EAST);
					}
				}
				
				
			}
		}

	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getBoots();
		diamondDuraCounter = 1;
		
		if (event != null) {
			if (item != null && item.getType().equals(Material.LEATHER_BOOTS) && item.getItemMeta().equals(Main.leatherStickyBootsMeta)) {
				armorCheck.put(player.getName(), (Integer) 1);
				currentBoots = item;
				//System.out.println("6");
				
			}
	
			if (item != null && item.getType().equals(Material.IRON_BOOTS) && item.getItemMeta().equals(Main.ironStickyBootsMeta)) {
				armorCheck.put(player.getName(), (Integer) 2);
			}
	
			/*
			if (item.getType().equals(Material.CHAINMAIL_BOOTS)) {
	
			}
			*/
	
			if (item != null && item.getType().equals(Material.DIAMOND_BOOTS) && item.getItemMeta().equals(Main.diamondStickyBootsMeta)) {
				armorCheck.put(player.getName(), (Integer) 5);
			}
			
			if (item == null || item.getType() == null || item.getType().equals(Material.AIR)) {
				armorCheck.remove(player.getName());
				if(ladderObjectsOne != null && !ladderObjectsOne.isEmpty()  && ladderObjectsOne.size() != 0 && ladderObjectsOne.get(0) != null) {
					ClimbWall.ladderObjectsOne.get(0).setType(Material.AIR);
					ClimbWall.ladderObjectsOne.remove(0);
				
				}
				if(ladderObjectsTwo != null && !ladderObjectsTwo.isEmpty() && ladderObjectsTwo.size() != 0  && ladderObjectsTwo.get(0) != null) {
					ClimbWall.ladderObjectsTwo.get(0).setType(Material.AIR);
					ClimbWall.ladderObjectsTwo.remove(0);
				}
			}
		}
	}
	
	public void checkIfPlayerIsFar(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		boolean hasRun = false;
		
		//System.out.print("playercheck1");
		if(ladderObjectsOne != null && !ladderObjectsOne.isEmpty()  && ladderObjectsOne.size() != 0 && ladderObjectsOne.get(0) != null) {
			//System.out.print("playercheck2");
			if (event != null && player != null) {
				//System.out.print("playercheck3");
				if((Math.abs(ladderObjectsOne.get(0).getX() - player.getLocation().getX()) > 1) && !hasRun) {
					//System.out.print("playercheck4");
					ladderObjectsOne.get(0).setType(Material.AIR);
					ladderObjectsOne.remove(0);
					hasRun = true;
				}
				
				if((Math.abs(ladderObjectsOne.get(0).getY() - player.getLocation().getY()) > 3) && !hasRun) {
					//System.out.print("playercheck5");
					ladderObjectsOne.get(0).setType(Material.AIR);
					ladderObjectsOne.remove(0);
					hasRun = true;
				}
				
				if((Math.abs(ladderObjectsOne.get(0).getZ() - player.getLocation().getZ()) > 1) && !hasRun) {
					//System.out.print("playercheck6");
					ladderObjectsOne.get(0).setType(Material.AIR);
					ladderObjectsOne.remove(0);
					hasRun = true;
				}
			}
		}
		
		if(ladderObjectsTwo != null && !ladderObjectsTwo.isEmpty()  && ladderObjectsTwo.size() != 0 && ladderObjectsTwo.get(0) != null) {
			
			if (event != null && player != null) {
				if((Math.abs(ladderObjectsTwo.get(0).getX() - player.getLocation().getX()) > 1) && !hasRun) {
					ladderObjectsTwo.get(0).setType(Material.AIR);
					ladderObjectsTwo.remove(0);
					hasRun = true;
				}
				
				if((Math.abs(ladderObjectsTwo.get(0).getY() - player.getLocation().getY()) > 3) && !hasRun) {
					ladderObjectsTwo.get(0).setType(Material.AIR);
					ladderObjectsTwo.remove(0);
					hasRun = true;
				}
				
				if((Math.abs(ladderObjectsTwo.get(0).getZ() - player.getLocation().getZ()) > 1)&& !hasRun) {
					ladderObjectsTwo.get(0).setType(Material.AIR);
					ladderObjectsTwo.remove(0);
					hasRun = true;
				}
			}
		}
	}
	
	
	@EventHandler
	public void playerEquipsArmour(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack item = player.getInventory().getBoots();
		
		if (event != null) {
			if (item != null && item.getType().equals(Material.LEATHER_BOOTS) && item.getItemMeta().equals(Main.leatherStickyBootsMeta)) {
				armorCheck.put(event.getWhoClicked().getName(), (Integer) 1);
				//System.out.println("6");
				
			}
	
			if (item != null && item.getType().equals(Material.IRON_BOOTS) && item.getItemMeta().equals(Main.ironStickyBootsMeta)) {
				armorCheck.put(event.getWhoClicked().getName(), (Integer) 2);
			}
	
			/*
			if (item.getType().equals(Material.CHAINMAIL_BOOTS)) {
	
			}
			*/
	
			if (item != null && item.getType().equals(Material.DIAMOND_BOOTS) && item.getItemMeta().equals(Main.diamondStickyBootsMeta)) {
				armorCheck.put(event.getWhoClicked().getName(), (Integer) 5);
			}
			
			if (item == null || item.getType() == null || item.getType().equals(Material.AIR)) {
				armorCheck.remove(event.getWhoClicked().getName());
				if(ladderObjectsOne != null && !ladderObjectsOne.isEmpty()  && ladderObjectsOne.size() != 0 && ladderObjectsOne.get(0) != null) {
					ClimbWall.ladderObjectsOne.get(0).setType(Material.AIR);
					ClimbWall.ladderObjectsOne.remove(0);
				
				}
				if(ladderObjectsTwo != null && !ladderObjectsTwo.isEmpty() && ladderObjectsTwo.size() != 0  && ladderObjectsTwo.get(0) != null) {
					ClimbWall.ladderObjectsTwo.get(0).setType(Material.AIR);
					ClimbWall.ladderObjectsTwo.remove(0);
				}
			}
		}
	}
	//Garbo
	/*
	public void newestPlaceLadderOne(Player player, BlockFace direction, Location locWithDir) {
		if(player != null ) {
			if(ClimbWall.ladderObjectsOne != null && ClimbWall.ladderObjectsOne.get(0) != null) {
				ClimbWall.ladderObjectsOne.get(0).setType(Material.AIR);
				ClimbWall.ladderObjectsOne.remove(0);
			
			}
			if(ClimbWall.ladderObjectsOne != null && ClimbWall.ladderObjectsOne.get(0) != null) {
				ClimbWall.ladderObjectsOne.get(0).setType(Material.AIR);
				ClimbWall.ladderObjectsOne.remove(0);
			}
			
			//*****Ladder 1
			locWithDir.getBlock().setType(Material.LADDER);
			Block placingLadderBlock = locWithDir.getBlock();

			BlockState state = placingLadderBlock.getState();

			Ladder ladder = (Ladder) state.getData();
			ladder.setFacing(direction);

			state.update();
			//******
			
			//******Ladder 2
			locWithDir.add(0, 1, 0).getBlock().setType(Material.LADDER);
			Block placingLadderBlockTwo = locWithDir.add(0, 1, 0).getBlock();

			BlockState stateTwo = placingLadderBlockTwo.getState();

			Ladder ladderTwo = (Ladder) state.getData();
			ladderTwo.setFacing(direction);

			stateTwo.update();
			ClimbWall.ladderObjectsTwo.add(placingLadderBlockTwo);
			
			
		}
	}
	*/
	
	public void newPlaceBothLadder(Player player, String cardinalDirection, BlockFace direction) {
		//System.out.println("7");
		
		if(ladderObjectsOne != null && !ladderObjectsOne.isEmpty()  && ladderObjectsOne.size() != 0 && ladderObjectsOne.get(0) != null) {
			ClimbWall.ladderObjectsOne.get(0).setType(Material.AIR);
			ClimbWall.ladderObjectsOne.remove(0);
		
		}
		if(ladderObjectsTwo != null && !ladderObjectsTwo.isEmpty() && ladderObjectsTwo.size() != 0  && ladderObjectsTwo.get(0) != null) {
			ClimbWall.ladderObjectsTwo.get(0).setType(Material.AIR);
			ClimbWall.ladderObjectsTwo.remove(0);
		}
		

		
		if (player != null) {
			
			// Actually North
			if (cardinalDirection.equals("N")) {
				//System.out.println("8");
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 0, -1);
				//Location ladderBlock = player.getLocation();
				//ladderBlock.setZ(ladderBlock.getZ() + 1.0);
				
				//Ladder1
				if(ladderBlock.getBlock() != null) {
					//System.out.println("North1");
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					ladderBlock.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ladderObjectsOne.add(ladderBlock.getBlock());
				}
				
				
				//Ladder2
				//Location ladderBlockTwo = ladderBlock.getBlock().getRelative(BlockFace.UP).getLocation();
				Location ladderBlockTwo = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 1, -1);
				ladderBlock.setZ(ladderBlock.getZ() + 1.0);
				
				if(ladderBlockTwo.getBlock() != null) {
					//System.out.println("North2");
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					ladderBlockTwo.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					Directional ladderDataTwo = (Directional) ladderBlockTwo.getBlock().getState().getBlockData();
					ladderDataTwo.setFacing(direction);
	
					ladderBlockTwo.getBlock().setBlockData(ladderDataTwo);
					ladderBlockTwo.getBlock().getState().update();
					ladderObjectsTwo.add(ladderBlockTwo.getBlock());
				}
				
				damageBoots();
			}
			
			// Actually East
			if (cardinalDirection.equals("E")) {
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(1, 0, 0);
				
				if(ladderBlock.getBlock()  != null) {
					//System.out.println("East1");
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					ladderBlock.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ladderObjectsOne.add(ladderBlock.getBlock());
				}
				
				//Ladder2
				//Location ladderBlockTwo = ladderBlock.getBlock().getRelative(BlockFace.UP).getLocation();
				Location ladderBlockTwo = player.getLocation().getBlock().getRelative(direction).getLocation().add(1, 1, 0);
				
				if(ladderBlockTwo.getBlock() != null) {
					//System.out.println("East2");
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					ladderBlockTwo.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					Directional ladderDataTwo = (Directional) ladderBlockTwo.getBlock().getState().getBlockData();
					ladderDataTwo.setFacing(direction);
	
					ladderBlockTwo.getBlock().setBlockData(ladderDataTwo);
					ladderBlockTwo.getBlock().getState().update();
					ladderObjectsTwo.add(ladderBlockTwo.getBlock());
				}
			}

			// Actually South
			if (cardinalDirection.equals("S")) {
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 0, 1);
				
				if(ladderBlock.getBlock()  != null) {
					//System.out.println("South1");
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					ladderBlock.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ladderObjectsOne.add(ladderBlock.getBlock());
				}
				
				//Ladder2
				//Location ladderBlockTwo = ladderBlock.getBlock().getRelative(BlockFace.UP).getLocation();
				Location ladderBlockTwo = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 1, 1);

				if(ladderBlockTwo.getBlock() != null) {
					//System.out.println("South2");
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					ladderBlockTwo.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					Directional ladderDataTwo = (Directional) ladderBlockTwo.getBlock().getState().getBlockData();
					ladderDataTwo.setFacing(direction);
	
					ladderBlockTwo.getBlock().setBlockData(ladderDataTwo);
					ladderBlockTwo.getBlock().getState().update();
					ladderObjectsTwo.add(ladderBlockTwo.getBlock());
				}
			}

			// Actually West
			if (cardinalDirection.equals("W")) {
				//Location untochedLadderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(-1, 0, 0);
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(-1, 0, 0);
				
				if(ladderBlock.getBlock() != null) {
					//System.out.println("West1");
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					ladderBlock.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock, Material.AIR.createBlockData());
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ladderObjectsOne.add(ladderBlock.getBlock());
				}
				
				//Ladder2
				//Location ladderBlockTwo = ladderBlock.getBlock().getRelative(BlockFace.UP).getLocation();
				//Location ladderBlockTwo = player.getLocation().getBlock().getRelative(direction).getLocation().add(1, 1, 0);
				Location ladderBlockTwo = player.getLocation().getBlock().getLocation().add(0, 1, 0);
				
				if(ladderBlockTwo.getBlock() != null) {
					//System.out.println("West2");
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					ladderBlockTwo.getBlock().setType(Material.LADDER);
					//player.sendBlockChange(ladderBlock.add(0, 1, 0), Material.AIR.createBlockData());
					Directional ladderDataTwo = (Directional) ladderBlockTwo.getBlock().getState().getBlockData();
					ladderDataTwo.setFacing(direction);
	
					ladderBlockTwo.getBlock().setBlockData(ladderDataTwo);
					ladderBlockTwo.getBlock().getState().update();
					ladderObjectsTwo.add(ladderBlockTwo.getBlock());
				}
			}

			
		}
	}
	
	public void damageBoots() {
		if (currentBoots != null && currentBoots.getType().equals(Material.DIAMOND_BOOTS) && currentBoots.getItemMeta().equals(Main.leatherStickyBootsMeta)) {
			if (currentBoots.getItemMeta() instanceof Damageable){
	            ((Damageable) currentBoots.getItemMeta()).setDamage( ((Damageable) currentBoots.getItemMeta()).getDamage() - Main.leatherBootsDamagePerUse);
	        }
		}
		
		if (currentBoots != null && currentBoots.getType().equals(Material.DIAMOND_BOOTS) && currentBoots.getItemMeta().equals(Main.ironStickyBootsMeta)) {
			if (currentBoots.getItemMeta() instanceof Damageable){
	            ((Damageable) currentBoots.getItemMeta()).setDamage( ((Damageable) currentBoots.getItemMeta()).getDamage() - Main.ironBootsDamagePerUse);
	        }
		}
		
		if (currentBoots != null && currentBoots.getType().equals(Material.DIAMOND_BOOTS) && currentBoots.getItemMeta().equals(Main.diamondStickyBootsMeta)) {
			if (diamondDuraCounter % 2 != 0) {
				if (currentBoots.getItemMeta() instanceof Damageable){
		            ((Damageable) currentBoots.getItemMeta()).setDamage( ((Damageable) currentBoots.getItemMeta()).getDamage() - Main.ironBootsDamagePerUse);
		            diamondDuraCounter++;
		        }
	        }
		}

	}
	
	/*
	public void newestPlaceLadderTwo(Player player, BlockFace direction, Location locWithDir) {
		if(player != null ) {
			if(ClimbWall.ladderObjectsOne != null && ClimbWall.ladderObjectsOne.get(0) != null) {
				ClimbWall.ladderObjectsOne.get(0).setType(Material.AIR);
				ClimbWall.ladderObjectsOne.remove(0);
			}
			
			locWithDir.getBlock().setType(Material.LADDER);
			Block placingLadderBlock = locWithDir.getBlock();

			BlockState state = placingLadderBlock.getState();

			Ladder ladder = (Ladder) state.getData();
			ladder.setFacing(direction);

			state.update();
			ClimbWall.ladderObjectsOne.add(placingLadderBlock);
		}
	}
	*/
	/*
	public void newPlaceLadderOne(Player player, BlockFace direction) {
		System.out.println("7");
		
		if (ClimbWall.ladderObjectsOne != null && ClimbWall.ladderObjectsOne.get(0) != null) {
			ClimbWall.ladderObjectsOne.get(0).setType(Material.AIR);
			ClimbWall.ladderObjectsOne.remove(0);
		}

		// Actually North
		if (player != null) {
			if (direction == BlockFace.SOUTH) {
				System.out.println("8");
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 0, 1);
				
				if(ladderBlock != null) {
					ladderBlock.getBlock().setType(Material.LADDER);
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ClimbWall.ladderObjectsOne.add(ladderBlock.getBlock());
				}
			}

			// Actually South
			if (direction == BlockFace.NORTH) {
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 0, -1);
				
				if(ladderBlock != null) {
					ladderBlock.getBlock().setType(Material.LADDER);
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ClimbWall.ladderObjectsOne.add(ladderBlock.getBlock());
				}
			}

			// Actually West
			if (direction == BlockFace.EAST) {
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(-1, 0, 0);
				
				if(ladderBlock != null) {
					ladderBlock.getBlock().setType(Material.LADDER);
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ClimbWall.ladderObjectsOne.add(ladderBlock.getBlock());
				}
			}

			// Actually East
			if (direction == BlockFace.WEST) {
				Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(1, 0, 0);
				
				if(ladderBlock != null) {
					ladderBlock.getBlock().setType(Material.LADDER);
					Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
					ladderData.setFacing(direction);
	
					player.getLocation().getBlock().setBlockData(ladderData);
					ladderBlock.getBlock().getState().update();
					ClimbWall.ladderObjectsOne.add(ladderBlock.getBlock());
				}
			}
		}
	}
		
		
		
		
		public void newPlaceLadderTwo(Player player, BlockFace direction) {	
			System.out.println("7");
			if(ClimbWall.ladderObjectsTwo != null && ClimbWall.ladderObjectsTwo.get(0) != null) {
				ClimbWall.ladderObjectsTwo.get(0).setType(Material.AIR);
				ClimbWall.ladderObjectsTwo.remove(0);
			}
			
			if (player != null) {
				//Actually North
				if(direction == BlockFace.SOUTH) {
					System.out.println("8");
					Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 1, 1);
					
					if(ladderBlock != null) {
						ladderBlock.getBlock().setType(Material.LADDER);
						Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
						ladderData.setFacing(direction);
						
						player.getLocation().getBlock().setBlockData(ladderData);
						ladderBlock.getBlock().getState().update();
						ClimbWall.ladderObjectsTwo.add(ladderBlock.getBlock());
					}
				}
				
				//Actually South
				if(direction == BlockFace.NORTH) {
					Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 1, -1);
					
					if(ladderBlock != null) {
						ladderBlock.getBlock().setType(Material.LADDER);
						Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
						ladderData.setFacing(direction);
						
						player.getLocation().getBlock().setBlockData(ladderData);
						ladderBlock.getBlock().getState().update();
						ClimbWall.ladderObjectsTwo.add(ladderBlock.getBlock());
					}
				}
				
				//Actually West
				if(direction == BlockFace.EAST) {
					Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(-1, 1, 0);
					
					if(ladderBlock != null) {
						ladderBlock.getBlock().setType(Material.LADDER);
						Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
						ladderData.setFacing(direction);
						
						player.getLocation().getBlock().setBlockData(ladderData);
						ladderBlock.getBlock().getState().update();
						ClimbWall.ladderObjectsTwo.add(ladderBlock.getBlock());
					}
				}
				
				//Actually East
				if(direction == BlockFace.WEST) {
					Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(1, 1, 0);
					
					if(ladderBlock != null) {
						ladderBlock.getBlock().setType(Material.LADDER);
						Directional ladderData = (Directional) ladderBlock.getBlock().getState().getBlockData();
						ladderData.setFacing(direction);
						
						player.getLocation().getBlock().setBlockData(ladderData);
						ladderBlock.getBlock().getState().update();
						ClimbWall.ladderObjectsTwo.add(ladderBlock.getBlock());
					}
				}
			}
			*/
		
		
		/*
		ladderBlock.getBlock().setType(Material.LADDER);
		Block placingLadderBlock = ladderBlock.getBlock();
		//Block hereTheLadderShouldGo = event.getClickedBlock().getRelative(event.getBlockFace());
		
		BlockState state = placingLadderBlock.getState();
        //Ladder ladder = new Ladder();
        //Ladder ladder2 = new Ladder();
        Ladder ladder = (Ladder) state.getData();
        ladder.setFacing(direction);
        //state.setData(ladder);
        state.update();
		// Ladder ladder = (Ladder) block;
		 
	}
	*/
	/*
	public void placeLadder(Player player, BlockFace direction) {
		Location ladderBlock = player.getLocation().getBlock().getRelative(direction).getLocation().add(0, 0, 1);
		ladderBlock.getBlock().setType(Material.LADDER);
		Block placingLadderBlock = ladderBlock.getBlock();
		//Block hereTheLadderShouldGo = event.getClickedBlock().getRelative(event.getBlockFace());
		
		BlockState state = placingLadderBlock.getState();
        //Ladder ladder = new Ladder();
        //Ladder ladder2 = new Ladder();
        Ladder ladder = (Ladder) state.getData();
        ladder.setFacing(direction);
        //state.setData(ladder);
        state.update();
		// Ladder ladder = (Ladder) block;
	}
	//old method
	*/
	public static String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 90) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
         if (0 <= rotation && rotation < 22.5) {
        	 //System.out.println("W");
        	 return "W";
        } else if (67.5 <= rotation && rotation < 112.5) {
        	//System.out.println("N");
        	return "N";
        } else if (157.5 <= rotation && rotation < 202.5) {
        	//System.out.println("E");
        	return "E";
        } else if (247.5 <= rotation && rotation < 292.5) {
        	//System.out.println("S");
        	return "S";
        } else if (337.5 <= rotation && rotation < 360.0) {
        	//System.out.println("W");
        	return "W";
        } else {
        	//System.out.println("NULL");
            return null;
        }
    }
	
	
	/*
	 * public static String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 90) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
         if (0 <= rotation && rotation < 22.5) {
        	 System.out.println("N");
        	 return "N";
        } else if (22.5 <= rotation && rotation < 67.5) {
            System.out.println("NE");
        	return "NE";
        } else if (67.5 <= rotation && rotation < 112.5) {
        	System.out.println("E");
        	return "E";
        } else if (112.5 <= rotation && rotation < 157.5) {
        	System.out.println("SE");
        	return "SE";
        } else if (157.5 <= rotation && rotation < 202.5) {
        	System.out.println("S");
        	return "S";
        } else if (202.5 <= rotation && rotation < 247.5) {
        	System.out.println("S");
        	return "SW";
        } else if (247.5 <= rotation && rotation < 292.5) {
        	System.out.println("W");
        	return "W";
        } else if (292.5 <= rotation && rotation < 337.5) {
        	System.out.println("NW");
        	return "NW";
        } else if (337.5 <= rotation && rotation < 360.0) {
        	System.out.println("N");
        	return "N";
        } else {
        	System.out.println("NULL");
            return null;
        }
    }
	 * 
	 */
	
	/*
	public void ladderSetter(boolean leatherBootsCheck, boolean ironBootsCheck, boolean diamondBootsCheck) {
		if (leatherBootsCheck) {

		}

		if (ironBootsCheck) {

		}

		if (diamondBootsCheck) {

		}
	}
	*/
	
	
	
	/*
	public static CardinalDirection get(Player player) {
	    float yaw = player.getLocation().getYaw();
	    if (yaw < 0) {
	        yaw += 360;
	    }
	    if (yaw >= 315 || yaw < 45) {
	        return CardinalDirection.SOUTH;
	    } else if (yaw < 135) {
	        return CardinalDirection.WEST;
	    } else if (yaw < 225) {
	        return CardinalDirection.NORTH;
	    } else if (yaw < 315) {
	        return CardinalDirection.EAST;
	    }
	    return CardinalDirection.NORTH;
	}
	*/
	
	
	
	/*
	@EventHandler
	public void craftSyringe(CraftItemEvent event) {
		
		if(event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().equals(Main.SyringeMeta)) {
			int syringeStack = event.getCurrentItem().getAmount() - 2;
			event.getCurrentItem().setAmount(2);
			
			ItemStack item = new ItemStack(Material.BAMBOO);
			item.setItemMeta(Main.SyringeMeta);
			
			for( )
			event.getInventory().addItem(item.setAmount(amount););
		}
		//for 2 stack size
		
		
	}
	*/
	
	/*
	@EventHandler
	public void onInventory(PlayerInteractEntityEvent event) {

	}
	
	@EventHandler
	public void questActionBlock(PlayerInteractEvent event) {
		
	}
	
	@EventHandler
	public void playerJoins(PlayerJoinEvent event) {
		
	}
	*/

	/*
	public static void dustCircle(Player player) {		
		new BukkitRunnable() {
			@Override
			public void run() {
				int degree = 0;
				if (degree < 360) {

					degree = degree + 5;
					double radian1 = Math.toRadians(degree);
					double radian2 = Math.toRadians(degree + 120);
					double radian3 = Math.toRadians(degree + 240);

					Location loc = player.getLocation();
					loc.add(Math.cos(radian1) * 2, 0, Math.sin(radian1) * 2);
					player.getWorld().playEffect(loc, Effect.SMOKE, 20);
					loc.subtract(Math.cos(radian1) * 2, 0, Math.sin(radian1) * 2);
					loc.add(Math.cos(radian2) * 2, 0, Math.sin(radian2) * 2);
					player.getWorld().playEffect(loc, Effect.SMOKE, 20);
					loc.subtract(Math.cos(radian2) * 2, 0, Math.sin(radian2) * 2);
					loc.add(Math.cos(radian3) * 2, 0, Math.sin(radian3) * 2);
					player.getWorld().playEffect(loc, Effect.SMOKE, 20);
					loc.subtract(Math.cos(radian3) * 2, 0, Math.sin(radian3) * 2);
				} else {
				degree = 0;
				}
			}
		}.runTaskTimer(Main.getInstance(), 0, Main.setDustDelay);
	}
	*/
}