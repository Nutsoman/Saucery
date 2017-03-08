package arheo.saucery.blocks;

import arheo.saucery.Saucery;
import arheo.saucery.blocks.tile.TileCore;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockCore extends SaucyBlockWithTile<TileCore>{
    public BlockCore() {
        super(Material.ROCK, "core");
        this.registerTile(TileCore.class);
    }

    @Override
    public TileEntity createNewTileEntity(World worldin, int meta) {
        return new TileCore();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                     EnumFacing side, float hitX, float hitY, float hitZ) {
        TileCore tile = this.getTile(world, pos);
        tile.counter ++;
        Saucery.logger.info("BLERP " + tile.counter);
        return true;
    }
}
