package arheo.saucery;


import arheo.saucery.blocks.BlockCore;
import arheo.saucery.blocks.SaucyBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SaucyBlocks {
    public static SaucyBlock blockone;
    public static BlockCore blockcore;

    public static void init() {
        blockone = new SaucyBlock(Material.CAKE, "saucyblock");
        blockcore = new BlockCore();
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        blockone.initModel();
        blockcore.initModel();
    }
}
