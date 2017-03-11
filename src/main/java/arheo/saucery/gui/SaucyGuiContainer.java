package arheo.saucery.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public abstract class SaucyGuiContainer<T extends TileEntity, C extends Container> extends GuiContainer {
    protected final T tile;
    protected final EntityPlayer player;
    protected final C container;
    public SaucyGuiContainer(EntityPlayer player, TileEntity tile, Container container) {
        super(container);
        this.tile = (T)tile;
        this.player = player;
        this.container = (C)container;
    }
}
