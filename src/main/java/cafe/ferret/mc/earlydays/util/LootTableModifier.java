package cafe.ferret.mc.earlydays.util;

import cafe.ferret.mc.earlydays.init.EarlyDaysItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class LootTableModifier {

    public static void lootTableModifier(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            //Tag<Block> DROPS_FLINT = ServerTagManagerHolder.getTagManager().getOrCreateTagGroup(Registry.BLOCK_KEY).getTag(new Identifier(MODID,"drops_flint"));
            //Set<Identifier> DROPS_FLINT_IDS = DROPS_FLINT.values().stream().map(block -> block.getLootTableId()).collect(Collectors.toSet());

            if (Blocks.GRASS_BLOCK.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(0, 1))
                        .with(ItemEntry.builder(EarlyDaysItems.genericItems.get(EarlyDaysItems.GenericItem.PLANT_MATTER)));
                tableBuilder.pool(pool);
            }
        });
    }
}
