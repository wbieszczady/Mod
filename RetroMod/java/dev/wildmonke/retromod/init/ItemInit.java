package dev.wildmonke.retromod.init;

import dev.wildmonke.retromod.BaseToolMaterial;
import dev.wildmonke.retromod.ModArmorMaterial;
import dev.wildmonke.retromod.RetroMod;
import dev.wildmonke.retromod.init.BlockInit;
import dev.wildmonke.retromod.items.LynchSword;
import dev.wildmonke.retromod.items.PhaseSword;
import dev.wildmonke.retromod.items.SentientSword;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RetroMod.MODID);

    //Items
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().tab(RetroMod.RETRO_TAB)));

    public static final RegistryObject<Item> PHASE_INGOT = ITEMS.register("phase_ingot", () -> new Item(new Item.Properties().tab(RetroMod.RETRO_TAB)));
    public static final RegistryObject<Item> LYNCH_INGOT = ITEMS.register("lynch_ingot", () -> new Item(new Item.Properties().tab(RetroMod.RETRO_TAB)));
    public static final RegistryObject<Item> SENTIENT_INGOT = ITEMS.register("sentient_ingot", () -> new Item(new Item.Properties().tab(RetroMod.RETRO_TAB)));

    //Items (Blocks)
    public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(RetroMod.RETRO_TAB)));

    //Tools

    public static final RegistryObject<PhaseSword> PHASE_SWORD = ITEMS.register("phase_sword", () -> new PhaseSword(ToolMaterialInit.PHASE, 4, -2f, new Item.Properties().tab(RetroMod.RETRO_TAB)));
    public static final RegistryObject<LynchSword> LYNCH_SWORD = ITEMS.register("lynch_sword", () -> new LynchSword(ToolMaterialInit.LYNCH, 4, -2f, new Item.Properties().tab(RetroMod.RETRO_TAB)));
    public static final RegistryObject<SentientSword> SENTIENT_SWORD = ITEMS.register("sentient_sword", () -> new SentientSword(ToolMaterialInit.SENTIENT, 4, -2f, new Item.Properties().tab(RetroMod.RETRO_TAB)));

    //Armor
    public static final RegistryObject<ArmorItem> LYNCH_HELMET = ITEMS.register("lynch_helmet", () -> new ArmorItem(ModArmorMaterial.LYNCH, EquipmentSlot.HEAD, new Item.Properties().tab(RetroMod.RETRO_TAB)));
    public static final RegistryObject<ArmorItem> LYNCH_CHESTPLATE = ITEMS.register("lynch_chestplate", () -> new ArmorItem(ModArmorMaterial.LYNCH, EquipmentSlot.CHEST, new Item.Properties().tab(RetroMod.RETRO_TAB)));
    public static final RegistryObject<ArmorItem> LYNCH_LEGGINGS = ITEMS.register("lynch_leggings", () -> new ArmorItem(ModArmorMaterial.LYNCH, EquipmentSlot.LEGS, new Item.Properties().tab(RetroMod.RETRO_TAB)));
    public static final RegistryObject<ArmorItem> LYNCH_BOOTS = ITEMS.register("lynch_boots", () -> new ArmorItem(ModArmorMaterial.LYNCH, EquipmentSlot.FEET, new Item.Properties().tab(RetroMod.RETRO_TAB)));
}
