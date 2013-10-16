package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class API {

    private NumaAdmin plugin;

    API(NumaAdmin plugin) {
        this.plugin = plugin;
    }

    /*
     * spawnにplayerをテレポート
     */
    public void spawn(Player player) {
        if(getSpawn() != null)
            player.teleport(getSpawn());
    }

   /*
    * spawn locationをget
    */
    public Location getSpawn() {
        plugin.reloadConfig();
        if (plugin.getConfig().getString("world") == null) {
            return null;
        }
        World world = Bukkit.getWorld(plugin.getConfig().getString("world"));
        double x = plugin.getConfig().getDouble("x");
        double y = plugin.getConfig().getDouble("y");
        double z = plugin.getConfig().getDouble("z");
        long yaw = plugin.getConfig().getLong("yaw");
        long pitch = plugin.getConfig().getLong("pitch");

        return new Location(world, x, y, z, yaw, pitch);
    }

    /*
     * spawnをset
     */
    public void setSpawn(Location loc) {
        plugin.getConfig().set("world", loc.getWorld().getName());
        plugin.getConfig().set("x", loc.getX());
        plugin.getConfig().set("y", loc.getY());
        plugin.getConfig().set("z", loc.getZ());
        plugin.getConfig().set("yaw", loc.getYaw());
        plugin.getConfig().set("pitch", loc.getPitch());
        plugin.saveConfig();
    }

    public void setSpawn(Player player) {
        setSpawn(player.getLocation());
    }

    /*
     * death spawn
     */
    public boolean onDeath() {
        plugin.reloadConfig();
        return plugin.getConfig().getBoolean("deathtp");
    }
}
