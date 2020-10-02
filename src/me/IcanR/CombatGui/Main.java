package me.IcanR.CombatGui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public Inventory inv;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		createInv();
	}
	
	@Override
	public void onDisable( ) {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("combat")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "" + "Console join server to do this");
				return true;
			}
			Player player = (Player) sender;
			//GUI
			player.openInventory(inv);
			return true;
		}
		return false;
	}
	
	@EventHandler()
	public void onClick(InventoryClickEvent event) {
		if (!event.getInventory().equals(inv))
			return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		event.setCancelled(true);
		
		Player player = (Player) event.getWhoClicked();
		
		if (event.getSlot() == 0) {
			//crossbow
			player.performCommand("combatcrossbow");
			player.sendMessage(ChatColor.GOLD + "This your item");
		}
		if (event.getSlot() == 1) {
			//sword
			player.performCommand("combatsword");
			player.sendMessage(ChatColor.GOLD + "This your item");
		}	
		if (event.getSlot() == 2) {
			//shotgun
			player.performCommand("shotgun");
			player.sendMessage(ChatColor.GOLD + "This your item");
		}
		if (event.getSlot() == 8) {
			player.closeInventory();
		}
		
		return;
		
	}
	

	
	
	
	
	public void createInv() {
		
		inv = Bukkit.createInventory(null, 9,ChatColor.BLUE + "" + ChatColor.BOLD + "Combat List");
		
		ItemStack item = new ItemStack(Material.CROSSBOW);
		ItemMeta meta = item.getItemMeta();
		
		//CrossBow
		meta.setDisplayName(ChatColor.YELLOW + "COMBAT CROSSBOW");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Click to select CrossBow");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(0, item);
		
		//Sword
		item.setType(Material.DIAMOND_SWORD);
		meta.setDisplayName(ChatColor.DARK_BLUE + "COMBAT SWORD");
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		//ShotGun
		item.setType(Material.GOLDEN_HORSE_ARMOR);
		meta.setDisplayName(ChatColor.DARK_PURPLE + "COMBAT GUN");
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		//ComingSoon
		item.setType(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.DARK_RED + "COOMING SOON");
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		//ComingSOOn
		item.setType(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.DARK_RED + "COOMING SOON");
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		//COmingSooN
		item.setType(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.DARK_RED + "COOMING SOON");
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		//ComingsOOn
		item.setType(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.DARK_RED + "COOMING SOON");
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		//CoMingsOOn
		item.setType(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		meta.setDisplayName(ChatColor.DARK_RED + "COOMING SOON");
		item.setItemMeta(meta);
		inv.setItem(8, item);
		
		//close button
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Menu");
		lore.clear();
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(8, item);
	}
	
	
}













