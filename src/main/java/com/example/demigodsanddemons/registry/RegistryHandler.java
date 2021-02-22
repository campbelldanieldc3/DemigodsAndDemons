package com.example.demigodsanddemons.registry;


import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.world.DDConfiguredSurfaceBuilders;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.function.Supplier;

public class RegistryHandler {
        public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DemigodsAndDemons.MODID);

        public static void init(){

            DDConfiguredSurfaceBuilders.register();

               addBiome("elderwood_forest");

               BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());

        }

//        public static void addSwordItem(String name , IItemTier iItemTier, int attackDmg, float attackSpd){
//
//            REGISTRY_HASH_MAP.put(name, ITEMS.register(name, () -> new SwordItem(iItemTier, attackDmg, attackSpd, new Item.Properties().group(ItemGroup.COMBAT))));
//
//        }

        public static void addBiome(String name){

            BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder().withSurfaceBuilder(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER.getOrThrow(DDConfiguredSurfaceBuilders.ELDERWOOD_FOREST));

            DefaultBiomeFeatures.withForestGrass(generationSettingsBuilder);
            DefaultBiomeFeatures.withCavesAndCanyons(generationSettingsBuilder);
            DefaultBiomeFeatures.withOverworldOres(generationSettingsBuilder);
            DefaultBiomeFeatures.withTallBirches(generationSettingsBuilder);



            Biome b = new Biome.Builder()
                    .withGenerationSettings(generationSettingsBuilder.build())
                    .category(Biome.Category.FOREST)
                    .temperature(0.5f)
                    .setEffects(new BiomeAmbience.Builder()
                            .withGrassColor(0x449382)
                            .setWaterColor(0x88c4e0)
                            .setFogColor(0xffffff)
                            .setWaterFogColor(0xb5d6e5)
                            .withSkyColor(0xb8a9fc).build())
                    .precipitation(Biome.RainType.RAIN)
                    .depth(0.125f)
                    .scale(0.5f)
                    .withMobSpawnSettings(MobSpawnInfo.EMPTY)
                    .downfall(0.3f)
                    .build();


            BIOMES.register(name, () -> b);



        }
        @Mod.EventBusSubscriber(modid = DemigodsAndDemons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class RegHandler{
            @SubscribeEvent
            public static void biomeSetup(FMLCommonSetupEvent event){

                event.enqueueWork(() -> {
                    RegistryKey<Biome> ELDERWOOD = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, new ResourceLocation(DemigodsAndDemons.MODID, "elderwood_forest"));
                    System.err.println(ELDERWOOD.getRegistryName() + " " + ELDERWOOD.getLocation());
                    BiomeDictionary.addTypes(ELDERWOOD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
                    BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(ELDERWOOD, 10));

                });

            }


        }


}
