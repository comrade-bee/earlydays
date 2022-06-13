package cafe.ferret.mc.earlydays.block.entity;

import cafe.ferret.mc.earlydays.init.EarlyDaysBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BloomeryBlockEntity extends BlockEntity {
    public BloomeryBlockEntity(BlockPos pos, BlockState state) {
        super(EarlyDaysBlockEntities.BLOOMERY, pos, state);
    }
}
