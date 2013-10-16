package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommander implements CommandExecutor {
    NumaAdmin plugin;

    public SpawnCommander(NumaAdmin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (label.equalsIgnoreCase("spawn")) {
            if (sender instanceof Player) {
                plugin.getAPI().spawn((Player) sender);
                sender.sendMessage(ChatColor.AQUA + "===スポーンしました===");
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ使用できます");
            }
        }
        if (label.equalsIgnoreCase("setspawn")) {
            if (sender instanceof Player) {
                plugin.getAPI().setSpawn((Player) sender);
                sender.sendMessage(ChatColor.AQUA + "===スポーン地点を設定しました===");
                sender.sendMessage(ChatColor.GOLD + "-World Name-");
                sender.sendMessage(ChatColor.GREEN + "" + plugin.getAPI().getSpawn().getWorld().getName());
                sender.sendMessage(ChatColor.GOLD + " ");
                sender.sendMessage(ChatColor.GOLD + "-Location-");
                sender.sendMessage(ChatColor.GREEN + "X: " + plugin.getAPI().getSpawn().getBlockX());
                sender.sendMessage(ChatColor.GREEN + "Y: " + plugin.getAPI().getSpawn().getBlockY());
                sender.sendMessage(ChatColor.GREEN + "Z: " + plugin.getAPI().getSpawn().getBlockZ());
                sender.sendMessage(ChatColor.AQUA + "======================================");
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ使用できます");
            }
        }

        return true;
    }
}
