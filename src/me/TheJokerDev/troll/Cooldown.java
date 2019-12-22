package me.TheJokerDev.troll;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Cooldown
        extends BukkitRunnable
{
    private Main plugin;
    private Player c;

    Cooldown(Main pl, Player cont)
    {
        this.plugin = pl;
        this.c = cont;
    }

    public void run()
    {
        this.plugin.cd.remove(this.c.getName());
        cancel();
    }
}
