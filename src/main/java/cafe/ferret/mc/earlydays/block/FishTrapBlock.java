package cafe.ferret.mc.earlydays.block;

// import cafe.ferret.mc.earlydays.block.entity.FishTrapBlockEntity;
import cafe.ferret.mc.earlydays.init.EarlyDaysItems;
import cafe.ferret.mc.earlydays.init.EarlyDaysTags;
import net.minecraft.block.*;
// import net.minecraft.block.entity.BlockEntity;
// import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
// import net.minecraft.inventory.Inventory;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.random.Random;
import net.minecraft.item.Item;
import net.minecraft.state.property.IntProperty;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.particle.ParticleTypes;

@SuppressWarnings("deprecation")
public class FishTrapBlock extends Block implements Waterloggable {
    public static VoxelShape TRAP = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty BAITED = BooleanProperty.of("baited");
    public static final BooleanProperty FULL = BooleanProperty.of("full");
    public static final IntProperty TIME = IntProperty.of("time",0,5);


    public FishTrapBlock(Settings settings) {
        super(settings);
        this.setDefaultState();
    }

    protected void setDefaultState() {
        setDefaultState(stateManager.getDefaultState().with(WATERLOGGED, false).with(FULL, false).with(BAITED, false).with(TIME, 0));
    }
    
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context){
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite()).with(WATERLOGGED, false).with(BAITED, false).with(FULL,false).with(TIME, 0);
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
        builder.add(FACING, WATERLOGGED, BAITED, FULL, TIME);
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
        if(!world.isClient && hand == Hand.MAIN_HAND){
            ItemStack handStack = player.getStackInHand(hand);
            if(!state.get(BAITED)&&!state.get(FULL)){
                 if(!handStack.isEmpty()) {
                    // if (handStack.getItem() instanceof FuelRegistry) {
                    if (handStack.isIn(EarlyDaysTags.BAIT_ITEMS)) {
                        world.setBlockState(pos, state.with(BAITED, true), 3);
                        handStack.decrement(1);
                        // blockEntity.markDirty();
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        return ActionResult.SUCCESS;
                    }
                }
            }

            if(state.get(FULL)){
                ItemStack itemStack = new ItemStack(rollLoot(world.getRandom()));
                player.getInventory().offerOrDrop(itemStack);
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, state.with(FULL, false), 3);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.CONSUME;
    }

    //LOOT ROLLER
    public Item rollLoot(Random random){
        int i = random.nextInt(100);
        if (i < 5) {
           return Items.SALMON;
        } else if (i < 10) {
           return Items.PUFFERFISH;
        } else if (i < 15) {
           return EarlyDaysItems.LOBSTER;
        } else if (i < 18) {
           return Items.STICK;
        } else {
           return Items.COD;
        }
    }

    //TICK THINGS
    public boolean hasRandomTicks(BlockState state) {
        return state.get(BAITED);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(state.get(WATERLOGGED)) {
           int i = state.get(TIME);
           if (i < 5) {
                world.setBlockState(pos, state.with(TIME, ++i), 3);
           } else {
                world.setBlockState(pos, state.with(FULL, true).with(BAITED, false).with(TIME, 0), 3);
           }
        }
    }

    //PARTICLE THINGS (BEE)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random){
        if(state.get(FULL)){
            fullParticles(world,pos);
        }
    }

    public static void fullParticles(World world, BlockPos pos){
        Random random = world.random;
        Direction[] directions = Direction.values();
        int directionsL = directions.length;

        for(int i = 0; i < directionsL; ++i) {
            Direction direction = directions[i];
            BlockPos blockPos = pos.offset(direction);
            if (!world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
                Direction.Axis axis = direction.getAxis();
                double e = axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getOffsetX() : (double)random.nextFloat();
                double f = axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getOffsetY() : (double)random.nextFloat();
                double g = axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getOffsetZ() : (double)random.nextFloat();
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double)pos.getX() + e, (double)pos.getY() + f, (double)pos.getZ() + g, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
