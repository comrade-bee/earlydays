package cafe.ferret.mc.earlydays.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.world.World;

public class DrawingEntity extends PaintingEntity {
    public DrawingEntity(EntityType<? extends PaintingEntity> entityType, World world) {
        super(entityType, world);
    }
}
