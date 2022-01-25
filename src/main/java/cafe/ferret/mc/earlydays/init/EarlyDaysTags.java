package cafe.ferret.mc.earlydays.init;

import cafe.ferret.mc.earlydays.EarlyDays;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class EarlyDaysTags {
    //ITEM TAGS
    public static Tag<Item> VANILLA_TOOLS;
    public static Tag<Item> STONE_RECIPES;
    //BLOCK TAGS
    public static Tag<Block> DROPS_PLANT_MATTER;
    //public static Tag<Block> DROPS_FLINT = TagFactory.BLOCK.create(new Identifier(MODID, "drops_flint"));
    //ENTITY TAGS
    public static Tag<EntityType<?>> DROPS_BONE;
    public static Tag<EntityType<?>> DROPS_HIDE;

    public static void register() {
        VANILLA_TOOLS = TagFactory.ITEM.create(new Identifier(EarlyDays.MODID, "vanilla_tools"));
        STONE_RECIPES = TagFactory.ITEM.create(new Identifier(EarlyDays.MODID, "stone_recipes"));
        DROPS_PLANT_MATTER = TagFactory.BLOCK.create(new Identifier(EarlyDays.MODID, "drops_plant_matter"));
        DROPS_BONE = TagFactory.ENTITY_TYPE.create(new Identifier(EarlyDays.MODID, "drops_bone"));
        DROPS_HIDE = TagFactory.ENTITY_TYPE.create(new Identifier(EarlyDays.MODID, "drops_hide"));
    }
}
