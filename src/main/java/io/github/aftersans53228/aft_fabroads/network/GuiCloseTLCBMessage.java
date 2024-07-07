package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlBox;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

public record GuiCloseTLCBMessage(BlockPos boxPos, int[] timeData, boolean enabled) {
    public GuiCloseTLCBMessage(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readVarIntArray(), buf.readBoolean());
    }

    public static void encoder(GuiCloseTLCBMessage mes, FriendlyByteBuf buf) {
        buf.writeBlockPos(mes.boxPos);
        buf.writeVarIntArray(mes.timeData);
        buf.writeBoolean(mes.enabled);
    }

    public static void handler(GuiCloseTLCBMessage mes, Supplier<NetworkEvent.Context> contextSupplier) {
        var context = contextSupplier.get();
        context.enqueueWork(() -> receiveGuiCloseTrafficLightsControlBox(mes, context.getSender()));
        context.setPacketHandled(true);
    }

    public static void receiveGuiCloseTrafficLightsControlBox(GuiCloseTLCBMessage mes, ServerPlayer player) {
        if (player == null)
            return;
        MinecraftServer server = player.getServer();
        BlockPos boxPos = mes.boxPos();//坐标
        int[] timeData= mes.timeData();
        Boolean enabled = mes.enabled();
        if (server != null) {
            server.execute(() -> {
                if (player.getLevel().getBlockEntity(boxPos) != null && player.getLevel().getBlockEntity(boxPos).getType() == AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY.get()) {
                    TrafficLightsControlEntity blockEntity = (TrafficLightsControlEntity) player.getLevel().getBlockEntity(boxPos);
                    ServerLevel world =player.getLevel();
                    world.setBlock(boxPos,world.getBlockState(boxPos).setValue(TrafficLightsControlBox.IS_ENABLE, enabled), Block.UPDATE_ALL);
                    blockEntity.setBlockState(blockEntity.getBlockState().setValue(TrafficLightsControlBox.IS_ENABLE, enabled));
                    ArrayList<Integer> timeForward = new ArrayList<>();
                    ArrayList<Integer> timeTurn = new ArrayList<>();
                    timeForward.add(timeData[0]);
                    timeForward.add(timeData[1]);
                    timeTurn.add(timeData[2]);
                    timeTurn.add(timeData[3]);
                    blockEntity.setTimeData(timeForward,timeTurn);
                    AFRoads.LOGGER.info("Set Traffic lights Control Box {"+ Arrays.toString(timeData) + "} ,"+enabled );
                }
                else if (player.getLevel().getBlockEntity(boxPos) == null) {
                    AFRoads.LOGGER.info("Invalid Block Entity.");
                }
            });
        }
    }
}