package io.github.aftersans53228.aft_fabroads;

import io.github.aftersans53228.aft_fabroads.block.pillarblock.SmartPillar;
import io.github.aftersans53228.aft_fabroads.item.RoadToolLinked;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmlserverevents.FMLServerStartedEvent;

import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.MOD_VERSION;

@Mod.EventBusSubscriber
public class AFRoadsEvent {
    @SubscribeEvent
    public static void playerJoined(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getPlayer();
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.displayClientMessage(new TextComponent(String.format("§8AFRoads Mod loaded.\n§fVersion:§c%s.", MOD_VERSION)), false);
        }
    }

    @SubscribeEvent
    public static void loadComplete(FMLServerStartedEvent event) {
        SmartPillar.init();
        RoadToolLinked.init();
    }
}