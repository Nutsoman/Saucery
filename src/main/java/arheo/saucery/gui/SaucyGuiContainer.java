package arheo.saucery.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public abstract class SaucyGuiContainer<T extends TileEntity> extends GuiContainer {
    protected final T tile;
    protected final EntityPlayer player;
    public SaucyGuiContainer(EntityPlayer player, TileEntity tile) {
        super(player.inventoryContainer);
        this.tile = (T)tile;
        this.player = player;

    }
}
