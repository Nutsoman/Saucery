package arheo.saucery.blocks.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileCore extends SaucyTile {

    public int counter = 0;

    @Override
    public void readCustomNBT(NBTTagCompound tag) {
        counter = tag.getInteger("counter");
    }

    @Override
    public void writeCustomNBT(NBTTagCompound tag) {
        tag.setInteger("counter", counter);
    }
}
