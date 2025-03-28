package com.jodexindustries.testaddon.registry;

import com.jodexindustries.donatecase.api.data.material.MaterialHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class TestMaterial implements MaterialHandler {

    @Override
    public @NotNull ItemStack handle(@NotNull String context) {

        Material type = Material.getMaterial("SKULL_ITEM");
        ItemStack item = type == null ? new ItemStack(Material.getMaterial("PLAYER_HEAD")) : new ItemStack(type, 1, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        if (meta != null) {
            meta.setOwner(context);
            item.setItemMeta(meta);
        }
        return item;
    }
}