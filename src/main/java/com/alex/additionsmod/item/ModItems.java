package com.alex.additionsmod.item;

import com.alex.additionsmod.MustHaveAdditions;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //Items added
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));


    //Methods
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MustHaveAdditions.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MustHaveAdditions.LOGGER.info("Registering items for " + MustHaveAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RUBY);
        });
    }
}
