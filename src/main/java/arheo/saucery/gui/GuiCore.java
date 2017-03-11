package arheo.saucery.gui;

import arheo.saucery.blocks.tile.TileCore;
import arheo.saucery.gui.container.ContainerCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class GuiCore extends SaucyGuiContainer<TileCore, ContainerCore> {
    public GuiCore(EntityPlayer player, TileEntity tile, Container container) {
        super(player, tile, container);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
