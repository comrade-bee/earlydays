package cafe.ferret.mc.earlydays.init;

import cafe.ferret.mc.earlydays.EarlyDays;
import cafe.ferret.mc.earlydays.block.entity.BasketBlockEntity;
import cafe.ferret.mc.earlydays.block.entity.BloomeryBlockEntity;
import cafe.ferret.mc.earlydays.block.entity.DryingRackBlockEntity;
import cafe.ferret.mc.earlydays.block.entity.FishTrapBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EarlyDaysBlockEntities {
    public static BlockEntityType<BasketBlockEntity> BASKET;
    public static BlockEntityType<BloomeryBlockEntity> BLOOMERY;
    public static BlockEntityType<DryingRackBlockEntity> DRYING_RACK;
    public static BlockEntityType<FishTrapBlockEntity> FISH_TRAP;


    public static void register (){
        BASKET = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EarlyDays.MODID, "wicker_basket"), FabricBlockEntityTypeBuilder.create(BasketBlockEntity::new, EarlyDaysBlocks.WICKER_BASKET).build(null));
        BLOOMERY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EarlyDays.MODID, "bloomery"), FabricBlockEntityTypeBuilder.create(BloomeryBlockEntity::new, EarlyDaysBlocks.BLOOMERY).build(null));
        DRYING_RACK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EarlyDays.MODID, "drying_rack"), FabricBlockEntityTypeBuilder.create(DryingRackBlockEntity::new, EarlyDaysBlocks.DRYING_RACK).build(null));
        FISH_TRAP = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EarlyDays.MODID, "fish_trap"), FabricBlockEntityTypeBuilder.create(FishTrapBlockEntity::new, EarlyDaysBlocks.FISH_TRAP).build(null));
    }
}
