package cafe.ferret.mc.earlydays;

import cafe.ferret.mc.earlydays.entity.CatfishEntity;
import cafe.ferret.mc.earlydays.init.EarlyDaysBlocks;
import cafe.ferret.mc.earlydays.init.EarlyDaysEntities;
import cafe.ferret.mc.earlydays.init.EarlyDaysItems;
import cafe.ferret.mc.earlydays.init.EarlyDaysTags;
import cafe.ferret.mc.earlydays.util.LootTableModifier;
import cafe.ferret.mc.earlydays.util.RecipeRemover;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

//CODE USED UNDER THE MIT LICENSE FROM EARLYGAME https://github.com/JayCeeCreates/earlygame AND RECIPE IMPROVER https://github.com/antlilja/recipe_improver

public class EarlyDays implements ModInitializer {
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(EarlyDays.MODID, "earlydays"))
            .icon(() -> new ItemStack(EarlyDaysItems.genericItems.get(EarlyDaysItems.GenericItem.FLAX_BUNDLE)))
            .build();

    public static final String MODID = "earlydays";
    public static final Logger LOGGER = LogManager.getLogger("earlydays");

    //LOOT_TABLE_THINGS

    // Unused code so I just commented it out
    /*
    public static List<Block> DROPS_PLANT_MATTER_ID = EarlyDaysTags.DROPS_PLANT_MATTER.values();
    public static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();
    public static final Identifier TALL_GRASS_LOOT_TABLE_ID = Blocks.TALL_GRASS.getLootTableId();
    public static final Identifier FERN_LOOT_TABLE_ID = Blocks.FERN.getLootTableId();
    public static final Identifier LARGE_FERN_LOOT_TABLE_ID = Blocks.LARGE_FERN.getLootTableId();
    public static final Identifier GRASS_BLOCK_LOOT_TABLE_ID = Blocks.GRASS_BLOCK.getLootTableId();
    public static final Identifier ACACIA_LEAVES_LOOT_TABLE_ID = Blocks.ACACIA_LEAVES.getLootTableId();
    public static final Identifier BIRCH_LEAVES_LOOT_TABLE_ID = Blocks.BIRCH_LEAVES.getLootTableId();
    public static final Identifier DARK_OAK_LEAVES_LOOT_TABLE_ID = Blocks.DARK_OAK_LEAVES.getLootTableId();
    public static final Identifier JUNGLE_LEAVES_LOOT_TABLE_ID = Blocks.JUNGLE_LEAVES.getLootTableId();
    public static final Identifier OAK_LEAVES_LOOT_TABLE_ID = Blocks.OAK_LEAVES.getLootTableId();
    public static final Identifier SPRUCE_LEAVES_LOOT_TABLE_ID = Blocks.SPRUCE_LEAVES.getLootTableId();
    public static final Identifier VINE_LOOT_TABLE_ID = Blocks.VINE.getLootTableId();
    public static final Identifier DIRT_LOOT_TABLE_ID = Blocks.DIRT.getLootTableId();
    public static final Identifier SAND_LOOT_TABLE_ID = Blocks.SAND.getLootTableId();
    public static final Identifier PIG_LOOT_TABLE_ID = EntityType.PIG.getLootTableId();
    public static final Identifier SHEEP_LOOT_TABLE_ID = EntityType.SHEEP.getLootTableId();
    public static final Identifier COW_LOOT_TABLE_ID = EntityType.COW.getLootTableId();
    public static final Identifier HORSE_LOOT_TABLE_ID = EntityType.HORSE.getLootTableId();
    */

    @Override
    public void onInitialize() {
        // Register all blocks
        EarlyDaysBlocks.register();
        // Register all items
        EarlyDaysItems.register();
        // Register all tags
        EarlyDaysTags.register();
        // Register all entities
        EarlyDaysEntities.register();

        RecipeRemover.removeRecipe();
        LootTableModifier.lootTableModifier();
        LootTableModifier.fishLootTableModifier();
        FabricDefaultAttributeRegistry.register(EarlyDaysEntities.CATFISH_ENTITY, CatfishEntity.createMobAttributes());
    }
}