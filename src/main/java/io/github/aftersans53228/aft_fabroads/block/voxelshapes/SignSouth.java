package io.github.aftersans53228.aft_fabroads.block.voxelshapes;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class SignSouth {
	public static VoxelShape getShape() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0, 0.400543816310171, 0.91875, 1, 0.599456183689829, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0, 0.400543816310171, 0.91875, 1, 0.599456183689829, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0, 0.400543816310171, 0.91875, 1, 0.599456183689829, 0.9375));
		shape = Shapes.or(shape, Shapes.box(0.25, 0.25, 0.9186875, 0.75, 0.75, 0.9186875));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = Shapes.or(shape, Shapes.box(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = Shapes.or(shape, Shapes.box(0, 0.400543816310171, 0.9375, 1, 0.599456183689829, 0.95));
		shape = Shapes.or(shape, Shapes.box(0, 0.400543816310171, 0.9375, 1, 0.599456183689829, 0.95));
		shape = Shapes.or(shape, Shapes.box(0, 0.400543816310171, 0.9375, 1, 0.599456183689829, 0.95));
		shape = Shapes.or(shape, Shapes.box(0.4375, 0.4375, 0.9375, 0.5625, 0.5625, 1));
		shape = Shapes.or(shape, Shapes.box(0, 0, 0.91875, 1, 1, 0.95));
		return shape;
	}
}