package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.common.extensions.IForgeBlockEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TrafficLightsControlEntity extends BlockEntity implements IForgeBlockEntity {
    private int timerTraffic =0;
    private List<Integer> timeForward = new ArrayList<>();
    private List<Integer> timeTurn = new ArrayList<>();
    private String NSlightType = "";
    private String WElightType = "";


    public TrafficLightsControlEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY.get(), pos, state);
        this.reset();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.NSlightType = nbt.getString("NS");
        this.WElightType = nbt.getString("WE");
        this.timeForward.clear();
        this.timeTurn.clear();
        for (int i : nbt.getIntArray("forward")){
            this.timeForward.add(i);
        }
        for (int i : nbt.getIntArray("turn")){
            this.timeTurn.add(i);
        }
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("NS",this.NSlightType);
        nbt.putString("WE",this.WElightType);
        nbt.putIntArray("forward",this.timeForward);
        nbt.putIntArray("turn",this.timeTurn);
        return nbt;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        this.deserializeNBT(tag);
    }

    public String getLightType(String arg){
        return switch (arg) {
            case "NS" -> this.NSlightType;
            case "WE" -> this.WElightType;
            default -> throw new IllegalStateException("Unexpected traffic lights value type: " + arg);
        };
    }

    public ArrayList<Integer> getTimerData(){
        ArrayList<Integer> inDt=new ArrayList<>();
        inDt.addAll(this.timeForward);
        inDt.addAll(this.timeTurn);
        return inDt;
    }

    public void timerSettingReset(){
        this.reset();
    }

    public void timerUsingStart(){
        this.start();
    }

    public void setTimeData(ArrayList<Integer> timeForward1, ArrayList<Integer> timeTurn1) {
        TrafficLightsControlEntity entity = null;
        if (this.level != null) {
            entity = (TrafficLightsControlEntity) this.level.getBlockEntity(this.worldPosition);
            this.timeForward=timeForward1;
            this.timeTurn=timeTurn1;
            this.setChanged();
            this.level.sendBlockUpdated(this.worldPosition, entity.getBlockState(), entity.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    private void start(){
        this.timerTraffic=0;
        if (this.level != null) {
            this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BooleanProperty.create("is_enable"), true), Block.UPDATE_ALL);
        }
    }

    private void reset() {
        if (this.level != null) {
            this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BooleanProperty.create("is_enable"),false), Block.UPDATE_ALL);
        }
        this.timerTraffic=0;
        this.timeForward = new ArrayList<>();
            this.timeForward.add(0,10);//绿（秒）
            this.timeForward.add(1,10);//红（秒）
        this.timeTurn =new ArrayList<>();
            this.timeTurn.add(0,0);//转弯绿左（秒）
            this.timeTurn.add(0,0);//转弯红左（秒）
        this.NSlightType = "disable";
        this.WElightType = "disable";
        this.setChanged();
        if (this.level != null && !this.level.isClientSide()) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    private int getTimerLength(){
        int timer = 40;
        for(Integer i:this.timeForward){
            timer+=(i*20);
        }
        for(Integer i:this.timeTurn){
            timer+=(i*20);
        }
        return timer*2;
    }

    public static void tick(Level world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        TrafficLightsControlEntity entity = (TrafficLightsControlEntity) blockEntity;
        if (entity.timeForward.isEmpty() || entity.timeTurn.isEmpty()) {
            entity.reset();
        }
        if (Boolean.TRUE.equals(state.getValue(BooleanProperty.create("is_enable")))){
            if (!world.isClientSide()) {
                int temporaryVar = 0;
                entity.timerTraffic += 1;
                if(entity.timerTraffic == entity.getTimerLength()){
                    entity.timerTraffic = 0;
                }
                if (entity.timerTraffic <= entity.timeForward.get(0)*20){
                    entity.NSlightType = "forward_green";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2)*20){
                    entity.NSlightType = "forward_yellow";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1))*20){
                    entity.NSlightType = "turn_left_red";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0))*20){
                    entity.NSlightType = "turn_left";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2)*20){
                    entity.NSlightType = "turn_left_yellow";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1))*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "forward_green";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2)*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "forward_yellow";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2+ entity.timeTurn.get(1))*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "turn_left_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2+ entity.timeTurn.get(1)+ entity.timeTurn.get(0))*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "turn_left_green";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2)*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "turn_left_yellow";
                }
                entity.setChanged();
                world.sendBlockUpdated(pos, entity.getBlockState(), entity.getBlockState(), Block.UPDATE_ALL);
            }
        }
        else{
            entity.NSlightType = "disable";
            entity.WElightType = "disable";
            //entity.reset();
            //entity.start();
        }

    }
}