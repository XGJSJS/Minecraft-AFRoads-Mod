package io.github.aftersans53228.aft_fabroads.block.pillarblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class VerticalStraightPillarThin extends Block {
    public VerticalStraightPillarThin() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.2f));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return Shapes.box(0.375, 0f, 0.375, 0.625, 1f, 0.625);
    }
}