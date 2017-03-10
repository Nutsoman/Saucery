package arheo.saucery.gui;

import arheo.saucery.blocks.tile.TileCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class GuiCore extends SaucyGuiContainer<TileCore> {
    public GuiCore(EntityPlayer player, TileEntity tile) {
        super(player, tile);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
