package com.jodexindustries.testaddon.registry;

import com.jodexindustries.donatecase.api.data.casedata.gui.TypedItemClickHandler;
import com.jodexindustries.donatecase.api.events.CaseGuiClickEvent;
import org.jetbrains.annotations.NotNull;

public class TestTypedItemClickHandler implements TypedItemClickHandler<CaseGuiClickEvent> {
    @Override
    public void onClick(@NotNull CaseGuiClickEvent event) {
        // execute on click actions
    }
}
