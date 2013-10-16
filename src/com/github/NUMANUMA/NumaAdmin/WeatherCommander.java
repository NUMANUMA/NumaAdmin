package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommander implements CommandExecutor {
    NumaAdmin plugin;

    public WeatherCommander(NumaAdmin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("tenki")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "値が正しくありません。");
                    return false;
                } else if (args[0].equalsIgnoreCase("hare")) {
                    player.sendMessage(ChatColor.AQUA + "晴れになりました。");
                    player.getWorld().setStorm(false);

                    return true;
                } else if (args[0].equalsIgnoreCase("ame")) {
                    player.sendMessage(ChatColor.AQUA + "雨になりました。");
                    player.getWorld().setThundering(true);

                    return true;
                } else if (args[0].equalsIgnoreCase("kaminari")) {
                    player.sendMessage(ChatColor.AQUA + "雷雨になりました。");
                    player.getWorld().setStorm(true);

                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "値が正しくありません。");
                    return false;
                }
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ使用できます");
            }
        }

        return true;
    }
}
