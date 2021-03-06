package com.voxelgameslib.voxelgameslib.api.stats;

import org.hibernate.annotations.Type;

import java.util.UUID;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.voxelgameslib.voxelgameslib.api.event.events.player.PlayerDecrementStatEvent;
import com.voxelgameslib.voxelgameslib.api.event.events.player.PlayerIncrementStatEvent;
import com.voxelgameslib.voxelgameslib.components.user.User;
import com.voxelgameslib.voxelgameslib.internal.persistence.converter.TrackableConverter;

@Entity
@Table(name = "stat")
public class StatInstance {

    @Transient
    private User user;
    @Transient
    private boolean dirty = false;

    @Id
    @GeneratedValue
    private long id;
    @Type(type = "uuid-char")
    private UUID uuid;
    private double val;
    @Convert(converter = TrackableConverter.class)
    private Trackable statType;

    protected StatInstance() {
    }

    public StatInstance(User user, Trackable statType, double val) {
        this.user = user;
        this.uuid = user.getUuid();
        this.statType = statType;
        this.val = val;
    }

    public void increment() {
        increment(1);
    }

    public void increment(double val) {
        PlayerIncrementStatEvent event = new PlayerIncrementStatEvent(getUser(), statType, this.val, this.val + val, val);
        if (event.callEvent()) {
            this.val = event.getNewVal();
            dirty = true;
        }
    }

    public void decrement() {
        decrement(1);
    }

    public void decrement(double val) {
        PlayerDecrementStatEvent event = new PlayerDecrementStatEvent(getUser(), statType, this.val, this.val - val, val);
        if (event.callEvent()) {
            this.val = event.getNewVal();
            dirty = true;
        }
    }

    public double getVal() {
        return val;
    }

    public void setVal(double amount) {
        this.val = amount;
        dirty = true;
    }

    public boolean isDirty() {
        return dirty;
    }

    public User getUser() {
        if (user == null) {
            user = statType.getUser(uuid);
        }
        return user;
    }
}
