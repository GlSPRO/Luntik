package net.svyatov.luntik.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.svyatov.luntik.item.ModCreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.svyatov.luntik.Luntik;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Luntik.MOD_ID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> LUNTIK = ITEMS.register("luntik",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LUNTIK_TAB)));

    public static final RegistryObject<Item> POOPSEN = ITEMS.register("poopsen",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LUNTIK_TAB)));

    public static final RegistryObject<Item> SHISHKA = ITEMS.register("shishka",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LUNTIK_TAB)));

    public static final RegistryObject<Item> PIVO = ITEMS.register("pivo",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LUNTIK_TAB)));


}

