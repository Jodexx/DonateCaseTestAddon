package com.jodexindustries.testaddon.commands;

import com.jodexindustries.donatecase.api.data.subcommand.SubCommandExecutor;
import com.jodexindustries.donatecase.api.data.subcommand.SubCommandTabCompleter;
import com.jodexindustries.donatecase.api.platform.DCCommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FirstCommand implements SubCommandExecutor, SubCommandTabCompleter {

    @Override
    public boolean execute(DCCommandSender sender, @NotNull String label, String[] args) {
        sender.sendMessage("First command");
        return true;
    }

    @Override
    public List<String> getTabCompletions(@NotNull DCCommandSender sender, @NotNull String label, String[] args) {
        return new ArrayList<>();
    }

}
