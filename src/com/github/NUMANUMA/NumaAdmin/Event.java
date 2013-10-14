package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Event implements Listener {

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
            //サバイバルを選択
            if(args[0] == "0") {
                player.sendMessage(Color.AQUA + "サバイバルモードに変更しました。");
                player.setGameMode(GameMode.SURVIVAL);

                return true;
            } else if(args[0] == "1") {
                player.sendMessage(Color.AQUA + "クリエイティブモードに変更しました。");
                player.setGameMode(GameMode.CREATIVE);

                return true;
            } else if(args[0] == "2") {
                player.sendMessage(Color.AQUA + "アドベンチャーモードに変更しました。");
                player.setGameMode(GameMode.ADVENTURE);

                return true;
            } else {
                player.sendMessage(Color.RED + "[0=サバイバル,1=クリエイティブ,2=アドベンチャー]");

                return true;
            }

        }

        return false;
    }
}
