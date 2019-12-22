package me.TheJokerDev.troll.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class IBlock
{
    private Location location;
    private int material;
    private byte data;

    public IBlock(Block block)
    {
        this.location = block.getLocation();
        this.material = block.getTypeId();
        this.data = block.getData();
    }

    public Location getLoc()
    {
        return this.location;
    }

    public int getType()
    {
        return this.material;
    }

    public byte getData()
    {
        return this.data;
    }
}
