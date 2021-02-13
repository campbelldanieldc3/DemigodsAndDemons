package com.example.demigodsanddemons.world;

import com.example.demigodsanddemons.DemigodsAndDemons;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DDConfiguredSurfaceBuilders {


    private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    private static final BlockState GRASS = Blocks.GRASS_BLOCK.getDefaultState();
    public static RegistryKey<ConfiguredSurfaceBuilder<?>> ELDERWOOD_FOREST = RegistryKey.getOrCreateKey(
            Registry.CONFIGURED_SURFACE_BUILDER_KEY,
            new ResourceLocation(
                    DemigodsAndDemons.MODID,
                    "elderwood_forest"
            )
    );

    public static void register(){

        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, ELDERWOOD_FOREST.getLocation(), new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(GRASS, DIRT, DIRT)));
    }
}
