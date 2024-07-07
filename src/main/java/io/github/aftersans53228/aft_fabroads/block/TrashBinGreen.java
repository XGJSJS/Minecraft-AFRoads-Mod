package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.item.RoadToolAttribute;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolAttribute;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolLinked;

public class TrashBinGreen extends HorizontalDirectionalBlock {
    public static final BooleanProperty CR200j = BooleanProperty.create("cr200j");

    public TrashBinGreen() {
        super(BlockBehaviour.Properties.of(Material.BAMBOO).strength(1.5f));
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(CR200j, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(CR200j);
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem().equals(RoadTool)){
            if (state.getValue(CR200j)) {
                world.setBlock(pos, state.setValue(CR200j, false), Block.UPDATE_ALL);
            } else {
                world.setBlock(pos, state.setValue(CR200j, true), Block.UPDATE_ALL);
            }
            return InteractionResult.SUCCESS;
        }
        if ((!player.isCreative() && ! player.getMainHandItem().isEmpty())&& !player.getMainHandItem().getItem().equals(RoadToolAttribute) && !player.getMainHandItem().getItem().equals(RoadToolLinked)){
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
        } else {
            return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return Shapes.box(0.125, 0, 0.125, 0.875, 1.51875, 0.875);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter blockGetter, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add( new TranslatableComponent("item.aft_fabroads.trash_bin"));
    }
}