package me.TheJokerDev.troll.effects;

import me.TheJokerDev.troll.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.ArrayList;

public class EffectTNT
        implements Listener
{
    public Main plugin;
    private ArrayList<java.util.UUID> ExplodedFallingSands = new ArrayList<>();
    private static File effect = new File("plugins/TrollGUI/effects/effects.yml");
    private YamlConfiguration effects = YamlConfiguration.loadConfiguration(effect);

    @EventHandler
    public void onBlockChange(EntityChangeBlockEvent event)
    {
        if (Main.effecttnt) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent event)
    {
        if (!this.effects.getBoolean(event.getLocation().getWorld().getName() + ".Enabled")) {
            return;
        }
        for (Block b : event.blockList())
        {
            Location loc = b.getLocation();
            Material mat = b.getType();

            float x = -1.0F + (float)(Math.random() * 2.0D);
            float y = -1.0F + (float)(Math.random() * 2.0D);
            float z = -1.0F + (float)(Math.random() * 2.0D);
            if (mat != Material.TNT)
            {
                FallingBlock fallingBlock = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
                fallingBlock.setDropItem(false);
                fallingBlock.setVelocity(new Vector(x, y, z));
                this.ExplodedFallingSands.add(fallingBlock.getUniqueId());
            }
            else
            {
                TNTPrimed tnt = b.getWorld().spawn(loc, TNTPrimed.class);
                tnt.setFuseTicks(20);
                tnt.setVelocity(new Vector(x, y, z));
            }
        }
    }

    @EventHandler
    public void onEntityChangeBlockEvent(EntityChangeBlockEvent event)
    {
        if (event.getEntityType() != EntityType.FALLING_BLOCK) {
            return;
        }
        if (!this.ExplodedFallingSands.contains(event.getEntity().getUniqueId())) {
            return;
        }
        if ((this.effects.getBoolean(event.getBlock().getWorld().getName() + ".Enabled")) && (this.effects.getBoolean(event.getBlock().getWorld().getName() + ".DisableDisappearBlocks"))) {
            return;
        }
        event.setCancelled(true);
    }
}
