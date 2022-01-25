package cafe.ferret.mc.earlydays.init;

import cafe.ferret.mc.earlydays.EarlyDays;
import cafe.ferret.mc.earlydays.item.*;
import cafe.ferret.mc.earlydays.util.EDRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Locale;

public class EarlyDaysItems {
    // Generic items are items that can be added without needing any special settings.
    public enum GenericItem {
        PLANT_MATTER, MYCELIUM_MATTER, PLANT_FIBER, MYCELIUM_FIBER, DRIED_PLANT_MATTER,
        FLAX_BUNDLE, DRIED_MYCELIUM_MATTER, FLOWER_BUNDLE, FLUFF, HIDE, FABRIC, ROPE,
        ADOBE_MIX, ADOBE_BRICK, DRIED_BAMBOO, COPPER_NUGGET, SEASHELL, SEASTAR, JELLYFISH,
        ALOE_VERA, BANDAGE, BUTTERFLY_NET
    }

    public static HashMap<GenericItem, Item> genericItems = new HashMap<>();

    // Edibles
    public static final Item PEPPER = new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.PEPPER));
    public static final Item CATFISH = new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item MINNOW = new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item CRAYFISH = new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item LOBSTER = new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item MEAT_BITS = new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final Item GRUB = new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.MEAT_BITS));
    public static final HoneyBottleItem COFFEE = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.COFFEE));
    public static final HoneyBottleItem TEA = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.TEA));
    public static final HoneyBottleItem HERBAL_TEA = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.HERBAL_TEA));
    public static final MushroomStewItem CHILI = new MushroomStewItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.CHILI));

    // Medicines
    public static final MushroomStewItem SALVE = new MushroomStewItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.SALVE).maxCount(1));
    public static final HoneyBottleItem ELIXIR = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.ELIXIR));
    public static final HoneyBottleItem HEARTY_ELIXIR = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.HEARTY_ELIXIR));
    public static final HoneyBottleItem ENLIGHTENING_ELIXIR = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.ENLIGHTENING_ELIXIR));
    public static final HoneyBottleItem TANNING_SOLUTION = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.TANNING_SOLUTION));
    public static final HoneyBottleItem CORRODING_SOLUTION = new HoneyBottleItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.CORRODING_SOLUTION));

    // Tools
    public static final KnifeItem FLINT_KNIFE = new KnifeItem(EarlyDaysToolMaterials.FLINT, 3, -2.4F, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ShovelItem FLINT_SHOVEL = new ShovelItem(EarlyDaysToolMaterials.FLINT, 1.5f, -3.0f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysPickaxeItem FLINT_PICKAXE = new EarlyDaysPickaxeItem(EarlyDaysToolMaterials.FLINT, 1, -2.8f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysAxeItem FLINT_HATCHET = new EarlyDaysAxeItem(EarlyDaysToolMaterials.FLINT, 3, -2.4f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysHoeItem FLINT_HOE = new EarlyDaysHoeItem(EarlyDaysToolMaterials.FLINT, 0, -3.0f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final KnifeItem BONE_KNIFE = new KnifeItem(EarlyDaysToolMaterials.FLINT, 3, -2.4F, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ShovelItem BONE_SHOVEL = new ShovelItem(EarlyDaysToolMaterials.FLINT, 1.5f, -3.0f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysPickaxeItem BONE_PICKAXE = new EarlyDaysPickaxeItem(EarlyDaysToolMaterials.FLINT, 1, -2.8f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysAxeItem BONE_HATCHET = new EarlyDaysAxeItem(EarlyDaysToolMaterials.FLINT, 3, -2.4f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysHoeItem BONE_HOE = new EarlyDaysHoeItem(EarlyDaysToolMaterials.FLINT, 0, -3.0f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final KnifeItem COPPER_KNIFE = new KnifeItem(EarlyDaysToolMaterials.COPPER, 3, -2.4F, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ShovelItem COPPER_SHOVEL = new ShovelItem(EarlyDaysToolMaterials.COPPER, 1.5f, -3.0f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysPickaxeItem COPPER_PICKAXE = new EarlyDaysPickaxeItem(EarlyDaysToolMaterials.COPPER, 1, -2.8f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysAxeItem COPPER_HATCHET = new EarlyDaysAxeItem(EarlyDaysToolMaterials.COPPER, 3, -2.4f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final EarlyDaysHoeItem COPPER_HOE = new EarlyDaysHoeItem(EarlyDaysToolMaterials.COPPER, 0, -3.0f, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ShearsItem COPPER_SHEARS = new ShearsItem(new FabricItemSettings().group(EarlyDays.ITEM_GROUP).maxDamage(20));

    public static final ArmorItem FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem ACE_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.ACE_FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem ARO_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.ARO_FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem BI_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.BI_FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem LESBIAN_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.LESBIAN_FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem NONBINARY_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.NONBINARY_FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem PAN_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.PAN_FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem TRANS_FLOWER_CROWN = new ArmorItem(EarlyDaysArmorMaterials.TRANS_FLOWER, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem WOOD_HELMET = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.HEAD, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem WOOD_CHESTPLATE = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.CHEST, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem WOOD_LEGGINGS = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.LEGS, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final ArmorItem WOOD_BOOTS = new ArmorItem(EarlyDaysArmorMaterials.WOOD, EquipmentSlot.FEET, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));

    // Aliased block items
    public static final Item PEPPER_SEEDS = new AliasedBlockItem(EarlyDaysBlocks.PEPPERS, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final Item COTTON_BALL = new AliasedBlockItem(EarlyDaysBlocks.COTTON, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final Item GINGER = new AliasedBlockItem(EarlyDaysBlocks.GINGERS, new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.GINGER));
    public static final Item ALOE_VERA_SEEDS = new AliasedBlockItem(EarlyDaysBlocks.ALOE, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));
    public static final Item OBSIDIAN_ROOT = new AliasedBlockItem(EarlyDaysBlocks.OBSIDIAN_ROOTS, new FabricItemSettings().group(EarlyDays.ITEM_GROUP).food(EarlyDaysFoodComponents.GINGER));
    public static final Item FLAX_SEEDS = new AliasedBlockItem(EarlyDaysBlocks.FLAX, new FabricItemSettings().group(EarlyDays.ITEM_GROUP));

    public static void register() {
        // Registering all "generic" items and placing them in a HashMap for later access.
        for (GenericItem item : GenericItem.values()) {
            genericItems.put(item, Registry.register(
                    Registry.ITEM,
                    new Identifier(EarlyDays.MODID, item.name().toLowerCase(Locale.ROOT)),
                    new Item(new FabricItemSettings().group(EarlyDays.ITEM_GROUP))
            ));
        }


        // Edibles
        EDRegistry.registerItem("pepper", PEPPER);
        EDRegistry.registerItem("catfish", CATFISH);
        EDRegistry.registerItem("minnow", MINNOW);
        EDRegistry.registerItem("crayfish", CRAYFISH);
        EDRegistry.registerItem("lobster", LOBSTER);
        EDRegistry.registerItem("meat_bits", MEAT_BITS);
        EDRegistry.registerItem("grub", GRUB);
        EDRegistry.registerItem("coffee", COFFEE);
        EDRegistry.registerItem("tea", TEA);
        EDRegistry.registerItem("herbal_tea", HERBAL_TEA);
        EDRegistry.registerItem("chili", CHILI);
        EDRegistry.registerItem("salve", SALVE);
        EDRegistry.registerItem("elixir", ELIXIR);
        EDRegistry.registerItem("hearty_elixir", HEARTY_ELIXIR);
        EDRegistry.registerItem("enlightening_elixir", ENLIGHTENING_ELIXIR);
        EDRegistry.registerItem("tanning_solution", TANNING_SOLUTION);
        EDRegistry.registerItem("corroding_solution", CORRODING_SOLUTION);

        EDRegistry.registerItem("flint_knife", FLINT_KNIFE);
        EDRegistry.registerItem("flint_shovel", FLINT_SHOVEL);
        EDRegistry.registerItem("flint_pickaxe", FLINT_PICKAXE);
        EDRegistry.registerItem("flint_hatchet", FLINT_HATCHET);
        EDRegistry.registerItem("flint_hoe", FLINT_HOE);
        EDRegistry.registerItem("bone_knife", BONE_KNIFE);
        EDRegistry.registerItem("bone_shovel", BONE_SHOVEL);
        EDRegistry.registerItem("bone_pickaxe", BONE_PICKAXE);
        EDRegistry.registerItem("bone_hatchet", BONE_HATCHET);
        EDRegistry.registerItem("bone_hoe", BONE_HOE);
        EDRegistry.registerItem("copper_knife", COPPER_KNIFE);
        EDRegistry.registerItem("copper_shovel", COPPER_SHOVEL);
        EDRegistry.registerItem("copper_pickaxe", COPPER_PICKAXE);
        EDRegistry.registerItem("copper_hatchet", COPPER_HATCHET);
        EDRegistry.registerItem("copper_hoe", COPPER_HOE);
        EDRegistry.registerItem("copper_shears", COPPER_SHEARS);

        EDRegistry.registerItem("flower_crown", FLOWER_CROWN);
        EDRegistry.registerItem("ace_flower_crown", ACE_FLOWER_CROWN);
        EDRegistry.registerItem("aro_flower_crown", ARO_FLOWER_CROWN);
        EDRegistry.registerItem("bi_flower_crown", BI_FLOWER_CROWN);
        EDRegistry.registerItem("lesbian_flower_crown", LESBIAN_FLOWER_CROWN);
        EDRegistry.registerItem("nonbinary_flower_crown", NONBINARY_FLOWER_CROWN);
        EDRegistry.registerItem("pan_flower_crown", PAN_FLOWER_CROWN);
        EDRegistry.registerItem("trans_flower_crown", TRANS_FLOWER_CROWN);
        EDRegistry.registerItem("wood_helmet", WOOD_HELMET);
        EDRegistry.registerItem("wood_chestplate", WOOD_CHESTPLATE);
        EDRegistry.registerItem("wood_leggings", WOOD_LEGGINGS);
        EDRegistry.registerItem("wood_boots", WOOD_BOOTS);

        EDRegistry.registerItem("pepper_seeds", PEPPER_SEEDS);
        EDRegistry.registerItem("cotton_ball", COTTON_BALL);
        EDRegistry.registerItem("ginger", GINGER);
        EDRegistry.registerItem("aloe_vera_seeds", ALOE_VERA_SEEDS);
        EDRegistry.registerItem("obsidian_root", OBSIDIAN_ROOT);
        EDRegistry.registerItem("flax_seeds", FLAX_SEEDS);
    }
}
