package arheo.saucery;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = Saucery.MODID, version = Saucery.VERSION)
public class Saucery
{
    public static final String MODID = "saucery";
    public static final String VERSION = "0.0.0.1";

    public static final Logger logger = LogManager.getLogger(MODID);


    @Mod.Instance(MODID)
    public static Saucery instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
