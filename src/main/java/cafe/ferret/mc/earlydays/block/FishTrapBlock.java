package cafe.ferret.mc.earlydays.block;

import cafe.ferret.mc.earlydays.block.entity.FishTrapBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class FishTrapBlock extends Block implements Waterloggable {
    public static VoxelShape TRAP = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty BAITED = BooleanProperty.of("baited");
    public static final BooleanProperty FULL = BooleanProperty.of("full");

    public FishTrapBlock(Settings settings) {
        super(settings);
        this.setDefaultState();
    }

    protected void setDefaultState() {
        setDefaultState(stateManager.getDefaultState().with(WATERLOGGED, false).with(FULL, false).with(BAITED, false));
    }
    
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context){
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite()).with(WATERLOGGED, false).with(BAITED, false).with(FULL,false);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState,
                                                WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
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
        super.appendProperties(builder);
        builder.add(FACING, WATERLOGGED, BAITED, FULL);
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return TRAP;
    }

    //BLOCK ACTION THINGS
    @Override
    public BlockRenderType getRenderType (BlockState state){
        return BlockRenderType.MODEL;
    }

    public ActionResult onUse (BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(!world.isClient){

            if(!state.get(BAITED)&&!state.get(FULL)){}

            if(state.get(FULL)){}
        }

        if(!world.isClient && hand == Hand.MAIN_HAND){
            boolean currentState = state.get(BAITED);
            world.setBlockState(pos, state.with(BAITED, !currentState), 3);
        }
        return ActionResult.SUCCESS;
    }


    /*
        @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient()) return ActionResult.CONSUME;
        BloomeryBlockEntity blockEntity = (BloomeryBlockEntity) world.getBlockEntity(pos);
        ItemStack cookingItem = blockEntity.getItems().get(0);
        ItemStack fuelItem = blockEntity.getItems().get(1);
        ItemStack handStack = player.getStackInHand(hand);


        if(fuelItem.isEmpty()) {
            if(!handStack.isEmpty()) {
                // if (handStack.getItem() instanceof FuelRegistry) {
                if (handStack.getItem() == Items.COAL) {
                    blockEntity.setStack(1, handStack.copy());
                    blockEntity.getItems().get(0).setCount(1);
                    handStack.decrement(1);
                    // blockEntity.markDirty();
                    world.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }
        }

        if(cookingItem.isEmpty()) {
            if(!handStack.isEmpty()) {
                blockEntity.setStack(0, handStack.copy());
                blockEntity.getItems().get(0).setCount(1);
                handStack.decrement(1);
                // blockEntity.markDirty();
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        } else {
            if(handStack.isEmpty()) {
                // blockEntity.canDry = false;
                // blockEntity.checkedRecipe = false;
                // blockEntity.dryingTime = 0;
                // blockEntity.markDirty();
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
        // world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        return ActionResult.SUCCESS;
    }

     */

}
