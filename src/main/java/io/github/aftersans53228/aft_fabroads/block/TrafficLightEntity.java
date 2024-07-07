package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeBlockEntity;

public class TrafficLightEntity  extends BlockEntity implements IForgeBlockEntity {
    private BlockPos boxPos ;

    public TrafficLightEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY.get(), pos, state);
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if (nbt.contains("box_x")) {
            this.boxPos = new BlockPos(
                    nbt.getInt("box_x"),
                    nbt.getInt("box_y"),
                    nbt.getInt("box_z")
            );
        }
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        if (boxPos != null) {
            nbt.putInt("box_x", boxPos.getX());
            nbt.putInt("box_y", boxPos.getY());
            nbt.putInt("box_z", boxPos.getZ());
        }
        return nbt;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        this.deserializeNBT(tag);
    }

    public void setControlBoxPos(BlockPos pos){
        this.boxPos = pos;
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    public BlockPos getControlBoxPos(){
        if (this.level != null && this.boxPos !=null && this.level.getBlockState(boxPos) != null && this.level.getBlockState(boxPos).getBlock() != AFRoadsBlockRegistry.TrafficLightsControlBox.get()) {
            this.boxPos = null;
        }
        return this.boxPos;
    }
}