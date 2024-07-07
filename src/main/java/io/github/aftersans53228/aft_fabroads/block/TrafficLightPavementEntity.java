package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TrafficLightPavementEntity extends BlockEntity {

    public TrafficLightPavementEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHT_PAVEMENT_ENTITY.get(), pos, state);
    }
    
    public static void tick(Level world, BlockPos pos, BlockState state, Direction dir) {
        int timer =  AFRoads.traffic_lights_timer;
        switch(dir) {
            case SOUTH:
            case NORTH:
                if (timer > 0 & timer < 40) {
                world.setBlock(pos, state.setValue(TrafficLightPavement.TrafficType, 1), Block.UPDATE_ALL);
                break;
                }
                if (timer > 40 & timer <= 620) {
                world.setBlock(pos, state.setValue(TrafficLightPavement.TrafficType, 0), Block.UPDATE_ALL);
                break;
                }
                if (timer > 620) {
                world.setBlock(pos, state.setValue(TrafficLightPavement.TrafficType, 2), Block.UPDATE_ALL);
                break;
                }
            case EAST:
            case WEST:

                if (timer > 40 & timer < 580) {
                    world.setBlock(pos, state.setValue(TrafficLightPavement.TrafficType, 2), Block.UPDATE_ALL);
                    break;
                }
                if (timer >= 580 & timer <= 620) {
                    world.setBlock(pos, state.setValue(TrafficLightPavement.TrafficType, 1), Block.UPDATE_ALL);
                    break;
                }
                if (timer > 620) {
                    world.setBlock(pos, state.setValue(TrafficLightPavement.TrafficType, 0), Block.UPDATE_ALL);
                    break;
                }
        }
    }
}