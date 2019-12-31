package me.TheJokerDev.troll.inventory;

import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.messages.Files;
import me.TheJokerDev.troll.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TrollGUI
{
    private Files lg = new Files();
    public Main plugin;

    public TrollGUI(Main plugin)
    {
        this.plugin = plugin;
    }

    public void openTroll(Player p)
    {
        Player t = Main.target.get(p);
        Main.target.get(t);
        if (t != null)
        {
            Inventory troll = Bukkit.getServer().createInventory(null, 54, c(lg.getString("GUI.Troll.Title").replaceAll("%page%", "1")));

            troll.setItem(i("<-"), is("<-"));
            troll.setItem(i("BedrockCage"), item("BedrockCage"));
            troll.setItem(i("Burn"), item("Burn"));
            troll.setItem(i("Creeper"), item("Creeper"));
            troll.setItem(i("ControlPlayer"), is("ControlPlayer"));
            troll.setItem(i("Demo"), item("Demo"));
            troll.setItem(i("DropInventory"), item("DropInventory"));
            troll.setItem(i("ExtremeTroll"), item("ExtremeTroll"));
            troll.setItem(i("ExplosiveWand"), item("ExplosiveWand"));
            troll.setItem(i("Facepalm"), item("Facepalm"));
            troll.setItem(i("FakeBan"), item("FakeBan"));
            troll.setItem(i("FakeOP"), item("FakeOP"));
            troll.setItem(i("FillInventory"), item("FillInventory"));
            troll.setItem(i("FlyCarpet"), item("FlyCarpet"));
            troll.setItem(i("Freeze"), item("Freeze"));
            troll.setItem(i("FreezeAll"), item("FreezeAll"));
            troll.setItem(i("HidePlayers"), item("HidePlayers"));
            troll.setItem(i("InfiniteInventory"), item("InfiniteInventory"));
            troll.setItem(i("Lag"), item("Lag"));
            troll.setItem(i("Launch"), item("Launch"));
            troll.setItem(i("LaunchInverted"), item("LaunchInverted"));
            troll.setItem(i("Lava"), item("Lava"));
            troll.setItem(i("LavaBlock"), item("LavaBlock"));
            troll.setItem(i("ExplodeBlock"), item("ExplodeBlock"));
            troll.setItem(i("Levitation"), item("Levitation"));
            troll.setItem(i("AllLevitation"), item("AllLevitation"));
            troll.setItem(i("Matrix"), item("Matrix"));
            troll.setItem(i("Morphs"), new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Troll.Morphs.material")))).setDurability((short)this.lg.getItems().getInt("Troll.Morphs.data")).setName(this.lg.getString("Troll.Morphs.name")).setLore(this.lg.getStringList("Troll.Morphs.lore")).setSkullOwner(this.lg.getItems().getString("Troll.Morphs.skull-owner").replaceAll("%player%", t.getName())).toItemStack());
            troll.setItem(i("PublicInventory"), item("PublicInventory"));
            troll.setItem(i("RandomChat"), item("RandomChat"));
            troll.setItem(i("RandomMenu"), item("RandomMenu"));
            troll.setItem(i("Arrow"), item("Arrow"));
            troll.setItem(i("SkyColors"), item("SkyColors"));
            troll.setItem(i("Smite"), item("Smite"));
            troll.setItem(i("Spam"), item("Spam"));
            troll.setItem(i("TnT"), item("TnT"));
            troll.setItem(i("TnTNuke"), item("TnTNuke"));
            troll.setItem(i("ExtremeTnT"), item("ExtremeTnT"));
            troll.setItem(i("EnderChest"), item("EnderChest"));
            troll.setItem(i("Inventory"), item("Inventory"));
            if (!Bukkit.getVersion().equals("1.8")) {
                troll.setItem(i("Vehicles"), item("Vehicles"));
            }
            troll.setItem(i("Void"), item("Void"));
            troll.setItem(i("Zeus"), item("Zeus"));
            troll.setItem(i("DontLeave"), item("DontLeave"));
            troll.setItem(i("Next"), is("Next"));

            p.openInventory(troll);
        }
    }

    public void openTroll2(Player p){
        Player t = Main.target.get(p);
        Main.target.get(t);
        if (t != null) {
            Inventory troll = Bukkit.getServer().createInventory(null, 27, c(lg.getString("GUI.Troll.Title").replaceAll("%page%", "2")));

            troll.setItem(i2("Back"), is2("Back"));

            p.openInventory(troll);
        }
    }

    private Integer i(String m)
{
    return Main.getConfiguration().getInt("Possitions.Troll." + m);
}

    public ItemStack item(String m)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Troll." + m + ".material"))), this.lg.getItems().getInt("Troll." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("Troll." + m + ".data")).setName(this.lg.getString("Troll." + m + ".name")).setLore(this.lg.getStringList("Troll." + m + ".lore")).toItemStack();
    }

    private ItemStack is(String m)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Troll." + m + ".material"))), this.lg.getItems().getInt("Troll." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("Troll." + m + ".data")).setName(this.lg.getString("Troll." + m + ".name")).setLore(this.lg.getStringList("Troll." + m + ".lore")).setSkullOwner(this.lg.getItems().getString("Troll." + m + ".skull-owner")).toItemStack();
    }

    private Integer i2(String m)
    {
        return Main.getConfiguration().getInt("Possitions.Troll2." + m);
    }

    public ItemStack item2(String m)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Troll2." + m + ".material"))), this.lg.getItems().getInt("Troll2." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("Troll2." + m + ".data")).setName(this.lg.getString("Troll2." + m + ".name")).setLore(this.lg.getStringList("Troll2." + m + ".lore")).toItemStack();
    }

    private ItemStack is2(String m)
    {

        return new ItemBuilder(Material.valueOf(String.valueOf(this.lg.getItem("Troll2." + m + ".material"))), this.lg.getItems().getInt("Troll2." + m + ".amount")).setDurability((short) this.lg.getItems().getInt("Troll2." + m + ".data")).setName(this.lg.getString("Troll2." + m + ".name")).setLore(this.lg.getStringList("Troll2." + m + ".lore")).setSkullOwner(this.lg.getItems().getString("Troll2." + m + ".skull-owner")).toItemStack();
    }

    private String c(String msg)
    {
        return msg.replaceAll("&", "§");
    }
}
