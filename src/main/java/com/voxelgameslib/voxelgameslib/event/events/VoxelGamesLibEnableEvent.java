package com.voxelgameslib.voxelgameslib.event.events;

import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.event.VoxelGamesLibEvent;

import org.bukkit.event.HandlerList;

/**
 * Called when this plugin was enabled
 */
public class VoxelGamesLibEnableEvent extends VoxelGamesLibEvent {

    private static final HandlerList handlers = new HandlerList();

    @Nonnull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    @Nonnull
    public HandlerList getHandlers() {
        return handlers;
    }
}
