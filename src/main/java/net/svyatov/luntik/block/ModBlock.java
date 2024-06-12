package net.svyatov.luntik.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.svyatov.luntik.Luntik;
import net.svyatov.luntik.item.ModCreativeModeTab;
import net.svyatov.luntik.item.ModItems;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Luntik.MOD_ID);
    public static final RegistryObject<Block> DRAWING_BLOCK = registryBlock( "drawing_block",
            () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .strength( 3f).requiresCorrectToolForDrops()
            ), ModCreativeModeTab.LUNTIK_TAB);
    public static final RegistryObject<Block> CUSTOM_LAVA_BLOCK = registryBlock("custom_lava_block",
            () -> new LiquidBlock(() -> net.minecraft.world.level.material.Fluids.LAVA,
                    BlockBehaviour.Properties.of(Material.LAVA, MaterialColor.COLOR_ORANGE)
                            .strength(100.0F)
                            .noCollission()
                            .lightLevel((state) -> 15)
                            .noOcclusion()),
            ModCreativeModeTab.LUNTIK_TAB);
    public static final RegistryObject<Block> GLOWING_WATER_BLOCK = registryBlock("glowing_water_block",
            () -> new LiquidBlock(() -> net.minecraft.world.level.material.Fluids.WATER,
                    BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_BLUE)
                            .strength(100.0F)
                            .noCollission()
                            .lightLevel((state) -> 15)
                            .noOcclusion()),
            ModCreativeModeTab.LUNTIK_TAB);
    public static final RegistryObject<Block> CUSTOM_GLASS_BLOCK = registryBlock("custom_glass_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(0.3f)
                    .noOcclusion()
                    .isValidSpawn((state, world, pos, entityType) -> false)
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)),
            ModCreativeModeTab.LUNTIK_TAB);


    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    public static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                        CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}

