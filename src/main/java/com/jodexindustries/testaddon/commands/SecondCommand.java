package com.jodexindustries.testaddon.commands;

import com.jodexindustries.donatecase.api.addon.Addon;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommand;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommandExecutor;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommandTabCompleter;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommandType;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class SecondCommand extends SubCommand<CommandSender> {

    public SecondCommand(String name, Addon addon) {
        super(name, addon);
    }

    @Override
    public String getDescription() {
        return "This is a second command";
    }

    @Override
    public String getPermission() {
        return SubCommandType.PLAYER.permission;
    }

    @Override
    public String[] getArgs() {
        return new String[]{"(test)", "(test2)"};
    }

    @Override
    public SubCommandExecutor<CommandSender> getExecutor() {
        return (sender, label, args) -> sender.sendMessage("Second command");
    }

    @Override
    public SubCommandTabCompleter<CommandSender> getTabCompleter() {
        return (sender, label, args) -> new ArrayList<>();
    }

}
