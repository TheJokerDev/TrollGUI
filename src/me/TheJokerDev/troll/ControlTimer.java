package me.TheJokerDev.troll;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ControlTimer
        extends BukkitRunnable
{
    private Player c;
    private Player v;
    private Main plugin;

    ControlTimer(Player controller, Player victim, Main pl)
    {
        this.c = controller;
        this.v = victim;
        this.plugin = pl;
    }

    public void run()
    {
        if ((this.c != null) && (this.v != null)) {
            this.plugin.stopControlling(this.v, this.c);
        }
        cancel();
    }
}
