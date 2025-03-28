package com.jodexindustries.testaddon.registry;

import com.jodexindustries.donatecase.api.DCAPI;
import com.jodexindustries.donatecase.spigot.api.animation.BukkitJavaAnimation;

public class TestAnimation extends BukkitJavaAnimation {

    private final DCAPI api = DCAPI.getInstance();

    @Override
    public void start() {
        preEnd();
        DCAPI.getInstance().getPlatform().getScheduler().run(api.getPlatform(), this::end, 20L);
    }
}