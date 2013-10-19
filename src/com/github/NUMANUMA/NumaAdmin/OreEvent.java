package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class OreEvent implements Listener, CommandExecutor {
    NumaAdmin plugin;

    public OreEvent(NumaAdmin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    //イベントたち

    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("oreevent")) {
            if (sender instanceof Player) {
                sender.sendMessage("Ore-Eventを開始しました。");
                Player player = (Player) sender;
                final World w = player.getWorld();

                Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    public void run() {
                        Location loc = new Location((World) w, 0, 0, 0);

                        loc.setX( loc.getX() + Math.random() * 1000 * 2 - 1000);
                        loc.setZ( loc.getZ() + Math.random() * 1000 * 2 - 1000);
                        loc.setY( w.getHighestBlockAt(loc.getBlockX(), loc.getBlockZ() ).getY() );

                        w.spawnFallingBlock(loc, Material.DIAMOND_BLOCK, (byte) 0);

                        sender.getServer().broadcastMessage(ChatColor.GOLD + "以下の座標にダイアモンドが落下した！");
                        sender.getServer().broadcastMessage(ChatColor.GREEN + "X: " + loc.getX() + " Z: " + loc.getZ());
                    }
                }, 20*5, 20*600);
                return true;
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ使用できます。");
            }
        }
        return true;
    }
}
