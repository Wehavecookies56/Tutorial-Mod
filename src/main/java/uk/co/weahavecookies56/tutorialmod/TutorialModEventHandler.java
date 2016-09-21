package uk.co.weahavecookies56.tutorialmod;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import uk.co.weahavecookies56.tutorialmod.item.ModItems;

/**
 * Created by Toby on 21/09/2016.
 */
public class TutorialModEventHandler {

    @SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            player.inventory.addItemStackToInventory(new ItemStack(Items.IRON_SHOVEL));
        }
    }

    @SubscribeEvent
    public void livingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof EntityMob) {
            event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(ModItems.tutorialItem)));
        }
    }

    @SubscribeEvent
    public void livingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if (player.getHeldItemMainhand() != null) {
                if (player.getHeldItemMainhand().getItem() == Items.APPLE) {
                    event.setAmount(10);
                    event.getEntity().setFire(10);
                }
            }
        }
    }

    @SubscribeEvent
    public void itemPickup(PlayerEvent.ItemPickupEvent event) {
        if (event.pickedUp.getEntityItem().getItem() == Items.DIAMOND) {
            event.player.setFire(5);
            event.player.inventory.clear();
        }
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            if (player.getHeldItemMainhand() != null) {
                if (player.getHeldItemMainhand().getItem() == Items.APPLE) {
                    player.setFire(5);
                }
            }
        }
    }

    @SubscribeEvent
    public void itemTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() == Items.APPLE) {
            event.getToolTip().add("Flaming Apple");
        }
    }

    @SubscribeEvent
    public void breakEvent(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() == Blocks.DIRT) {
            event.setExpToDrop(10);
            BlockPos pos = event.getPos();
            event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DIAMOND)));
        }
    }

}
