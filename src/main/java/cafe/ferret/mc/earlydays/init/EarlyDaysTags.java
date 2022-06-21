package cafe.ferret.mc.earlydays.init;

import cafe.ferret.mc.earlydays.EarlyDays;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.event.GameEvent;

public class EarlyDaysTags {

    //Item Tags
    public static final TagKey<Item> VANILLA_TOOLS = TagKey.of(Registry.ITEM_KEY, new Identifier(EarlyDays.MODID,"vanilla_tools"));
    public static final TagKey<Item> BAIT_ITEMS = TagKey.of(Registry.ITEM_KEY, new Identifier(EarlyDays.MODID,"bait_items"));
    //Block Tags

}
