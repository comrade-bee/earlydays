package cafe.ferret.mc.earlydays.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class FlowerBundleBlock extends Block {
    public static VoxelShape BUNDLE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D);
    public static VoxelShape FLOWERS = Block.createCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static VoxelShape SYNTHESIS = VoxelShapes.union(BUNDLE,FLOWERS);
    public FlowerBundleBlock(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return SYNTHESIS;
    }
}
