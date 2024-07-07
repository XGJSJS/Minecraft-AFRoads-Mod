package io.github.aftersans53228.aft_fabroads.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolAttribute;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolLinked;

public class RubbishBinMetal extends HorizontalDirectionalBlock {

    public RubbishBinMetal() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(1.5f));
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!player.isCreative() && ! player.getMainHandItem().isEmpty()&& !player.getMainHandItem().getItem().equals(RoadToolAttribute) && !player.getMainHandItem().getItem().equals(RoadToolLinked)) {
            player.getMainHandItem().setCount(0);
            if (!world.isClientSide()) {
                world.playSound(
                        null, // 当不是null时给所有人放
                        pos, // 播放坐标
                        SoundEvents.AZALEA_LEAVES_PLACE, // 播放声音
                        SoundSource.BLOCKS, // 播放类型
                        2f, //声音
                        1f // 音高倍增器
                );
            }
        }
        else{
            return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        return switch (dir) {
            case NORTH, SOUTH -> Shapes.box(-0.11875, 0, 0.24375, 1.11875, 1.05625, 0.75625);
            case EAST, WEST -> Shapes.box(0.24375, 0, -0.11875, 0.75625, 1.05625, 1.11875);
            default -> Shapes.block();
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, ctx.getHorizontalDirection());
    }
}