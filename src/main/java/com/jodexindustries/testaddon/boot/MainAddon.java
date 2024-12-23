package com.jodexindustries.testaddon.boot;

import com.jodexindustries.donatecase.api.addon.internal.InternalJavaAddon;
import org.bukkit.event.Listener;

public class MainAddon extends InternalJavaAddon implements Listener {
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