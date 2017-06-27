package uk.co.weahavecookies56.tutorialmod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import uk.co.weahavecookies56.tutorialmod.TutorialMod;
import uk.co.weahavecookies56.tutorialmod.container.ContainerTutorial;
import uk.co.weahavecookies56.tutorialmod.tiles.TileEntityTutorial;

import java.awt.*;

/**
 * Created by Toby on 27/06/2017.
 */
public class GuiTutorialContainer extends GuiContainer {

    private static final ResourceLocation texture = new ResourceLocation(TutorialMod.MODID, "textures/gui/container.png");

    public GuiTutorialContainer(InventoryPlayer player, TileEntityTutorial tileEntityTutorial) {
        super(new ContainerTutorial(player, tileEntityTutorial));
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString(new TextComponentTranslation("tile.tutorial_container.name").getFormattedText(), 5, 5, Color.darkGray.getRGB());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
