package com.alex.additionsmod.item;

import com.alex.additionsmod.MustHaveAdditions;
import com.alex.additionsmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    //Item Groups added
    public static final ItemGroup Must_Have_Building_Blocks = Registry.register(Registries.ITEM_GROUP, Identifier.of(MustHaveAdditions.MOD_ID, "must_have_building_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK))
                    .displayName(Text.translatable("itemgroup.additionsmod.building_blocks"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.RUBY_BLOCK);
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
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.RUBY);
        });
    }
}
