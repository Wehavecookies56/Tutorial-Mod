package uk.co.weahavecookies56.tutorialmod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.weahavecookies56.tutorialmod.TutorialMod;

/**
 * Created by Toby on 11/02/2017.
 */
public class GuiOverlayTutorial extends Gui {

    private final ResourceLocation bar = new ResourceLocation(TutorialMod.MODID, "textures/gui/hpbar.png");
    private final int tex_width = 102, tex_height = 8, bar_width = 100, bar_height = 6;

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();
            mc.renderEngine.bindTexture(bar);
            float oneUnit = (float)bar_width / mc.player.getMaxHealth();
            int currentWidth = (int)(oneUnit * mc.player.getHealth());
            System.out.println((int)mc.player.getHealth());
            drawTexturedModalRect(0, 0, 0, 0, tex_width, tex_height);
            drawTexturedModalRect(1, 0, 1, tex_height, currentWidth, tex_height);
        }
    }

}
