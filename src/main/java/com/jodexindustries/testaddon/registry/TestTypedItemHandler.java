package com.jodexindustries.testaddon.registry;

import com.jodexindustries.donatecase.api.data.casedata.CaseDataBukkit;
import com.jodexindustries.donatecase.api.data.casedata.CaseDataMaterialBukkit;
import com.jodexindustries.donatecase.api.data.casedata.gui.GUI;
import com.jodexindustries.donatecase.api.data.casedata.gui.TypedItemHandler;
import com.jodexindustries.donatecase.api.gui.CaseGui;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class TestTypedItemHandler implements TypedItemHandler<CaseDataMaterialBukkit, CaseGui<Inventory, Location, Player, CaseDataBukkit, CaseDataMaterialBukkit>> {

    @NotNull
    @Override
    public GUI.Item<CaseDataMaterialBukkit> handle(@NotNull CaseGui<Inventory, Location, Player, CaseDataBukkit, CaseDataMaterialBukkit> caseGui,
                                                   @NotNull GUI.Item<CaseDataMaterialBukkit> item) {
        // example: HISTORY-0
        // args[0] = HISTORY
        // args[1] = 0
        String[] args = item.getType().split("-");
        if(args.length >= 2) {
            if(args[1].equalsIgnoreCase("test")) {
                item.getMaterial().setDisplayName("Test");
            }
        }

        return item;
    }
}
