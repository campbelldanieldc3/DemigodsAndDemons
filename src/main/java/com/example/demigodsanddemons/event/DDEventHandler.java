package com.example.demigodsanddemons.event;

import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.potion.DDEffects;
import com.example.demigodsanddemons.potion.DDPotionEffect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.event.ItemEvent;

@Mod.EventBusSubscriber(modid = DemigodsAndDemons.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DDEventHandler {

//    private ItemEvent ie;
//    @SubscribeEvent
//    public static void eatedAmbrosia(PlayerEvent p){
//
//        for(String s : p.getPlayer().getTags()){
//
//            if(s.equals("Ascended")){
//                p.getPlayer().addPotionEffect(new EffectInstance(Effects.REGENERATION));
//            }
//
//        }
//
//    }

    @SubscribeEvent
    public static void isMortal(PotionEvent.PotionAddedEvent p){

        if(p.getPotionEffect().equals(new EffectInstance((DDEffects.MORTALITY.get())))){

            // if entity is "immortal"
            if(p.getEntityLiving().getTags().contains("Ascended")){

                p.getEntityLiving().addPotionEffect(new EffectInstance(Effects.REGENERATION, 10, 3));

            }else{

                p.getEntityLiving().addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 5));

            }


        }
    }
}
