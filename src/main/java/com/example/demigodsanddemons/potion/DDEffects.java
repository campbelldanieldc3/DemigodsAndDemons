package com.example.demigodsanddemons.potion;

import com.example.demigodsanddemons.DemigodsAndDemons;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DDEffects {

    private static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, DemigodsAndDemons.MODID);

    public static final RegistryObject<DDPotionEffect> MORTALITY = EFFECTS.register("mortality", () -> new DDPotionEffect(EffectType.NEUTRAL, 216,162,36));


    public static void init(){

        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
