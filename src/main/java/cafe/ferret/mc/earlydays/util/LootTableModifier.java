package cafe.ferret.mc.earlydays.util;

import cafe.ferret.mc.earlydays.init.EarlyDaysItems;
import cafe.ferret.mc.earlydays.mixin.LootTableBuilderAccessor;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.tag.ServerTagManagerHolder;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Set;
import java.util.stream.Collectors;

import static cafe.ferret.mc.earlydays.EarlyDays.MODID;
import static cafe.ferret.mc.earlydays.init.EarlyDaysItems.GenericItem.HIDE;
import static cafe.ferret.mc.earlydays.init.EarlyDaysItems.GenericItem.PLANT_MATTER;

public class LootTableModifier {
    public static final Identifier FISH_LOOT_TABLE = new Identifier("gameplay/fishing/fish");

    //BLOCK LOOT TABLES
    public static final Identifier GRASS_BLOCK_LOOT_TABLE_ID = Blocks.GRASS_BLOCK.getLootTableId();
    public static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();
    public static final Identifier TALL_GRASS_LOOT_TABLE_ID = Blocks.TALL_GRASS.getLootTableId();
    public static final Identifier FERN_LOOT_TABLE_ID = Blocks.FERN.getLootTableId();
    public static final Identifier LARGE_FERN_LOOT_TABLE_ID = Blocks.LARGE_FERN.getLootTableId();
    public static final Identifier SAND_LOOT_TABLE_ID = Blocks.GRASS_BLOCK.getLootTableId();
    public static final Identifier DIRT_LOOT_TABLE_ID = Blocks.GRASS_BLOCK.getLootTableId();

    //ENTITY LOOT TABLES
    public static final Identifier COW_LOOT_TABLE_ID = EntityType.COW.getLootTableId();
    public static final Identifier PIG_LOOT_TABLE_ID = EntityType.PIG.getLootTableId();
    public static final Identifier SHEEP_LOOT_TABLE_ID = EntityType.SHEEP.getLootTableId();
    public static final Identifier HORSE_LOOT_TABLE_ID = EntityType.HORSE.getLootTableId();
    public static final Identifier DONKEY_LOOT_TABLE_ID = EntityType.DONKEY.getLootTableId();
    public static final Identifier MULE_LOOT_TABLE_ID = EntityType.MULE.getLootTableId();
    public static final Identifier TURTLE_LOOT_TABLE_ID = EntityType.TURTLE.getLootTableId();
    public static final Identifier LLAMA_LOOT_TABLE_ID = EntityType.LLAMA.getLootTableId();

    //CHEST LOOT TABLES
    public static void lootTableModifier() {

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            Tag<Block> DROPS_FLINT = ServerTagManagerHolder.getTagManager().getOrCreateTagGroup(Registry.BLOCK_KEY).getTag(new Identifier(MODID, "drops_flint"));
            Tag<Block> DROPS_PLANT_MATTER = ServerTagManagerHolder.getTagManager().getOrCreateTagGroup(Registry.BLOCK_KEY).getTag(new Identifier(MODID, "drops_plant_matter"));
            Tag<EntityType<?>> LARGE_MAMMALS = ServerTagManagerHolder.getTagManager().getOrCreateTagGroup(Registry.ENTITY_TYPE_KEY).getTag(new Identifier(MODID, "large_mammals"));
            Tag<EntityType<?>> SMALL_MAMMALS = ServerTagManagerHolder.getTagManager().getOrCreateTagGroup(Registry.ENTITY_TYPE_KEY).getTag(new Identifier(MODID, "small_mammals"));

            Set<Identifier> DROPS_FLINT_IDS = DROPS_FLINT.values().stream().map(AbstractBlock::getLootTableId).collect(Collectors.toSet());
            Set<Identifier> DROPS_PLANT_MATTER_IDS = DROPS_PLANT_MATTER.values().stream().map(block -> block.getLootTableId()).collect(Collectors.toSet());
            Set<Identifier> LARGE_MAMMALS_IDS = LARGE_MAMMALS.values().stream().map(EntityType::getLootTableId).collect(Collectors.toSet());
            Set<Identifier> SMALL_MAMMALS_IDS = SMALL_MAMMALS.values().stream().map(EntityType::getLootTableId).collect(Collectors.toSet());

            if (DROPS_FLINT_IDS.contains(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.FLINT));
                table.pool(poolBuilder);
            }
            if (DROPS_PLANT_MATTER_IDS.contains(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EarlyDaysItems.genericItems.get(PLANT_MATTER)));
                table.pool(poolBuilder);
            }
            if (LARGE_MAMMALS_IDS.contains(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EarlyDaysItems.genericItems.get(HIDE)));
                table.pool(poolBuilder);
            }
            if (SMALL_MAMMALS_IDS.contains(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EarlyDaysItems.genericItems.get(HIDE)));
                table.pool(poolBuilder);
            }
        });
    }

    public static void fishLootTableModifier() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, fabricLootSupplierBuilder, lootTableSetter) -> {
            if (identifier.equals(FISH_LOOT_TABLE)) {
                LootPool lootPool = ((LootTableBuilderAccessor) fabricLootSupplierBuilder).getPools().get(0);
                FabricLootPoolBuilder lpb = FabricLootPoolBuilder.of(lootPool);
                lpb.with(ItemEntry.builder(EarlyDaysItems.CATFISH).weight(100));
                ((LootTableBuilderAccessor) fabricLootSupplierBuilder).getPools().set(0, lpb.build());
            }
        });
    }
}