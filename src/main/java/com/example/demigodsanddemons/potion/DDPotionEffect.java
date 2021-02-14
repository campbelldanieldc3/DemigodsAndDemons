package com.example.demigodsanddemons.potion;

import com.example.demigodsanddemons.DemigodsAndDemons;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;

public class DDPotionEffect extends Effect{

    protected DDPotionEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    public DDPotionEffect(final EffectType effectType, final int ColorR, final int ColorG, final int ColorB){

        this(effectType, new Color(ColorR, ColorG, ColorB).getRGB());

    }



}
