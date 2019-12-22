package me.TheJokerDev.troll;

import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.metadata.FixedMetadataValue;

public class iListener
        implements Listener
{
    private Main plugin;

    iListener(Main c)
    {
        this.plugin = c;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        if (p.hasMetadata("iCU_P")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent e)
    {
        Player p = e.getPlayer();
        if (p.hasMetadata("iCU_P")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e)
    {
        Player p = e.getPlayer();
        if (p.hasMetadata("iCU_P"))
        {
            if (p.hasMetadata("iCU_Chat")) {
                p.removeMetadata("iCU_Chat", this.plugin);
            } else {
                e.setCancelled(true);
            }
        }
        else if (p.hasMetadata("iCU_H"))
        {
            e.setCancelled(true);
            Player v = Bukkit.getPlayer(p.getMetadata("iCU_H").get(0).asString());
            v.setMetadata("iCU_Chat", new FixedMetadataValue(this.plugin, Boolean.TRUE));
            v.chat(e.getMessage());
        }
    }

    @EventHandler
    public void onPlayerGetKicked(PlayerKickEvent e)
    {
        Player p = e.getPlayer();
        if (p.hasMetadata("iCU_P"))
        {
            Player c = Bukkit.getPlayer(p.getMetadata("iCU_P").get(0).asString());

            p.removeMetadata("iCU_P", this.plugin);
            c.removeMetadata("iCU_H", this.plugin);

            p.getInventory().setContents(c.getInventory().getContents());
            p.getInventory().setArmorContents(c.getInventory().getArmorContents());

            c.getInventory().setContents(this.plugin.inventory.get(c.getName()));
            c.getInventory().setArmorContents(this.plugin.armor.get(c.getName()));
            this.plugin.inventory.remove(c.getName());
            this.plugin.armor.remove(c.getName());

            DisguiseAPI.undisguiseToAll(c);
            p.setGameMode(GameMode.SURVIVAL);
        }
        else if (p.hasMetadata("iCU_H"))
        {
            Player v = Bukkit.getPlayer(p.getMetadata("iCU_H").get(0).asString());

            v.removeMetadata("iCU_P", this.plugin);
            p.removeMetadata("iCU_H", this.plugin);

            v.getInventory().setContents(p.getInventory().getContents());
            v.getInventory().setArmorContents(p.getInventory().getArmorContents());

            p.getInventory().setContents(this.plugin.inventory.get(p.getName()));
            p.getInventory().setArmorContents(this.plugin.armor.get(p.getName()));
            this.plugin.inventory.remove(p.getName());
            this.plugin.armor.remove(p.getName());

            DisguiseAPI.undisguiseToAll(p);
            v.setGameMode(GameMode.SURVIVAL);
        }
    }

    @EventHandler
    public void onPlayerLogout(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        if (p.hasMetadata("iCU_P"))
        {
            Player c = Bukkit.getPlayer(p.getMetadata("iCU_P").get(0).asString());

            p.removeMetadata("iCU_P", this.plugin);
            c.removeMetadata("iCU_H", this.plugin);

            p.getInventory().setContents(c.getInventory().getContents());
            p.getInventory().setArmorContents(c.getInventory().getArmorContents());

            c.getInventory().setContents(this.plugin.inventory.get(c.getName()));
            c.getInventory().setArmorContents(this.plugin.armor.get(c.getName()));
            this.plugin.inventory.remove(c.getName());
            this.plugin.armor.remove(c.getName());

            DisguiseAPI.undisguiseToAll(c);
            p.setGameMode(GameMode.SURVIVAL);
        }
        else if (p.hasMetadata("iCU_H"))
        {
            Player v = Bukkit.getPlayer(p.getMetadata("iCU_H").get(0).asString());

            v.removeMetadata("iCU_P", this.plugin);
            p.removeMetadata("iCU_H", this.plugin);

            v.getInventory().setContents(p.getInventory().getContents());
            v.getInventory().setArmorContents(p.getInventory().getArmorContents());

            p.getInventory().setContents(this.plugin.inventory.get(p.getName()));
            p.getInventory().setArmorContents(this.plugin.armor.get(p.getName()));
            this.plugin.inventory.remove(p.getName());
            this.plugin.armor.remove(p.getName());

            DisguiseAPI.undisguiseToAll(p);
            v.setGameMode(GameMode.SURVIVAL);
        }
    }
}
