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

public class MorphsGUI
{
    private Files lg = new Files();

    public void openMorphs(Player p)
    {
        Set<Player> names = Main.target.keySet();
        Iterator<Player> localIterator = names.iterator();
        if (localIterator.hasNext())
        {
            Player t = Main.target.get(p);
            Main.target.get(t);
            if (t != null)
            {
                Inventory morph = Bukkit.getServer().createInventory(null, 36, this.lg.getString("GUI.Morphs.Title"));

                morph.setItem(i("Back"), is("Back", t));
                morph.setItem(i("Vanish"), is("Vanish", t));
                morph.setItem(i("Mobs-item"), is("Mobs-item", t));
                morph.setItem(i("Blocks-item"), item("Blocks-item"));
                morph.setItem(i("Players-item"), is("Players-item", t));
                morph.setItem(i("BackToBody"), is("BackToBody", t));
                morph.setItem(i("BackToBodyAll"), is("BackToBodyAll", t));

                p.openInventory(morph);
            }
        }
    }

    public void openMorphsMobs(Player p)
    {
        Set<Player> names = Main.target.keySet();
        Iterator<Player> localIterator = names.iterator();
        if (localIterator.hasNext())
        {
            Player t = Main.target.get(p);
            Main.target.get(t);
            if (t != null)
            {
                Inventory morph = Bukkit.getServer().createInventory(null, 27, this.lg.getString("GUI.Morphs.Mobs.Title"));

                morph.setItem(i("Mobs.Back"), is("Mobs.Back", t));
                morph.setItem(i("Mobs.Chicken"), is("Mobs.Chicken", t));
                morph.setItem(i("Mobs.Cow"), is("Mobs.Cow", t));
                morph.setItem(i("Mobs.Pig"), is("Mobs.Pig", t));
                morph.setItem(i("Mobs.Creeper"), item("Mobs.Creeper"));
                morph.setItem(i("Mobs.Bat"), is("Mobs.Bat", t));
                morph.setItem(i("Mobs.Rabbit"), is("Mobs.Rabbit", t));

                p.openInventory(morph);
            }
        }
    }

    public void openMorphsBlocks(Player p)
    {
        Set<Player> names = Main.target.keySet();
        Iterator<Player> localIterator = names.iterator();
        if (localIterator.hasNext())
        {
            Player t = Main.target.get(p);
            Main.target.get(t);
            if (t != null)
            {
                Inventory morph = Bukkit.getServer().createInventory(null, 27, this.lg.getString("GUI.Morphs.Blocks.Title"));

                morph.setItem(i("Blocks.Back"), is("Blocks.Back", t));
                morph.setItem(i("Blocks.CraftingTable"), item("Blocks.CraftingTable"));
                morph.setItem(i("Blocks.EnchantingTable"), item("Blocks.EnchantingTable"));
                morph.setItem(i("Blocks.Fire"), item("Blocks.Fire"));
                morph.setItem(i("Blocks.Grass"), item("Blocks.Grass"));
                morph.setItem(i("Blocks.Leaves"), item("Blocks.Leaves"));
                morph.setItem(i("Blocks.Log"), item("Blocks.Log"));
                morph.setItem(i("Blocks.Quartz"), item("Blocks.Quartz"));
                morph.setItem(i("Blocks.Planks"), item("Blocks.Planks"));
                morph.setItem(i("Blocks.Stone"), item("Blocks.Stone"));
                morph.setItem(i("Blocks.TnT"), is("Blocks.TnT", t));
                morph.setItem(i("Blocks.TnTTroll"), is("Blocks.TnTTroll", t));

                p.openInventory(morph);
            }
        }
    }
    public void openMorphsPlayers(Player p) {
        Set<Player> names = Main.target.keySet();
        Iterator<Player> localIterator = names.iterator();
        if (localIterator.hasNext()) {
            Player t = Main.target.get(p);
            Main.target.get(t);
            if (t != null) {
                Inventory morph = Bukkit.getServer().createInventory(null, 27, this.lg.getString("GUI.Morphs.Players.Title"));
                morph.setItem(this.i("Players.Back"), this.is("Players.Back", t));
                morph.setItem(this.i("Players.DisguiseInAnotherPlayer"), this.item("Players.DisguiseInAnotherPlayer"));
                morph.setItem(this.i("Players.ClonePlayer"), this.is("Players.ClonePlayer", t));
                morph.setItem(this.i("Players.AllDisguiseInAnotherPlayer"), this.item("Players.AllDisguiseInAnotherPlayer"));
                p.openInventory(morph);
            }
        }
    }

    private Integer i(String m)
    {
        return Main.getConfiguration().getInt("Possitions.Morphs." + m);
    }

    public ItemStack item(String m)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Morphs." + m + ".material"))), this.lg.getItems().getInt("Morphs." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("Morphs." + m + ".data")).setName(this.lg.getString("Morphs." + m + ".name")).setLore(this.lg.getStringList("Morphs." + m + ".lore")).toItemStack();
    }

    private ItemStack is(String m, Player p)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Morphs." + m + ".material"))), this.lg.getItems().getInt("Morphs." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("Morphs." + m + ".data")).setName(this.lg.getString("Morphs." + m + ".name")).setLore(this.lg.getStringList("Morphs." + m + ".lore")).setSkullOwner(this.lg.getItems().getString("Morphs." + m + ".skull-owner").replaceAll("%player%", p.getName())).toItemStack();
    }
}