package arheo.saucery.gui.container;

import arheo.saucery.blocks.tile.SaucyTile;
import arheo.saucery.blocks.tile.SaucyTileContainer;
import arheo.saucery.inventory.slot.SaucySlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public abstract class SaucyContainer<T extends SaucyTile> extends Container {
    protected final T tile;
    protected final EntityPlayer player;

    public SaucyContainer(EntityPlayer player, TileEntity tile) {
        this.tile = (T)tile;
        this.player = player;
    }

    public Slot addOwnSlot(int id, int x, int y) {
        return this.addSlotToContainer(new SaucySlot(this.tile.getItemHandler(null), id, x, y));
    }

    protected void addPlayerInventory(int x, int y) {
        for (int iy = 0; iy < 3; ++iy)
        {
            for (int ix = 0; ix < 9; ++ix)
            {
                this.addSlotToContainer(new Slot(player.inventory, ix + iy * 9 + 9, x + ix * 18, y + iy * 18));
            }
        }

        for (int ix = 0; ix < 9; ++ix)
        {
            this.addSlotToContainer(new Slot(player.inventory, ix, x + ix * 18, y + 56));
        }
    }
}
