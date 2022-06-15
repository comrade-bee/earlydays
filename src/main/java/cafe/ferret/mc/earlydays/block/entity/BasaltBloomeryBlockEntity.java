package cafe.ferret.mc.earlydays.block.entity;

import cafe.ferret.mc.earlydays.init.EarlyDaysBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BasaltBloomeryBlockEntity extends BlockEntity {
    public BasaltBloomeryBlockEntity(BlockPos pos, BlockState state) {
        super(EarlyDaysBlockEntities.BASALT_BLOOMERY, pos, state);
    }
}
