package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeBlockEntity;

import java.util.ArrayList;
import java.util.List;

public class RoadNameSignEntity extends BlockEntity implements IForgeBlockEntity {
    private String roadName = "未命名";
    private String roadName2rd = "Unnamed";


    public RoadNameSignEntity(BlockPos pos, BlockState state){
        super(AFRoadsBlockRegistry.ROAD_NAME_SIGN_ENTITY.get(), pos, state);
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.roadName = nbt.getString("road_name");
        this.roadName2rd = nbt.getString("road_name2rd");
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("road_name",this.roadName);
        nbt.putString("road_name2rd",this.roadName2rd);
        return nbt;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        this.deserializeNBT(tag);
    }

    public void setRoadNames(String roadName) {
        this.roadName = roadName;
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }
    public void setRoadNames2(String roadName2rd){
        this.roadName2rd = roadName2rd;
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    public List<String> getRoadNames(){
        List<String> names = new ArrayList<>();
        names.add(0, this.roadName);
        names.add(1, this.roadName2rd);
        return names;
    }
}