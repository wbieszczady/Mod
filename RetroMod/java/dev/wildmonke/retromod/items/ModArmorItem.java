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

import java.util.Map;

public class ModArmorItem extends ArmorItem {


    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }



}
