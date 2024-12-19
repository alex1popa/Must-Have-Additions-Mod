package com.alex.additionsmod.block;

import com.alex.additionsmod.MustHaveAdditions;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //region Ruby blocks
    public final static Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BIT)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F)
            ));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.copyShallow(RUBY_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)
            ));
    //endregion

    //region Sand blocks
    public static final Block SAND_LAYER = registerBlock("sand_layer",
            new SnowBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .replaceable()
                    .notSolid()
                    .ticksRandomly()
                    .strength(0.1F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.SAND)
                    .blockVision((state, world, pos) -> (Integer)state.get(SnowBlock.LAYERS) >= 8)
                    .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    public static final Block RED_SAND_LAYER = registerBlock("red_sand_layer",
            new SnowBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.ORANGE)
                    .replaceable()
                    .notSolid()
                    .ticksRandomly()
                    .strength(0.1F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.SAND)
                    .blockVision((state, world, pos) -> (Integer)state.get(SnowBlock.LAYERS) >= 8)
                    .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    //endregion

    //region End stone blocks
    public static final Block END_STONE_STAIRS = registerBlock("end_stone_stairs",
            new StairsBlock(Blocks.END_STONE.getDefaultState(),
                    AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).requiresTool().strength(3.0F, 9.0F)));
    public static final Block END_STONE_SLAB = registerBlock("end_stone_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).requiresTool().strength(3.0F, 9.0F)));
    public static final Block END_STONE_WALL = registerBlock("end_stone_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).requiresTool().strength(3.0F, 9.0F)));
    public static final Block END_STONE_PRESSURE_PLATE = registerBlock("end_stone_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).requiresTool().strength(3.0f)));
    public static final Block END_STONE_BUTTON = registerBlock("end_stone_button",
            new ButtonBlock(BlockSetType.STONE, 20, AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).requiresTool().strength(3.0f).noCollision().pistonBehavior(PistonBehavior.DESTROY)));
    //endregion

    //Methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MustHaveAdditions.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MustHaveAdditions.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MustHaveAdditions.LOGGER.info("Registering blocks for " + MustHaveAdditions.MOD_ID);
    }
}
