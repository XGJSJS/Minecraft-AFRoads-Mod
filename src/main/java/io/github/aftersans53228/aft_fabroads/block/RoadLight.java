package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public  class RoadLight extends BaseEntityBlock {
    public static final IntegerProperty LightType = IntegerProperty.create("type",0,1);


    public RoadLight() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(1.5f).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(LightType, 0).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(LightType);
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem() == RoadTool.get()) {
            if (state.getValue(LightType) == 0) {
                world.setBlock(pos, state.setValue(LightType,1), Block.UPDATE_ALL);
            } else {
                if (state.getValue(LightType)==1){
                    world.setBlock(pos, state.setValue(LightType,0), Block.UPDATE_ALL);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        switch(dir) {
            case NORTH:
                return Shapes.box(0.3125, 0.44375, 0, 0.6875, 0.6125, 0.89375);
            case SOUTH:
                return Shapes.box(0.3125, 0.44375, 0.10625, 0.6875, 0.6125, 1);
            case WEST:
                return Shapes.box(0, 0.44375, 0.3125, 0.6875, 0.6125, 0.6875);
            case EAST:
                return Shapes.box(0.10625, 0.44375, 0.3125, 1, 0.6125, 0.6875);
            default:
                return Shapes.block();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, ctx.getHorizontalDirection());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(BlockStateProperties.HORIZONTAL_FACING, rotation.rotate(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, BlockGetter world, List<Component> tooltip, TooltipFlag tooltipContext) {
        tooltip.add(new TranslatableComponent("item.aft_fabroads.road_light"));
    }
/*
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        for(int i=1;i<15;i++){
            if(world.getBlockState(pos.down(i)).getBlock().equals(Blocks.AIR)){
                break;
            };
        }

    }*/

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RoadLightEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}