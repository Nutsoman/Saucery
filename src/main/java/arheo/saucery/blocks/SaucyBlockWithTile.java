package arheo.saucery.blocks;

import arheo.saucery.Saucery;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class SaucyBlockWithTile<T extends TileEntity> extends SaucyBlock implements ITileEntityProvider {
    public SaucyBlockWithTile(Material mat, String name) {
        super(mat, name);
    }

    public T getTile(World world, BlockPos pos) {
        return (T)world.getTileEntity(pos);
    }

    public void registerTile(Class<? extends T> clazz) {
        GameRegistry.registerTileEntity(clazz, Saucery.MODID +"_"+this.getRegistryName());
    }

}
