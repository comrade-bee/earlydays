package cafe.ferret.mc.earlydays.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DryingRackBlock extends Block {
    public static VoxelShape LEG_0 = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 3.0D, 14.0D, 3.0D);
    public static VoxelShape LEG_1 = Block.createCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 14.0D, 3.0D);
    public static VoxelShape LEG_2 = Block.createCuboidShape(13.0D, 0.0D, 13.0D, 15.0D, 14.0D, 15.0D);
    public static VoxelShape LEG_3 = Block.createCuboidShape(1.0D, 0.0D, 13.0D, 3.0D, 14.0D, 15.0D);
    public static VoxelShape BASE = Block.createCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static VoxelShape SYNTHESIS = VoxelShapes.union(LEG_0,LEG_1,LEG_2,LEG_3,BASE);

    public DryingRackBlock(Settings settings) {
        super(settings);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return SYNTHESIS;
    }
}