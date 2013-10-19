package com.github.NUMANUMA.NumaAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class MeteoCommander implements Listener, CommandExecutor {
    NumaAdmin plugin;

    public MeteoCommander(NumaAdmin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    final HashMap<Player, Boolean> mete = new HashMap<>();
    List<String> entityList = new ArrayList<String>();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (label.equalsIgnoreCase("meteo")) {
            if (sender instanceof Player) {
                if (mete.get(player) == null) {
                    mete.put(player, true);
                    player.sendMessage(ChatColor.GREEN + "メテオモードが有効になりました。");
                } else if (mete.get(player) == true) {
                    mete.put(player, false);
                    player.sendMessage(ChatColor.RED + "メテオモードが無効になりました。");
                } else if (mete.get(player) == false) {
                    mete.put(player, true);
                    player.sendMessage(ChatColor.GREEN + "メテオモードが有効になりました。");
                }
            } else {
                sender.sendMessage("このコマンドはプレイヤーのみ使用できます。");
            }
        }
        return true;
    }

    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        //player.getServer().broadcastMessage("クリック");
        if (mete.get(player) == null) {
            //player.getServer().broadcastMessage("nullだよ");
            return;
        } else if (mete.get(player) == true) {
            //player.getServer().broadcastMessage("trueだよ");
            final Location eyeloc = player.getTargetBlock(null, 200).getLocation();
            player.getWorld().strikeLightning(eyeloc);
            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                public void run() {
                    /*
                    eyeloc.setY(eyeloc.getY() + 20);
                    Location loc00 = eyeloc;
                    Location loc10 = eyeloc;
                    Location loc20 = eyeloc;
                    Location loc30 = eyeloc;

                    loc10.setX(loc10.getX() + 1);
                    loc20.setZ(loc20.getZ() + 1);
                    loc30.setX(loc30.getX() + 1);loc30.setZ(loc30.getZ() + 1);

                    Location loc01 = loc00;
                    Location loc11 = loc10;
                    Location loc21 = loc20;
                    Location loc31 = loc30;

                    loc01.setY(loc01.getY() + 1);
                    loc11.setY(loc11.getY() + 1);
                    loc21.setY(loc21.getY() + 1);
                    loc31.setY(loc31.getY() + 1);

                    player.getWorld().spawnFallingBlock(loc00, Material.NETHERRACK, (byte) 0);
                    player.getWorld().spawnFallingBlock(loc10, Material.NETHERRACK, (byte) 0);
                    player.getWorld().spawnFallingBlock(loc20, Material.NETHERRACK, (byte) 0);
                    player.getWorld().spawnFallingBlock(loc30, Material.NETHERRACK, (byte) 0);
                    player.getWorld().spawnFallingBlock(loc01, Material.NETHERRACK, (byte) 0);
                    player.getWorld().spawnFallingBlock(loc11, Material.NETHERRACK, (byte) 0);
                    player.getWorld().spawnFallingBlock(loc21, Material.NETHERRACK, (byte) 0);
                    player.getWorld().spawnFallingBlock(loc31, Material.NETHERRACK, (byte) 0);
                    */

                    eyeloc.setY(eyeloc.getY() + 20);
                    Location loc = eyeloc;
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);
                    loc.setX(loc.getX() + 1);
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);
                    loc.setZ(loc.getZ() + 1);
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);
                    loc.setX(loc.getX() - 1);
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);
                    loc.setZ(loc.getZ() - 1);
                    loc.setY(loc.getY() + 1);
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);
                    loc.setX(loc.getX() + 1);
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);
                    loc.setZ(loc.getZ() + 1);
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);
                    loc.setX(loc.getX() - 1);
                    player.getWorld().spawnFallingBlock(loc, Material.NETHERRACK, (byte) 0);

                }
            }, 20*5);
        } else if (mete.get(player) == false) {
            //player.getServer().broadcastMessage("falseだよ");
            return;
        }
    }
}
