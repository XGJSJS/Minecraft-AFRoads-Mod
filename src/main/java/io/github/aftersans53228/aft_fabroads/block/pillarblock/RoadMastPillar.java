package io.github.aftersans53228.aft_fabroads.block.pillarblock;

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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

import javax.annotation.Nullable;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public class RoadMastPillar extends HorizontalDirectionalBlock {
    public static final BooleanProperty is_Bracket = BooleanProperty.create("is_bracket");
    public RoadMastPillar() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f));
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(is_Bracket, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
        stateManager.add(is_Bracket);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem()== RoadTool.get()) {
            if (state.getValue(is_Bracket)) {
                world.setBlock(pos, state.setValue(is_Bracket, false), Block.UPDATE_ALL);
            } else {
                world.setBlock(pos, state.setValue(is_Bracket, true), Block.UPDATE_ALL);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        return switch(dir) {
            case NORTH, SOUTH -> Shapes.box(0, 0f, 0.375, 1f, 1f, 0.625);
            case EAST, WEST -> Shapes.box(0.375, 0f, 0f, 0.625, 1f, 1f);
            default -> Shapes.block();
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, ctx.getHorizontalDirection());
    }

    @Override
    public void appendHoverText(ItemStack p_49816_, @Nullable BlockGetter p_49817_, List<Component> tooltip, TooltipFlag p_49819_) {
        tooltip.add(new TranslatableComponent("item.aft_fabroads.mast-pillar_tip"));
    }
}