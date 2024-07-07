package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlBox;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.gui.RoadNameSignGui;
import io.github.aftersans53228.aft_fabroads.gui.TrafficControlBoxGui;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public record GuiOpenMessage(BlockPos blockPos, byte type) {
    public GuiOpenMessage(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readByte());
    }

    public static void encoder(GuiOpenMessage mes, FriendlyByteBuf buf) {
        buf.writeBlockPos(mes.blockPos);
        buf.writeByte(mes.type);
    }

    public static void handler(GuiOpenMessage mes, Supplier<NetworkEvent.Context> contextSupplier) {
        var context = contextSupplier.get();
        if (context.getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
            context.enqueueWork(() -> {
                Minecraft client = Minecraft.getInstance();
                if (mes.type() == 0) {
                    client.execute(() -> {
                        if (client.level != null) {
                            RoadNameSignEntity entity = (RoadNameSignEntity) client.level.getBlockEntity(mes.blockPos());
                            List<String> roadNames = entity.getRoadNames();
                            client.setScreen(new RoadNameSignGui(mes.blockPos(), roadNames, client.level));
                        }
                    });
                }
                if (mes.type() == 1) {
                    client.execute(() -> {
                        if (client.level != null) {
                            ArrayList<Integer> timeData;
                            TrafficLightsControlEntity entity = (TrafficLightsControlEntity) client.level.getBlockEntity(mes.blockPos());
                            timeData = entity.getTimerData();
                            client.setScreen(new TrafficControlBoxGui(mes.blockPos(), client.level.getBlockState(mes.blockPos()).getValue(TrafficLightsControlBox.IS_ENABLE), timeData));
                        }
                    });
                }

            });
        }
        context.setPacketHandled(true);
    }
}