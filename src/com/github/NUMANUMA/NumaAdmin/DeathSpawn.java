package com.github.NUMANUMA.NumaAdmin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathSpawn implements Listener {
    NumaAdmin plugin;

    public DeathSpawn(NumaAdmin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /*
     * 死亡したらスポーンポイントにスポーン
     */
    @EventHandler
    public void onPlayerRespawn(final PlayerRespawnEvent e) {
        if (plugin.getAPI().onDeath()) {
            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                public void run() {
                    plugin.getAPI().spawn(e.getPlayer());
                }
            }, 5);
        }
    }
}
