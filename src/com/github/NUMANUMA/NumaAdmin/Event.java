package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Event implements Listener, CommandExecutor {

    NumaAdmin plugin;

    public Event(NumaAdmin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    //イベントたち

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }

        /*
         * ゲームモードを変更する
         *
         * @gm [0,1,2]
         * 0 = Survival
         * 1 = Creative
         * 2 = Adventure
         */
        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (player != null) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "数値が正しくありません。");

                    return false;
                } else if (args.length == 1) {
                    //ゲームモードの選択選択
                    if (args[0].equalsIgnoreCase("0")) {

                        player.sendMessage(ChatColor.AQUA + "サバイバルモードに変更しました。");
                        player.setGameMode(GameMode.SURVIVAL);

                        return true;
                    } else if (args[0].equalsIgnoreCase("1")) {

                        player.sendMessage(ChatColor.AQUA + "クリエイティブモードに変更しました。");
                        player.setGameMode(GameMode.CREATIVE);

                        return true;
                    } else if (args[0].equalsIgnoreCase("2")) {
                        /*
                         * 動かない！！！！！！
                         * なんで！！！！
                        if(!args[1].isEmpty()) {
                            Player other = (Bukkit.getServer().getPlayer(args[1]));
                            //対象の選択
                            if(other == null) {
                                player.sendMessage(ChatColor.RED + args[1] + "は、オフラインです！");
                                return false;
                            } else {
                                //ここに実行したいことをかく
                                other.sendMessage(ChatColor.AQUA + "アドベンチャーモードに変更しました。");
                                other.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(ChatColor.AQUA + args[1] + "を、アドベンチャーモードに変更しました。");

                                return true;
                            }
                        }
                        */
                        player.sendMessage(ChatColor.AQUA + "アドベンチャーモードに変更しました。");
                        player.setGameMode(GameMode.ADVENTURE);

                        return true;
                    } else {
                        player.sendMessage(ChatColor.RED + "数値が正しくありません。");

                        return false;
                    }
                }
            } else {
                sender.sendMessage("このコマンドはプレイヤー専用です。");
            }
            return true;
        }
        return false;
    }
}
