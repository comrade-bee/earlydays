package cafe.ferret.mc.earlydays.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class FishTrapBlock extends Block {
    public static VoxelShape TRAP = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public FishTrapBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context){
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation){
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }
    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror){
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    @Override
    protected void appendProperties (StateManager.Builder<Block, BlockState> builder){
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return TRAP;
    }
}
