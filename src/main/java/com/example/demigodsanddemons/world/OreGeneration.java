package com.example.demigodsanddemons.world;

import com.example.demigodsanddemons.registry.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;

public class OreGeneration {


    public static void generateOres(final BiomeLoadingEvent biomeLoadingEvent){

        if(!biomeLoadingEvent.getCategory().equals(Biome.Category.NETHER) || !biomeLoadingEvent.getCategory().equals(Biome.Category.THEEND)){

            GenerateOre(biomeLoadingEvent, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.REGISTRY_HASH_MAP.get("azurite_ore"), 5, 10, 0, 40, 1);

        }

        //if(biomeLoadingEvent.getCategory().equals(Biome.Category.NETHER))

    }
    private static void GenerateOre(BiomeLoadingEvent biomeLoadingEvent, RuleTest filler, RegistryObject<Block> state, int veinsize, int bottomRange, int offset, int topRange, int amount){

        biomeLoadingEvent.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(new OreFeatureConfig(filler, state.get().getDefaultState(), veinsize)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(bottomRange, offset, topRange))).square().func_242731_b(amount));


    }

}
