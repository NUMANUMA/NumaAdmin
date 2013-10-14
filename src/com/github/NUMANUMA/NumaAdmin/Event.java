package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Event implements Listener,CommandExecutor {

    public Event(NumaAdmin plugin){
    }

    //イベントたち

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = null;
        if(sender instanceof Player) {
            player = (Player) sender;
        }

        //gmコマンド
        if(cmd.getName().equalsIgnoreCase("gm")){
            if(player != null) {
              //選択
                if(args.length == 0) {
                    player.sendMessage(ChatColor.RED + "数値が正しくありません。");

                    return false;
                } else if(args[0].equalsIgnoreCase("0")) {
                    player.sendMessage(ChatColor.AQUA + "サバイバルモードに変更しました。");
                    player.setGameMode(GameMode.SURVIVAL);

                    return true;
                } else if(args[0].equalsIgnoreCase("1")) {
                    player.sendMessage(ChatColor.AQUA + "クリエイティブモードに変更しました。");
                    player.setGameMode(GameMode.CREATIVE);

                    return true;
                } else if(args[0].equalsIgnoreCase("2")) {
                    player.sendMessage(ChatColor.AQUA + "アドベンチャーモードに変更しました。");
                    player.setGameMode(GameMode.ADVENTURE);

                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "数値が正しくありません。");

                    return false;
                }
            } else {
                sender.sendMessage("このコマンドはプレイヤー専用です。");
            }
            return true;
        }
        return false;
    }

}
