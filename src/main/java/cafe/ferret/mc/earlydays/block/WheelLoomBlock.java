package cafe.ferret.mc.earlydays.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;

public class WheelLoomBlock extends Block {
    public WheelLoomBlock(Settings settings) {
        super(settings);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
