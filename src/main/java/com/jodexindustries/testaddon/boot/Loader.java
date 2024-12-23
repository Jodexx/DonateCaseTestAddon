package com.jodexindustries.testaddon.boot;

import com.jodexindustries.donatecase.api.DCAPIBukkit;
import com.jodexindustries.donatecase.api.addon.Addon;
import com.jodexindustries.donatecase.api.addon.external.ExternalJavaAddon;
import com.jodexindustries.donatecase.api.addon.internal.InternalJavaAddon;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommand;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommandType;
import com.jodexindustries.donatecase.api.events.KeysTransactionEvent;
import com.jodexindustries.donatecase.api.manager.ActionManager;
import com.jodexindustries.donatecase.api.manager.MaterialManager;
import com.jodexindustries.donatecase.api.manager.SubCommandManager;
import com.jodexindustries.testaddon.registry.*;
import com.jodexindustries.testaddon.commands.FirstCommand;
import com.jodexindustries.testaddon.commands.SecondCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Loader implements Listener {
    private final DCAPIBukkit api;
    private final Plugin plugin;
    private final Addon addon;


    public Loader(JavaPlugin plugin) {
        this.addon = new ExternalJavaAddon(plugin);
        this.api = DCAPIBukkit.get(plugin);
        this.plugin = plugin;
    }

    public Loader(InternalJavaAddon addon) {
        this.addon = addon;
        this.api = DCAPIBukkit.get(addon);
        this.plugin = api.getDonateCase();
    }

    public void load() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);

        // register subcommands

        // the first method of registering subcommand
        SubCommandManager<CommandSender> subCommandManager = api.getSubCommandManager();
        FirstCommand executor = new FirstCommand();

        SubCommand<CommandSender> first = subCommandManager.builder("test")
                .permission(SubCommandType.PLAYER.permission)
                .executor(executor)
                .tabCompleter(executor)
                .args(new String[]{"(test)", "(test2)"})
                .description("This is cool command!")
                .build();

        subCommandManager.registerSubCommand(first);

        // the second method of registering subcommand
        SecondCommand second = new SecondCommand("test2", api.getAddon());
        subCommandManager.registerSubCommand(second);

        // register animation
        api.getAnimationManager().registerAnimation(
                api.getAnimationManager().builder("test")
                        .animation(TestAnimation.class)
                        .description("Here some description")
                        .build()
        );

        // register action
        ActionManager<Player> actionManager = api.getActionManager();
        actionManager.registerAction("[test]", new TestAction(), "Awesome action!");

        MaterialManager<ItemStack> materialManager = api.getMaterialManager();
        materialManager.registerMaterial("HEAD", new TestMaterial(), "Default Minecraft heads by nickname");

        api.getGuiTypedItemManager().registerItem(
                api.getGuiTypedItemManager().builder("TEST")
                        .description("Some cool item")
                        .handler(new TestTypedItemHandler())
                        .click(new TestTypedItemClickHandler())
                        .build()
        );
    }

    public void unload() {
        // unregister subcommands
        api.getSubCommandManager().unregisterSubCommand("test");
        api.getSubCommandManager().unregisterSubCommand("test2");
        // unregister animation
        api.getAnimationManager().unregisterAnimation("test");
        // unregister action
        api.getActionManager().unregisterAction("[test]");
    }

    @EventHandler
    public void onTransaction(KeysTransactionEvent e) {
        Logger logger = addon.getLogger();
        logger.info("Transaction: " + e.type());
        logger.info("Before: " + e.before());
        logger.info("After: " + e.after());
        logger.info("Amount: " + e.amount());
        logger.info("Player: " + e.playerName());
        logger.info("Case type: " + e.caseType());
    }
}
