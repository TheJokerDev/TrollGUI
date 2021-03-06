package me.TheJokerDev.troll.listeners;

import es.pollitoyeye.vehicles.VehiclesMain;
import es.pollitoyeye.vehicles.events.VehicleEnterEvent;
import es.pollitoyeye.vehicles.interfaces.Vehicle;
import es.pollitoyeye.vehicles.vehiclemanagers.*;
import me.TheJokerDev.troll.Main;
import me.TheJokerDev.troll.inventory.TrollGUI;
import me.TheJokerDev.troll.messages.Files;
import me.TheJokerDev.troll.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.event.entity.EntityDismountEvent;
import org.spigotmc.event.entity.EntityMountEvent;

public class VehiclesListeners
        implements Listener {
    private static String[] vehiclePartsNames = {";BikePart;", ";Bike;", ";Car;", ";CarPart;", ";Train;", ";TrainPart;", ";Raft;", ";RaftPart;", ";Plane;", ";PlanePart;", ";Para;", ";ParaPart;", ";Heli;", ";HeliPart;", ";Tank;", ";TankPart;", ";Subma;", ";SubmaPart;", ";Broom;", ";BroomPart;", ";HBike;", ";HBikePart;"};
    public Main plugin;
    private TrollGUI tm;
    private Files lf;

    public VehiclesListeners(Main plugin) {
        this.tm = new TrollGUI(this.plugin);
        this.lf = new Files();
        this.plugin = plugin;
    }

    @EventHandler
    public void Vehicles(InventoryClickEvent e) {
        if (!e.getInventory().getName().equals(this.lf.getString("GUI.Vehicles.Title"))) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Player t = Main.target.get(p);
        Main.target.get(t);
        if (t != null) {
            e.setCancelled(true);
            if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType() == Material.AIR) || (!e.getCurrentItem().hasItemMeta())) {
                p.closeInventory();
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Vehicles.Back.name"))) {
                this.tm.openTroll(p);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Vehicles.Helicopter.name"))) {
                p.closeInventory();
                HelicopterManager hm = new HelicopterManager();
                hm.spawn(t.getLocation(), String.valueOf(t.getUniqueId()), "H3");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Vehicles.Plane.name"))) {
                p.closeInventory();
                PlaneManager hm = new PlaneManager();
                hm.spawn(t.getLocation(), String.valueOf(t.getUniqueId()), "P3");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Vehicles.Tank.name"))) {
                p.closeInventory();
                TankManager hm = new TankManager();
                hm.spawn(t.getLocation(), String.valueOf(t.getUniqueId()), "T3");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Vehicles.Raft.name"))) {
                p.closeInventory();
                RaftManager hm = new RaftManager();
                hm.spawn(t.getLocation(), String.valueOf(t.getUniqueId()), "PIRATE");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lf.getString("Vehicles.Bike.name"))) {
                p.closeInventory();
                BikeManager hm = new BikeManager();
                hm.spawn(t.getLocation(), String.valueOf(t.getUniqueId()), "RED");
            }
        }
    }

    @EventHandler
    public void alsubirse(VehicleEnterEvent paramEntityDismountEvent) {
        Player p = paramEntityDismountEvent.getPlayer();
        VehiclesMain localVehiclesMain = VehiclesMain.getPlugin();
        String str = paramEntityDismountEvent.getMainArmorStand().getCustomName();
        if ((str != null) && (localVehiclesMain.keepVehicleMomentum)) {
            int i = 0;
            String[] arrayOfString;
            int k = (arrayOfString = vehiclePartsNames).length;
            for (int j = 0; j < k; j++) {
                String localObject = arrayOfString[j];
                if (str.startsWith(localObject)) {
                    i = 1;
                    break;
                }
            }
            if ((p instanceof Player)) {
                Object localObject = p.getPlayer();
                Vehicle localVehicle = localVehiclesMain.getPlayerVehicle(p);
                if (localVehicle != null) {
                    ItemStack TnTItem = new ItemBuilder(Material.SKULL_ITEM).setSkullOwner("MHF_TnT").setDurability((short) 3).setName(lf.getString("Troll.Vehicles.TnTItem.name")).toItemStack();
                    ItemStack Explode= new ItemBuilder(Material.SKULL_ITEM).setSkullOwner("Pesse_").setDurability((short) 3).setName(lf.getString("Troll.Vehicles.Explode.name")).toItemStack();
                    p.getInventory().addItem(TnTItem, Explode);
                }
            }
        }
    }

    @EventHandler
    public void keepMomentum(EntityDismountEvent paramEntityDismountEvent) {
        VehiclesMain localVehiclesMain = VehiclesMain.getPlugin();
        Entity localEntity = paramEntityDismountEvent.getDismounted();
        if (!(localEntity instanceof ArmorStand)) {
            return;
        }
        String str = localEntity.getCustomName();
        if ((str != null) && (localVehiclesMain.keepVehicleMomentum)) {
            int i = 0;
            String[] arrayOfString;
            int k = (arrayOfString = vehiclePartsNames).length;
            for (int j = 0; j < k; j++) {
                String localObject = arrayOfString[j];
                if (str.startsWith(localObject)) {
                    i = 1;
                    break;
                }
            }
            if ((paramEntityDismountEvent.getEntity() instanceof Player)) {
                Object localObject = paramEntityDismountEvent.getEntity();
                Vehicle localVehicle = localVehiclesMain.getPlayerVehicle((Player) localObject);
                if (localVehicle != null) {
                    localVehicle.remove();
                    Player p = (Player)localObject;
                    p.getItemInHand();
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.LEFT_CLICK_AIR)
                || (event.getAction() == Action.LEFT_CLICK_AIR)) {
            if ((player.getItemInHand().getType() == Material.SKULL_ITEM) && (player.getItemInHand().getItemMeta().getLore() != null) && (player.getItemInHand().getDurability() == 3) && (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(lf.getString("Troll.Vehicles.Explode.name")))) {
                player.getWorld().createExplosion(player.getLocation(), 8.0F);
                VehiclesMain localVehiclesMain = VehiclesMain.getPlugin();
                Vehicle localVehicle = localVehiclesMain.getPlayerVehicle(player);
                if (localVehicle != null) {
                    localVehicle.remove();
                }
                return;
            }
            return;
        }
    }

    private String color(String msg)
    {
        return msg.replaceAll("&", "§");
    }
}
