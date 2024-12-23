package com.jodexindustries.testaddon.registry;

import com.jodexindustries.donatecase.api.data.action.ActionExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TestAction implements ActionExecutor<Player> {

    @Override
    public void execute(@Nullable Player player, @NotNull String context, int cooldown) {
        if (player != null) player.sendMessage("Hello!");
    }
}