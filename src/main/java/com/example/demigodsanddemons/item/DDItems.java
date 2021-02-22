package com.example.demigodsanddemons.item;

import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.block.DDBlocks;
import com.example.demigodsanddemons.potion.DDEffects;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DDItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemigodsAndDemons.MODID);

    public static final RegistryObject<Item> ALTAR_BLOCK_ITEM = ITEMS.register(
            "altar_block", () -> new BlockItem(DDBlocks.ALTAR_BLOCK.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    );
    public static final RegistryObject<Item> AZURITE_ORE_ITEM = ITEMS.register(
            "azurite_ore", () -> new BlockItem(DDBlocks.AZURITE_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    );
    public static final RegistryObject<Item> AZURITE_BLOCK_ITEM = ITEMS.register(
            "azurite_block", () -> new BlockItem(DDBlocks.AZURITE_BLOCK.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    );
    public static final RegistryObject<Item> UMBRAL_IRON_BLOCK_ITEM = ITEMS.register(
            "umbral_iron_block", () -> new BlockItem(DDBlocks.UMBRAL_IRON_BLOCK.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    );
    public static final RegistryObject<Item> AZURITE = ITEMS.register(
            "azurite", () -> new Item(
                    new Item.Properties().group(ItemGroup.MATERIALS))
    );
    public static final RegistryObject<Item> UMBRAL_IRON_INGOT = ITEMS.register(
            "umbral_iron_ingot", () -> new Item(
                    new Item.Properties().group(ItemGroup.MATERIALS))
    );
    public static final RegistryObject<Item> AMBROSIA = ITEMS.register(
            "ambrosia", () -> new Item(
                    new Item.Properties().group(ItemGroup.FOOD)
                            .food(new Food.Builder()
                                    .hunger(20)
                                    .saturation(.5f)
                                    .setAlwaysEdible()
                                    .effect(() -> new EffectInstance(DDEffects.MORTALITY.get()), 1)
                                    .build()
                            )
            )
    );



     public static void init(){

         ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

     }
}
