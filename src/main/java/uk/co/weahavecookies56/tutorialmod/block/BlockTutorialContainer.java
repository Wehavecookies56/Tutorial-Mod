package uk.co.weahavecookies56.tutorialmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import uk.co.weahavecookies56.tutorialmod.TutorialMod;
import uk.co.weahavecookies56.tutorialmod.client.gui.GuiHandler;
import uk.co.weahavecookies56.tutorialmod.tiles.TileEntityTutorial;

import javax.annotation.Nullable;

/**
 * Created by Toby on 27/06/2017.
 */
public class BlockTutorialContainer extends Block implements ITileEntityProvider {

    public BlockTutorialContainer(Material materialIn, String name) {
        super(materialIn);
        setCreativeTab(TutorialMod.tabTutorial);
        setUnlocalizedName(name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityTutorial te = (TileEntityTutorial) world.getTileEntity(pos);
        if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
            player.openGui(TutorialMod.instance, GuiHandler.GUI_TUTORIAL_CONTAINER_ID, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityTutorial te = (TileEntityTutorial) world.getTileEntity(pos);
        if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
            IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
            if (inventory != null) {
                for (int i = 0; i < inventory.getSlots(); i++) {
                    if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
                        EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

                        float multiplier = 0.1f;
                        float motionX = world.rand.nextFloat() - 0.5f;
                        float motionY = world.rand.nextFloat() - 0.5f;
                        float motionZ = world.rand.nextFloat() - 0.5f;

                        item.motionX = motionX * multiplier;
                        item.motionY = motionY * multiplier;
                        item.motionZ = motionZ * multiplier;

                        world.spawnEntity(item);
                    }
                }
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTutorial();
    }
}
