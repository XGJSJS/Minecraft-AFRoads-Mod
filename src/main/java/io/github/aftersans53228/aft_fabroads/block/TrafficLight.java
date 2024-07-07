package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public  class TrafficLight extends BaseEntityBlock {
    public static final BooleanProperty hasTimer = BooleanProperty.create("has_timer");

    public TrafficLight() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).noOcclusion().lightLevel(state -> 3));
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(hasTimer, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
        stateManager.add(hasTimer);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem() == RoadTool.get()) {
            world.setBlock(pos, state.setValue(hasTimer, !state.getValue(hasTimer)), Block.UPDATE_ALL);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        VoxelShape shape = Shapes.empty();
        switch (dir) {
            case NORTH:
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.8125, 0.3125, 0.6875, 1.1875, 0.375));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.4375, 0.3125, 0.6875, 0.8125, 0.375));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.125, 0.3125, 0.6875, 0.4375, 0.375));
                shape = Shapes.or(shape, Shapes.box(0.1875, 0, 0.1875, 0.8125, 1.3125, 0.3125));
                shape = Shapes.or(shape, Shapes.box(0.3125, 1.15625, 0.3125, 0.6875, 1.20625, 0.5625));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.8125, 0.375, 0.6875, 0.8625, 0.5625));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.45625, 0.375, 0.6875, 0.50625, 0.5625));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.875, 0.375, 0.625, 1.125, 0.38125));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.5375, 0.375, 0.625, 0.7875, 0.38125));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.1875, 0.375, 0.625, 0.4375, 0.38125));
                shape = Shapes.or(shape, Shapes.box(0.4375, 0.4375, 0, 0.5625, 0.5625, 0.1875));
                shape = Shapes.or(shape, Shapes.box(0.25, 0.0625, 0.3125, 0.3125, 1.1875, 0.4375));
                shape = Shapes.or(shape, Shapes.box(0.6875, 0.0625, 0.3125, 0.75, 1.1875, 0.4375));
                return shape;
            case SOUTH:
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.8125, 0.625, 0.6875, 1.1875, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.4375, 0.625, 0.6875, 0.8125, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.125, 0.625, 0.6875, 0.4375, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.1875, 0, 0.6875, 0.8125, 1.3125, 0.8125));
                shape = Shapes.or(shape, Shapes.box(0.3125, 1.15625, 0.4375, 0.6875, 1.20625, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.8125, 0.4375, 0.6875, 0.8625, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.45625, 0.4375, 0.6875, 0.50625, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.875, 0.61875, 0.625, 1.125, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.5375, 0.61875, 0.625, 0.7875, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.1875, 0.61875, 0.625, 0.4375, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.4375, 0.4375, 0.8125, 0.5625, 0.5625, 1));
                shape = Shapes.or(shape, Shapes.box(0.6875, 0.0625, 0.5625, 0.75, 1.1875, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.25, 0.0625, 0.5625, 0.3125, 1.1875, 0.6875));
                return shape;
            case EAST:
                shape = Shapes.or(shape, Shapes.box(0.625, 0.8125, 0.3125, 0.6875, 1.1875, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.625, 0.4375, 0.3125, 0.6875, 0.8125, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.625, 0.125, 0.3125, 0.6875, 0.4375, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.6875, 0, 0.1875, 0.8125, 1.3125, 0.8125));
                shape = Shapes.or(shape, Shapes.box(0.4375, 1.15625, 0.3125, 0.6875, 1.20625, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.4375, 0.8125, 0.3125, 0.625, 0.8625, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.4375, 0.45625, 0.3125, 0.625, 0.50625, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.61875, 0.875, 0.375, 0.625, 1.125, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.61875, 0.5375, 0.375, 0.625, 0.7875, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.61875, 0.1875, 0.375, 0.625, 0.4375, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.8125, 0.4375, 0.4375, 1, 0.5625, 0.5625));
                shape = Shapes.or(shape, Shapes.box(0.5625, 0.0625, 0.25, 0.6875, 1.1875, 0.3125));
                shape = Shapes.or(shape, Shapes.box(0.5625, 0.0625, 0.6875, 0.6875, 1.1875, 0.75));
                return shape;
            case WEST:
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.8125, 0.3125, 0.375, 1.1875, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.4375, 0.3125, 0.375, 0.8125, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.125, 0.3125, 0.375, 0.4375, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.1875, 0, 0.1875, 0.3125, 1.3125, 0.8125));
                shape = Shapes.or(shape, Shapes.box(0.3125, 1.15625, 0.3125, 0.5625, 1.20625, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.8125, 0.3125, 0.5625, 0.8625, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.45625, 0.3125, 0.5625, 0.50625, 0.6875));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.875, 0.375, 0.38125, 1.125, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.5375, 0.375, 0.38125, 0.7875, 0.625));
                shape = Shapes.or(shape, Shapes.box(0.375, 0.1875, 0.375, 0.38125, 0.4375, 0.625));
                shape = Shapes.or(shape, Shapes.box(0, 0.4375, 0.4375, 0.1875, 0.5625, 0.5625));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.0625, 0.6875, 0.4375, 1.1875, 0.75));
                shape = Shapes.or(shape, Shapes.box(0.3125, 0.0625, 0.25, 0.4375, 1.1875, 0.3125));
                return shape;
            default:
                return Shapes.block();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, ctx.getHorizontalDirection());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation direction) {
        return state.setValue(BlockStateProperties.HORIZONTAL_FACING, direction.rotate(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag tooltipContext) {
        tooltip.add(new TranslatableComponent("item.aft_fabroads.traffic_light_tip"));
        tooltip.add(new TranslatableComponent("item.aft_fabroads.traffic_light_tip2"));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TrafficLightEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}