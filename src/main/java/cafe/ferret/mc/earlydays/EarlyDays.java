package cafe.ferret.mc.earlydays;

import cafe.ferret.mc.earlydays.entity.CatfishEntity;
import cafe.ferret.mc.earlydays.init.EarlyDaysBlockEntities;
import cafe.ferret.mc.earlydays.init.EarlyDaysBlocks;
import cafe.ferret.mc.earlydays.init.EarlyDaysEntities;
import cafe.ferret.mc.earlydays.init.EarlyDaysItems;
import cafe.ferret.mc.earlydays.util.LootTableModifier;
import cafe.ferret.mc.earlydays.util.RecipeRemover;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cafe.ferret.mc.earlydays.init.EarlyDaysScreenHandlers;

import java.util.List;

//CODE USED UNDER THE MIT LICENSE FROM EARLYGAME https://github.com/JayCeeCreates/earlygame

public class EarlyDays implements ModInitializer {
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(EarlyDays.MODID, "earlydays"))
            .icon(() -> new ItemStack(EarlyDaysItems.genericItems.get(EarlyDaysItems.GenericItem.FLAX_BUNDLE)))
            .build();

    public static final String MODID = "earlydays";
    public static final Logger LOGGER = LogManager.getLogger("earlydays");

    @Override
    public void onInitialize() {
        // Register all blocks
        EarlyDaysBlocks.register();
        //Register all block entities
        EarlyDaysBlockEntities.register();
        // Register all items
        EarlyDaysItems.register();
        // Register all entities
        EarlyDaysEntities.register();
        // Register all screenhandlers
        EarlyDaysScreenHandlers.register();
        // Loot table things
        LootTableModifier.lootTableModifier();
        RecipeRemover.removeRecipe();

        FabricDefaultAttributeRegistry.register(EarlyDaysEntities.CATFISH_ENTITY, CatfishEntity.createMobAttributes());
    
    }
}