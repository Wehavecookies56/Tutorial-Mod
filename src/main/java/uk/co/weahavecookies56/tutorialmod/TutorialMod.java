package uk.co.weahavecookies56.tutorialmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import uk.co.weahavecookies56.tutorialmod.block.ModBlocks;
import uk.co.weahavecookies56.tutorialmod.client.gui.GuiHandler;
import uk.co.weahavecookies56.tutorialmod.client.gui.GuiOverlayTutorial;
import uk.co.weahavecookies56.tutorialmod.item.ModItems;
import uk.co.weahavecookies56.tutorialmod.proxy.CommonProxy;
import uk.co.weahavecookies56.tutorialmod.tab.CreativeTabTutorial;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION, name = TutorialMod.NAME)
public class TutorialMod {
    public static final String MODID = "tutorialmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Tutorial Mod";

    @SidedProxy(clientSide = "uk.co.weahavecookies56.tutorialmod.proxy.ClientProxy", serverSide = "uk.co.weahavecookies56.tutorialmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static TutorialMod instance;

    public static CreativeTabTutorial tabTutorial;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabTutorial = new CreativeTabTutorial(CreativeTabs.getNextID(), "tab_tutorial");
        ModItems.preInit();
        ModBlocks.preInit();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new TutorialModEventHandler());
        MinecraftForge.EVENT_BUS.register(new GuiOverlayTutorial());
        proxy.postInit(event);
    }
}
