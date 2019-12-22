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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class SkyColorsListeners
        implements Listener
{
    public Main plugin;
    private Files fl = new Files();

    @EventHandler
    public void SkyColors(InventoryClickEvent event)
    {
        if (!event.getInventory().getName().equals(this.fl.getString("GUI.SkyColors.Title"))) {
            return;
        }
        Player p = (Player)event.getWhoClicked();
        event.setCancelled(true);
        if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType() == Material.AIR) || (!event.getCurrentItem().hasItemMeta()))
        {
            p.closeInventory();
            return;
        }
        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.fl.getString("SkyColors.Normal.name")))
        {
            Set names = Main.target.keySet();
            Iterator localIterator = names.iterator();
            if (localIterator.hasNext())
            {
                Player t = Main.target.get(p);
                Main.target.get(t);
                if (t != null)
                {
                    String path = Bukkit.getServer().getClass().getPackage().getName();
                    String version = path.substring(path.lastIndexOf(".") + 1);
                    try
                    {
                        t.resetPlayerTime();
                        Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                        Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                        Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                        Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(Integer.TYPE, Float.TYPE);

                        Object packet = playOutConstructor.newInstance(7, 0);
                        Object craftPlayerObject = craftPlayer.cast(t);
                        Method getHandleMethod = craftPlayer.getMethod("getHandle");
                        Object handle = getHandleMethod.invoke(craftPlayerObject);
                        Object pc = handle.getClass().getField("playerConnection").get(handle);
                        Method sendPacketMethod = pc.getClass().getMethod("sendPacket", Packet);
                        sendPacketMethod.invoke(pc, packet);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                    p.sendMessage(Main.prefix + m("SkyColors.Normal.messages.successful", t));
                    p.closeInventory();
                }
            }
        }
        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.fl.getString("SkyColors.Night.name")))
        {
            Set names = Main.target.keySet();
            Iterator localIterator = names.iterator();
            if (localIterator.hasNext())
            {
                Player t = Main.target.get(p);
                Main.target.get(t);
                if (t != null)
                {
                    String path = Bukkit.getServer().getClass().getPackage().getName();
                    String version = path.substring(path.lastIndexOf(".") + 1);
                    try
                    {
                        t.setPlayerTime(13000L, true);
                        Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                        Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                        Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                        Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(Integer.TYPE, Float.TYPE);

                        Object packet = playOutConstructor.newInstance(7, 1);
                        Object craftPlayerObject = craftPlayer.cast(t);
                        Method getHandleMethod = craftPlayer.getMethod("getHandle");
                        Object handle = getHandleMethod.invoke(craftPlayerObject);
                        Object pc = handle.getClass().getField("playerConnection").get(handle);
                        Method sendPacketMethod = pc.getClass().getMethod("sendPacket", Packet);
                        sendPacketMethod.invoke(pc, packet);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                    p.sendMessage(Main.prefix + m("SkyColors.Night.messages.successful", t));
                    p.closeInventory();
                }
            }
        }
        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.fl.getString("SkyColors.BrightStars.name")))
        {
            Set names = Main.target.keySet();
            Iterator localIterator = names.iterator();
            if (localIterator.hasNext())
            {
                Player t = Main.target.get(p);
                Main.target.get(t);
                if (t != null)
                {
                    String path = Bukkit.getServer().getClass().getPackage().getName();
                    String version = path.substring(path.lastIndexOf(".") + 1);
                    try
                    {
                        t.setPlayerTime(13000L, true);
                        Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                        Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                        Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                        Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(Integer.TYPE, Float.TYPE);

                        Object packet = playOutConstructor.newInstance(7, -1);
                        Object craftPlayerObject = craftPlayer.cast(t);
                        Method getHandleMethod = craftPlayer.getMethod("getHandle");
                        Object handle = getHandleMethod.invoke(craftPlayerObject);
                        Object pc = handle.getClass().getField("playerConnection").get(handle);
                        Method sendPacketMethod = pc.getClass().getMethod("sendPacket", Packet);
                        sendPacketMethod.invoke(pc, packet);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                    p.sendMessage(Main.prefix + m("SkyColors.BrightStars.messages.successful", t));
                    p.closeInventory();
                }
            }
        }
        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.fl.getString("SkyColors.Yellow.name")))
        {
            Set names = Main.target.keySet();
            Iterator localIterator = names.iterator();
            if (localIterator.hasNext())
            {
                Player t = Main.target.get(p);
                Main.target.get(t);
                if (t != null)
                {
                    String path = Bukkit.getServer().getClass().getPackage().getName();
                    String version = path.substring(path.lastIndexOf(".") + 1);
                    try
                    {
                        t.setPlayerTime(1000L, true);
                        Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                        Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                        Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                        Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(Integer.TYPE, Float.TYPE);

                        Object packet = playOutConstructor.newInstance(7, 8);
                        Object craftPlayerObject = craftPlayer.cast(t);
                        Method getHandleMethod = craftPlayer.getMethod("getHandle");
                        Object handle = getHandleMethod.invoke(craftPlayerObject);
                        Object pc = handle.getClass().getField("playerConnection").get(handle);
                        Method sendPacketMethod = pc.getClass().getMethod("sendPacket", Packet);
                        sendPacketMethod.invoke(pc, packet);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                    p.sendMessage(Main.prefix + m("SkyColors.Yellow.messages.successful", t));
                    p.closeInventory();
                }
            }
        }
        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.fl.getString("SkyColors.Lag.name")))
        {
            Set names = Main.target.keySet();
            Iterator localIterator = names.iterator();
            if (localIterator.hasNext())
            {
                Player t = Main.target.get(p);
                Main.target.get(t);
                if (t != null)
                {
                    String path = Bukkit.getServer().getClass().getPackage().getName();
                    String version = path.substring(path.lastIndexOf(".") + 1);
                    try
                    {
                        t.setPlayerTime(13000L, true);
                        Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                        Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                        Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                        Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(Integer.TYPE, Float.TYPE);

                        Object packet = playOutConstructor.newInstance(7, 20);
                        Object craftPlayerObject = craftPlayer.cast(t);
                        Method getHandleMethod = craftPlayer.getMethod("getHandle");
                        Object handle = getHandleMethod.invoke(craftPlayerObject);
                        Object pc = handle.getClass().getField("playerConnection").get(handle);
                        Method sendPacketMethod = pc.getClass().getMethod("sendPacket", Packet);
                        sendPacketMethod.invoke(pc, packet);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                    p.sendMessage(Main.prefix + m("SkyColors.Lag.messages.successful", t));
                    p.closeInventory();
                }
            }
        }
        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.fl.getString("SkyColors.Back.name")))
        {
            Set names = Main.target.keySet();
            Iterator localIterator = names.iterator();
            if (localIterator.hasNext())
            {
                Player t = Main.target.get(p);
                Main.target.get(t);
                if (t != null)
                {
                    Main.target.get(t);
                    Main.target.put(p, t);
                    TrollGUI tm = new TrollGUI(this.plugin);
                    tm.openTroll(p);
                }
            }
        }
    }

    public String m(String msg, Player t)
    {
        return this.fl.getString(msg).replaceAll("%player%", t.getName());
    }
}
