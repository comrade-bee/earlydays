package cafe.ferret.mc.earlydays.init;

import cafe.ferret.mc.earlydays.EarlyDays;
import cafe.ferret.mc.earlydays.entity.CatfishEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EarlyDaysEntities {
    public static final EntityType<CatfishEntity> CATFISH_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, CatfishEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build();

    public static void register() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(EarlyDays.MODID, "catfish"), CATFISH_ENTITY);
    }
}
