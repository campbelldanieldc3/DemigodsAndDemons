package com.example.demigodsanddemons.entity;

import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.block.DDBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DDTileEntities {

    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(
                    ForgeRegistries.TILE_ENTITIES,
                    DemigodsAndDemons.MODID
            );

    public static final RegistryObject<TileEntityType<AltarTileEntity>> ANIMA_STORAGE_ENTITY = TILE_ENTITIES.register(
            "altar_tile_entity",
            () -> TileEntityType.Builder.create(AltarTileEntity::new, DDBlocks.ALTAR_BLOCK.get()).build(null));

    public static void init(){

        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
