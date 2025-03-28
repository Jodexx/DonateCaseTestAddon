package com.jodexindustries.testaddon.boot;

import com.jodexindustries.donatecase.api.DCAPI;
import com.jodexindustries.donatecase.api.addon.InternalJavaAddon;
import com.jodexindustries.donatecase.api.data.casedata.gui.typeditem.TypedItem;
import com.jodexindustries.testaddon.registry.TestTypedItemClickHandler;
import com.jodexindustries.testaddon.registry.TestTypedItemHandler;

public class MainAddon extends InternalJavaAddon {
    private Loader loader;

    private final DCAPI api = DCAPI.getInstance();

    @Override
    public void onLoad() {
        loader = new Loader(this);
    }

    @Override
    public void onEnable() {
        loader.load();

        api.getGuiTypedItemManager().register(
                TypedItem.builder()
                        .id("TEST")
                        .description("Some cool item")
                        .handler(new TestTypedItemHandler())
                        .click(new TestTypedItemClickHandler())
                        .build()
        );
    }
}