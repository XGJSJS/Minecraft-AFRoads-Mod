package io.github.aftersans53228.aft_fabroads.block.structureblock;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public class ConcreteSlab extends SlabBlock {
    public ConcreteSlab() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getMainHandItem().getItem()== RoadTool.get()) {
            if (state.getValue(TYPE) == SlabType.BOTTOM) {
                world.setBlock(pos, state.setValue(TYPE, SlabType.TOP), Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
            if (state.getValue(TYPE) == SlabType.TOP) {
                world.setBlock(pos, state.setValue(TYPE, SlabType.BOTTOM), Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
            if (state.getValue(TYPE) == SlabType.DOUBLE) {
                player.displayClientMessage(new TranslatableComponent("item.aft_fabroads.tool2slab_tip"), true);
            }
        }
        return InteractionResult.PASS;
    }
}