package cafe.ferret.mc.earlydays.init;

import cafe.ferret.mc.earlydays.block.*;
import cafe.ferret.mc.earlydays.util.EDRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import cafe.ferret.mc.earlydays.block.BasketBlock;

public class EarlyDaysBlocks {
    //B L O C K S
    public static final Block WICKER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block THATCH = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block FLAX_THATCH = new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block ADOBE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE, MapColor.DIRT_BROWN).requiresTool().strength(1.25F, 4.2F));
    public static final Block SMOOTH_ADOBE = new Block(FabricBlockSettings.copy(ADOBE_BRICKS));
    public static final Block BAMBOO_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.GREEN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block DRIED_BAMBOO_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block BONE_PILE = new Block(FabricBlockSettings.copy(Blocks.BONE_BLOCK));
    //slabs
    public static final SlabBlock WICKER_SLAB = new SlabBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final SlabBlock THATCH_SLAB = new SlabBlock(FabricBlockSettings.copy(THATCH));
    public static final SlabBlock FLAX_THATCH_SLAB = new SlabBlock(FabricBlockSettings.copy(FLAX_THATCH));
    public static final SlabBlock ADOBE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copy(ADOBE_BRICKS));
    public static final SlabBlock SMOOTH_ADOBE_SLAB = new SlabBlock(FabricBlockSettings.copy(SMOOTH_ADOBE));
    public static final SlabBlock BAMBOO_SLAB = new SlabBlock(FabricBlockSettings.copy(BAMBOO_BLOCK));
    public static final SlabBlock DRIED_BAMBOO_SLAB = new SlabBlock(FabricBlockSettings.copy(DRIED_BAMBOO_BLOCK));
    //stairs
    public static final EarlyDaysStairsBlock WICKER_STAIRS = new EarlyDaysStairsBlock(WICKER_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(WICKER_BLOCK));
    public static final EarlyDaysStairsBlock THATCH_STAIRS = new EarlyDaysStairsBlock(THATCH.getDefaultState(), FabricBlockSettings.copyOf(THATCH));
    public static final EarlyDaysStairsBlock FLAX_THATCH_STAIRS = new EarlyDaysStairsBlock(FLAX_THATCH.getDefaultState(), FabricBlockSettings.copyOf(FLAX_THATCH));
    public static final EarlyDaysStairsBlock ADOBE_BRICK_STAIRS = new EarlyDaysStairsBlock(ADOBE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ADOBE_BRICKS));
    public static final EarlyDaysStairsBlock SMOOTH_ADOBE_STAIRS = new EarlyDaysStairsBlock(SMOOTH_ADOBE.getDefaultState(), FabricBlockSettings.copyOf(SMOOTH_ADOBE));
    public static final EarlyDaysStairsBlock BAMBOO_STAIRS = new EarlyDaysStairsBlock(BAMBOO_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(BAMBOO_BLOCK));
    public static final EarlyDaysStairsBlock DRIED_BAMBOO_STAIRS = new EarlyDaysStairsBlock(DRIED_BAMBOO_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(DRIED_BAMBOO_BLOCK));
    //doors
    public static final EarlyDaysDoorBlock WICKER_DOOR = new EarlyDaysDoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final EarlyDaysDoorBlock BAMBOO_DOOR = new EarlyDaysDoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.GREEN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final EarlyDaysDoorBlock DRIED_BAMBOO_DOOR = new EarlyDaysDoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    //trapdoors
    public static final EarlyDaysTrapdoorBlock WICKER_TRAPDOOR = new EarlyDaysTrapdoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final EarlyDaysTrapdoorBlock BAMBOO_TRAPDOOR = new EarlyDaysTrapdoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.GREEN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final EarlyDaysTrapdoorBlock DRIED_BAMBOO_TRAPDOOR = new EarlyDaysTrapdoorBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.5F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    //fences and walls
    public static final FenceBlock WICKER_FENCE = new FenceBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final FenceBlock BAMBOO_FENCE = new FenceBlock(FabricBlockSettings.copy(BAMBOO_BLOCK));
    public static final FenceBlock DRIED_BAMBOO_FENCE = new FenceBlock(FabricBlockSettings.copy(DRIED_BAMBOO_BLOCK));
    public static final WallBlock ADOBE_BRICK_WALL = new WallBlock(FabricBlockSettings.copy(ADOBE_BRICKS));
    public static final WallBlock SMOOTH_ADOBE_WALL = new WallBlock(FabricBlockSettings.copy(SMOOTH_ADOBE));
    //fence gates
    public static final FenceGateBlock WICKER_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final FenceGateBlock BAMBOO_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(BAMBOO_BLOCK));
    public static final FenceGateBlock DRIED_BAMBOO_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(DRIED_BAMBOO_BLOCK));
    //misc
    //public static final Block WHEEL_LOOM = new Block(FabricBlockSettings.copy(Blocks.OAK_LOG));
    public static final BasketBlock WICKER_BASKET = new BasketBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final Block DRYING_RACK = new DryingRackBlock(FabricBlockSettings.copy(WICKER_BLOCK));
    public static final Block BASALT_BLOOMERY = new BasaltBloomeryBlock(FabricBlockSettings.copy(Blocks.STONE));
    public static final Block BLACKSTONE_BLOOMERY = new BlackstoneBloomeryBlock(FabricBlockSettings.copy(Blocks.STONE));
    public static final Block BLOOMERY = new BloomeryBlock(FabricBlockSettings.copy(Blocks.STONE));
    public static final Block FISH_TRAP = new FishTrapBlock(FabricBlockSettings.copy(EarlyDaysBlocks.WICKER_BLOCK).nonOpaque());
    //bundles
    public static final Block ACE_BUNDLE = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block ARO_BUNDLE = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block BI_BUNDLE = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block FLOWER_BUNDLE_BLOCK = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block LESBIAN_BUNDLE = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block NONBINARY_BUNDLE = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block PAN_BUNDLE = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    public static final Block TRANS_BUNDLE = new FlowerBundleBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK));
    //flowers
    public static final FlowerBlock WEEPING_LILY = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4, FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final FlowerBlock SELF_HEAL = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4, FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final FlowerBlock RAFFLESIA = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4, FabricBlockSettings.copy(Blocks.ALLIUM));
    //plants
    public static final FlowerBlock THORNS = new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4, FabricBlockSettings.copy(Blocks.ALLIUM));
    public static final EarlyDaysSandPlant WILD_ALOE = new EarlyDaysSandPlant(StatusEffects.FIRE_RESISTANCE, 0, FabricBlockSettings.copy(Blocks.ALLIUM));
    //crops
    public static final EarlyDaysCropBlock PEPPERS = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final EarlyDaysCropBlock FLAX = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final EarlyDaysCropBlock GINGERS = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final EarlyDaysWildCrop ALOE = new EarlyDaysWildCrop(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final EarlyDaysCropBlock OBSIDIAN_ROOTS = new EarlyDaysCropBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

    public static void register() {
        EDRegistry.registerBlockWithItem("wicker_block", WICKER_BLOCK);
        EDRegistry.registerBlockWithItem("thatch", THATCH);
        EDRegistry.registerBlockWithItem("flax_thatch", FLAX_THATCH);
        EDRegistry.registerBlockWithItem("adobe_bricks", ADOBE_BRICKS);
        EDRegistry.registerBlockWithItem("smooth_adobe", SMOOTH_ADOBE);
        EDRegistry.registerBlockWithItem("bamboo_block", BAMBOO_BLOCK);
        EDRegistry.registerBlockWithItem("dried_bamboo_block", DRIED_BAMBOO_BLOCK);
        EDRegistry.registerBlockWithItem("bone_pile", BONE_PILE);
        //slabs
        EDRegistry.registerBlockWithItem("wicker_slab", WICKER_SLAB);
        EDRegistry.registerBlockWithItem("thatch_slab", THATCH_SLAB);
        EDRegistry.registerBlockWithItem("flax_thatch_slab", FLAX_THATCH_SLAB);
        EDRegistry.registerBlockWithItem("adobe_brick_slab", ADOBE_BRICK_SLAB);
        EDRegistry.registerBlockWithItem("smooth_adobe_slab", SMOOTH_ADOBE_SLAB);
        EDRegistry.registerBlockWithItem("bamboo_slab", BAMBOO_SLAB);
        EDRegistry.registerBlockWithItem("dried_bamboo_slab", DRIED_BAMBOO_SLAB);
        //stairs
        EDRegistry.registerBlockWithItem("wicker_stairs", WICKER_STAIRS);
        EDRegistry.registerBlockWithItem("thatch_stairs", THATCH_STAIRS);
        EDRegistry.registerBlockWithItem("flax_thatch_stairs", FLAX_THATCH_STAIRS);
        EDRegistry.registerBlockWithItem("adobe_brick_stairs", ADOBE_BRICK_STAIRS);
        EDRegistry.registerBlockWithItem("smooth_adobe_stairs", SMOOTH_ADOBE_STAIRS);
        EDRegistry.registerBlockWithItem("bamboo_stairs", BAMBOO_STAIRS);
        EDRegistry.registerBlockWithItem("dried_bamboo_stairs", DRIED_BAMBOO_STAIRS);
        //doors
        EDRegistry.registerBlockWithItem("wicker_door", WICKER_DOOR);
        EDRegistry.registerBlockWithItem("dried_bamboo_door", DRIED_BAMBOO_DOOR);
        EDRegistry.registerBlockWithItem("bamboo_door", BAMBOO_DOOR);
        //trapdoors
        EDRegistry.registerBlockWithItem("wicker_trapdoor", WICKER_TRAPDOOR);
        EDRegistry.registerBlockWithItem("bamboo_trapdoor", BAMBOO_TRAPDOOR);
        EDRegistry.registerBlockWithItem("dried_bamboo_trapdoor", DRIED_BAMBOO_TRAPDOOR);
        //fences and walls
        EDRegistry.registerBlockWithItem("wicker_fence", WICKER_FENCE);
        EDRegistry.registerBlockWithItem("bamboo_fence", BAMBOO_FENCE);
        EDRegistry.registerBlockWithItem("dried_bamboo_fence", DRIED_BAMBOO_FENCE);
        EDRegistry.registerBlockWithItem("adobe_brick_wall", ADOBE_BRICK_WALL);
        EDRegistry.registerBlockWithItem("smooth_adobe_wall", SMOOTH_ADOBE_WALL);
        //fence gates
        EDRegistry.registerBlockWithItem("wicker_fence_gate", WICKER_FENCE_GATE);
        EDRegistry.registerBlockWithItem("bamboo_fence_gate", BAMBOO_FENCE_GATE);
        EDRegistry.registerBlockWithItem("dried_bamboo_fence_gate", DRIED_BAMBOO_FENCE_GATE);
        //misc
        //EDRegistry.registerBlockWithItem("wheel_loom", WHEEL_LOOM);
        EDRegistry.registerBlockWithItem("wicker_basket", WICKER_BASKET);
        EDRegistry.registerBlockWithItem("drying_rack", DRYING_RACK);
        EDRegistry.registerBlockWithItem("bloomery", BLOOMERY);
        EDRegistry.registerBlockWithItem("basalt_bloomery", BASALT_BLOOMERY);
        EDRegistry.registerBlockWithItem("blackstone_bloomery", BLACKSTONE_BLOOMERY);
        EDRegistry.registerBlockWithItem("fish_trap", FISH_TRAP);
        //bundles
        EDRegistry.registerBlockWithItem("ace_bundle", ACE_BUNDLE);
        EDRegistry.registerBlockWithItem("aro_bundle", ARO_BUNDLE);
        EDRegistry.registerBlockWithItem("bi_bundle", BI_BUNDLE);
        EDRegistry.registerBlockWithItem("flower_bundle_block", FLOWER_BUNDLE_BLOCK);
        EDRegistry.registerBlockWithItem("lesbian_bundle", LESBIAN_BUNDLE);
        EDRegistry.registerBlockWithItem("nonbinary_bundle", NONBINARY_BUNDLE);
        EDRegistry.registerBlockWithItem("pan_bundle", PAN_BUNDLE);
        EDRegistry.registerBlockWithItem("trans_bundle", TRANS_BUNDLE);
        //flowers
        EDRegistry.registerBlockWithItem("weeping_lily", WEEPING_LILY);
        EDRegistry.registerBlockWithItem("self_heal", SELF_HEAL);
        EDRegistry.registerBlockWithItem("rafflesia", RAFFLESIA);
        //plants
        EDRegistry.registerBlockWithItem("thorns", THORNS);
        EDRegistry.registerBlockWithItem("wild_aloe", WILD_ALOE);
        //crops
        EDRegistry.registerBlockWithItem("peppers", PEPPERS);
        EDRegistry.registerBlockWithItem("flax", FLAX);
        EDRegistry.registerBlockWithItem("gingers", GINGERS);
        EDRegistry.registerBlockWithItem("obsidian_roots", OBSIDIAN_ROOTS);
        EDRegistry.registerBlockWithItem("aloe", ALOE);
    }
}
