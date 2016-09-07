package uk.co.weahavecookies56.tutorialmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.weahavecookies56.tutorialmod.TutorialMod;
import uk.co.weahavecookies56.tutorialmod.item.ItemTutorialItem;

/**
 * Created by Toby on 24/08/2016.
 */
public class ModBlocks {

    public static Block tutorialBlock;

    public static void preInit() {

        tutorialBlock = new BlockTutorialBlock(Material.ROCK, "tutorial_block");

        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(tutorialBlock, "tutorial_block");
    }

    public static void registerBlock(Block block, String name) {
        GameRegistry.register(block, new ResourceLocation(TutorialMod.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(TutorialMod.MODID, name));
    }

    public static void registerRenders() {
        registerRender(tutorialBlock);
    }

    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(TutorialMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
