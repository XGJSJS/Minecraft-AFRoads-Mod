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

public class PillarBase extends Block {
    public PillarBase() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.or(shape, Shapes.box(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = Shapes.or(shape, Shapes.box(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = Shapes.or(shape, Shapes.box(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = Shapes.or(shape, Shapes.box(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = Shapes.or(shape, Shapes.box(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = Shapes.or(shape, Shapes.box(0, 0, 0.40054375, 1, 0.0625, 0.59945625));
        shape = Shapes.or(shape, Shapes.box(0, 0, 0.40054375, 1, 0.0625, 0.59945625));
        shape = Shapes.or(shape, Shapes.box(0, 0, 0.40054375, 1, 0.0625, 0.59945625));
        shape = Shapes.or(shape, Shapes.box(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = Shapes.or(shape, Shapes.box(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = Shapes.or(shape, Shapes.box(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = Shapes.or(shape, Shapes.box(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = Shapes.or(shape, Shapes.box(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = Shapes.or(shape, Shapes.box(0.25, 0.59375, 0.450271875, 0.75, 0.65625, 0.549728125));
        shape = Shapes.or(shape, Shapes.box(0.25, 0.59375, 0.450271875, 0.75, 0.65625, 0.549728125));
        shape = Shapes.or(shape, Shapes.box(0.25, 0.59375, 0.450271875, 0.75, 0.65625, 0.549728125));
        shape = Shapes.or(shape, Shapes.box(0.375, 0.0625, 0.375, 0.625, 1, 0.625));
        shape = Shapes.or(shape, Shapes.box(0.46875, 0.0625, 0.1875, 0.53125, 0.125, 0.25));
        shape = Shapes.or(shape, Shapes.box(0.46875, 0.625, 0.625, 0.53125, 0.6875, 0.6875));
        shape = Shapes.or(shape, Shapes.box(0.46875, 0.625, 0.3125, 0.53125, 0.6875, 0.375));
        shape = Shapes.or(shape, Shapes.box(0.75, 0.0625, 0.46875, 0.8125, 0.125, 0.53125));
        shape = Shapes.or(shape, Shapes.box(0.625, 0.625, 0.46875, 0.6875, 0.6875, 0.53125));
        shape = Shapes.or(shape, Shapes.box(0.3125, 0.625, 0.46875, 0.375, 0.6875, 0.53125));
        shape = Shapes.or(shape, Shapes.box(0.1875, 0.0625, 0.46875, 0.25, 0.125, 0.53125));
        return shape;
    }
}