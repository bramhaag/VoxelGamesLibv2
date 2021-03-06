package com.voxelgameslib.voxelgameslib.components.map;

import com.google.gson.annotations.Expose;

import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.internal.math.Vector3D;

import org.bukkit.inventory.ItemStack;

/**
 * A chest marker is a marker that is a chest (uh)<br> it is used to save kits or layout for chest locations in the map
 */
public class ChestMarker extends Marker {

    @Nonnull
    @Expose
    private final ItemStack[] items;

    /**
     * constructs a new chest marker
     *
     * @param loc   the location that his marker is at in the world
     * @param name  the name of this chest marker (the name of the inventory)
     * @param items the items that ar in that chest
     */
    public ChestMarker(@Nonnull Vector3D loc, @Nonnull String name, @Nonnull ItemStack[] items) {
        super(loc, 0.0, name, null);//TODO mark def for chest marker
        this.items = items;
    }

    /**
     * @return the items that are in this chest
     */
    @Nonnull
    public ItemStack[] getItems() {
        return items;
    }
}
