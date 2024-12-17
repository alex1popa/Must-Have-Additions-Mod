package com.alex.additionsmod.datagen;

import com.alex.additionsmod.block.ModBlocks;
import com.alex.additionsmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //region Ruby blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        //endregion

        //region End stone blocks
        BlockStateModelGenerator.BlockTexturePool endStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.END_STONE);
        endStonePool.stairs(ModBlocks.END_STONE_STAIRS);
        endStonePool.slab(ModBlocks.END_STONE_SLAB);
        endStonePool.wall(ModBlocks.END_STONE_WALL);
        endStonePool.button(ModBlocks.END_STONE_BUTTON);
        endStonePool.pressurePlate(ModBlocks.END_STONE_PRESSURE_PLATE);
        //endregion
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
    }
}
