package arheo.saucery.gui.container;

import arheo.saucery.blocks.tile.TileCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class ContainerCore extends SaucyContainer<TileCore> {

    public ContainerCore(EntityPlayer player, TileEntity tile) {
        super(player, tile);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tile.isUsableByPlayer(playerIn);
    }
}
