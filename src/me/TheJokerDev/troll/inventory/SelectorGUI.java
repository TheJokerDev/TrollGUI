package me.TheJokerDev.troll.inventory;

import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.messages.Files;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SelectorGUI {
    private Files fl = new Files();
    private String invName = this.fl.getString("GUI.Selector.Title");
    private Inventory inv;
    public Main plugin;

    private Inventory createGUI() {
        int i = Bukkit.getOnlinePlayers().size();
        if (i < 9) {
            this.inv = Bukkit.createInventory(null, 9, this.invName);
        } else if (i < 18) {
            this.inv = Bukkit.createInventory(null, 18, this.invName);
        } else if (i < 27) {
            this.inv = Bukkit.createInventory(null, 27, this.invName);
        } else if (i < 36) {
            this.inv = Bukkit.createInventory(null, 36, this.invName);
        } else if (i < 45) {
            this.inv = Bukkit.createInventory(null, 45, this.invName);
        } else if (i < 54) {
            this.inv = Bukkit.createInventory(null, 54, this.invName);
        }
        Bukkit.getOnlinePlayers().stream().map(localPlayer -> {
            ItemStack localItemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
            SkullMeta localSkullMeta = (SkullMeta)localItemStack.getItemMeta();
            localSkullMeta.setOwner(localPlayer.getName());
            localSkullMeta.setDisplayName(ChatColor.GREEN + localPlayer.getName());
            localItemStack.setItemMeta(localSkullMeta);
            return localItemStack;
        }).forEachOrdered(localItemStack -> this.inv.addItem(new ItemStack[]{localItemStack}));
        return this.inv;
    }

    public void openGUI(Player paramPlayer) {
        Inventory localInventory = this.createGUI();
        paramPlayer.openInventory(localInventory);
    }
}