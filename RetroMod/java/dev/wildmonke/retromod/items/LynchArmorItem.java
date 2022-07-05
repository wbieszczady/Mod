package dev.wildmonke.retromod.items;


import com.google.common.collect.ImmutableMap;
import dev.wildmonke.retromod.ModArmorMaterial;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

import java.util.Map;


public class LynchArmorItem extends GeoArmorItem implements IAnimatable {
        private AnimationFactory factory = new AnimationFactory(this);


        public LynchArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
            super(material, slot, settings);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<LynchArmorItem>(this, "controller",
                    20, this::predicate));
        }

        @Override
        public AnimationFactory getFactory() {return this.factory;}

        private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
            return PlayState.CONTINUE;
        }


}
