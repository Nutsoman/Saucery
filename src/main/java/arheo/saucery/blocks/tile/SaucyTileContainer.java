package arheo.saucery.blocks.tile;

import arheo.saucery.inventory.SaucyItemStackHandler;
import arheo.saucery.inventory.TileItemStackHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SaucyTileContainer extends SaucyTile implements SaucyItemStackHandler.IProvider {
    public final ItemStackHandler inventory;

    public SaucyTileContainer(int slots) {
        super();
        inventory = this.createItemHandler(slots);
    }

    protected ItemStackHandler createItemHandler(int slots) {
        return new TileItemStackHandler(this, slots);
    }

    @Override
    public void readCustomNBT(NBTTagCompound tag) {
        this.readInventory(tag);
    }

    @Override
    public void writeCustomNBT(NBTTagCompound tag) {
        this.writeInventory(tag);
    }

    public void writeInventory(NBTTagCompound tag) {
        SaucyItemStackHandler.writeInventory(this.inventory, tag);
    }

    public void readInventory(NBTTagCompound tag) {
        SaucyItemStackHandler.readInventory(this.inventory, tag);
    }

    @Override
    public IItemHandler getItemHandler(EnumFacing facing) {
        return inventory;
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

}

