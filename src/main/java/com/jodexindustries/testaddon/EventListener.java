package com.jodexindustries.testaddon;

import com.jodexindustries.donatecase.api.event.Subscriber;
import com.jodexindustries.donatecase.api.event.player.CaseInteractEvent;
import net.kyori.event.method.annotation.Subscribe;

public class EventListener implements Subscriber {

    @Subscribe
    public void onCaseInteract(CaseInteractEvent event) {
        if(event.action() == CaseInteractEvent.Action.RIGHT) {
            event.player().sendMessage("Right clicked!");
        } else {
            event.player().sendMessage("Left clicked!");
        }
    }
}
