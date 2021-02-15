package com.example.demigodsanddemons.event;

import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.potion.DDEffects;
import net.minecraft.command.Commands;
import net.minecraft.command.impl.SayCommand;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.event.ItemEvent;

@Mod.EventBusSubscriber(modid = DemigodsAndDemons.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DDEventHandler {

    @SubscribeEvent
    public static void isMortal(PotionEvent.PotionAddedEvent p){

        if(p.getPotionEffect().equals(new EffectInstance((DDEffects.MORTALITY.get())))){

            // if entity is "immortal"
            if(p.getEntityLiving().getTags().contains("Ascended")){

                p.getEntityLiving().addPotionEffect(new EffectInstance(Effects.REGENERATION, 400, 1));

            }else{

                p.getEntityLiving().attackEntityFrom(DamageSource.IN_FIRE, Float.MAX_VALUE);


            }


        }
    }
}
