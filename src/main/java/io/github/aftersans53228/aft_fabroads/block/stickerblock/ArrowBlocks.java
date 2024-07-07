package io.github.aftersans53228.aft_fabroads.block.stickerblock;

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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public class ArrowBlocks extends HorizontalDirectionalBlock {
    public static final BooleanProperty is_Mini = BooleanProperty.create("is_mini");
    public ArrowBlocks() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(0.1f).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(is_Mini, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(is_Mini);
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem()== RoadTool.get()) {
            if (state.getValue(is_Mini)) {
                world.setBlock(pos, state.setValue(is_Mini, false), Block.UPDATE_ALL);
            } else {
                world.setBlock(pos, state.setValue(is_Mini, true), Block.UPDATE_ALL);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(is_Mini)) {
            return Shapes.box(0.0f, 0.0f, 0.0f, 1f, 0.00500f, 1.0f);
        } else {
            return Shapes.box(-1.0f, 0.0f, -1.0f, 2.0f, 0.00500f, 2.0f);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter p_49817_, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TranslatableComponent("item.aft_fabroads.arrow_tip"));
    }
}