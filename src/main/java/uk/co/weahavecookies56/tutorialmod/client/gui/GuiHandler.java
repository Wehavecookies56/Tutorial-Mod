package uk.co.weahavecookies56.tutorialmod.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import uk.co.weahavecookies56.tutorialmod.container.ContainerTutorial;
import uk.co.weahavecookies56.tutorialmod.tiles.TileEntityTutorial;

import javax.annotation.Nullable;

/**
 * Created by Toby on 27/06/2017.
 */
public class GuiHandler implements IGuiHandler {

    public static final int GUI_TUTORIAL_CONTAINER_ID = 0;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

        switch (ID) {
            case GUI_TUTORIAL_CONTAINER_ID:
                return new ContainerTutorial(player.inventory, (TileEntityTutorial) te);
            default: return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

        switch (ID) {
            case GUI_TUTORIAL_CONTAINER_ID:
                return new GuiTutorialContainer(player.inventory, (TileEntityTutorial) te);
            default: return null;
        }
    }
}
