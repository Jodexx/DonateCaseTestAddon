package com.jodexindustries.testaddon.boot;

import com.jodexindustries.donatecase.api.DCAPI;
import com.jodexindustries.donatecase.api.addon.Addon;
import com.jodexindustries.donatecase.api.addon.InternalJavaAddon;
import com.jodexindustries.donatecase.api.data.action.CaseAction;
import com.jodexindustries.donatecase.api.data.animation.CaseAnimation;
import com.jodexindustries.donatecase.api.data.casedata.gui.typeditem.TypedItem;
import com.jodexindustries.donatecase.api.data.material.CaseMaterial;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommand;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommandType;
import com.jodexindustries.donatecase.api.event.Subscriber;
import com.jodexindustries.donatecase.api.event.player.CaseInteractEvent;
import com.jodexindustries.donatecase.api.event.plugin.KeysTransactionEvent;
import com.jodexindustries.testaddon.registry.*;
import com.jodexindustries.testaddon.commands.FirstCommand;
import net.kyori.event.method.annotation.Subscribe;

import java.util.logging.Logger;

public class Loader implements Subscriber {

    private final DCAPI api = DCAPI.getInstance();
    private final Addon addon;

    public Loader(InternalJavaAddon addon) {
        this.addon = addon;
    }

    public void load() {
        api.getEventBus().register(this);

        api.getEventBus().register(CaseInteractEvent.class, event -> {
            if(event.action() == CaseInteractEvent.Action.RIGHT) {
                event.player().sendMessage("Right clicked!");
            } else {
                event.player().sendMessage("Left clicked!");
            }
        });

        // register subcommand
        FirstCommand executor = new FirstCommand();

        SubCommand first = SubCommand.builder()
                .name("test")
                .permission(SubCommandType.PLAYER.permission)
                .executor(executor)
                .tabCompleter(executor)
                .args(new String[]{"(test)", "(test2)"})
                .description("This is cool command!")
                .build();

        api.getSubCommandManager().register(first);

        // register animation
        api.getAnimationManager().register(
                CaseAnimation.builder()
                        .name("test")
                        .animation(TestAnimation.class)
                        .description("Here some description")
                        .build()
        );

        // register action
        api.getActionManager().register(
                CaseAction.builder()
                        .name("[test]")
                        .description("Awesome action!")
                        .executor(new TestAction()).build()
        );

        // register material
        api.getMaterialManager().register(
                CaseMaterial.builder()
                        .id("HEAD")
                        .description("Default Minecraft heads by nickname")
                        .handler(new TestMaterial())
                        .build()
        );

        // register gui item
        api.getGuiTypedItemManager().register(
                TypedItem.builder()
                        .id("TEST")
                        .description("Some cool item")
                        .handler(new TestTypedItemHandler())
                        .click(new TestTypedItemClickHandler())
                        .build()
        );
    }

    @Subscribe
    public void onTransaction(KeysTransactionEvent e) {
        Logger logger = addon.getLogger();
        logger.info("Transaction: " + e.transactionType());
        logger.info("Before: " + e.before());
        logger.info("After: " + e.after());
        logger.info("Amount: " + e.amount());
        logger.info("Player: " + e.source());
        logger.info("Case type: " + e.caseType());
    }
}
