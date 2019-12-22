package me.TheJokerDev.troll;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckVictim
        extends BukkitRunnable
{
    private Player v;
    private Player c;

    CheckVictim(Player victim, Player controller)
    {
        this.v = victim;
        this.c = controller;
    }

    public void run()
    {
        if ((this.v != null) && (this.c != null))
        {
            if (this.v.hasMetadata("iCU_P"))
            {
                if (this.c.hasMetadata("iCU_H"))
                {
                    if (this.v.getWorld().getName().equalsIgnoreCase(this.c.getWorld().getName()))
                    {
                        if (this.v.getLocation().distance(this.c.getLocation()) > 15.0D) {
                            this.v.teleport(this.c);
                        }
                    }
                    else
                    {
                        this.v.teleport(this.c);
                        this.v.setGameMode(GameMode.SPECTATOR);
                    }
                }
                else {
                    cancel();
                }
            }
            else {
                cancel();
            }
        }
        else {
            cancel();
        }
    }
}
