package arheo.saucery.blocks;

import arheo.saucery.Saucery;
import arheo.saucery.blocks.renderer.RecipeRenderer;
import arheo.saucery.blocks.tile.TileCore;
import arheo.saucery.gui.GuiHandler;
import arheo.saucery.gui.GuiHandler.GuiTypes;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCore extends SaucyBlockWithTile<TileCore>{

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);

    public BlockCore() {
        super(Material.ROCK, "core");
        this.registerTile(TileCore.class);
        this.setLightOpacity(0);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldin, int meta) {
        return new TileCore();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                     EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            GuiHandler.openGui(player, world, GuiTypes.CORE, pos);
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel() {
        super.initModel();
        ClientRegistry.bindTileEntitySpecialRenderer(TileCore.class, new RecipeRenderer());
    }



}
