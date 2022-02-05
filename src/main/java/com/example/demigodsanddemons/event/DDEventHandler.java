package com.example.demigodsanddemons.event;

import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.potion.DDEffects;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.swing.text.JTextComponent;

@Mod.EventBusSubscriber(modid = DemigodsAndDemons.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DDEventHandler {

    public final static KeyBinding powerKey = new KeyBinding("key.use_super_ability",70, "key.categories.miscellaneous");

    @SubscribeEvent
    public static void keyBindings(FMLClientSetupEvent event){
        ClientRegistry.registerKeyBinding(powerKey);
    }

    @SubscribeEvent
    public static void onEatImmortalFood(PotionEvent.PotionAddedEvent p){
        if(p.getPotionEffect().equals(new EffectInstance((DDEffects.MORTALITY.get())))){
            // If entity is considered "immortal"
            if(p.getEntityLiving().getTags().contains("Ascended")){
                p.getEntityLiving().addPotionEffect(new EffectInstance(Effects.REGENERATION, 400, 1));
            }else{
                p.getEntityLiving().attackEntityFrom(DamageSource.IN_FIRE, Float.MAX_VALUE);
            }
        }
    }
}
