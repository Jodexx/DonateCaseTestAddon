package com.jodexindustries.testaddon.registry;

import com.jodexindustries.donatecase.api.data.casedata.gui.CaseGui;
import com.jodexindustries.donatecase.api.data.casedata.gui.CaseGuiWrapper;
import com.jodexindustries.donatecase.api.data.casedata.gui.typeditem.TypedItemException;
import com.jodexindustries.donatecase.api.data.casedata.gui.typeditem.TypedItemHandler;
import org.jetbrains.annotations.NotNull;

public class TestTypedItemHandler implements TypedItemHandler {

    @Override
    public CaseGui.@NotNull Item handle(@NotNull CaseGuiWrapper caseGui, CaseGui.@NotNull Item item) throws TypedItemException {
        // example: HISTORY-0
        // args[0] = HISTORY
        // args[1] = 0
        String[] args = item.type().split("-");
        if(args.length >= 2) {
            if(args[1].equalsIgnoreCase("test")) {
                item.material().displayName("Test");
            }
        }

        return item;
    }
}
