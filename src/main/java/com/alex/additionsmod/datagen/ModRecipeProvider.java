package com.alex.additionsmod.datagen;

import com.alex.additionsmod.MustHaveAdditions;
import com.alex.additionsmod.block.ModBlocks;
import com.alex.additionsmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //region item lists
        List<ItemConvertible> RUBY_SMELT = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE); //blocks that give rubies when smelted
        //endregion

        //region Ruby recipes
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
        offerSmelting(exporter, RUBY_SMELT, RecipeCategory.MISC, ModItems.RUBY, 0.9f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELT, RecipeCategory.MISC, ModItems.RUBY, 0.9f, 100, "ruby");
        //endregion

        //region Sand recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SAND_LAYER, 6)
                .pattern("SSS")
                .input('S', Blocks.SAND)
                .criterion(hasItem(Blocks.SAND), conditionsFromItem(Blocks.SAND))
                .offerTo(exporter, Identifier.of(MustHaveAdditions.MOD_ID, "sand_layer"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RED_SAND_LAYER, 6)
                .pattern("SSS")
                .input('S', Blocks.RED_SAND)
                .criterion(hasItem(Blocks.RED_SAND), conditionsFromItem(Blocks.RED_SAND))
                .offerTo(exporter, Identifier.of(MustHaveAdditions.MOD_ID, "red_sand_layer"));
        //endregion

        //region End stone recipes
        createStairsRecipe(ModBlocks.END_STONE_STAIRS, Ingredient.ofItems(Blocks.END_STONE))
                .criterion(hasItem(Blocks.END_STONE), conditionsFromItem(Blocks.END_STONE))
                .offerTo(exporter, Identifier.of(MustHaveAdditions.MOD_ID, "end_stone_stairs"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS ,ModBlocks.END_STONE_SLAB, Ingredient.ofItems(Blocks.END_STONE))
                .criterion(hasItem(Blocks.END_STONE), conditionsFromItem(Blocks.END_STONE))
                .offerTo(exporter, Identifier.of(MustHaveAdditions.MOD_ID, "end_stone_slab"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_WALL, 6)
                .pattern("EEE")
                .pattern("EEE")
                .input('E', Blocks.END_STONE)
                .criterion(hasItem(Blocks.END_STONE), conditionsFromItem(Blocks.END_STONE))
                .offerTo(exporter, Identifier.of(MustHaveAdditions.MOD_ID, "end_stone_wall"));

        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.END_STONE_PRESSURE_PLATE, Ingredient.ofItems(Blocks.END_STONE))
                .criterion(hasItem(Blocks.END_STONE), conditionsFromItem(Blocks.END_STONE))
                .offerTo(exporter, Identifier.of(MustHaveAdditions.MOD_ID, "end_stone_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.END_STONE_BUTTON)
                .input(Blocks.END_STONE).criterion(hasItem(Blocks.END_STONE), conditionsFromItem(Blocks.END_STONE))
                .offerTo(exporter, Identifier.of(MustHaveAdditions.MOD_ID, "end_stone_button"));
        //endregion
    }
}
