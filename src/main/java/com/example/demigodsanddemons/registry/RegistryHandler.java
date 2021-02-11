package com.example.demigodsanddemons.registry;


import com.example.demigodsanddemons.DemigodsAndDemons;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;

public class RegistryHandler {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemigodsAndDemons.MODID);
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DemigodsAndDemons.MODID);

        public static final HashMap<String, RegistryObject> REGISTRY_HASH_MAP = new HashMap<>();


        public static void init(){


               addBlock("azurite_ore", Material.IRON, 7.0f, 6.0f, SoundType.STONE, 2, ToolType.PICKAXE, ItemGroup.BUILDING_BLOCKS);
               addBlock("azurite_block", Material.IRON, 8.0f, 6.0f, SoundType.METAL, 2, ToolType.PICKAXE, ItemGroup.BUILDING_BLOCKS);
               addBlock("umbral_iron_block", Material.IRON, 9.0f, 7.0f, SoundType.METAL, 3, ToolType.PICKAXE, ItemGroup.BUILDING_BLOCKS);
               addItem("azurite",ItemGroup.MATERIALS);
               addItem("umbral_iron_ingot", ItemGroup.MATERIALS);


               ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
               BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        }

        public static void addItem(String name, ItemGroup itemGroup){

                REGISTRY_HASH_MAP.put(name, ITEMS.register(name, () -> new Item(new Item.Properties().group(itemGroup))));


        }

        public static void addSwordItem(String name , IItemTier iItemTier, int attackDmg, float attackSpd){

            REGISTRY_HASH_MAP.put(name, ITEMS.register(name, () -> new SwordItem(iItemTier, attackDmg, attackSpd, new Item.Properties().group(ItemGroup.COMBAT))));

        }

        public static void addBlock(String name, Material material, float hardness, float resistance, SoundType soundType, int level, ToolType toolType, ItemGroup itemGroup){

                RegistryObject<Block> block = BLOCKS.register(name, () -> new Block( AbstractBlock.Properties
                        .create(material)
                        .hardnessAndResistance(hardness, resistance)
                        .sound(soundType)
                        .harvestTool(toolType).harvestLevel(level)));
                REGISTRY_HASH_MAP.put(name, block);
                REGISTRY_HASH_MAP.put(name + "_item", ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(itemGroup))));
        }


}
