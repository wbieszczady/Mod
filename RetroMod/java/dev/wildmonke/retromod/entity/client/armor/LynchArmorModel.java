package dev.wildmonke.retromod.entity.client.armor;

import dev.wildmonke.retromod.RetroMod;
import dev.wildmonke.retromod.items.LynchArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LynchArmorModel extends AnimatedGeoModel<LynchArmorItem> {
    @Override
    public ResourceLocation getModelResource(LynchArmorItem object) {
        return new ResourceLocation(RetroMod.MODID, "geo/lynch_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LynchArmorItem object) {
        return new ResourceLocation(RetroMod.MODID, "textures/models/armor/lynch_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LynchArmorItem animatable) {
        return new ResourceLocation(RetroMod.MODID, "animations/armor_animation.json");
    }
}
