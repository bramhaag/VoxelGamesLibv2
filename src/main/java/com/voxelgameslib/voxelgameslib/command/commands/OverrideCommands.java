package com.voxelgameslib.voxelgameslib.command.commands;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import lombok.extern.java.Log;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;

/**
 * This class overrides core Bukkit commands as necessary.
 */
@Singleton
@Log
@SuppressWarnings("JavaDoc") // commands don't need javadoc, go read the command's descriptions
public class OverrideCommands extends BaseCommand {

    @CommandAlias("reload|rl")
    @CommandPermission("bukkit.command.reload") // don't change the access for this command
    public void reload(@Nonnull CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "This command has been disabled by VoxelGamesLib, as it will break the framework from functioning.");
    }
}
