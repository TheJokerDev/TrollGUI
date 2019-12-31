package me.TheJokerDev.troll.listeners;

import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.inventory.TrollGUI;
import me.TheJokerDev.troll.messages.Files;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TrollListeners2
        implements Listener {
    public Main plugin;
    private TrollGUI tm;
    private Files lf;

    public TrollListeners2(Main plugin) {
        this.tm = new TrollGUI(null);
        this.lf = new Files();
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerClickNull(InventoryClickEvent e) {
        final Player t = Main.target.get(e.getWhoClicked());
        if (t != null) {
            if (!e.getInventory().getName().equals(this.m("GUI.Troll.Title", t).replaceAll("%page%", "2"))) {
                return;
            }
            final Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Troll2.Back.name")) && Main.target.keySet().iterator().hasNext()){
                p.closeInventory();
                tm.openTroll(p);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c("&aSpanish")) && Main.target.keySet().iterator().hasNext()){
                p.closeInventory();
                Main.getConfiguration().addDefault("language", "es");
                Main.getInstance().reloadConfig();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> tm.openTroll2(p), 3L);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c("&aEnglish")) && Main.target.keySet().iterator().hasNext()){
                p.closeInventory();
                Main.getConfiguration().addDefault("language", "en");
                Main.getInstance().reloadConfig();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> tm.openTroll2(p), 3L);
            }
        }
    }

    private String c(String msg)
    {
        return msg.replaceAll("&", "§");
    }

    public String m(String msg, Player t) {
        return this.lf.getString(msg).replaceAll("%player%", t.getName());
    }
}