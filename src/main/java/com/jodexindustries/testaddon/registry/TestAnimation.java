package com.jodexindustries.testaddon.registry;

import com.jodexindustries.donatecase.api.data.animation.JavaAnimationBukkit;
import org.bukkit.Bukkit;

public class TestAnimation extends JavaAnimationBukkit {

    @Override
    public void start() {
        getApi().getAnimationManager().animationPreEnd(getCaseData(), getPlayer(), getUuid(), getWinItem());
        Bukkit.getScheduler().runTaskLater(getApi().getDonateCase(), () -> getApi().getAnimationManager().animationEnd(getCaseData(), getPlayer(), getUuid(), getWinItem()), 20L);
    }
}