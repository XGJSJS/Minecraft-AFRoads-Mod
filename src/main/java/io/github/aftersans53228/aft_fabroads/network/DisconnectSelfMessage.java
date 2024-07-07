package io.github.aftersans53228.aft_fabroads.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public record DisconnectSelfMessage() {
    public DisconnectSelfMessage(FriendlyByteBuf buf) {
        this();
    }

    public static void encoder(DisconnectSelfMessage message, FriendlyByteBuf buf) {}

    public static void handler(DisconnectSelfMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        var context = contextSupplier.get();
        if (context.getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
            context.enqueueWork(() -> {
                Minecraft client = Minecraft.getInstance();
                client.execute(()->{
                    var listener = client.getConnection();
                    if (listener != null) {
                        listener.getConnection().disconnect(new TextComponent(I18n.get("text.gui.aft_fabroads.version_mistake") + "\n\n"
                                + I18n.get("text.gui.aft_fabroads.version_mistake_client")+"§4"+"AFRoadsStatics.MOD_VERSION(Client)\n"
                                + I18n.get("text.gui.aft_fabroads.version_mistake_server")+"§2"+"AFRoadsStatics.MOD_VERSION(Server)\n"
                                + "§f(The operator self-disconnected.)"));
                    }
                });
            });
        }
        context.setPacketHandled(true);
    }
}