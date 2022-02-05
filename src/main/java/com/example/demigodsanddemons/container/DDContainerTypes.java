package com.example.demigodsanddemons.container;

import com.example.demigodsanddemons.DemigodsAndDemons;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DDContainerTypes {

    private static DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(
            ForgeRegistries.CONTAINERS,
            DemigodsAndDemons.MODID
    );
    public static void init(){

        CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());


    }


    public static final RegistryObject<ContainerType<AltarBlockContainer>> ALTAR_CONTAINER = CONTAINER_TYPES.register("altar_block", () -> IForgeContainerType.create(AltarBlockContainer::new));


}
