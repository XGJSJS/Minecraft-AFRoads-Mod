package io.github.aftersans53228.aft_fabroads.block.pillarblock;

import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

public class SmartPillar extends PipeBlock {
    private static List<Block> PILLAR_BLOCKS = List.of();
    private static List<Block> CAN_PILLAR_CONNECT = List.of();
    private static boolean init = false;

    public SmartPillar() {
        super(0.125f, BlockBehaviour.Properties.of(Material.STONE).strength(1.5f) );
        this.registerDefaultState(this.defaultBlockState()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(UP, false)
                .setValue(DOWN, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.withConnectionProperties(ctx.getLevel(), ctx.getClickedPos());
    }

    public BlockState withConnectionProperties(BlockGetter world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.below());
        BlockState blockState2 = world.getBlockState(pos.above());
        BlockState blockState3 = world.getBlockState(pos.north());
        BlockState blockState4 = world.getBlockState(pos.east());
        BlockState blockState5 = world.getBlockState(pos.south());
        BlockState blockState6 = world.getBlockState(pos.west());
        return this.defaultBlockState()
                .setValue(DOWN, blockState.is(this) || blockState.is(SmartPillarThin.get()) || isStateInList(blockState,PILLAR_BLOCKS)|| isStateInList(blockState,CAN_PILLAR_CONNECT)||blockState.isCollisionShapeFullBlock(world, pos.below()))
                .setValue(UP, blockState2.is(this) || blockState2.is(SmartPillarThin.get())|| isStateInList(blockState2,PILLAR_BLOCKS)|| isStateInList(blockState2,CAN_PILLAR_CONNECT))
                .setValue(NORTH, blockState3.is(this) || blockState3.is(SmartPillarThin.get())|| isStateInList(blockState3,PILLAR_BLOCKS)|| isStateInList(blockState3,CAN_PILLAR_CONNECT))
                .setValue(EAST, blockState4.is(this) || blockState4.is(SmartPillarThin.get())|| isStateInList(blockState4,PILLAR_BLOCKS)|| isStateInList(blockState4,CAN_PILLAR_CONNECT))
                .setValue(SOUTH, blockState5.is(this) || blockState5.is(SmartPillarThin.get())|| isStateInList(blockState5,PILLAR_BLOCKS)|| isStateInList(blockState5,CAN_PILLAR_CONNECT))
                .setValue(WEST, blockState6.is(this) || blockState6.is(SmartPillarThin.get())|| isStateInList(blockState6,PILLAR_BLOCKS)|| isStateInList(blockState6,CAN_PILLAR_CONNECT));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor p_60544_, BlockPos p_60545_, BlockPos p_60546_) {
        boolean bl =
                neighborState.is(this) ||
                        neighborState.is(SmartPillarThin.get()) ||
                        isStateInList(neighborState, PILLAR_BLOCKS)||
                        isStateInList(neighborState, CAN_PILLAR_CONNECT)
                ;
        return state.setValue(PROPERTY_BY_DIRECTION.get(direction), bl);
    }

    public boolean isStateInList(BlockState state, List<Block> list){
        for (Block block : list) {
            if (state.is(block)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack p_49816_, @Nullable BlockGetter p_49817_, List<Component> tooltip, TooltipFlag p_49819_) {
        tooltip.add(new TranslatableComponent("item.aft_fabroads.smart_pillar") );
    }

    public static void init() {
        if (!init) {
            PILLAR_BLOCKS = AFRoadsStatics.PILLAR_BLOCKS.stream().map(RegistryObject::get).toList();
            CAN_PILLAR_CONNECT = AFRoadsStatics.CAN_PILLAR_CONNECT.stream().map(RegistryObject::get).toList();
            init = true;
        }
    }
}