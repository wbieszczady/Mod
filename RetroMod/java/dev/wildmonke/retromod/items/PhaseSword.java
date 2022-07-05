package dev.wildmonke.retromod.items;


import dev.wildmonke.retromod.effect.ModEffects;
import dev.wildmonke.retromod.init.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;


public class PhaseSword extends SwordItem {


    public PhaseSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {

        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Right click to enter a Phase Shift!").withStyle(ChatFormatting.BLUE));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }



        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.hasEffect(ModEffects.PHASE.get()) == true ) {
            target.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 1), attacker);
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.getCooldowns().addCooldown(this, 760);

            //Lynch
            player.removeEffect(MobEffects.HEALTH_BOOST);
            player.removeEffect(MobEffects.REGENERATION);
            player.removeEffect(ModEffects.LYNCH.get());

            //Sentient
            player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            player.removeEffect(MobEffects.DAMAGE_BOOST);
            player.removeEffect(MobEffects.MOVEMENT_SPEED);
            player.removeEffect(MobEffects.LUCK);
            player.removeEffect(ModEffects.SENTIENT.get());

            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 5));
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0));
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600, 0));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 4));
            player.addEffect(new MobEffectInstance(ModEffects.PHASE.get(), 600, 0));

            double xd = player.getX();
            double yd = player.getY();
            double zd = player.getZ();

            level.addParticle(ParticleTypes.EXPLOSION_EMITTER, xd, yd, zd, 0.0D, 0.0D, 0.0D);
            level.playSound((Player)null, xd, yd, zd, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
        }

        return super.use(level, player, hand);

    }








}

