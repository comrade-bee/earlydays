package cafe.ferret.mc.earlydays.util;

import cafe.ferret.mc.earlydays.init.EarlyDaysItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;

public class LootTableModifier {

    public static void lootTableModifier(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            //Tag<Block> DROPS_FLINT = ServerTagManagerHolder.getTagManager().getOrCreateTagGroup(Registry.BLOCK_KEY).getTag(new Identifier(MODID,"drops_flint"));
            //Set<Identifier> DROPS_FLINT_IDS = DROPS_FLINT.values().stream().map(block -> block.getLootTableId()).collect(Collectors.toSet());

            //Plant Matter Drops
            if (Blocks.GRASS_BLOCK.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(EarlyDaysItems.genericItems.get(EarlyDaysItems.GenericItem.PLANT_MATTER)));
                tableBuilder.pool(pool);
            }
            if (Blocks.GRASS.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(EarlyDaysItems.genericItems.get(EarlyDaysItems.GenericItem.PLANT_MATTER)));
                tableBuilder.pool(pool);
            }
            //Sticks
            if (Blocks.ACACIA_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.AZALEA_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.BIRCH_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.DARK_OAK_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.FLOWERING_AZALEA_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.MANGROVE_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.JUNGLE_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.SPRUCE_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            if (Blocks.OAK_LEAVES.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.STICK));
                tableBuilder.pool(pool);
            }
            //Grubs
            if (Blocks.GRASS_BLOCK.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(EarlyDaysItems.GRUB));
                tableBuilder.pool(pool);
            }
            if (Blocks.MUDDY_MANGROVE_ROOTS.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(EarlyDaysItems.GRUB));
                tableBuilder.pool(pool);
            }
            if (Blocks.PODZOL.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(EarlyDaysItems.GRUB));
                tableBuilder.pool(pool);
            }
            if (Blocks.ROOTED_DIRT.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(EarlyDaysItems.GRUB));
                tableBuilder.pool(pool);
            }
        });
    }
}
