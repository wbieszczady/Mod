package dev.wildmonke.retromod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class LynchEffect extends MobEffect {
    protected LynchEffect(MobEffectCategory mobEffectCategory, int color) {

        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
    }


    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {

        return true;
    }

}