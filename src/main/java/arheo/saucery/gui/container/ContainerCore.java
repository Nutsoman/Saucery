package arheo.saucery.gui.container;

import arheo.saucery.blocks.tile.TileCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCore extends SaucyContainer<TileCore> {

    public ContainerCore(EntityPlayer player, TileEntity tile) {
        super(player, tile);

        TileCore tcore = this.tile;

        this.addOwnSlot(0, 50,50);

        this.addPlayerInventory(8,84);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tile.isUsableByPlayer(playerIn);
    }
}
