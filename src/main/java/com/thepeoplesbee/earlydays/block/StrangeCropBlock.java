package com.thepeoplesbee.earlydays.block;

import com.thepeoplesbee.earlydays.EarlyDays;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class StrangeCropBlock extends CropBlock {
    public StrangeCropBlock(Settings settings) {super(settings);}
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(EarlyDays.STRANGE_SOIL);
    }
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}
