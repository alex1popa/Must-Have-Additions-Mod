package com.alex.additionsmod.datagen;

import com.alex.additionsmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.END_STONE_STAIRS)
                .add(ModBlocks.END_STONE_SLAB)
                .add(ModBlocks.END_STONE_WALL)
                .add(ModBlocks.END_STONE_BUTTON)
                .add(ModBlocks.END_STONE_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.END_STONE_STAIRS)
                .add(ModBlocks.END_STONE_SLAB)
                .add(ModBlocks.END_STONE_WALL)
                .add(ModBlocks.END_STONE_BUTTON)
                .add(ModBlocks.END_STONE_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.END_STONE_WALL);
    }
}
