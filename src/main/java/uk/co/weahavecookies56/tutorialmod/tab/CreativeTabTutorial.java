package uk.co.weahavecookies56.tutorialmod.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Toby on 18/08/2016.
 */
public class CreativeTabTutorial extends CreativeTabs {

    public CreativeTabTutorial(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.EMERALD);
    }
}
