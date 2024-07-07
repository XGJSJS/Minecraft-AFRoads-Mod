package io.github.aftersans53228.aft_fabroads.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class InsulationPanelsGray extends HorizontalDirectionalBlock {
    public List<VoxelShape> railingShapes = new ArrayList<>();
    private boolean tipsMode = true;

    public InsulationPanelsGray() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).noOcclusion());
        this.railingShapes.add(Shapes.empty());
        this.railingShapes.add(Shapes.empty());
        this.railingShapes.add(Shapes.empty());
        this.railingShapes.add(Shapes.empty());
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
            case NORTH ->this.railingShapes.get(0);
            case SOUTH-> this.railingShapes.get(1);
            case EAST ->this.railingShapes.get(2);
            case WEST->this.railingShapes.get(3);
            default -> Shapes.block();
        };
    }

    public InsulationPanelsGray setVoxelShapes(List<VoxelShape> shapes){
        this.railingShapes.set(0, shapes.get(0));
        this.railingShapes.set(1, shapes.get(1));
        this.railingShapes.set(2, shapes.get(2));
        this.railingShapes.set(3, shapes.get(3));
        return this;
    }

    public InsulationPanelsGray setTipsMode(boolean mode){
        this.tipsMode = mode;
        return  this;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter blockGetter, List<Component> tooltip, TooltipFlag flag) {
        if (this.tipsMode){
            tooltip.add(new TranslatableComponent("item.aft_fabroads.insulation_gray_tip"));
        }
    }
}