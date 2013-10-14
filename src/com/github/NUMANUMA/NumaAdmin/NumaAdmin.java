package com.github.NUMANUMA.NumaAdmin;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NumaAdmin extends JavaPlugin{
    Logger log;
    public Event eve = new Event(this);

    @Override
    public void onEnable() {
        log = this.getLogger();
        log.info("プラグインが有効になりました。");

        getServer().getPluginManager().registerEvents(eve, this);

        //コマンドの追加
        eve = new Event(this);
        getCommand("gm").setExecutor(eve);
    }

    @Override
    public void onDisable() {
        log.info("プラグインが無効になりました。");
    }
}
