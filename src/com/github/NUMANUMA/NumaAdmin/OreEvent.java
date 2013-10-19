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

public class OreEvent implements CommandExecutor {
    NumaAdmin plugin;

    public OreEvent(NumaAdmin plugin) {
        this.plugin = plugin;
    }

    //イベントたち

    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("oreevent")) {
            if (sender instanceof Player) {
                plugin.reloadConfig();
                if (plugin.getConfig().getString("orex") == null) {
                    plugin.getConfig().set("orex", 0);
                    plugin.saveConfig();
                }
                if (plugin.getConfig().getString("orez") == null) {
                    plugin.getConfig().set("orez", 0);
                    plugin.saveConfig();
                }
                if (plugin.getConfig().getString("maxrange") == null) {
                    plugin.getConfig().set("maxrange", 1000);
                    plugin.saveConfig();
                }
                if (plugin.getConfig().getString("oresec") == null) {
                    plugin.getConfig().set("oresec", 10);
                    plugin.saveConfig();
                }
                if (plugin.getConfig().getString("orestart") == null) {
                    plugin.getConfig().set("orestart", 3);
                    plugin.saveConfig();
                }

                sender.sendMessage("Ore-Eventを開始しました。");
                Player player = (Player) sender;
                final World w = player.getWorld();

                Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    public void run() {
                        Location loc = new Location((World) w, plugin.getConfig().getDouble("orex"), 0, plugin.getConfig().getDouble("orez"));

                        loc.setX( loc.getX() + Math.random() * plugin.getConfig().getDouble("maxrange") * 2 - plugin.getConfig().getDouble("maxrange"));
                        loc.setZ( loc.getZ() + Math.random() * plugin.getConfig().getDouble("maxrange") * 2 - plugin.getConfig().getDouble("maxrange"));
                        loc.setY(256);

                        w.spawnFallingBlock(loc, Material.DIAMOND_BLOCK, (byte) 0);

                        sender.getServer().broadcastMessage(ChatColor.GOLD + "以下の座標にダイアモンドブロックが落下した！");
                        sender.getServer().broadcastMessage(ChatColor.GREEN + "X: " + loc.getX() + " Z: " + loc.getZ());
                    }
                }, 20*plugin.getConfig().getInt("orestart"), 20*plugin.getConfig().getInt("oresec"));
                return true;
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ使用できます。");
            }
        }
        if (label.equalsIgnoreCase("oreconfig")) {
            if (sender instanceof Player) {
                sender.sendMessage(ChatColor.AQUA + "###コンフィグの情報###");
                sender.sendMessage(ChatColor.GREEN + "orex: " + plugin.getConfig().getDouble("orex"));
                sender.sendMessage(ChatColor.GREEN + "orez: " + plugin.getConfig().getDouble("orez"));
                sender.sendMessage(ChatColor.GREEN + "maxrange: " + plugin.getConfig().getDouble("maxrange"));
                sender.sendMessage(ChatColor.AQUA + "#################");
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ使用できます。");
            }
        }
        return true;
    }
}
