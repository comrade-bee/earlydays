package cafe.ferret.mc.earlydays.util;

import cafe.ferret.mc.earlydays.EarlyDays;
import cafe.ferret.mc.earlydays.init.EarlyDaysItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EDRegistry {
    public static void registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(EarlyDays.MODID, name), item);
    }

    public static void registerBlockWithItem(String name, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(EarlyDays.MODID, name), block);
        Registry.register(Registry.ITEM, new Identifier(EarlyDays.MODID, name), new BlockItem(block, new FabricItemSettings().group(EarlyDays.ITEM_GROUP)));
    }
}
