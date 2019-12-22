package me.TheJokerDev.troll.messages;

import org.bukkit.plugin.Plugin;

import java.io.File;

public class FilesManager
{
    private Plugin plugin;
    private File configFileen;
    private File configFilees;
    private File pluginmessagesen;
    private File pluginmessageses;
    private File items;
    public static File item = new File("plugins/TrollGUI/items.yml");

    public FilesManager(Plugin plugin)
    {
        this.plugin = plugin;
        this.configFileen = new File(this.plugin.getDataFolder(), "lang/lang_en.yml");
        this.configFilees = new File(this.plugin.getDataFolder(), "lang/lang_es.yml");
        this.pluginmessagesen = new File(this.plugin.getDataFolder(), "lang/msgs_en.yml");
        this.pluginmessageses = new File(this.plugin.getDataFolder(), "lang/msgs_es.yml");
        this.items = new File(this.plugin.getDataFolder(), "items.yml");
    }

    public void setup(Plugin paramPlugin)
    {
        File effects = new File(paramPlugin.getDataFolder() + File.separator + "effects", "");
        if (!effects.exists())
        {
            System.out.println("No folder of effects was found, creating...");
            effects.mkdir();
        }
        Files.loadEffects();
        File langcarpet = new File(paramPlugin.getDataFolder() + File.separator + "lang", "");
        if (!langcarpet.exists())
        {
            System.out.println("No folder of languages was found, creating...");
            langcarpet.mkdir();
        }
        if (!this.configFileen.exists()) {
            this.plugin.saveResource("lang/lang_en.yml", false);
        }
        if (!this.configFilees.exists()) {
            this.plugin.saveResource("lang/lang_es.yml", false);
        }
        if (!this.pluginmessageses.exists()) {
            this.plugin.saveResource("lang/msgs_es.yml", false);
        }
        if (!this.pluginmessagesen.exists()) {
            this.plugin.saveResource("lang/msgs_en.yml", false);
        }
        if (!this.items.exists()) {
            this.plugin.saveResource("items.yml", false);
        }
    }
}
