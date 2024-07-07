package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.item.RoadToolAttribute;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public record AttributesItemMessage(String s1, String s2) {
    public AttributesItemMessage(FriendlyByteBuf buf) {
        this(buf.readUtf(), buf.readUtf());
    }

    public static void encoder(AttributesItemMessage mes, FriendlyByteBuf buf) {
        buf.writeUtf(mes.s1);
        buf.writeUtf(mes.s2);
    }

    public static void handler(AttributesItemMessage mes , Supplier<NetworkEvent.Context> contextSupplier) {
        var context = contextSupplier.get();
        if (context.getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
            context.enqueueWork(() -> {
                Minecraft client = Minecraft.getInstance();
                client.execute(() -> RoadToolAttribute.receiveAttributeItem(mes.s1(), mes.s2(), client.player));
            });
        }
        context.setPacketHandled(true);
    }
}