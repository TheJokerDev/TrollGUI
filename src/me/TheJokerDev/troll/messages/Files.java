package me.TheJokerDev.troll.messages;

import me.TheJokerDev.troll.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Files
{
    private static File effect = new File("plugins/TrollGUI/effects/effects.yml");
    public String m = null;
    private List<String> messagesend = null;
    private Configuration listsend = null;
    private File langfileen = new File("plugins/TrollGUI/lang/lang_en.yml");
    private File langfilees = new File("plugins/TrollGUI/lang/lang_es.yml");
    private File plmsgen = new File("plugins/TrollGUI/lang/msgs_en.yml");
    private File plmsges = new File("plugins/TrollGUI/lang/msgs_es.yml");
    private File items = new File("plugins/TrollGUI/items.yml");
    private FileConfiguration langen = YamlConfiguration.loadConfiguration(this.langfileen);
    private FileConfiguration langes = YamlConfiguration.loadConfiguration(this.langfilees);
    private FileConfiguration plmsen = YamlConfiguration.loadConfiguration(this.plmsgen);
    private FileConfiguration plmses = YamlConfiguration.loadConfiguration(this.plmsges);
    private FileConfiguration item = YamlConfiguration.loadConfiguration(this.items);


    public String getString(String msg)
    {
        if (Main.getConfiguration().getString("language").contains("en")) {
            this.m = ChatColor.translateAlternateColorCodes('&', this.langen.getString(msg));
        } else if (Main.getConfiguration().getString("language").contains("es")) {
            this.m = ChatColor.translateAlternateColorCodes('&', this.langes.getString(msg));
        }
        return this.m;
    }

    public String getPluginMSG(String msg)
    {
        if (Main.getConfiguration().getString("language").contains("en")) {
            this.m = ChatColor.translateAlternateColorCodes('&', this.plmsen.getString(msg));
        } else if (Main.getConfiguration().getString("language").contains("es")) {
            this.m = ChatColor.translateAlternateColorCodes('&', this.plmses.getString(msg));
        }
        return this.m;
    }

    public List<String> getStringList(String msg)
    {
        if (Main.getConfiguration().getString("language").contains("en"))
        {
            ArrayList<String> lore = new ArrayList<>();
            for (String all : this.langen.getStringList(msg)) {
                lore.add(ChatColor.translateAlternateColorCodes('&', all));
            }
            this.messagesend = lore;
        }
        else if (Main.getConfiguration().getString("language").contains("es"))
        {
            List<String> lore = new ArrayList<>();
            for (String all : this.langes.getStringList(msg)) {
                lore.add(ChatColor.translateAlternateColorCodes('&', all));
            }
            this.messagesend = lore;
        }
        return this.messagesend;
    }

    public FileConfiguration getLang()
    {
        if (Main.getConfiguration().getString("language").contains("en")) {
            this.listsend = this.langen;
        } else if (Main.getConfiguration().getString("language").contains("es")) {
            this.listsend = this.langes;
        }
        return (FileConfiguration)this.listsend;
    }

    public FileConfiguration getItems()
    {
        this.listsend = this.item;
        return (FileConfiguration)this.listsend;
    }

    public Material getItem(String msg)
    {
        return Material.getMaterial(this.item.getString(msg));
    }

    static void loadEffects()
    {
        YamlConfiguration effects = YamlConfiguration.loadConfiguration(effect);
        effects.options().copyDefaults(true);
        effects.options().header("TrollItems");
        for (World world : Bukkit.getWorlds())
        {
            if (!effects.contains(world.getName() + ".Enabled")) {
                effects.set(world.getName() + ".Enabled", Boolean.TRUE);
            }
            if (!effects.contains(world.getName() + ".DisableDisappearBlocks")) {
                effects.set(world.getName() + ".DisableDisappearBlocks", Boolean.FALSE);
            }
        }
        try
        {
            effects.save(effect);
        }
        catch (IOException ignored) {}
    }
}
