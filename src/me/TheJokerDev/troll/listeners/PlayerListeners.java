package me.TheJokerDev.troll.listeners;

import com.comphenix.protocol.wrappers.EnumWrappers;
import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.inventory.SelectorGUI;
import me.TheJokerDev.troll.inventory.TrollGUI;
import me.TheJokerDev.troll.messages.Files;
import me.TheJokerDev.troll.utils.ItemBuilder;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerListeners
        implements Listener
{
    public Main plugin;
    private TrollGUI tm = new TrollGUI(null);
    private Files lf = new Files();

    public PlayerListeners(Main plugin)
    {
        this.plugin = plugin;
        this.plugin.frozen = new ArrayList();
        this.plugin.allfrozen = new ArrayList();
    }

    @EventHandler
    public void FreezePlayer(PlayerMoveEvent e)
    {
        if (this.plugin.frozen.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void FreezeAll(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();
        if (this.plugin.allfrozen.contains(p.getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHit(EntityDamageEvent event)
    {
        if (event.getEntityType() == EntityType.PLAYER)
        {
            Player t = (Player)event.getEntity();
            if (this.plugin.morphsdamage.contains(t)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e)
    {
        if (e.getEntityType() == EntityType.PLAYER)
        {
            Player p = e.getEntity();
            if (this.plugin.arrow.contains(p.getName())) {
                Bukkit.getScheduler().cancelTask(Main.plugin.arrowtroll);
            }
            if (this.plugin.zeus.contains(p.getName()))
            {
                Bukkit.getScheduler().cancelTasks(this.plugin);
                this.plugin.zeus.remove(p.getName());
                Bukkit.broadcastMessage(this.lf.getString("Troll.Zeus.LeaveZeus"));
            }
            if (p.hasPermission("troll.skull")){
                if (e.getDrops() == new ItemBuilder(Material.SKULL_ITEM).setName(lf.getString("Skull.name")).setDurability((short)3).setSkullOwner(Main.getInstance().getConfig().getString("skull-owner")).setLore(lf.getStringList("Skull.lore")).toItemStack()){
                    e.getDrops().clear();
                }
                //final Item item = p.getWorld().dropItem(p.getLocation(), new ItemBuilder(Material.SKULL_ITEM).setName(lf.getString("Skull.name")).setDurability((short)3).setSkullOwner(Main.getInstance().getConfig().getString("skull-owner")).setLore(lf.getStringList("Skull.lore")).toItemStack());
                //this.taskID1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
                //  p.setCanPickupItems(true);
                //  item.remove();
                //  item.remove();
                //  Bukkit.getScheduler().cancelTasks(this.plugin);
                //}, 20L, 0L);
            }
        }
    }
    @EventHandler
    public void romper(BlockBreakEvent e)
    {
        Player p = e.getPlayer();
        if (plugin.expBlock.contains(p.getName()))
        {
            p.getWorld().createExplosion(e.getBlock().getLocation(), 5.0F);
            plugin.expBlock.remove(p.getName());
        }
        Block block = e.getBlock();
        if (plugin.lavablock.contains(p.getName()))
        {
            e.setCancelled(true);
            block.setType(Material.LAVA);
            plugin.lavablock.remove(p.getName());
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        Player p = e.getPlayer();
        if (this.plugin.frozen.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
        if (plugin.expBlock.contains(p.getName()))
        {
            p.getWorld().createExplosion(e.getBlock().getLocation(), 5.0F);
            plugin.expBlock.remove(p.getName());
        }
        if (this.plugin.allfrozen.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
        if (this.plugin.lagg.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
        if (p.getItemInHand().getType() == Material.SKULL_ITEM)
        {
            if ((p.getItemInHand().getItemMeta().getLore() != null) &&
                    (p.getItemInHand().getDurability() == 3)) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Skull.name")))
                {
                    if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                        return;
                    }
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void PlayerChat(PlayerChatEvent e){
        Player player = e.getPlayer();
        if (this.plugin.toTrans.contains(player.getName())) {
            Player t = Main.target.get(player);
            PlayerDisguise d = new PlayerDisguise(e.getMessage());
            DisguiseAPI.disguiseToAll(t, d);
            player.sendMessage(Main.prefix + this.lf.getString("Morphs.Players.DisguiseInAnotherPlayer.messages.converted").replaceAll("%player%", t.getName()).replaceAll("%chat%", e.getMessage().replaceAll("&", "\u00a7")));
            this.plugin.toTrans.remove(player.getName());
            e.setCancelled(true);
        }
        if (this.plugin.toTrans1.contains(player.getName())) {
            for (Player t : Bukkit.getOnlinePlayers()) {
                PlayerDisguise d = new PlayerDisguise(e.getMessage());
                DisguiseAPI.disguiseToAll(t, d);
            }
            player.sendMessage(Main.prefix + this.lf.getString("Morphs.Players.AllDisguiseInAnotherPlayer.messages.converted").replaceAll("%chat%", e.getMessage().replaceAll("&", "\u00a7")));
            e.setCancelled(true);
            this.plugin.toTrans1.remove(player.getName());
        }
    }

    @EventHandler
    public void ChatWatch(AsyncPlayerChatEvent e)
    {
        Player player = e.getPlayer();
        if (this.plugin.fillinvWatchChat.contains(player))
        {
            e.setCancelled(true);
            try
            {
                ItemStack fillInv = new ItemStack(Material.valueOf(e.getMessage().toUpperCase()), 2304);
                this.plugin.select.get(player).getInventory().addItem(fillInv);
                player.sendMessage(Main.prefix + this.lf.getString("Troll.FillInventory.successful").replaceAll("%player%", this.plugin.select.get(player).getName()).replaceAll("%item%", e.getMessage()));
            }
            catch (IllegalArgumentException error)
            {
                player.sendMessage(Main.prefix + this.lf.getString("Troll.FillInventory.no-valid-item").replaceAll("%player%", this.plugin.select.get(player).getName()).replaceAll("%item%", e.getMessage()));
            }
            this.plugin.fillinvWatchChat.remove(player);
            this.plugin.fillinvAllowanceTime.remove(player);
        }
        else if (this.plugin.disguiseplayer.contains(player))
        {
            e.setCancelled(true);

            Player t = Main.target.get(player);
            Main.target.get(t);

            this.plugin.disguiseplayer.remove(player);
            this.plugin.disguiseplayerTime.remove(player);
        }
        else if (this.plugin.randomChatACTIVE.contains(player))
        {
            e.setCancelled(true);
            List<?> messages = this.lf.getStringList("Troll.RandomChat.messages.randomlist");
            int index = ThreadLocalRandom.current().nextInt(messages.size());
            String message = ChatColor.translateAlternateColorCodes('&', (String)messages.get(index));

            this.plugin.randomChatACTIVE.remove(player);
            player.chat(message);
            this.plugin.randomChatACTIVE.add(player);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e)
    {
        Player p = e.getPlayer();
        if (this.plugin.frozen.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
        if (this.plugin.allfrozen.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
        if (this.plugin.lagg.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
        if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
            if ((p.getItemInHand().getItemMeta().getLore() != null) &&
                    (p.getItemInHand().getDurability() == 3))
            {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Skull.name")))
                {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void RandomMenu(InventoryOpenEvent e)
    {
        Player player = (Player)e.getPlayer();
        if (this.plugin.randomMenu.contains(player))
        {
            e.setCancelled(true);

            ArrayList<InventoryType> invList = new ArrayList<>();
            invList.add(InventoryType.ANVIL);
            invList.add(InventoryType.BEACON);
            invList.add(InventoryType.BREWING);
            invList.add(InventoryType.CHEST);
            invList.add(InventoryType.DISPENSER);
            invList.add(InventoryType.DROPPER);
            invList.add(InventoryType.ENCHANTING);
            invList.add(InventoryType.ENDER_CHEST);
            invList.add(InventoryType.FURNACE);
            invList.add(InventoryType.HOPPER);
            invList.add(InventoryType.MERCHANT);
            invList.add(InventoryType.WORKBENCH);

            int index = ThreadLocalRandom.current().nextInt(invList.size());
            InventoryType desiredInv = invList.get(index);

            this.plugin.randomMenu.remove(player);
            player.openInventory(Bukkit.createInventory(player, desiredInv, e.getInventory().getTitle()));
            this.plugin.randomMenu.add(player);
        }
    }

    @EventHandler
    public void InteractVictim(PlayerInteractEntityEvent e)
    {
        Player player = e.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("interact-victim")) {
            if (player.hasPermission("atroll.open"))
            {
                if (e.getRightClicked().getType() == EntityType.PLAYER)
                {
                    Player t = (Player)e.getRightClicked();
                    Main.target.put(player, t);
                    this.tm.openTroll(e.getPlayer());
                }
                else
                {
                    player.sendMessage(Main.prefix + this.lf.getPluginMSG("PluginMessages.interactMessage"));
                }
            }
            else
            {
                player.sendMessage(Main.prefix + this.lf.getPluginMSG("PluginMessages.noPermission"));
            }
        }
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        if (!Main.getInstance().getConfig().getBoolean("skull-troll")) {
            return;
        }
        if (p.hasPermission("atroll.skull"))
        {
            ItemStack skull = new ItemBuilder(Material.SKULL_ITEM).setName(lf.getString("Skull.name")).setDurability((short)3).setSkullOwner(Main.getInstance().getConfig().getString("skull-owner")).setLore(lf.getStringList("Skull.lore")).toItemStack();
            p.getInventory().setItem(Main.getInstance().getConfig().getInt("skull-slotinventory"), skull);
        }
    }


    @EventHandler(ignoreCancelled = true)
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack skull = new ItemBuilder(Material.SKULL_ITEM).setName(lf.getString("Skull.name")).setDurability((short)3).setSkullOwner(Main.getInstance().getConfig().getString("skull-owner")).setLore(lf.getStringList("Skull.lore")).toItemStack();
        ItemStack drop = event.getItemDrop().getItemStack();
            if (skull.isSimilar(drop)) {
                event.setCancelled(true);
                final Player player = event.getPlayer();
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                    public void run() {
                        player.updateInventory();
                    }
                }, 1L);
            }
        }
        
    @EventHandler
    public void LockHand(InventoryClickEvent e)
    {
        Player p = (Player)e.getWhoClicked();
        if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
            if ((p.getItemInHand().getItemMeta().getLore() != null) &&
                    (p.getItemInHand().getDurability() == 3))
            {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Skull.name")))
                {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        if (!Main.getInstance().getConfig().getBoolean("skull-troll")) {
            return;
        }
        if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            Player p = e.getPlayer();
            if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
                if ((p.getItemInHand().getItemMeta().getLore() != null) &&
                        (p.getItemInHand().getDurability() == 3))
                {
                    if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Skull.name")))
                    {
                        SelectorGUI sc = new SelectorGUI();
                        sc.openGUI(p);
                    }
                }
            }
        }
    }

    @EventHandler
    public void Respawn(PlayerRespawnEvent e)
    {
        Player p = e.getPlayer();
        if (!Main.getInstance().getConfig().getBoolean("skull-troll")) {
            return;
        }
        if (p.hasPermission("atroll.skull"))
        {
            ItemStack skull = new ItemBuilder(Material.SKULL_ITEM).setName(lf.getString("Skull.name")).setDurability((short)3).setSkullOwner(Main.getInstance().getConfig().getString("skull-owner")).setLore(lf.getStringList("Skull.lore")).toItemStack();
            p.getInventory().setItem(Main.getInstance().getConfig().getInt("skull-slotinventory"), skull);
        }
    }
}
