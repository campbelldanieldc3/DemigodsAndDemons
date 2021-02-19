package com.example.demigodsanddemons.registry;


import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.block.AltarBlock;
import com.example.demigodsanddemons.potion.DDEffects;
import com.example.demigodsanddemons.world.DDConfiguredSurfaceBuilders;
import com.example.demigodsanddemons.world.ModBiome;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.data.BiomeProvider;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.function.Supplier;

public class RegistryHandler {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemigodsAndDemons.MODID);
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DemigodsAndDemons.MODID);
        public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DemigodsAndDemons.MODID);
        public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, DemigodsAndDemons.MODID);

        public static final HashMap<String, RegistryObject> REGISTRY_HASH_MAP = new HashMap<>();


        //private static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> ELDERWOOD_SURFACE_BUILDER = Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(DemigodsAndDemons.MODID, "elderwood_forest"), SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);

        public static void init(){

            DDConfiguredSurfaceBuilders.register();
               addBlock("azurite_ore", Material.IRON, 7.0f, 6.0f, SoundType.STONE, 2, ToolType.PICKAXE, ItemGroup.BUILDING_BLOCKS);
               addBlock("azurite_block", Material.IRON, 8.0f, 6.0f, SoundType.METAL, 2, ToolType.PICKAXE, ItemGroup.BUILDING_BLOCKS);
               addBlock("umbral_iron_block", Material.IRON, 9.0f, 7.0f, SoundType.METAL, 3, ToolType.PICKAXE, ItemGroup.BUILDING_BLOCKS);
               RegistryObject<Block> altar_block = BLOCKS.register("altar_block", AltarBlock::new);
               ITEMS.register("altar_block",
                       () -> new BlockItem(
                               altar_block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
                       ));
               addItem("azurite",ItemGroup.MATERIALS);
               addItem("umbral_iron_ingot", ItemGroup.MATERIALS);
               addFood("ambrosia", ItemGroup.FOOD, 10, .5f);
               addBiome("elderwood_forest");

               ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
               BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
               BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());

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
                        .setRequiresTool()
                        .harvestTool(toolType).harvestLevel(level)));
                REGISTRY_HASH_MAP.put(name, block);
                REGISTRY_HASH_MAP.put(name + "_item", ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(itemGroup))));
        }

        public static void addFood(String name, ItemGroup itemGroup, int hunger, float saturation){

            REGISTRY_HASH_MAP.put(name, ITEMS.register(name, () -> new Item(
                    new Item.Properties()
                            .group(itemGroup)
                            .food(new Food.Builder()
                                    .hunger(hunger)
                                    .effect(() -> new EffectInstance(DDEffects.MORTALITY.get()), 1)
                                    .saturation(saturation).setAlwaysEdible()
                                    .build()))));
        }

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
