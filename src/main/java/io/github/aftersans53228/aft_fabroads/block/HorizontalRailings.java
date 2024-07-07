package io.github.aftersans53228.aft_fabroads.block;

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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public class HorizontalRailings extends HorizontalDirectionalBlock {
    public static final IntegerProperty is_Turn = IntegerProperty.create("is_turn",0,2);
    public List<VoxelShape> railingShapes = new ArrayList<>();

    public HorizontalRailings() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f));
        this.railingShapes.add(0, Shapes.empty());
        this.railingShapes.add(1, Shapes.empty());
        this.railingShapes.add(2, Shapes.empty());
        this.railingShapes.add(3, Shapes.empty());
        this.registerDefaultState(this.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH).setValue(is_Turn, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
        stateManager.add(is_Turn);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem() == RoadTool.get()) {
            switch (state.getValue(is_Turn)) {
                case 0 -> world.setBlock(pos, state.setValue(is_Turn, 1), Block.UPDATE_ALL);
                case 1 -> world.setBlock(pos, state.setValue(is_Turn, 2), Block.UPDATE_ALL);
                case 2 -> world.setBlock(pos, state.setValue(is_Turn, 0), Block.UPDATE_ALL);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ctx) {
        Direction dir = state.getValue(FACING);
        return switch (dir) {
            case NORTH ,SOUTH-> this.railingShapes.get(0);
            case EAST ,WEST->this.railingShapes.get(1);
            default -> Shapes.block();
        };
    }

    public HorizontalRailings setVoxelShapes(List<VoxelShape> shapes){
        this.railingShapes.set(0, shapes.get(0));
        this.railingShapes.set(1, shapes.get(1));
        return this;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag tooltipContext) {
        tooltip.add(new TranslatableComponent("item.aft_fabroads.railing_tip"));
    }
}