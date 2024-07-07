package io.github.aftersans53228.aft_fabroads.block.voxelshapes;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class PtlSouth {
public static VoxelShape getShape() {
	VoxelShape shape = Shapes.empty();
	shape = Shapes.or(shape, Shapes.box(0.3125, 0.875, 0.625, 0.6875, 0.9375, 0.6875));
	shape = Shapes.or(shape, Shapes.box(0.3125, 0.5, 0.625, 0.6875, 0.875, 0.6875));
	shape = Shapes.or(shape, Shapes.box(0.3125, 0.1875, 0.625, 0.6875, 0.5, 0.6875));
	shape = Shapes.or(shape, Shapes.box(0.1875, 0.0625, 0.6875, 0.8125, 1, 0.8125));
	shape = Shapes.or(shape, Shapes.box(0.3125, 0.9, 0.4375, 0.6875, 0.93125, 0.625));
	shape = Shapes.or(shape, Shapes.box(0.3125, 0.5499999999999999, 0.4375, 0.6875, 0.5812499999999999, 0.625));
	shape = Shapes.or(shape, Shapes.box(0.375, 0.6124999999999999, 0.59375, 0.625, 0.8624999999999999, 0.625));
	shape = Shapes.or(shape, Shapes.box(0.375, 0.23125, 0.59375, 0.625, 0.48125, 0.625));
	shape = Shapes.or(shape, Shapes.box(0.4375, 0.4375, 0.8125, 0.5625, 0.5625, 1));
	shape = Shapes.or(shape, Shapes.box(0.6875, 0.125, 0.5625, 0.75, 0.9375, 0.6875));
	shape = Shapes.or(shape, Shapes.box(0.25, 0.125, 0.5625, 0.3125, 0.9375, 0.6875));

	return shape;
	}
}