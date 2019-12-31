package me.TheJokerDev.troll.listeners;

import io.netty.util.internal.ThreadLocalRandom;
import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.inventory.*;
import me.TheJokerDev.troll.messages.Files;
import me.TheJokerDev.troll.utils.IBlock;
import me.egg82.tcpp.events.player.playerMove.LagEventCommand;
import me.egg82.tcpp.lib.ninja.egg82.bukkit.utils.TaskUtil;
import me.egg82.tcpp.lib.ninja.egg82.utils.MathUtil;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

public class TrollListeners
        implements Listener {
    public Main plugin;
    private TrollGUI tm;
    private Files lf;
    private int infinityTask;
    private static ArrayList<Player> playersocult = new ArrayList<>();
    private static LinkedList<Player> VANISHED = new LinkedList<>();
    private int i;

    public TrollListeners(Main plugin) {
        this.tm = new TrollGUI(null);
        this.lf = new Files();
        this.i = 0;
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerClickNull(InventoryClickEvent event) {
        final Player t = Main.target.get(event.getWhoClicked());
        if (t != null) {
            Iterator<Player> localIterator;
            Location tl22;
            ItemStack emerald2;
            Set<Player> names;
            if (!event.getInventory().getName().equals(this.m("GUI.Troll.Title", t).replaceAll("%page%", "1"))) {
                return;
            }
            final Player p = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.FakeOP.name")) && Main.target.keySet().iterator().hasNext()) {
                t.sendMessage(this.m("Troll.FakeOP.messages.toplayer", t));
                p.sendMessage(Main.prefix + this.m("Troll.FakeOP.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Spam.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(p);
                p.closeInventory();
                p.sendMessage(Main.prefix + this.m("Troll.Spam.messages.successful", t));
                for (int x = 0; x <= 3000; ++x) {
                    List<String> messages = this.lf.getStringList("Troll.Spam.messages.spamlist");
                    int i = ThreadLocalRandom.current().nextInt(messages.size());
                    String message = org.bukkit.ChatColor.translateAlternateColorCodes('&', messages.get(i));
                    t.sendMessage(message);
                    t.sendMessage(message);
                    t.sendMessage(message);
                    t.sendMessage(message);
                    t.sendMessage(message);
                    t.sendMessage(message);
                    t.sendMessage(message);
                    t.sendMessage(message);
                }
                Main.target.remove(p);
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.FakeBan.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                t.kickPlayer(this.lf.getString("Troll.FakeBan.messages.banMessage"));
                p.sendMessage(Main.prefix + this.m("Troll.FakeBan.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.TnTNuke.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                final Location loc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 3.0, t.getLocation().getZ());
                final Location te = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ());
                final Location t2 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ());
                Location blocksloc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location unten = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                final Location t5 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
                final Location tl6 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
                final Location tl7 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
                final Location tl8 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
                final Location tl19 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ());
                final Location tl20 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0, t.getLocation().getZ());
                final Location tl21 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 3.0, t.getLocation().getZ());
                t.getWorld().strikeLightning(loc);
                t.getWorld().getBlockAt(te).setType(Material.TNT);
                t.getWorld().getBlockAt(t2).setType(Material.TNT);
                t.getWorld().getBlockAt(blocksloc).setType(Material.TNT);
                t.getWorld().getBlockAt(unten).setType(Material.TNT);
                t.getWorld().getBlockAt(t5).setType(Material.TNT);
                t.getWorld().getBlockAt(tl6).setType(Material.TNT);
                t.getWorld().getBlockAt(tl7).setType(Material.TNT);
                t.getWorld().getBlockAt(tl8).setType(Material.TNT);
                t.getWorld().getBlockAt(tl19).setType(Material.TNT);
                t.getWorld().getBlockAt(tl20).setType(Material.TNT);
                t.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
                final Location finalBlocksloc = blocksloc;
                final Location finalUnten = unten;
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                    t.getWorld().createExplosion(loc, (float) Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(te, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(t2, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(finalBlocksloc, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(finalUnten, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(t5, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(tl6, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(tl7, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(tl8, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(tl19, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(tl21, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                    t.getWorld().createExplosion(tl20, (float)Main.getInstance().getConfig().getInt("nuke-radius"));
                }, 100L);
                p.sendMessage(Main.prefix + this.m("Troll.TnTNuke.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.TnT.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                Location loc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 3.0, t.getLocation().getZ());
                Location te = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ());
                Location t2 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ());
                Location blocksloc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location unten = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                Location t5 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
                Location tl6 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
                Location tl7 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
                Location tl8 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
                Location tl19 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ());
                Location tl20 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0, t.getLocation().getZ());
                new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 3.0, t.getLocation().getZ());
                t.getWorld().strikeLightning(loc);
                t.getWorld().getBlockAt(te).setType(Material.TNT);
                t.getWorld().getBlockAt(t2).setType(Material.TNT);
                t.getWorld().getBlockAt(blocksloc).setType(Material.TNT);
                t.getWorld().getBlockAt(unten).setType(Material.TNT);
                t.getWorld().getBlockAt(t5).setType(Material.TNT);
                t.getWorld().getBlockAt(tl6).setType(Material.TNT);
                t.getWorld().getBlockAt(tl7).setType(Material.TNT);
                t.getWorld().getBlockAt(tl8).setType(Material.TNT);
                t.getWorld().getBlockAt(tl19).setType(Material.TNT);
                t.getWorld().getBlockAt(tl20).setType(Material.TNT);
                t.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
                p.sendMessage(Main.prefix + this.m("Troll.TnT.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.ExtremeTnT.name"))) {
                p.closeInventory();
                p.sendMessage(Main.prefix + this.m("Troll.ExtremeTnT.messages.successful", t));
                FallingBlock b = t.getWorld().spawnFallingBlock(t.getLocation().add(0.0, 15.0, 0.0), Material.TNT, (byte)1);
                new BukkitRunnable(){
                    public void run() {
                        if (b.isOnGround()) {
                            if (Bukkit.getVersion().contains("1.8")) {
                                t.playSound(b.getLocation(), Sound.valueOf("EXPLODE"), 1.0f, 1.0f);
                            } else {
                                t.playSound(b.getLocation(), Sound.valueOf("ENTITY_GENERIC_EXPLODE"), 1.0f, 1.0f);
                            }
                            b.remove();
                            if (b.isDead()) {
                                this.cancel();
                                World w = b.getWorld();
                                List<IBlock> blocks = TrollListeners.this.getSphere(b.getLocation(), Main.getConfiguration().getInt("ExtremeTnT-Radius"));
                                for (IBlock b : blocks) {
                                    w.getBlockAt(b.getLoc().clone()).setType(Material.AIR);
                                }
                                Bukkit.getScheduler().scheduleSyncDelayedTask(TrollListeners.this.plugin, () -> {
                                    for (IBlock b : blocks) {
                                        w.getBlockAt(b.getLoc()).setTypeIdAndData(b.getType(), b.getData(), true);
                                    }
                                }, 200L);
                            }
                        }
                    }
                }.runTaskTimer(this.plugin, 0L, 2L);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.BedrockCage.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                Location loc = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ());
                Location te = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ());
                Location t2 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location blocksloc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                Location unten = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location t5 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                Location tl6 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                Location tl7 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location tl8 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
                Location tl19 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
                Location tl20 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
                Location tl21 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
                tl22 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() + 1.0);
                Location tl23 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() - 1.0);
                Location tl24 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() - 1.0);
                Location tl25 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() + 1.0);
                Location tl26 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ());
                Location tl27 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ());
                Location tl28 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ() + 1.0);
                Location tl29 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ() - 1.0);
                Location tl30 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 3.0, t.getLocation().getZ());
                Location tl31 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
                Location tl32 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
                Location tl33 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
                Location tl34 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
                Location tl35 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0, t.getLocation().getZ());
                Location tl36 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ());
                Location tl37 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ());
                Location tl38 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ());
                t.getWorld().getBlockAt(loc).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(te).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(t2).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(blocksloc).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(unten).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(t5).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl6).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl7).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl8).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl19).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl20).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl21).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl22).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl23).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl24).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl25).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl26).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl27).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl28).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl29).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl30).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl31).setType(Material.IRON_FENCE);
                t.getWorld().getBlockAt(tl32).setType(Material.IRON_FENCE);
                t.getWorld().getBlockAt(tl33).setType(Material.IRON_FENCE);
                t.getWorld().getBlockAt(tl34).setType(Material.IRON_FENCE);
                t.getWorld().getBlockAt(tl35).setType(Material.BEDROCK);
                t.getWorld().getBlockAt(tl36).setType(Material.AIR);
                t.getWorld().getBlockAt(tl37).setType(Material.AIR);
                t.getWorld().getBlockAt(tl38).setType(Material.AIR);
                t.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Main.prefix + this.m("Troll.BedrockCage.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.ExtremeTroll.name"))) {
                p.closeInventory();
                names = Main.target.keySet();
                localIterator = names.iterator();
                if (localIterator.hasNext()) {
                    Main.target.get(t);
                    for (int x = 0; x <= 1000; ++x) {
                        List<String> messages = (List<String>)this.lf.getLang().getList("Troll.ExtremeTroll.messages.spamlist");
                        int i = ThreadLocalRandom.current().nextInt(messages.size());
                        String message = org.bukkit.ChatColor.translateAlternateColorCodes('&', messages.get(i));
                        t.sendMessage(message);
                        t.sendMessage(message);
                        t.sendMessage(message);
                        t.sendMessage(message);
                        t.sendMessage(message);
                        t.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 3000, 1000));
                        t.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3000, 1000));
                        t.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 3000, 1000));
                        t.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 3000, 1000));
                    }
                    Main.target.remove(t);
                    p.sendMessage(Main.prefix + this.m("Troll.ExtremeTroll.messages.successful", t));
                }
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Lava.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                Location loc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0, t.getLocation().getZ());
                Location te = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0, t.getLocation().getZ() + 1.0);
                Location t2 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0, t.getLocation().getZ() - 1.0);
                Location blocksloc = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() - 1.0, t.getLocation().getZ() + 1.0);
                Location unten = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() - 1.0, t.getLocation().getZ() - 1.0);
                Location t5 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() - 1.0, t.getLocation().getZ() + 1.0);
                Location tl6 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() - 1.0, t.getLocation().getZ() - 1.0);
                Location tl7 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() - 1.0, t.getLocation().getZ());
                Location tl8 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() - 1.0, t.getLocation().getZ());
                Location tl19 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 2.0, t.getLocation().getZ());
                Location tl20 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 2.0, t.getLocation().getZ() + 1.0);
                Location tl21 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 2.0, t.getLocation().getZ() - 1.0);
                tl22 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() - 2.0, t.getLocation().getZ() + 1.0);
                Location tl23 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() - 2.0, t.getLocation().getZ() - 1.0);
                Location tl24 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() - 2.0, t.getLocation().getZ() + 1.0);
                Location tl25 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() - 2.0, t.getLocation().getZ() - 1.0);
                Location tl26 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() - 2.0, t.getLocation().getZ());
                Location tl27 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() - 2.0, t.getLocation().getZ());
                Location tl28 = new Location(t.getWorld(), t.getLocation().getX() + 2.0, t.getLocation().getY(), t.getLocation().getZ() + 2.0);
                Location tl29 = new Location(t.getWorld(), t.getLocation().getX() - 2.0, t.getLocation().getY(), t.getLocation().getZ() - 2.0);
                Location tl30 = new Location(t.getWorld(), t.getLocation().getX() + 2.0, t.getLocation().getY(), t.getLocation().getZ() - 2.0);
                Location tl31 = new Location(t.getWorld(), t.getLocation().getX() - 2.0, t.getLocation().getY(), t.getLocation().getZ() + 2.0);
                Location tl32 = new Location(t.getWorld(), t.getLocation().getX() + 2.0, t.getLocation().getY(), t.getLocation().getZ());
                Location tl33 = new Location(t.getWorld(), t.getLocation().getX() - 2.0, t.getLocation().getY(), t.getLocation().getZ());
                Location tl34 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 2.0);
                Location tl35 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() - 2.0);
                Location tl36 = new Location(t.getWorld(), t.getLocation().getX() + 2.0, t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location tl37 = new Location(t.getWorld(), t.getLocation().getX() - 2.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                Location tl38 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ() - 2.0);
                Location tl39 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ() + 2.0);
                Location tl40 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ() + 2.0);
                Location tl41 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ() - 2.0);
                Location tl42 = new Location(t.getWorld(), t.getLocation().getX() - 2.0, t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location tl43 = new Location(t.getWorld(), t.getLocation().getX() + 2.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                t.getWorld().getBlockAt(loc).setType(Material.LAVA);
                t.getWorld().getBlockAt(te).setType(Material.LAVA);
                t.getWorld().getBlockAt(t2).setType(Material.LAVA);
                t.getWorld().getBlockAt(blocksloc).setType(Material.LAVA);
                t.getWorld().getBlockAt(unten).setType(Material.LAVA);
                t.getWorld().getBlockAt(t5).setType(Material.LAVA);
                t.getWorld().getBlockAt(tl6).setType(Material.LAVA);
                t.getWorld().getBlockAt(tl7).setType(Material.LAVA);
                t.getWorld().getBlockAt(tl8).setType(Material.LAVA);
                t.getWorld().getBlockAt(tl19).setType(Material.STONE);
                t.getWorld().getBlockAt(tl20).setType(Material.STONE);
                t.getWorld().getBlockAt(tl21).setType(Material.STONE);
                t.getWorld().getBlockAt(tl22).setType(Material.STONE);
                t.getWorld().getBlockAt(tl23).setType(Material.STONE);
                t.getWorld().getBlockAt(tl24).setType(Material.STONE);
                t.getWorld().getBlockAt(tl25).setType(Material.STONE);
                t.getWorld().getBlockAt(tl26).setType(Material.STONE);
                t.getWorld().getBlockAt(tl27).setType(Material.STONE);
                t.getWorld().getBlockAt(tl28).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl29).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl30).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl31).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl32).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl33).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl34).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl35).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl36).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl37).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl38).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl39).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl40).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl41).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl42).setType(Material.FENCE);
                t.getWorld().getBlockAt(tl43).setType(Material.FENCE);
                t.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Main.prefix + this.m("Troll.Lava.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Facepalm.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                t.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 100));
                t.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 1));
                p.sendMessage(Main.prefix + this.m("Troll.Facepalm.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Launch.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                Vector launch = new Vector(0, 20, 0);
                t.setVelocity(launch);
                p.sendMessage(Main.prefix + this.m("Troll.Launch.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Freeze.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                if (!this.plugin.frozen.contains(t.getName())) {
                    this.plugin.frozen.add(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.Freeze.messages.activated", t));
                    return;
                }
                if (this.plugin.frozen.contains(t.getName())) {
                    this.plugin.frozen.remove(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.Freeze.messages.deactivated", t));
                    return;
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.FreezeAll.name"))) {
                p.closeInventory();
                if (!this.plugin.allfrozen.contains(t.getName())) {
                    p.sendMessage(Main.prefix + this.lf.getString("Troll.FreezeAll.messages.activated"));
                } else {
                    p.sendMessage(Main.prefix + this.lf.getString("Troll.FreezeAll.messages.deactivated"));
                }
                Bukkit.getOnlinePlayers().forEach(p2 -> {
                    if (!this.plugin.allfrozen.contains(p2.getName())) {
                        this.plugin.allfrozen.add(p2.getName());
                        this.plugin.allfrozen.remove(p.getName());
                    } else if (this.plugin.allfrozen.contains(p2.getName())) {
                        this.plugin.allfrozen.remove(p2.getName());
                        this.plugin.frozen.remove(p2.getName());
                    }
                });
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Smite.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.getWorld().strikeLightning(t.getLocation());
                p.sendMessage(Main.prefix + this.m("Troll.Smite.messages.successful", t));
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Burn.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                t.setFireTicks(5000);
                p.sendMessage(Main.prefix + this.m("Troll.Burn.messages.successful", t));
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.EnderChest.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.openInventory(t.getEnderChest());
                p.sendMessage(Main.prefix + this.m("Troll.EnderChest.messages.successful", t));
                Main.target.remove(t);
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Inventory.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                Bukkit.dispatchCommand(p, "oi " + t.getName());
                p.sendMessage(Main.prefix + this.m("Troll.Inventory.messages.successful", t));
                Main.target.remove(t);
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.ControlPlayer.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                this.plugin.startControlling(t, p);
                p.sendMessage(Main.prefix + this.m("Troll.ControlPlayer.messages.successful", t));
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.HidePlayers.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                if (playersocult.contains(t)) {
                    playersocult.remove(t);
                    Bukkit.getOnlinePlayers().forEach(t::showPlayer);
                    p.sendMessage(Main.prefix + this.m("Troll.HidePlayers.messages.deactivated", t));
                } else {
                    playersocult.add(t);
                    Bukkit.getOnlinePlayers().forEach(t::hidePlayer);
                    p.sendMessage(Main.prefix + this.m("Troll.HidePlayers.messages.activated", t));
                }
                Main.target.remove(t);
                p.closeInventory();
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Matrix.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                t.kickPlayer("§a§kFAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_");
                p.sendMessage(Main.prefix + this.m("Troll.Matrix.messages.successful", t));
                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.<-.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                SelectorGUI localObject2 = new SelectorGUI();
                localObject2.openGUI(p);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Morphs.name"))) {
                Main.target.get(t);
                Main.target.put(p, t);
                MorphsGUI mg = new MorphsGUI();
                mg.openMorphs(p);
                p.sendMessage(Main.prefix + this.m("Troll.Morphs.messages.successful", t));
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Creeper.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                Location te = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ());
                Location t2 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ());
                Location blocksloc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                Location unten = new Location(t.getWorld(), t.getLocation().getX() + 2.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
                Location t5 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
                this.CCreeper(te.add(0.5, 1.0, 0.5));
                this.CCreeper(t2.add(0.5, 1.0, 0.5));
                this.CCreeper(blocksloc.add(0.5, 1.0, 0.5));
                this.CCreeper(unten.add(0.5, 1.0, 0.5));
                this.CCreeper(t5.add(0.5, 1.0, 0.5));
                p.sendMessage(Main.prefix + this.m("Troll.Creeper.messages.successful", t));
                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.ExplosiveWand.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("\u00a77-    -");
                emerald2 = new ItemStack(Material.STICK);
                ItemMeta meta = emerald2.getItemMeta();
                meta.setDisplayName(this.lf.getString("Troll.ExplosiveWand.name"));
                meta.setLore(lore);
                emerald2.setItemMeta(meta);
                t.getInventory().addItem(emerald2);
                p.sendMessage(Main.prefix + this.m("Troll.ExplosiveWand.messages.successful", t));
                event.setCancelled(true);
                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Demo.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                Bukkit.dispatchCommand(p, "demotroll " + t.getName());
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.DropInventory.name"))) {
                for (ItemStack emerald1 : t.getInventory().getContents()) {
                    if (emerald1 == null) continue;
                    Main.target.get(t);
                    t.getWorld().dropItemNaturally(t.getLocation(), emerald1);
                    t.getInventory().remove(emerald1);
                }
                for (ItemStack emerald3 : t.getInventory().getArmorContents()) {
                    if (emerald3 == null) continue;
                    Main.target.get(t);
                    t.getWorld().dropItemNaturally(t.getLocation(), emerald3);
                    t.getInventory().setArmorContents(null);
                }
                p.closeInventory();
                p.sendMessage(Main.prefix + this.m("Troll.DropInventory.messages.successful", t));
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.SkyColors.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                Main.target.get(t);
                Main.target.put(p, t);
                SkyColorsGUI scg = new SkyColorsGUI();
                scg.openSkyColors(p);
                p.sendMessage(Main.prefix + this.m("Troll.SkyColors.messages.successful", t));
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.PublicInventory.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.openInventory(t.getInventory());
                }
                p.sendMessage(Main.prefix + this.m("Troll.PublicInventory.messages.successful", t));
                Main.target.remove(t);
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Arrow.name"))) {
                Main.target.get(t);
                if (t != null) {
                    this.plugin.arrowtroll = this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
                        Location loc = t.getLocation().clone();
                        Arrow arrow = t.getWorld().spawn(loc.clone().add((double)TrollListeners.this.getRandom(-10, 10), (double)TrollListeners.this.getRandom(5, 10), (double)TrollListeners.this.getRandom(-10, 10)), Arrow.class);
                        Location aloc = arrow.getLocation();
                        Vector angle = new Vector(loc.getX() - aloc.getX(), loc.getY() - (double)aloc.getBlockY(), loc.getZ() - (double)aloc.getBlockZ());
                        arrow.setVelocity(angle.normalize().multiply(2.0));
                        Arrow arrow2 = t.getWorld().spawn(loc.clone().add((double)TrollListeners.this.getRandom(-10, 10), (double)TrollListeners.this.getRandom(5, 10), (double)TrollListeners.this.getRandom(-10, 10)), Arrow.class);
                        Location aloc2 = arrow2.getLocation();
                        Vector angle2 = new Vector(loc.getX() - aloc2.getX(), loc.getY() - (double)aloc2.getBlockY(), loc.getZ() - (double)aloc2.getBlockZ());
                        arrow2.setVelocity(angle2.normalize().multiply(2.0));
                        Arrow arrow3 = t.getWorld().spawn(loc.clone().add((double)TrollListeners.this.getRandom(-10, 10), (double)TrollListeners.this.getRandom(5, 10), (double)TrollListeners.this.getRandom(-10, 10)), Arrow.class);
                        Location aloc3 = arrow3.getLocation();
                        Vector angle3 = new Vector(loc.getX() - aloc3.getX(), loc.getY() - (double)aloc3.getBlockY(), loc.getZ() - (double)aloc3.getBlockZ());
                        arrow3.setVelocity(angle3.normalize().multiply(2.0));
                        Arrow arrow4 = t.getWorld().spawn(loc.clone().add((double)TrollListeners.this.getRandom(-10, 10), (double)TrollListeners.this.getRandom(5, 10), (double)TrollListeners.this.getRandom(-10, 10)), Arrow.class);
                        Location aloc4 = arrow4.getLocation();
                        Vector angle4 = new Vector(loc.getX() - aloc4.getX(), loc.getY() - (double)aloc4.getBlockY(), loc.getZ() - (double)aloc4.getBlockZ());
                        arrow4.setVelocity(angle4.normalize().multiply(2.0));
                        Arrow arrow5 = t.getWorld().spawn(loc.clone().add((double)TrollListeners.this.getRandom(-10, 10), (double)TrollListeners.this.getRandom(5, 10), (double)TrollListeners.this.getRandom(-10, 10)), Arrow.class);
                        Location aloc5 = arrow5.getLocation();
                        Vector angle5 = new Vector(loc.getX() - aloc5.getX(), loc.getY() - (double)aloc5.getBlockY(), loc.getZ() - (double)aloc5.getBlockZ());
                        arrow5.setVelocity(angle5.normalize().multiply(2.0));
                    }, 0L, 15L);
                    if (!this.plugin.arrow.contains(t.getName())) {
                        this.plugin.arrow.add(t.getName());
                        p.sendMessage(Main.prefix + this.m("Troll.Arrow.messages.activated", t));
                    } else {
                        Bukkit.getScheduler().cancelTasks(this.plugin);
                        this.plugin.arrow.remove(t.getName());
                        p.sendMessage(Main.prefix + this.m("Troll.Arrow.messages.deactivated", t));
                    }

                }
                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Lag.name"))) {
                Main.target.get(t);
                if (t != null) {
                    if (!this.plugin.lagg.contains(t.getName())) {
                        this.plugin.lagg.add(t.getName());
                        p.sendMessage(Main.prefix + this.m("Troll.Lag.messages.activated", t));
                    } else {
                        Bukkit.getScheduler().cancelTasks(this.plugin);
                        this.plugin.lagg.remove(t.getName());
                        p.sendMessage(Main.prefix + this.m("Troll.Lag.messages.deactivated", t));
                    }
                }
                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Zeus.name"))) {
                Main.target.get(t);
                if (t != null) {
                    // empty if block
                }
                if (!this.plugin.zeus.contains(t.getName())) {
                    this.plugin.zeus.add(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.Zeus.messages.activated", t));
                    Bukkit.broadcastMessage(this.lf.getString("Troll.Zeus.messages.JoinZeus"));
                } else {
                    Bukkit.getScheduler().cancelTasks(this.plugin);
                    this.plugin.zeus.remove(t.getName());
                    Bukkit.broadcastMessage(this.lf.getString("Troll.Zeus.messages.LeaveZeus"));
                    p.sendMessage(Main.prefix + this.m("Troll.Zeus.messages.deactivated", t));
                }
                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.RandomChat.name"))) {
                Main.target.get(t);
                if (t != null) {
                    if (!this.plugin.randomChatACTIVE.contains(t)) {
                        this.plugin.randomChatACTIVE.add(t);
                        p.sendMessage(Main.prefix + this.m("Troll.RandomChat.messages.activated", t));
                    } else {
                        this.plugin.randomChatACTIVE.remove(t);
                        p.sendMessage(Main.prefix + this.m("Troll.RandomChat.messages.deactivated", t));
                    }
                }

                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Void.name"))) {
                p.closeInventory();
                p.sendMessage(Main.prefix + this.m("Troll.Void.messages.successful", t));
                if (Bukkit.getVersion().contains("1.8")) {
                    t.playSound(t.getLocation(), Sound.valueOf("EXPLODE"), 1.0f, 1.0f);
                } else {
                    t.playSound(t.getLocation(), Sound.valueOf("ENTITY_GENERIC_EXPLODE"), 1.0f, 1.0f);
                }
                new BukkitRunnable(){

                    public void run() {
                        this.cancel();
                        World w = t.getWorld();
                        List<IBlock> blocks = TrollListeners.this.getHole(t.getLocation());
                        for (IBlock b : blocks) {
                            w.getBlockAt(b.getLoc().clone()).setType(Material.AIR);
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(TrollListeners.this.plugin, () -> {
                            for (IBlock b : blocks) {
                                w.getBlockAt(b.getLoc()).setTypeIdAndData(b.getType(), b.getData(), true);
                            }
                        }, 200L);
                    }
                }.runTaskTimer(this.plugin, 0L, 2L);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.FlyCarpet.name"))) {
                Main.target.get(t);
                if (t != null) {
                    FallingBlock b;
                    FallingBlock b8;
                    FallingBlock b7;
                    FallingBlock b6;
                    FallingBlock b5;
                    FallingBlock b3;
                    FallingBlock b2;
                    FallingBlock b4;
                    FallingBlock b1;
                    Location l = t.getLocation();
                    l.add(0.0, 5.0, 0.0);
                    t.teleport(l);
                    if (!Bukkit.getVersion().contains("1.13") && !Bukkit.getVersion().contains("1.13.1")) {
                        b = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, (byte)this.getRandom(0, 15));
                        b1 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b2 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b3 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b4 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b5 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b6 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b7 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b8 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b.setPassenger(t);
                        p.sendMessage(Main.prefix + this.m("Troll.FlyCarpet.messages.successful", t));
                        new BukkitRunnable(){

                            public void run() {
                                Location l = t.getLocation();
                                Vector pv = l.getDirection();
                                b1.teleport(b.getLocation().add(0.0, 0.0, -1.0));
                                b2.teleport(b.getLocation().add(0.0, 0.0, 1.0));
                                b3.teleport(b.getLocation().add(-1.0, 0.0, 0.0));
                                b4.teleport(b.getLocation().add(-1.0, 0.0, -1.0));
                                b5.teleport(b.getLocation().add(-1.0, 0.0, 1.0));
                                b6.teleport(b.getLocation().add(-2.0, 0.0, 0.0));
                                b7.teleport(b.getLocation().add(-2.0, 0.0, -1.0));
                                b8.teleport(b.getLocation().add(-2.0, 0.0, 1.0));
                                b1.setVelocity(pv);
                                b2.setVelocity(pv);
                                b3.setVelocity(pv);
                                b4.setVelocity(pv);
                                b5.setVelocity(pv);
                                b6.setVelocity(pv);
                                b7.setVelocity(pv);
                                b8.setVelocity(pv);
                                b.setVelocity(pv);
                                if (b.getPassenger() == null || p.isOnGround()) {
                                    b.remove();
                                    b1.remove();
                                    b2.remove();
                                    b4.remove();
                                    b3.remove();
                                    b5.remove();
                                    b6.remove();
                                    b7.remove();
                                    b8.remove();
                                }
                            }
                        }.runTaskTimer(this.plugin, 0L, 1L);
                    } else {
                        b = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, (byte)this.getRandom(0, 15));
                        b1 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b2 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b3 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b4 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b5 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b6 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b7 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b8 = t.getWorld().spawnFallingBlock(t.getLocation(), Material.CARPET, b.getBlockData());
                        b.setPassenger(t);
                        p.sendMessage(Main.prefix + this.m("Troll.FlyCarpet.messages.successful", t));
                        new BukkitRunnable(){

                            public void run() {
                                Location l = t.getLocation();
                                Vector pv = l.getDirection();
                                b1.teleport(b.getLocation().add(0.0, 0.0, -1.0));
                                b2.teleport(b.getLocation().add(0.0, 0.0, 1.0));
                                b3.teleport(b.getLocation().add(-1.0, 0.0, 0.0));
                                b4.teleport(b.getLocation().add(-1.0, 0.0, -1.0));
                                b5.teleport(b.getLocation().add(-1.0, 0.0, 1.0));
                                b6.teleport(b.getLocation().add(-2.0, 0.0, 0.0));
                                b7.teleport(b.getLocation().add(-2.0, 0.0, -1.0));
                                b8.teleport(b.getLocation().add(-2.0, 0.0, 1.0));
                                b1.setVelocity(pv);
                                b2.setVelocity(pv);
                                b3.setVelocity(pv);
                                b4.setVelocity(pv);
                                b5.setVelocity(pv);
                                b6.setVelocity(pv);
                                b7.setVelocity(pv);
                                b8.setVelocity(pv);
                                b.setVelocity(pv);
                                if (b.getPassenger() == null || p.isOnGround()) {
                                    b.remove();
                                    b1.remove();
                                    b2.remove();
                                    b4.remove();
                                    b3.remove();
                                    b5.remove();
                                    b6.remove();
                                    b7.remove();
                                    b8.remove();
                                }
                            }
                        }.runTaskTimer(this.plugin, 0L, 1L);
                    }
                }
                p.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Levitation.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                if (Bukkit.getServer().getVersion().contains("1.8")) {
                    p.sendMessage(this.lf.getString("GUI.BlockedVersion"));
                    p.closeInventory();
                } else {
                    t.addPotionEffect(new PotionEffect(PotionEffectType.getByName("LEVITATION"), 140, 2));
                    p.closeInventory();
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.AllLevitation.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (Bukkit.getServer().getVersion().contains("1.8")) {
                        p.sendMessage(this.lf.getString("GUI.BlockedVersion"));
                        p.closeInventory();
                        continue;
                    }
                    player.addPotionEffect(new PotionEffect(PotionEffectType.getByName("LEVITATION"), 140, 2));
                    p.closeInventory();
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.RandomMenu.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                if (this.plugin.randomMenu.contains(t)) {
                    this.plugin.randomMenu.remove(t);
                    p.sendMessage(Main.prefix + this.m("Troll.RandomMenu.messages.deactivated", t));
                } else {
                    this.plugin.randomMenu.add(t);
                    p.sendMessage(Main.prefix + this.m("Troll.RandomMenu.messages.activated", t));
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.FillInventory.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                if (this.plugin.fillinvAllowanceTime.containsKey(p) && this.plugin.fillinvAllowanceTime.get(p) > System.currentTimeMillis()) {
                    p.sendMessage(Main.prefix + this.m("Troll.FillInventory.messages.waiting", t));
                } else {
                    this.plugin.fillinvAllowanceTime.put(p, System.currentTimeMillis() + 15000L);
                    p.sendMessage(Main.prefix + this.m("Troll.FillInventory.messages.waiting", t));
                    this.plugin.fillinvWatchChat.add(p);
                    this.plugin.select.put(p, t);
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.LavaBlock.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                if (this.plugin.lavablock.contains(t.getName())) {
                    this.plugin.lavablock.remove(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.LavaBlock.messages.deactivated", t));
                } else {
                    this.plugin.lavablock.add(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.LavaBlock.messages.activated", t));
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.ExplodeBlock.name")) && Main.target.keySet().iterator().hasNext()) {
                Main.target.get(t);
                p.closeInventory();
                if (this.plugin.expBlock.contains(t.getName())) {
                    this.plugin.expBlock.remove(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.ExplodeBlock.messages.deactivated", t));
                } else {
                    this.plugin.expBlock.add(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.ExplodeBlock.messages.activated", t));
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Vehicles.name")) && Main.target.keySet().iterator().hasNext()) {
                VehiclesGUI vg = new VehiclesGUI();
                vg.openVehicles(p);
                p.sendMessage(Main.prefix + this.m("Troll.Vehicles.messages.successful", t));
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Troll.InfiniteInventory.name")) && Main.target.keySet().iterator().hasNext()){
                p.closeInventory();
                if (this.plugin.infiniteInventory.contains(t.getName())) {
                    this.plugin.infiniteInventory.remove(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.InfiniteInventory.messages.deactivated", t));
                    Bukkit.getScheduler().cancelTasks(this.plugin);
                } else {
                    this.plugin.infiniteInventory.add(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.InfiniteInventory.messages.activated", t));
                    this.infinityTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
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
                        t.openInventory(Bukkit.createInventory(t, desiredInv, org.bukkit.ChatColor.translateAlternateColorCodes('&', "&4&l&n<Error>")));
                    }, 0L, 5L);
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.LaunchInverted.name")) && Main.target.keySet().iterator().hasNext()) {
                p.closeInventory();
                if (t.isOnGround()) {
                    t.setGameMode(GameMode.SPECTATOR);
                }
                p.sendMessage(Main.prefix + this.m("Troll.LaunchInverted.messages.successful", t));
                Vector v = new Vector(0, -20, 0);
                for (int x = 0; x < 20; ++x) {
                    t.setVelocity(v);
                }
                this.infinityTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
                        t.setGameMode(GameMode.SURVIVAL);
                        Bukkit.getScheduler().cancelTasks(this.plugin);
                }, 5L, 0L);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.DontLeave.name")) && Main.target.keySet().iterator().hasNext()) {
                p.closeInventory();
                if (this.plugin.dontleave.contains(t.getName())) {
                    this.plugin.dontleave.remove(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.DontLeave.messages.deactivated", t));
                } else {
                    this.plugin.dontleave.add(t.getName());
                    p.sendMessage(Main.prefix + this.m("Troll.DontLeave.messages.activated", t));
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll.Next.name")) && Main.target.keySet().iterator().hasNext()){
                p.closeInventory();
                if (Main.getConfiguration().getString("language").equalsIgnoreCase("en")){
                    p.sendTitle(Main.prefix,"&8Coming soon... :D".replaceAll("&", "§"));
                } else {
                    p.sendTitle(Main.prefix,"&8Muy pronto... :D".replaceAll("&", "§"));
                }
                //tm.openTroll2(p);
            }
        }
    }

    private List<IBlock> getSphere(Location centerBlock, int radius) {
        ArrayList<IBlock> circleBlocks = new ArrayList<>();
        if (centerBlock == null) {
            return circleBlocks;
        }
        int bx = centerBlock.getBlockX();
        int by = centerBlock.getBlockY();
        int bz = centerBlock.getBlockZ();
        for (int x = bx - radius; x <= bx + radius; ++x) {
            for (int y = by - radius; y <= by + radius; ++y) {
                for (int z = bz - radius; z <= bz + radius; ++z) {
                    double distance = (bx - x) * (bx - x) + (bz - z) * (bz - z) + (by - y) * (by - y);
                    if (!(distance < (double) (radius * radius))) continue;
                    Location l = new Location(centerBlock.getWorld(), (double)x, (double)y, (double)z);
                    circleBlocks.add(new IBlock(l.getBlock()));
                }
            }
        }
        return circleBlocks;
    }

    private List<IBlock> getHole(Location centBlock) {
        ArrayList<IBlock> voidBlocks = new ArrayList<>();
        if (centBlock == null) {
            return voidBlocks;
        }
        int times = (int)centBlock.getY() + 1;
        Location blocksloc = centBlock.getBlock().getRelative(10, -this.i, 10).getLocation();
        this.plugin.nummer.put(this.i, blocksloc.getBlock().getTypeId());
        Location unten = centBlock.getBlock().getRelative(10, -this.i, 10).getLocation();
        this.plugin.bloque.put(this.i, unten);
        for (int i = 0; i < times; ++i) {
            if (this.i < times) {
                for (int x = 0; x < 10; ++x) {
                    for (int z = 0; z < 10; ++z) {
                        Location loca = centBlock.getBlock().getRelative(x, -i, z).getLocation();
                        voidBlocks.add(new IBlock(loca.getBlock()));
                        Location loca1 = centBlock.getBlock().getRelative(-x, -i, -z).getLocation();
                        voidBlocks.add(new IBlock(loca1.getBlock()));
                        Location loca2 = centBlock.getBlock().getRelative(-x, -i, z).getLocation();
                        voidBlocks.add(new IBlock(loca2.getBlock()));
                        Location loca3 = centBlock.getBlock().getRelative(x, -i, -z).getLocation();
                        voidBlocks.add(new IBlock(loca3.getBlock()));
                    }
                }
                continue;
            }
            if (this.i != times) continue;
            this.i = 0;
        }
        return voidBlocks;
    }

    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getType() == Material.STICK) {
            HashSet<Material> transparent = new HashSet<>();
            transparent.add(Material.AIR);
            transparent.add(Material.WATER);
            Block block = player.getTargetBlock(transparent, 120);
            if ((player.getItemInHand().getType() == Material.STICK) && (player.getItemInHand().getItemMeta().getLore() != null) && (player.getItemInHand().getDurability() == 0) && (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Troll.ExplosiveWand.name")))) {
                player.getWorld().strikeLightning(block.getLocation());
                player.getWorld().createExplosion(block.getLocation(), 3f);
            }
        }
        if ((player.getItemInHand().getType() == Material.SKULL_ITEM) && (player.getItemInHand().getItemMeta().getLore() != null) && (player.getItemInHand().getDurability() == 3) && (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Troll.Vehicles.TnTItem.name")))) {
            player.getWorld().spawnEntity(player.getLocation().add(0, -1, 0), EntityType.PRIMED_TNT);
            return;
        }
        return;
    }

    public String m(String msg, Player t) {
        return this.lf.getString(msg).replaceAll("%player%", t.getName());
    }

    private int getRandom(int lower, int upper) {
        return new Random().nextInt(upper - lower + 1) + lower;
    }

    private void CCreeper(Location loc) {
        Creeper creeper = loc.getWorld().spawn(loc, Creeper.class);
        creeper.setPowered(true);
    }

    @EventHandler
    public void onPlayerClickNull3(InventoryClickEvent event) {
        if (event.getInventory().getName().equals(this.lf.getLang().getString("GUI.Morphs.Title").replaceAll("&", "§"))) {
            Player p = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta()) {
                MiscDisguise miscDisguise;
                MobDisguise bat;
                Player t;
                MorphsGUI mg;
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs-item.name"))) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        mg = new MorphsGUI();
                        mg.openMorphsMobs(p);
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks-item.name"))) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        mg = new MorphsGUI();
                        mg.openMorphsBlocks(p);
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Players-item.name"))) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        mg = new MorphsGUI();
                        mg.openMorphsPlayers(p);
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.BackToBody.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    t.setWalkSpeed(0.2f);
                    t.removePotionEffect(PotionEffectType.JUMP);
                    DisguiseAPI.undisguiseToAll(t);
                    t.removeMetadata("iCU_P", this.plugin);
                    t.setGameMode(GameMode.SURVIVAL);
                    p.removeMetadata("iCU_H", this.plugin);
                    t.setAllowFlight(false);
                    Bukkit.getScheduler().cancelTasks(this.plugin);
                    this.plugin.morphsdamage.remove(t);
                    VANISHED.remove(t);
                    p.closeInventory();
                    Main.target.remove(t);
                    return;
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.BackToBodyAll.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.setWalkSpeed(0.2f);
                        all.removePotionEffect(PotionEffectType.JUMP);
                        DisguiseAPI.undisguiseToAll(all);
                        all.removeMetadata("iCU_P", this.plugin);
                        all.setGameMode(GameMode.SURVIVAL);
                        all.removeMetadata("iCU_H", this.plugin);
                        all.setAllowFlight(false);
                        Bukkit.getScheduler().cancelTasks(this.plugin);
                        this.plugin.morphsdamage.remove(all);
                        if (!VANISHED.contains(all)) continue;
                        VANISHED.remove(all);
                    }
                    p.closeInventory();
                    Main.target.remove(t);
                    return;
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Vanish.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        if (VANISHED.contains(t)) {
                            VANISHED.remove(t);
                            this.plugin.morphsdamage.remove(t);
                            p.closeInventory();
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.showPlayer(t);
                                p.sendMessage(Main.prefix + this.m("Morphs.Vanish.messages.deactivated", t));
                            }
                        } else {
                            if (!VANISHED.contains(t)) {
                                VANISHED.add(t);
                                this.plugin.morphsdamage.add(t);
                                p.closeInventory();
                                p.sendMessage(Main.prefix + this.m("Morphs.Vanish.messages.activated", t));
                            }
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.hidePlayer(t);
                            }
                        }
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Chicken.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.CHICKEN);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Chicken.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Cow.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.COW);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Cow.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Pig.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.PIG);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Pig.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Creeper.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.CREEPER);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Creeper.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Bat.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.BAT);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(true);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Bat.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Rabbit.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.RABBIT);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setWalkSpeed(0.4f);
                        t.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 123456, 3));
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Rabbit.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.TnT.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.PRIMED_TNT);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.TnT.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.TnTTroll.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.PRIMED_TNT);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        t.setAllowFlight(false);
                        if (!this.plugin.morphsdamage.contains(t)) {
                            this.plugin.morphsdamage.add(t);
                            final Player finalT = t;
                            this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
                                Location localLocation = new Location(finalT.getWorld(), finalT.getLocation().getX(), finalT.getLocation().getY() + 1.0, finalT.getLocation().getZ());
                                finalT.getWorld().createExplosion(localLocation, 3.0f);
                            }, 30L, 30L);
                        } else {
                            Bukkit.getServer().getScheduler().cancelTasks(this.plugin);
                            this.plugin.morphsdamage.remove(t);
                        }
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.TnTTroll.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Back.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        Main.target.get(t);
                        Main.target.put(p, t);
                        this.tm.openTroll(p);
                    }
                }
            } else {
                p.closeInventory();
            }
        }
        if (event.getInventory().getName().equals(this.lf.getLang().getString("GUI.Morphs.Players.Title").replaceAll("&", "§"))) {
            Player p = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta()) {
                Player t;
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Players.DisguiseInAnotherPlayer.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        if (this.plugin.toTrans.contains(p.getName())) {
                            p.sendMessage(Main.prefix + this.m("Morphs.Players.DisguiseInAnotherPlayer.messages.successful", t));
                        } else {
                            this.plugin.toTrans.add(p.getName());
                            p.sendMessage(Main.prefix + this.m("Morphs.Players.DisguiseInAnotherPlayer.messages.successful", t));
                        }
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Players.AllDisguiseInAnotherPlayer.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        if (this.plugin.toTrans1.contains(p.getName())) {
                            p.sendMessage(Main.prefix + this.m("Morphs.Players.AllDisguiseInAnotherPlayer.messages.successful", t));
                        } else {
                            this.plugin.toTrans1.add(p.getName());
                            p.sendMessage(Main.prefix + this.m("Morphs.Players.AllDisguiseInAnotherPlayer.messages.successful", t));
                        }
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Players.ClonePlayer.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    p.closeInventory();
                    p.sendMessage(Main.prefix + this.m("Morphs.Players.ClonePlayer.messages.successful", t));
                    for (int e = 0; e < 10; ++e) {
                        Zombie z = (Zombie)t.getLocation().getWorld().spawnEntity(t.getLocation(), EntityType.ZOMBIE);
                        z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 2));
                        ItemStack helmet = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                        SkullMeta m = (SkullMeta)helmet.getItemMeta();
                        m.setOwner(p.getName());
                        helmet.setItemMeta((ItemMeta)m);
                        z.getEquipment().setHelmet(helmet);
                        z.setCustomName(p.getName());
                        PlayerDisguise d = new PlayerDisguise(p);
                        DisguiseAPI.disguiseToAll((Entity)z, (Disguise)d);
                        z.setTarget(t);
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Players.Back.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        Main.target.get(t);
                        Main.target.put(p, t);
                        MorphsGUI mg = new MorphsGUI();
                        mg.openMorphs(p);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerClickNull4(InventoryClickEvent event) {
        if (event.getInventory().getName().equals(this.lf.getLang().getString("GUI.Morphs.Blocks.Title").replaceAll("&", "§"))) {
            Player p = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta()) {
                Player t;
                MiscDisguise miscDisguise;
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.CraftingTable.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 58).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.CraftingTable.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.EnchantingTable.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 116).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.EnchantingTable.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Fire.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 51).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.Fire.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Grass.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 2).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.Grass.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Leaves.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 18).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.Leaves.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Log.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 17).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.Log.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Quartz.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 155).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.Quartz.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Planks.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, 5).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.Planks.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Stone.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK).setViewSelfDisguise(true);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.Stone.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.TnT.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.PRIMED_TNT);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.TnT.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.TnTTroll.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        miscDisguise = new MiscDisguise(DisguiseType.PRIMED_TNT);
                        DisguiseAPI.disguiseToAll(t, miscDisguise);
                        DisguiseAPI.setViewDisguiseToggled(t, false);
                        t.setAllowFlight(false);
                        if (!this.plugin.morphsdamage.contains(t)) {
                            this.plugin.morphsdamage.add(t);
                            final Player finalT = t;
                            this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
                                Location localLocation = new Location(finalT.getWorld(), finalT.getLocation().getX(), finalT.getLocation().getY() + 1.0, finalT.getLocation().getZ());
                                finalT.getWorld().createExplosion(localLocation, 3.0f);
                            }, 30L, 30L);
                        } else {
                            Bukkit.getServer().getScheduler().cancelTasks(this.plugin);
                            this.plugin.morphsdamage.remove(t);
                        }
                        p.sendMessage(Main.prefix + this.m("Morphs.Blocks.TnTTroll.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Blocks.Back.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        MorphsGUI mg = new MorphsGUI();
                        mg.openMorphs(p);
                    }
                }
            } else {
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent paramInventoryClickEvent) {
        ItemStack localItemStack = paramInventoryClickEvent.getCurrentItem();
        if (localItemStack != null && localItemStack.getType() != Material.AIR && localItemStack.getItemMeta() != null) {
            Player p = (Player)paramInventoryClickEvent.getWhoClicked();
            Inventory inventory2 = paramInventoryClickEvent.getInventory();
            new SelectorGUI();
            if (inventory2.getName().equals(this.lf.getString("GUI.Selector.Title"))) {
                paramInventoryClickEvent.setCancelled(true);
                p.closeInventory();
            }
            if (inventory2.getName().equals(this.lf.getString("GUI.Selector.Title"))) {
                String t1 = ChatColor.stripColor(localItemStack.getItemMeta().getDisplayName());
                Player t = Bukkit.getPlayer(t1);
                if (t == null) {
                    p.closeInventory();
                    paramInventoryClickEvent.setCancelled(true);
                    p.sendMessage(Main.prefix + this.m("GUI.Selector.Error", t));
                    return;
                }
                p.closeInventory();
                if (p.hasPermission("atroll.open")) {
                    Main.target.put(p, t);
                    this.tm.openTroll(p);
                } else {
                    p.sendMessage(Main.prefix + this.lf.getString("PluginMessages.noCommandUse"));
                }
            }
        }
    }

    @EventHandler
    public void onPlayerClickNull2(InventoryClickEvent event) {
        if (event.getInventory().getName().equals(this.lf.getLang().getString("GUI.Morphs.Mobs.Title").replaceAll("&", "§"))) {
            Player p = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta()) {
                Player t;
                MobDisguise bat;
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Chicken.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.CHICKEN);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Chicken.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Cow.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.COW);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Cow.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Pig.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.PIG);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Pig.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Creeper.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.CREEPER);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(false);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Creeper.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Bat.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.BAT);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setAllowFlight(true);
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Bat.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Rabbit.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        bat = new MobDisguise(DisguiseType.RABBIT);
                        DisguiseAPI.disguiseToAll(t, bat);
                        this.plugin.morphsdamage.add(t);
                        t.setWalkSpeed(0.4f);
                        t.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 123456, 3));
                        p.sendMessage(Main.prefix + this.m("Morphs.Mobs.Rabbit.messages.successful", t));
                        p.closeInventory();
                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Morphs.Mobs.Back.name")) && Main.target.keySet().iterator().hasNext()) {
                    t = Main.target.get(p);
                    Main.target.get(t);
                    if (t != null) {
                        MorphsGUI mg = new MorphsGUI();
                        mg.openMorphs(p);
                    }
                }
            } else {
                p.closeInventory();
            }
        }
    }
}