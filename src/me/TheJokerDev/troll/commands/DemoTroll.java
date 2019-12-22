package me.TheJokerDev.troll.commands;

import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.messages.Files;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoTroll
        implements CommandExecutor
{
    public Main plugin;
    private Files fl = new Files();

    public DemoTroll(Main plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (!sender.hasPermission("atroll.demotroll"))
        {
            sender.sendMessage(Main.prefix + this.fl.getString("PluginMessages.noPermission"));
            return true;
        }
        if (args.length > 0)
        {
            OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
            if (p.isOnline())
            {
                Player enviar = Bukkit.getPlayer(args[0]);
                String path = Bukkit.getServer().getClass().getPackage().getName();
                String version = path.substring(path.lastIndexOf(".") + 1);
                try
                {
                    Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                    Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                    Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                    Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(Integer.TYPE, Float.TYPE);
                    Object packet = playOutConstructor.newInstance(5, 0);
                    Object craftPlayerObject = craftPlayer.cast(enviar);
                    Method getHandleMethod = craftPlayer.getMethod("getHandle");
                    Object handle = getHandleMethod.invoke(craftPlayerObject);
                    Object pc = handle.getClass().getField("playerConnection").get(handle);
                    Method sendPacketMethod = pc.getClass().getMethod("sendPacket", Packet);
                    sendPacketMethod.invoke(pc, packet);
                }
                catch (ClassNotFoundException|IllegalAccessException|IllegalArgumentException|InstantiationException|NoSuchFieldException|NoSuchMethodException|SecurityException|InvocationTargetException ex)
                {
                    ex.printStackTrace();
                }
                sender.sendMessage(Main.prefix + this.fl.getString("Troll.Demo.messages.successful").replaceAll("%player%", enviar.getName()));
            }
            return true;
        }
        sender.sendMessage(Main.prefix + this.fl.getString("PluginMessages.noCommandUse"));
        return true;
    }
}
