package arheo.saucery;

import arheo.saucery.gui.GuiHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event)
    {
        SaucyBlocks.init();
    }

    public void init(FMLInitializationEvent event)
    {
        GuiHandler.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
