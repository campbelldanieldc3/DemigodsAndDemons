package com.example.demigodsanddemons.block;

import com.example.demigodsanddemons.DemigodsAndDemons;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DDBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DemigodsAndDemons.MODID);


    public static final RegistryObject<Block> ALTAR_BLOCK = BLOCKS.register(
            "altar_block", AltarBlock::new);

    public static final RegistryObject<Block> AZURITE_ORE = BLOCKS.register(
            "azurite_ore", () -> new Block( AbstractBlock.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(7.0f, 6.0f)
                    .sound(SoundType.BASALT)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE).harvestLevel(2))
    );
    public static final RegistryObject<Block> AZURITE_BLOCK = BLOCKS.register(
            "azurite_block", () -> new Block( AbstractBlock.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(8.0f, 6.0f)
                    .sound(SoundType.METAL)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE).harvestLevel(2))
    );
    public static final RegistryObject<Block> UMBRAL_IRON_BLOCK = BLOCKS.register(
            "umbral_iron_block", () -> new Block( AbstractBlock.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(9.0f, 7.0f)
                    .sound(SoundType.METAL)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE).harvestLevel(3))
    );

    public static void init(){

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

//    private RegistryObject<Block> register(String name, Material material, float hardness, float resistance){
//
//
//        return null;
//    }

}
