package arheo.saucery.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public abstract class SaucyContainer<T extends TileEntity> extends Container {
    protected final T tile;
    protected final EntityPlayer player;
    public SaucyContainer(EntityPlayer player, TileEntity tile) {
        this.tile = (T)tile;
        this.player = player;
    }

}
