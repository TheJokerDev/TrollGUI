package me.TheJokerDev.troll;

import me.TheJokerDev.troll.commands.DemoTroll;
import me.TheJokerDev.troll.commands.ForceChat;
import me.TheJokerDev.troll.effects.EffectTNT;
import me.TheJokerDev.troll.inventory.MorphsGUI;
import me.TheJokerDev.troll.inventory.SelectorGUI;
import me.TheJokerDev.troll.inventory.TrollGUI;
import me.TheJokerDev.troll.listeners.PlayerListeners;
import me.TheJokerDev.troll.listeners.SkyColorsListeners;
import me.TheJokerDev.troll.listeners.TrollListeners;
import me.TheJokerDev.troll.listeners.VehiclesListeners;
import me.TheJokerDev.troll.messages.Files;
import me.TheJokerDev.troll.messages.FilesManager;
import me.TheJokerDev.troll.utils.ItemBuilder;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
        extends JavaPlugin
{
    public static boolean effecttnt;
    public static String prefix;
    public static Main plugin;
    public int arrowtroll;
    private Files lg = new Files();
    public static HashMap<Player, Player> target = new HashMap<>();
    private static Main instance;
    public HashMap<String, ItemStack[]> inventory;
    HashMap<String, ItemStack[]> armor;
    ArrayList<String> cd;
    private int maxControlTime;
    private int cooldown;
    public ArrayList<String> lagg = new ArrayList<>();
    public ArrayList<String> arrow = new ArrayList<>();
    public ArrayList<String> zeus = new ArrayList<>();
    public ArrayList<Player> randomChatACTIVE = new ArrayList<>();
    public ArrayList<Player> morphsdamage = new ArrayList<>();
    public ArrayList<Player> randomMenu = new ArrayList<>();
    public HashMap<Integer, Integer> nummer = new HashMap<>();
    public HashMap<Integer, org.bukkit.Location> bloque = new HashMap<>();
    public HashMap<Player, Long> fillinvAllowanceTime = new HashMap<>();
    public ArrayList<Player> fillinvWatchChat = new ArrayList<>();
    public ArrayList disguiseplayer = new ArrayList();
    public HashMap disguiseplayerTime = new HashMap();
    public HashMap<Player, Player> select = new HashMap<>();
    public ArrayList lavablock = new ArrayList();
    public ArrayList infiniteInventory = new ArrayList();
    public ArrayList expBlock = new ArrayList();
    public ArrayList dontleave = new ArrayList();
    public ArrayList<String> toTrans = new ArrayList<>();
    public ArrayList<String> toTrans1 = new ArrayList<>();
    public ArrayList frozen;
    public ArrayList allfrozen;
    public static ArrayList items;

    public void onEnable()
    {
        hookDependiencies();
        saveDefaultConfig();
        System.out.println("TrollGUI");
        System.out.println("Developed by TheJokerDev");
        if (getConfig().getBoolean("StartMessage"))
        {
            System.out.println("---------------------------------------------------");
            System.out.println("         Thanks for download my plugin");
            System.out.println("      You can see my others projects in my");
            System.out.println("     SpigotMC profile, give me a 5 star pls xD!");
            System.out.println("---------------------------------------------------");
        }
        getLogger().info("Plugin Version: " + getDescription().getVersion());
        FilesManager lm = new FilesManager(this);
        lm.setup(this);
        getLogger().info("All files are been loaded");

        instance = this;
        getCommand("forcechat").setExecutor(new ForceChat(this));
        getCommand("demotroll").setExecutor(new DemoTroll(this));
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new TrollListeners(this), this);
        pm.registerEvents(new PlayerListeners(this), this);
        pm.registerEvents(new SkyColorsListeners(), this);
        pm.registerEvents(new VehiclesListeners(this), this);
        effecttnt = getConfig().getBoolean("effect-explode");
        Bukkit.getPluginManager().registerEvents(new EffectTNT(), this);
        getLogger().info("All Events are been loaded!");

        prefix = getInstance().getConfig().getString("prefix").replaceAll("&", "§");
        this.armor = new HashMap<>();
        this.inventory = new HashMap<>();
        this.maxControlTime = 0;
        this.cooldown = 0;
        this.cd = new ArrayList<>();
        getLogger().info("All Add-ons are been loaded!");
    }

    public static FileConfiguration getConfiguration()
    {
        return getInstance().getConfig();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("troll"))
        {
            if (!(sender instanceof Player))
            {
                Bukkit.getConsoleSender().sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.consoleNoRunCommand"));
                return true;
            }
            if (!sender.hasPermission("troll.open"))
            {
                sender.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.noPermission"));
                return true;
            }
            if (args.length == 0)
            {
                Player localPlayer1 = (Player)sender;
                SelectorGUI localObject2 = new SelectorGUI();
                localObject2.openGUI(localPlayer1);
            }
            Player p = (Player)sender;
            if (args.length == 1)
            {
                Player t = Bukkit.getServer().getPlayer(args[0]);
                if (t == null)
                {
                    p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.noPlayerOnline").replaceAll("%player%", args[0]));
                    return true;
                }
                target.put(p, t);
                TrollGUI tm = new TrollGUI(this);
                tm.openTroll(p);
                return true;
            }
            if (args.length >= 2)
            {
                p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.tooManyArguments"));
                return true;
            }
        }
        if (cmd.getName().equalsIgnoreCase("viewdisguise"))
        {
            Player p = (Player)sender;
            if (!sender.hasPermission("troll.viewdisguise"))
            {
                p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.noPermission"));
                return true;
            }
            if (args.length == 0) {
                if (p.getType() == EntityType.PLAYER) {
                    if (DisguiseAPI.isViewSelfToggled(p))
                    {
                        DisguiseAPI.setViewDisguiseToggled(p, false);
                        p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.DisguiseOff"));
                    }
                    else
                    {
                        DisguiseAPI.setViewDisguiseToggled(p, true);
                        p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.DisguiseOn"));
                    }
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("morphs"))
        {
            Player p = (Player)sender;
            if (sender == null)
            {
                Bukkit.getConsoleSender().sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.consoleNoRunCommand"));
                return true;
            }
            if (!sender.hasPermission("troll.morphs"))
            {
                p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.noPermission"));
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.tooManyArguments"));
            }
            if (args.length == 1)
            {
                Player t = Bukkit.getServer().getPlayer(args[0]);
                if (t == null)
                {
                    p.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.noPlayerOnline").replaceAll("%player%", args[0]));
                    return true;
                }
                target.put(p, t);
                MorphsGUI mg = new MorphsGUI();
                mg.openMorphs(p);
                return true;
            }
            if (args.length >= 2)
            {
                sender.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.noCommandUse"));
                return true;
            }
        }
        if (cmd.getName().equalsIgnoreCase("trollreload"))
        {
            if (!sender.hasPermission("troll.reload"))
            {
                sender.sendMessage(prefix + this.lg.getPluginMSG("PluginMessages.noPermission"));
                return true;
            }
            if (args.length == 0)
            {
                reloadConfig();
                sender.sendMessage(this.lg.getPluginMSG("PluginMessages.reloadMessage"));
            }
        }
        return true;
    }

    private void hookDependiencies()
    {
        new BukkitRunnable()
        {
            public void run()
            {
                if (!Bukkit.getPluginManager().isPluginEnabled("ProtocolLib"))
                {
                    Main.this.getLogger().info("ProtocolLib not found, disabling the plugin...");
                    Main.this.setEnabled(false);
                }
            }
        }

                .runTaskLater(this, 1L);

        new BukkitRunnable()
        {
            public void run()
            {
                if (!Bukkit.getPluginManager().isPluginEnabled("LibsDisguises"))
                {
                    Main.this.getLogger().info("LibsDisguises not found, disabling the plugin...");
                    Main.this.setEnabled(false);
                }
            }
        }

                .runTaskLater(this, 1L);

        new BukkitRunnable()
        {
            public void run()
            {
                if (!Bukkit.getPluginManager().isPluginEnabled("OpenInv"))
                {
                    Main.this.getLogger().info("OpenInv not found, disabling the plugin...");
                    Main.this.setEnabled(false);
                }
            }
        }

                .runTaskLater(this, 1L);
        new BukkitRunnable()
        {
            public void run()
            {
                if (!Bukkit.getPluginManager().isPluginEnabled("Vehicles")) {
                    Main.this.getLogger().info("Vehicles not found, disabling the features of this plugin...");
                }
            }
        }

                .runTaskLater(this, 1L);
    }

    void stopControlling(Player v, Player c)
    {
        c.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 1));

        v.removeMetadata("iCU_P", this);
        v.setGameMode(GameMode.SURVIVAL);

        c.removeMetadata("iCU_H", this);
        DisguiseAPI.undisguiseToAll(c);

        v.getInventory().setContents(c.getInventory().getContents());
        v.getInventory().setArmorContents(c.getInventory().getArmorContents());

        c.getInventory().setContents(this.inventory.get(c.getName()));
        c.getInventory().setArmorContents(this.armor.get(c.getName()));
        this.inventory.remove(c.getName());
        this.armor.remove(c.getName());

        v.teleport(c);
        if (this.cooldown > 0)
        {
            this.cd.add(c.getName());
            new Cooldown(this, c).runTaskLater(this, this.cooldown * 20);
        }
    }

    public void startControlling(Player v, Player c)
    {
        v.setMetadata("iCU_P", new FixedMetadataValue(this, c.getName()));
        c.setMetadata("iCU_H", new FixedMetadataValue(this, v.getName()));

        this.inventory.put(c.getName(), c.getInventory().getContents());
        this.armor.put(c.getName(), c.getInventory().getArmorContents());
        c.getInventory().setContents(v.getInventory().getContents());
        c.getInventory().setArmorContents(v.getInventory().getArmorContents());

        c.teleport(v);
        v.setGameMode(GameMode.SPECTATOR);

        PlayerDisguise disV = new PlayerDisguise(v.getName());
        DisguiseAPI.disguiseToAll(c, disV);

        new CheckVictim(v, c).runTaskTimer(this, 100L, 100L);
        if (this.maxControlTime > 0) {
            new ControlTimer(c, v, this).runTaskLater(this, this.maxControlTime * 20);
        }
    }

    public static Main getInstance()
    {
        return instance;
    }

    class inventory
    {
        public inventory() {}
    }
}
