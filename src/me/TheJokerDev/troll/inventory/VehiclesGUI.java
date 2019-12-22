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

public class VehiclesGUI
{
    private Files lg = new Files();

    public void openVehicles(Player p)
    {
        Set<Player> names = Main.target.keySet();
        Iterator<Player> localIterator = names.iterator();
        if (localIterator.hasNext())
        {
            Player t = Main.target.get(p);
            Main.target.get(t);
            if (t != null)
            {
                Inventory vehiclemenu = Bukkit.getServer().createInventory(null, 36, this.lg.getString("GUI.Vehicles.Title"));

                vehiclemenu.setItem(i("Back"), is(t));
                vehiclemenu.setItem(i("Helicopter"), item("Helicopter"));
                vehiclemenu.setItem(i("Plane"), item("Plane"));
                vehiclemenu.setItem(i("Tank"), item("Tank"));
                vehiclemenu.setItem(i("Raft"), item("Raft"));
                vehiclemenu.setItem(i("Bike"), item("Bike"));

                p.openInventory(vehiclemenu);
            }
        }
    }

    private Integer i(String m)
    {
        return Main.getConfiguration().getInt("Possitions.Vehicles." + m);
    }

    public ItemStack item(String m)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Vehicles." + m + ".material"))), this.lg.getItems().getInt("Vehicles." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("Vehicles." + m + ".data")).setName(this.lg.getString("Vehicles." + m + ".name")).setLore(this.lg.getStringList("Vehicles." + m + ".lore")).toItemStack();
    }

    private ItemStack is(Player p)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Vehicles." + "Back" + ".material"))), this.lg.getItems().getInt("Vehicles." + "Back" + ".amount")).setDurability((short) this.lg.getItems().getInt("Vehicles." + "Back" + ".data")).setName(this.lg.getString("Vehicles." + "Back" + ".name")).setLore(this.lg.getStringList("Vehicles." + "Back" + ".lore")).setSkullOwner(this.lg.getItems().getString("Vehicles." + "Back" + ".skull-owner").replaceAll("%player%", p.getName())).toItemStack();
    }
}
