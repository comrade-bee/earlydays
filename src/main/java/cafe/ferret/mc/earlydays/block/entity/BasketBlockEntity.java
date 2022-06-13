package cafe.ferret.mc.earlydays.block.entity;

import cafe.ferret.mc.earlydays.init.EarlyDaysBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class BasketBlockEntity extends BlockEntity {
    public BasketBlockEntity(BlockPos pos, BlockState state) {
        super(EarlyDaysBlockEntities.BASKET, pos, state);
    }
}
