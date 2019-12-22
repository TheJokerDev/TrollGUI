package me.TheJokerDev.troll.inventory;

import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.messages.Files;
import me.TheJokerDev.troll.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.Set;

public class SkyColorsGUI
{
    private Files lg = new Files();
    public Main plugin;

    public void openSkyColors(Player p)
    {
        Set<Player> names = Main.target.keySet();
        Iterator<Player> localIterator = names.iterator();
        if (localIterator.hasNext())
        {
            Player t = Main.target.get(p);
            Main.target.get(t);
            if (t != null)
            {
                Inventory sc = Bukkit.getServer().createInventory(null, 18, this.lg.getString("GUI.SkyColors.Title"));

                sc.setItem(i("Back"), is());
                sc.setItem(i("Normal"), item("Normal"));
                sc.setItem(i("Night"), item("Night"));
                sc.setItem(i("BrightStars"), item("BrightStars"));
                sc.setItem(i("Yellow"), item("Yellow"));
                sc.setItem(i("Lag"), item("Lag"));

                p.openInventory(sc);
            }
        }
    }

    private Integer i(String m)
    {
        return Main.getConfiguration().getInt("Possitions.SkyColors." + m);
    }

    public ItemStack item(String m)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("SkyColors." + m + ".material"))), this.lg.getItems().getInt("SkyColors." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("SkyColors." + m + ".data")).setName(this.lg.getString("SkyColors." + m + ".name")).setLore(this.lg.getStringList("SkyColors." + m + ".lore")).toItemStack();
    }

    private ItemStack is()
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("SkyColors." + "Back" + ".material")))).setDurability((short) this.lg.getItems().getInt("SkyColors." + "Back" + ".data")).setName(this.lg.getString("SkyColors." + "Back" + ".name")).setLore(this.lg.getStringList("SkyColors." + "Back" + ".lore")).setSkullOwner(this.lg.getItems().getString("SkyColors." + "Back" + ".skull-owner")).toItemStack();
    }
}
