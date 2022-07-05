package dev.wildmonke.retromod.event;

import dev.wildmonke.retromod.RetroMod;
import dev.wildmonke.retromod.entity.client.armor.LynchArmorRenderer;
import dev.wildmonke.retromod.items.LynchArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;



@Mod.EventBusSubscriber(modid = RetroMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(LynchArmorItem.class, new LynchArmorRenderer());
    }
}
