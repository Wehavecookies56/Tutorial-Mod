package uk.co.weahavecookies56.tutorialmod.container;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

/**
 * Created by Toby on 27/06/2017.
 */
public class SlotTutorial extends SlotItemHandler {

    public SlotTutorial(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        if (stack.getItem() == Items.IRON_SHOVEL) {
            return true;
        } else {
            return false;
        }
    }

}
