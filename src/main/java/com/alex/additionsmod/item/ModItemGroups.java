package com.alex.additionsmod.item;

import com.alex.additionsmod.MustHaveAdditions;
import com.alex.additionsmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    //Item Groups added
    public static final ItemGroup Must_Have_Vanilla = Registry.register(Registries.ITEM_GROUP, Identifier.of(MustHaveAdditions.MOD_ID, "must_have_vanilla"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(Blocks.COMMAND_BLOCK))
                    .displayName(Text.translatable("itemgroup.additionsmod.vanilla"))
                    .entries(((displayContext, entries) -> {
                        entries.add(Blocks.BARRIER);
                        entries.add(Blocks.COMMAND_BLOCK);
                    })).build());
    public static final ItemGroup Must_Have_Building_Blocks = Registry.register(Registries.ITEM_GROUP, Identifier.of(MustHaveAdditions.MOD_ID, "must_have_building_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK))
                    .displayName(Text.translatable("itemgroup.additionsmod.building_blocks"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.RUBY_BLOCK);
                    })).build());
    public static final ItemGroup Must_Have_Natural_Blocks = Registry.register(Registries.ITEM_GROUP, Identifier.of(MustHaveAdditions.MOD_ID, "must_have_naturals"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RUBY_ORE))
                    .displayName(Text.translatable("itemgroup.additionsmod.naturals"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.SAND_LAYER);
                        entries.add(ModBlocks.RED_SAND_LAYER);
                    })).build());
    public static final ItemGroup Must_Have_Items = Registry.register(Registries.ITEM_GROUP, Identifier.of(MustHaveAdditions.MOD_ID, "must_have_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(Text.translatable("itemgroup.additionsmod.items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                    })).build());


    //Methods
    public static void registerItemGroups(){
        MustHaveAdditions.LOGGER.info("Registering item groups for " + MustHaveAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RUBY_BLOCK);
            entries.add(ModBlocks.SAND_LAYER);
            entries.add(ModBlocks.RED_SAND_LAYER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.RUBY);
        });
    }
}
