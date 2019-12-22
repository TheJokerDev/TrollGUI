package me.TheJokerDev.troll.commands;

import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.messages.Files;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceChat
        implements CommandExecutor
{
    public Main plugin;
    private Files lg = new Files();

    public ForceChat(Main plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player p = (Player)sender;
        if (sender.hasPermission("troll.forcechat"))
        {
            if (args.length == 0)
            {
                sender.sendMessage(Main.prefix + this.lg.getPluginMSG("PluginMessages.playerNeeded"));
                return true;
            }
            if (args.length == 1)
            {
                sender.sendMessage(Main.prefix + this.lg.getPluginMSG("PluginMessages.forcechatMessage2").replaceAll("%player%", args[0]));
                p.sendTitle(c("&a&lVariables"), c("&b- &7'&acmd:&7' to '&c/&7'"));
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null)
            {
                sender.sendMessage(Main.prefix + this.lg.getPluginMSG("PluginMessages.noPlayerOnline").replaceAll("%player%", args[0]));
                return true;
            }
            StringBuilder msg = new StringBuilder(args[1]);
            for (int arg = 2; arg < args.length; arg++) {
                msg.append(" ").append(args[arg]);
            }
            String m = msg.toString().replaceAll("cmd:", "/");
            target.chat(m);
            return true;
        }
        sender.sendMessage(Main.prefix + this.lg.getString("PluginMessages.noCommandUse"));
        return true;
    }

    private String c(String msg)
    {
        return msg.replaceAll("&", "§");
    }
}
