package io.github.aftersans53228.aft_fabroads.block.signblock;

import io.github.aftersans53228.aft_fabroads.block.voxelshapes.SignEast;
import io.github.aftersans53228.aft_fabroads.block.voxelshapes.SignNorth;
import io.github.aftersans53228.aft_fabroads.block.voxelshapes.SignSouth;
import io.github.aftersans53228.aft_fabroads.block.voxelshapes.SignWest;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class SignNormal extends HorizontalDirectionalBlock {
    public SignNormal() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f));
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        return switch (dir) {
            case NORTH -> SignNorth.getShape();
            case SOUTH -> SignSouth.getShape();
            case EAST -> SignEast.getShape();
            case WEST -> SignWest.getShape();
            default -> Shapes.block();
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, ctx.getHorizontalDirection());
    }
}