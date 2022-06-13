package cafe.ferret.mc.earlydays.block;

// import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
// import net.minecraft.block.entity.BlockEntity;
// import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
// import net.minecraft.particle.ParticleTypes;
// import net.minecraft.sound.SoundCategory;
// import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.math.Direction;
// import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

// import java.util.Random;

public class BloomeryBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public BloomeryBlock(Settings settings) {
        super(settings);
    }

    //THE ROTATION THINGS
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
}
