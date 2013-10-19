package com.github.NUMANUMA.NumaAdmin;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NumaAdmin extends JavaPlugin{
    Logger log;

    private API API;

    @Override
    public void onEnable() {
        log = this.getLogger();
        log.info("プラグインが有効になりました。");

        //config
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);

        //Get API
        API = new API(this);

        //イベントの登録
        new Event(this);
        new DeathSpawn(this);

        //コマンドの追加
        getCommand("gm").setExecutor(new Event(this));
        getCommand("spawn").setExecutor(new SpawnCommander(this));
        getCommand("setspawn").setExecutor(new SpawnCommander(this));
        getCommand("tenki").setExecutor(new WeatherCommander(this));
        getCommand("oreevent").setExecutor(new OreEvent(this));
        getCommand("oreconfig").setExecutor(new OreEvent(this));
    }

    public API getAPI() {
        return API;
    }
}
