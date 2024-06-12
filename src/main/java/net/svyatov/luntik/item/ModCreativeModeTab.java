package net.svyatov.luntik.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab LUNTIK_TAB = new CreativeModeTab("Luntik tab"){
        @Override
        public ItemStack makeIcon(){
            return new ItemStack(ModItems.LUNTIK.get());
        }
    };
}
