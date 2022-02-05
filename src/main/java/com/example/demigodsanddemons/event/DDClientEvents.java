package com.example.demigodsanddemons.event;

import com.example.demigodsanddemons.DemigodsAndDemons;
import com.example.demigodsanddemons.clientGUI.AltarBlockScreen;
import com.example.demigodsanddemons.container.DDContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DemigodsAndDemons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DDClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){

        ScreenManager.registerFactory(DDContainerTypes.ALTAR_CONTAINER.get(), AltarBlockScreen::new);

    }
}
