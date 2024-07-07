package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RoadLightEntity extends BlockEntity {
    public RoadLightEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.ROAD_LIGHT_ENTITY.get(), pos, state);
    }
}