package com.thepeoplesbee.earlydays;

import com.thepeoplesbee.earlydays.block.*;
import com.thepeoplesbee.earlydays.config.EarlyDaysConfig;
import com.thepeoplesbee.earlydays.entity.CatfishEntity;
import com.thepeoplesbee.earlydays.item.*;
import com.thepeoplesbee.earlydays.util.LootTableModifier;
import com.thepeoplesbee.earlydays.util.RecipeRemover;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.ServerTagManagerHolder;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

import net.minecraft.util.registry.RegistryKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.jmx.Server;

//CODE USED UNDER THE MIT LICENSE FROM EARLYGAME https://github.com/JayCeeCreates/earlygame AND RECIPE IMPROVER https://github.com/antlilja/recipe_improver

public class EarlyDays implements ModInitializer {

    public static EarlyDaysConfig CONFIG;

    public static final ItemGroup EARLYDAYS_GROUP = FabricItemGroupBuilder.create(new Identifier(EarlyDays.MODID, "earlydays"))
            .icon(() -> new ItemStack(EarlyDays.FLAX_BUNDLE))
            .build();

    public static Item.Settings createGroup() {
        return new Item.Settings().group(EARLYDAYS_GROUP);
    }

    public static final String MODID = "earlydays";
    public static final Logger LOGGER = LogManager.getLogger("earlydays");
    //I T E M S
    public static final Item PLANT_MATTER = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item MYCELIUM_MATTER = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item PLANT_FIBRE = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item MYCELIUM_FIBRE = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item DRIED_PLANT_MATTER = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item FLAX_BUNDLE = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item DRIED_MYCELIUM_MATTER = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item FLOWER_BUNDLE = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item FLUFF = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item HIDE = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item FABRIC = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item ROPE = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item SILK = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item ADOBE_MIX = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item ADOBE_BRICK = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item DRIED_BAMBOO = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item COPPER_NUGGET = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item SEASHELL = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item SEASTAR = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item JELLYFISH = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    //food
    public static final Item PEPPER = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.PEPPER));
    public static final Item CATFISH = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item MINNOW = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item CRAYFISH = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item LOBSTER = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item MEAT_BITS = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item GRUB = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item COFFEE = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.COFFEE));
    public static final Item TEA = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.TEA));
    public static final Item HERBAL_TEA = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.HERBAL_TEA));
    public static final Item CHILI = new StewItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.CHILI));
    //medicines
    public static final Item ALOE_VERA = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item BANDAGE = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item SALVE = new StewItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.SALVE).maxCount(1));
    public static final Item ELIXIR = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.ELIXIR));
    public static final Item HEARTY_ELIXIR = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.HEARTY_ELIXIR));
    public static final Item ENLIGHTENING_ELIXIR = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.ENLIGHTENING_ELIXIR));
    public static final Item TANNING_SOLUTION = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.TANNING_SOLUTION));
    public static final Item CORRODING_SOLUTION = new HoneyBottleItem(new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.CORRODING_SOLUTION));

    //tools
    public static final ToolItem FLINT_KNIFE = new KnifeItem(EarlyDaysToolMaterials.FLINT, 3, -2.4F, new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem FLINT_SHOVEL = new ShovelItem(EarlyDaysToolMaterials.FLINT, 1.5f,-3.0f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem FLINT_PICKAXE = new EarlyDaysPickaxeItem(EarlyDaysToolMaterials.FLINT, 1,-2.8f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem FLINT_HATCHET = new EarlyDaysAxeItem(EarlyDaysToolMaterials.FLINT, 3,-2.4f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem FLINT_HOE = new EarlyDaysHoeItem(EarlyDaysToolMaterials.FLINT, 0,-3.0f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem BONE_KNIFE = new KnifeItem(EarlyDaysToolMaterials.FLINT, 3, -2.4F, new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem BONE_SHOVEL = new ShovelItem(EarlyDaysToolMaterials.FLINT, 1.5f,-3.0f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem BONE_PICKAXE = new EarlyDaysPickaxeItem(EarlyDaysToolMaterials.FLINT, 1,-2.8f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem BONE_HATCHET = new EarlyDaysAxeItem(EarlyDaysToolMaterials.FLINT, 3,-2.4f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem BONE_HOE = new EarlyDaysHoeItem(EarlyDaysToolMaterials.FLINT, 0,-3.0f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem COPPER_KNIFE = new KnifeItem(EarlyDaysToolMaterials.COPPER, 3, -2.4F, new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem COPPER_SHOVEL = new ShovelItem(EarlyDaysToolMaterials.COPPER, 1.5f,-3.0f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem COPPER_PICKAXE = new EarlyDaysPickaxeItem(EarlyDaysToolMaterials.COPPER, 1,-2.8f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem COPPER_HATCHET = new EarlyDaysAxeItem(EarlyDaysToolMaterials.COPPER, 3,-2.4f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final ToolItem COPPER_HOE = new EarlyDaysHoeItem(EarlyDaysToolMaterials.COPPER, 0,-3.0f , new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item COPPER_SHEARS = new ShearsItem(new FabricItemSettings().maxDamage(20).group(EARLYDAYS_GROUP));
    public static final Item BUTTERFLY_NET = new Item(new FabricItemSettings().group(EARLYDAYS_GROUP));
    //armor
    public static final Item FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item ACE_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.ACE_FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item ARO_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.ARO_FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item BI_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.BI_FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item LESBIAN_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.LESBIAN_FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item NONBINARY_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.NONBINARY_FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item PAN_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.PAN_FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item TRANS_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.TRANS_FLOWER, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item WOOD_HELMET = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.HEAD,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item WOOD_CHESTPLATE = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.CHEST,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item WOOD_LEGGINGS = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.LEGS,new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item WOOD_BOOTS = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.FEET,new FabricItemSettings().group(EARLYDAYS_GROUP));
    //B L O C K S
    public static final Block WICKER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block THATCH = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block FLAX_THATCH = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block MYCELIUM_THATCH = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block ADOBE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE, MapColor.DIRT_BROWN).requiresTool().strength(1.25F, 4.2F));
    public static final Block SMOOTH_ADOBE = new Block(FabricBlockSettings.copy(EarlyDays.ADOBE_BRICKS));
    public static final Block BAMBOO_BLOCK = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.GREEN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block DRIED_BAMBOO_BLOCK = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block BONE_PILE = new Block(FabricBlockSettings.copy(Blocks.BONE_BLOCK));
    public static final Block STRANGE_SOIL = new Block(FabricBlockSettings.copy(Blocks.COARSE_DIRT));
    public static final Block GLOWSHROOM_BLOCK = new MushroomBlock(FabricBlockSettings.of(Material.WOOD, MapColor.WHITE).strength(0.2F).sounds(BlockSoundGroup.WOOD).luminance(10));
    //slabs
    public static final Block WICKER_SLAB = new SlabBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final Block THATCH_SLAB = new SlabBlock(FabricBlockSettings.copy(THATCH));
    public static final Block FLAX_THATCH_SLAB = new SlabBlock(FabricBlockSettings.copy(FLAX_THATCH));
    public static final Block MYCELIUM_THATCH_SLAB = new SlabBlock(FabricBlockSettings.copy(MYCELIUM_THATCH));
    public static final Block ADOBE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copy(ADOBE_BRICKS));
    public static final Block SMOOTH_ADOBE_SLAB = new SlabBlock(FabricBlockSettings.copy(SMOOTH_ADOBE));
    //stairs
    public static final Block WICKER_STAIRS = new EarlyDaysStairsBlock(WICKER_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(WICKER_BLOCK));
    public static final Block THATCH_STAIRS = new EarlyDaysStairsBlock(THATCH.getDefaultState(), FabricBlockSettings.copyOf(THATCH));
    public static final Block FLAX_THATCH_STAIRS = new EarlyDaysStairsBlock(FLAX_THATCH.getDefaultState(), FabricBlockSettings.copyOf(FLAX_THATCH));
    public static final Block MYCELIUM_THATCH_STAIRS = new EarlyDaysStairsBlock(MYCELIUM_THATCH.getDefaultState(), FabricBlockSettings.copyOf(MYCELIUM_THATCH));
    public static final Block ADOBE_BRICK_STAIRS = new EarlyDaysStairsBlock(ADOBE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ADOBE_BRICKS));
    public static final Block SMOOTH_ADOBE_STAIRS = new EarlyDaysStairsBlock(SMOOTH_ADOBE.getDefaultState(), FabricBlockSettings.copyOf(SMOOTH_ADOBE));
    //doors
    public static final Block WICKER_DOOR = new EarlyDaysDoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block BAMBOO_DOOR = new EarlyDaysDoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.GREEN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block DRIED_BAMBOO_DOOR = new EarlyDaysDoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    //trapdoors
    public static final Block WICKER_TRAPDOOR = new EarlyDaysTrapdoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block BAMBOO_TRAPDOOR = new EarlyDaysTrapdoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.GREEN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block DRIED_BAMBOO_TRAPDOOR = new EarlyDaysTrapdoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    //fences and walls
    public static final Block WICKER_FENCE = new FenceBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final Block BAMBOO_FENCE = new FenceBlock(FabricBlockSettings.copy(BAMBOO_BLOCK));
    public static final Block DRIED_BAMBOO_FENCE = new FenceBlock(FabricBlockSettings.copy(DRIED_BAMBOO_BLOCK));
    public static final Block ADOBE_BRICK_WALL = new WallBlock(FabricBlockSettings.copy(ADOBE_BRICKS));
    public static final Block SMOOTH_ADOBE_WALL = new WallBlock(FabricBlockSettings.copy(SMOOTH_ADOBE));
    //fence gates
    public static final Block WICKER_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final Block BAMBOO_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(BAMBOO_BLOCK));
    public static final Block DRIED_BAMBOO_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(DRIED_BAMBOO_BLOCK));
    //shelves
    //chairs
    //stools
    //tables
    //misc
    //bundles
    public static final Block ACE_BUNDLE = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block ARO_BUNDLE = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block BI_BUNDLE = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block FLOWER_BUNDLE_BLOCK = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block LESBIAN_BUNDLE = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block NONBINARY_BUNDLE = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block PAN_BUNDLE = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block TRANS_BUNDLE = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    //flowers
    public static final Block BLUEBELLS = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4,FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final Block SHRUB = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4,FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final Block WEEPING_LILY = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4,FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final Block RED_ORCHID = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4,FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final Block SELF_HEAL = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4,FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final Block RAFFLESIA = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4,FabricBlockSettings.copy(Blocks.ALLIUM));
    //plants
    public static final Block THORNS = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4,FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final Block WILD_ALOE = new EarlyDaysSandPlant(StatusEffects.FIRE_RESISTANCE, 0,FabricBlockSettings.copy(Blocks.ALLIUM));
    //fungi
    public static final Block WITHERCAP_MUSHROOM = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block BARGAIN_BELL = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block GREEN_MUSHROOM = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block EARTHSTAR = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block GLOWSHROOM = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(8));
    public static final Block MILKCAP_MUSHROOM = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block BROWN_MUSHROOMS = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block RED_MUSHROOMS = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block ASSORTED_MUSHROOMS = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block AMETHYST_DECEIVERS = new EarlyDaysMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.BROWN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    //crops
    public static final Block PEPPERS = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Block COTTON = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Block FLAX = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Block GINGERS = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Block ALOE = new EarlyDaysWildCrop(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Block OBSIDIAN_ROOTS = new StrangeCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    //crop items
    public static final Item PEPPER_SEEDS = new AliasedBlockItem((EarlyDays.PEPPERS),new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item COTTON_BALL = new AliasedBlockItem((EarlyDays.COTTON),new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item GINGER = new AliasedBlockItem((EarlyDays.GINGERS),new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.GINGER));
    public static final Item ALOE_VERA_SEEDS = new AliasedBlockItem((EarlyDays.ALOE),new FabricItemSettings().group(EARLYDAYS_GROUP));
    public static final Item OBSIDIAN_ROOT = new AliasedBlockItem((EarlyDays.OBSIDIAN_ROOTS),new FabricItemSettings().group(EARLYDAYS_GROUP).food(EarlyDaysFoodComponents.GINGER));
    public static final Item FLAX_SEEDS = new AliasedBlockItem((EarlyDays.FLAX),new FabricItemSettings().group(EARLYDAYS_GROUP));
    //ITEM TAGS
    public static Tag<Item> VANILLA_TOOLS = TagFactory.ITEM.create(new Identifier(MODID, "vanilla_tools"));
    public static Tag<Item> STONE_RECIPES = TagFactory.ITEM.create(new Identifier(MODID, "stone_recipes"));
    //BLOCK TAGS
    public static Tag<Block> DROPS_PLANT_MATTER = TagFactory.BLOCK.create(new Identifier(MODID, "drops_plant_matter"));
    //public static Tag<Block> DROPS_FLINT = TagFactory.BLOCK.create(new Identifier(MODID, "drops_flint"));
    //ENTITY TAGS
    public static Tag<EntityType<?>> DROPS_BONE = TagFactory.ENTITY_TYPE.create(new Identifier(MODID, "drops_bone"));
    public static Tag<EntityType<?>> DROPS_HIDE = TagFactory.ENTITY_TYPE.create(new Identifier(MODID, "drops_hide"));


    //LOOT_TABLE_THINGS

    public static List<Block> DROPS_PLANT_MATTER_ID = DROPS_PLANT_MATTER.values();
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

    //ENTITIES
    public static final EntityType<CatfishEntity> CATFISH_ENTITY = Registry.register(Registry.ENTITY_TYPE, new Identifier(MODID, "catfish"), FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, CatfishEntity::new).dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());
    @Override
    public void onInitialize() {
        //I T E M S
        Registry.register(Registry.ITEM, new Identifier("earlydays", "plant_matter"), PLANT_MATTER);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "mycelium_matter"), MYCELIUM_MATTER);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "plant_fibre"), PLANT_FIBRE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "mycelium_fibre"), MYCELIUM_FIBRE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_plant_matter"), DRIED_PLANT_MATTER);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flax_bundle"), FLAX_BUNDLE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_mycelium_matter"), DRIED_MYCELIUM_MATTER);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flower_bundle"), FLOWER_BUNDLE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "fluff"), FLUFF);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "cotton_ball"), COTTON_BALL);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "hide"), HIDE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "fabric"), FABRIC);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "rope"), ROPE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "silk"), SILK);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "adobe_mix"), ADOBE_MIX);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "adobe_brick"), ADOBE_BRICK);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_bamboo"), DRIED_BAMBOO);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "copper_nugget"), COPPER_NUGGET);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "seashell"), SEASHELL);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "seastar"), SEASTAR);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "pepper_seeds"), PEPPER_SEEDS);
        //food
        Registry.register(Registry.ITEM, new Identifier("earlydays", "pepper"), PEPPER);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "ginger"), GINGER);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "obsidian_root"), OBSIDIAN_ROOT);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "catfish"), CATFISH);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "minnow"), MINNOW);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "crayfish"), CRAYFISH);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "lobster"), LOBSTER);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "jellyfish"), JELLYFISH);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "meat_bits"), MEAT_BITS);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "grub"), GRUB);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "aloe_vera_seeds"), ALOE_VERA_SEEDS);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flax_seeds"), FLAX_SEEDS);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "coffee"), COFFEE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "tea"), TEA);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "herbal_tea"), HERBAL_TEA);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "chili"), CHILI);
        //medicine
        Registry.register(Registry.ITEM, new Identifier("earlydays", "aloe_vera"), ALOE_VERA);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bandage"), BANDAGE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "salve"), SALVE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "elixir"), ELIXIR);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "hearty_elixir"), HEARTY_ELIXIR);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "enlightening_elixir"), ENLIGHTENING_ELIXIR);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "tanning_solution"), TANNING_SOLUTION);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "corroding_solution"), CORRODING_SOLUTION);
        //tools
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flint_knife"), FLINT_KNIFE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flint_shovel"), FLINT_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flint_pickaxe"), FLINT_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flint_hatchet"), FLINT_HATCHET);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flint_hoe"), FLINT_HOE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bone_knife"), BONE_KNIFE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bone_shovel"), BONE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bone_pickaxe"), BONE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bone_hatchet"), BONE_HATCHET);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bone_hoe"), BONE_HOE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "copper_knife"), COPPER_KNIFE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "copper_hatchet"), COPPER_HATCHET);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "copper_hoe"), COPPER_HOE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "copper_shears"), COPPER_SHEARS);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "butterfly_net"), BUTTERFLY_NET);
        //armor
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flower_crown"), FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "ace_flower_crown"), ACE_FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "aro_flower_crown"), ARO_FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bi_flower_crown"), BI_FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "lesbian_flower_crown"), LESBIAN_FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "nonbinary_flower_crown"), NONBINARY_FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "pan_flower_crown"), PAN_FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "trans_flower_crown"), TRANS_FLOWER_CROWN);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wood_helmet"), WOOD_HELMET);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wood_chestplate"), WOOD_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wood_leggings"), WOOD_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wood_boots"), WOOD_BOOTS);
        //B L O C K S
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wicker_block"), WICKER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "thatch"), THATCH);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "flax_thatch"), FLAX_THATCH);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "mycelium_thatch"), MYCELIUM_THATCH);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "adobe_bricks"), ADOBE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "smooth_adobe"), SMOOTH_ADOBE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bamboo_block"), BAMBOO_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "dried_bamboo_block"), DRIED_BAMBOO_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bone_pile"), BONE_PILE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "strange_soil"), STRANGE_SOIL);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "glowshroom_block"), GLOWSHROOM_BLOCK);
        //slabs
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wicker_slab"), WICKER_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "thatch_slab"), THATCH_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "flax_thatch_slab"), FLAX_THATCH_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "mycelium_thatch_slab"), MYCELIUM_THATCH_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "adobe_brick_slab"), ADOBE_BRICK_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "smooth_adobe_slab"), SMOOTH_ADOBE_SLAB);
        //stairs
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wicker_stairs"), WICKER_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "thatch_stairs"), THATCH_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "flax_thatch_stairs"), FLAX_THATCH_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "mycelium_thatch_stairs"), MYCELIUM_THATCH_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "adobe_brick_stairs"), ADOBE_BRICK_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "smooth_adobe_stairs"), SMOOTH_ADOBE_STAIRS);
        //doors
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wicker_door"), WICKER_DOOR);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "dried_bamboo_door"), DRIED_BAMBOO_DOOR);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bamboo_door"), BAMBOO_DOOR);
        //trapdoors
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wicker_trapdoor"), WICKER_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bamboo_trapdoor"), BAMBOO_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "dried_bamboo_trapdoor"), DRIED_BAMBOO_TRAPDOOR);
        //fences and walls
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wicker_fence"), WICKER_FENCE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bamboo_fence"), BAMBOO_FENCE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "dried_bamboo_fence"), DRIED_BAMBOO_FENCE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "adobe_brick_wall"), ADOBE_BRICK_WALL);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "smooth_adobe_wall"), SMOOTH_ADOBE_WALL);
        //fence gates
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wicker_fence_gate"), WICKER_FENCE_GATE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bamboo_fence_gate"), BAMBOO_FENCE_GATE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "dried_bamboo_fence_gate"), DRIED_BAMBOO_FENCE_GATE);
        //boxes
        //shelves
        //chairs
        //stools
        //tables
        //misc
        //bundles
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "ace_bundle"), ACE_BUNDLE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "aro_bundle"), ARO_BUNDLE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bi_bundle"), BI_BUNDLE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "flower_bundle_block"), FLOWER_BUNDLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "lesbian_bundle"), LESBIAN_BUNDLE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "nonbinary_bundle"), NONBINARY_BUNDLE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "pan_bundle"), PAN_BUNDLE);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "trans_bundle"), TRANS_BUNDLE);
        //flowers
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bluebells"), BLUEBELLS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "shrub"), SHRUB);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "weeping_lily"), WEEPING_LILY);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "red_orchid"), RED_ORCHID);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "self_heal"), SELF_HEAL);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "rafflesia"), RAFFLESIA);
        //plants
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "thorns"), THORNS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "wild_aloe"), WILD_ALOE);
        //fungi
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "withercap_mushroom"), WITHERCAP_MUSHROOM);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "bargain_bell"), BARGAIN_BELL);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "green_mushroom"), GREEN_MUSHROOM);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "earthstar"), EARTHSTAR);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "glowshroom"), GLOWSHROOM);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "milkcap_mushroom"), MILKCAP_MUSHROOM);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "brown_mushrooms"), BROWN_MUSHROOMS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "red_mushrooms"), RED_MUSHROOMS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "assorted_mushrooms"), ASSORTED_MUSHROOMS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "amethyst_deceivers"), AMETHYST_DECEIVERS);
        //crops
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "peppers"), PEPPERS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "cotton"), COTTON);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "flax"), FLAX);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "gingers"), GINGERS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "obsidian_roots"), OBSIDIAN_ROOTS);
        Registry.register(Registry.BLOCK, new Identifier("earlydays", "aloe"), ALOE);
        //B L O C K  I T E M S
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wicker_block"), new BlockItem(WICKER_BLOCK, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "thatch"), new BlockItem(THATCH, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flax_thatch"), new BlockItem(FLAX_THATCH, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "mycelium_thatch"), new BlockItem(MYCELIUM_THATCH, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "adobe_bricks"), new BlockItem(ADOBE_BRICKS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "smooth_adobe"), new BlockItem(SMOOTH_ADOBE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bamboo_block"), new BlockItem(BAMBOO_BLOCK, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_bamboo_block"), new BlockItem(DRIED_BAMBOO_BLOCK, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bone_pile"), new BlockItem(BONE_PILE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "strange_soil"), new BlockItem(STRANGE_SOIL, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "glowshroom_block"), new BlockItem(GLOWSHROOM_BLOCK, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //slabs
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wicker_slab"), new BlockItem(WICKER_SLAB, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "thatch_slab"), new BlockItem(THATCH_SLAB, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flax_thatch_slab"), new BlockItem(FLAX_THATCH_SLAB, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "mycelium_thatch_slab"), new BlockItem(MYCELIUM_THATCH_SLAB, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "adobe_brick_slab"), new BlockItem(ADOBE_BRICK_SLAB, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "smooth_adobe_slab"), new BlockItem(SMOOTH_ADOBE_SLAB, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //stairs
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wicker_stairs"), new BlockItem(WICKER_STAIRS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "thatch_stairs"), new BlockItem(THATCH_STAIRS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flax_thatch_stairs"), new BlockItem(FLAX_THATCH_STAIRS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "mycelium_thatch_stairs"), new BlockItem(MYCELIUM_THATCH_STAIRS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "adobe_brick_stairs"), new BlockItem(ADOBE_BRICK_STAIRS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "smooth_adobe_stairs"), new BlockItem(SMOOTH_ADOBE_STAIRS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //doors
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wicker_door"), new BlockItem(WICKER_DOOR, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bamboo_door"), new BlockItem(BAMBOO_DOOR, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_bamboo_door"), new BlockItem(DRIED_BAMBOO_DOOR, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //trapdoors
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wicker_trapdoor"), new BlockItem(WICKER_TRAPDOOR, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bamboo_trapdoor"), new BlockItem(BAMBOO_TRAPDOOR, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_bamboo_trapdoor"), new BlockItem(DRIED_BAMBOO_TRAPDOOR, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //fences and walls
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wicker_fence"), new BlockItem(WICKER_FENCE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bamboo_fence"), new BlockItem(BAMBOO_FENCE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_bamboo_fence"), new BlockItem(DRIED_BAMBOO_FENCE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "adobe_brick_wall"), new BlockItem(ADOBE_BRICK_WALL, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "smooth_adobe_wall"), new BlockItem(SMOOTH_ADOBE_WALL, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //fence gates
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wicker_fence_gate"), new BlockItem(WICKER_FENCE_GATE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bamboo_fence_gate"), new BlockItem(BAMBOO_FENCE_GATE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "dried_bamboo_fence_gate"), new BlockItem(DRIED_BAMBOO_FENCE_GATE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //boxes
        //shelves
        //chairs
        //stools
        //tables
        //misc
        //bundles
        Registry.register(Registry.ITEM, new Identifier("earlydays", "ace_bundle"), new BlockItem(ACE_BUNDLE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "aro_bundle"), new BlockItem(ARO_BUNDLE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bi_bundle"), new BlockItem(BI_BUNDLE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "flower_bundle_block"), new BlockItem(FLOWER_BUNDLE_BLOCK, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "lesbian_bundle"), new BlockItem(LESBIAN_BUNDLE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "nonbinary_bundle"), new BlockItem(NONBINARY_BUNDLE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "pan_bundle"), new BlockItem(PAN_BUNDLE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "trans_bundle"), new BlockItem(TRANS_BUNDLE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //flowers
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bluebells"), new BlockItem(BLUEBELLS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "shrub"), new BlockItem(SHRUB, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "weeping_lily"), new BlockItem(WEEPING_LILY, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "red_orchid"), new BlockItem(RED_ORCHID, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "self_heal"), new BlockItem(SELF_HEAL, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "rafflesia"), new BlockItem(RAFFLESIA, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //plants
        Registry.register(Registry.ITEM, new Identifier("earlydays", "thorns"), new BlockItem(THORNS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "wild_aloe"), new BlockItem(WILD_ALOE, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        //fungi
        Registry.register(Registry.ITEM, new Identifier("earlydays", "withercap_mushroom"), new BlockItem(WITHERCAP_MUSHROOM, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "bargain_bell"), new BlockItem(BARGAIN_BELL, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "green_mushroom"), new BlockItem(GREEN_MUSHROOM, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "earthstar"), new BlockItem(EARTHSTAR, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "glowshroom"), new BlockItem(GLOWSHROOM, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "milkcap_mushroom"), new BlockItem(MILKCAP_MUSHROOM, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "brown_mushrooms"), new BlockItem(BROWN_MUSHROOMS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "red_mushrooms"), new BlockItem(RED_MUSHROOMS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "assorted_mushrooms"), new BlockItem(ASSORTED_MUSHROOMS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("earlydays", "amethyst_deceivers"), new BlockItem(AMETHYST_DECEIVERS, new FabricItemSettings().group(EARLYDAYS_GROUP)));
        AutoConfig.register(EarlyDaysConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(EarlyDaysConfig.class).getConfig();

        RecipeRemover.removeRecipe();
        LootTableModifier.lootTableModifier();
        LootTableModifier.fishLootTableModifier();
        FabricDefaultAttributeRegistry.register(CATFISH_ENTITY, CatfishEntity.createMobAttributes());
    }
}