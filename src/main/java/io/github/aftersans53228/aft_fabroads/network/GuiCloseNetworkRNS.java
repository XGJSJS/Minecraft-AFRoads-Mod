package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSign;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author aftersans53228
 */
public record GuiCloseNetworkRNS(BlockPos signPos, String roadName, String roadName2rd, boolean dirLeft, boolean dirRight) {
    public GuiCloseNetworkRNS(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readUtf(), buf.readUtf(), buf.readBoolean(), buf.readBoolean());
    }

    public static void encoder(GuiCloseNetworkRNS mes, FriendlyByteBuf buf) {
        buf.writeBlockPos(mes.signPos);
        buf.writeUtf(mes.roadName);
        buf.writeUtf(mes.roadName2rd);
        buf.writeBoolean(mes.dirLeft);
        buf.writeBoolean(mes.dirRight);
    }

    public static void handler(GuiCloseNetworkRNS mes, Supplier<NetworkEvent.Context> contextSupplier) {
        var context = contextSupplier.get();
        context.enqueueWork(() -> receiveGuiCloseRNS(mes, context.getSender()));
        context.setPacketHandled(true);
    }

    public static void receiveGuiCloseRNS(GuiCloseNetworkRNS mes, ServerPlayer player) {
        if (player == null)
            return;
        MinecraftServer server = player.getServer();
        BlockPos signPos = mes.signPos();//坐标
        String roadName = mes.roadName();//路名
        String roadName2rd = mes.roadName2rd();//路名2
        boolean dirLeft =mes.dirLeft();//左边
        boolean dirRight =mes.dirRight();//右边
        if (server != null) {
            server.execute(() -> {
                if (player.getLevel().getBlockEntity(signPos) != null && player.getLevel().getBlockEntity(signPos).getType() == AFRoadsBlockRegistry.ROAD_NAME_SIGN_ENTITY.get()) {
                    RoadNameSignEntity blockEntity = (RoadNameSignEntity) player.getLevel().getBlockEntity(signPos);
                    ServerLevel world = player.getLevel();
                    world.setBlock(signPos, world.getBlockState(signPos).setValue(RoadNameSign.DirLeft, dirLeft), Block.UPDATE_ALL);
                    world.setBlock(signPos, world.getBlockState(signPos).setValue(RoadNameSign.DirRight, dirRight), Block.UPDATE_ALL);
                    blockEntity.setBlockState(blockEntity.getBlockState().setValue(RoadNameSign.DirLeft, dirLeft));
                    blockEntity.setBlockState(blockEntity.getBlockState().setValue(RoadNameSign.DirRight, dirRight));
                    if (!Objects.equals(roadName, "") &&roadName !=null ){
                        blockEntity.setRoadNames(roadName);
                        AFRoads.LOGGER.info("Set Sign Name Sign {"+roadName+"}  " + blockEntity.getBlockState());
                    }
                    if(!Objects.equals(roadName2rd, "")&& roadName2rd !=null) {
                        blockEntity.setRoadNames2(roadName2rd);
                        AFRoads.LOGGER.info("Set Sign Name Sign {"+roadName2rd+ "} " + blockEntity.getBlockState());
                    }
                } else if (player.getLevel().getBlockEntity(signPos) == null) {
                    AFRoads.LOGGER.info("Invalid Block Entity.");
                }
            });
        }

    }
}