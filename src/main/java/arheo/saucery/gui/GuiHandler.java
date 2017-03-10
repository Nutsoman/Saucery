package arheo.saucery.gui;

import arheo.saucery.Saucery;
import arheo.saucery.gui.container.ContainerCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    public static void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Saucery.instance, new GuiHandler());
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        GuiTypes type = GuiTypes.values()[ID];
        TileEntity tile = null;
        if(type.usesTile){
            tile = world.getTileEntity(new BlockPos(x,y,z));
        }
        return type.getServer(player, tile);
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        GuiTypes type = GuiTypes.values()[ID];
        TileEntity tile = null;
        if(type.usesTile){
            tile = world.getTileEntity(new BlockPos(x,y,z));
        }
        return type.getClient(player, tile);
    }

    public enum GuiTypes {
        CORE(
                (EntityPlayer player, TileEntity tile)->new ContainerCore(player, tile),
                (EntityPlayer player, TileEntity tile)->new GuiCore(player, tile)
        );

        public final boolean usesTile;
        public final ContainerGetter container;
        public final GuiGetter gui;


        GuiTypes(ContainerGetter container, GuiGetter gui){

            this(container, gui, true);

        }
        GuiTypes(ContainerGetter container, GuiGetter gui, boolean usesTile){
            this.usesTile = usesTile;
            this.container = container;
            this.gui = gui;
        }



        public Container getServer(EntityPlayer player, TileEntity tile) { return this.container == null?null:this.container.operation(player, tile); }
        public GuiContainer getClient(EntityPlayer player, TileEntity tile) { return this.gui == null?null:this.gui.operation(player, tile); }

        private interface ContainerGetter {
            Container operation(EntityPlayer player, TileEntity tile);
        }

        private interface GuiGetter {
            GuiContainer operation(EntityPlayer player, TileEntity tile);
        }

    }

}
