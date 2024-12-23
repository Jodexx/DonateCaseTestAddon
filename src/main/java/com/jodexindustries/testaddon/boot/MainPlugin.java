package com.jodexindustries.testaddon.boot;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin implements Listener {
    private Loader loader;

    @Override
    public void onLoad() {
        loader = new Loader(this);
    }

    @Override
    public void onEnable() {
        loader.load();
    }

    @Override
    public void onDisable() {
        loader.unload();
    }
}