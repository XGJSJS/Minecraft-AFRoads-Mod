package io.github.aftersans53228.aft_fabroads.command;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.network.DisconnectSelfMessage;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.PacketDistributor;

import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.*;
import static net.minecraft.commands.Commands.*;

/**
 * @author aftersans53228
 */
@Mod.EventBusSubscriber
public class AftCommand {
    @SubscribeEvent
    public static void register(RegisterCommandsEvent event) {
        event.getDispatcher().register(literal("afroads")
                .then(literal("info")
                        .then(literal("zh_cn")
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    player.displayClientMessage(new TextComponent("§8§o aftersans53228's fabric roads"), false);
                                    player.displayClientMessage(new TextComponent("aftersans53228制作"), false);
                                    player.displayClientMessage(new TextComponent(String.format("本模组命名空间为%s",MOD_ID )), false);
                                    player.displayClientMessage(new TextComponent(String.format("版本为%s", MOD_VERSION)), false);
                                    player.displayClientMessage(new TextComponent(String.format("此版本mod支持mc版本为%s",MINECRAFT_VERSION )), false);
                                    player.displayClientMessage(new TextComponent("mc百科:https://www.mcmod.cn/class/5636.html"), false);
                                    player.displayClientMessage(new TextComponent("modrinth:https://modrinth.com/mod/aftersans53228-fabric-road"), false);
                                    player.displayClientMessage(new TextComponent("code-github:https://github.com/aftersans53228/Minecraft-AFRoads-Mod"), false);
                                    player.displayClientMessage(new TextComponent("感谢"), false);
                                    return 1;
                                }))
                        .then(literal("en_world")
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    player.displayClientMessage(new TextComponent("§8§o aftersans53228's fabric roads"), false);
                                    player.displayClientMessage(new TextComponent("Made by Aftersans53228"), false);
                                    player.displayClientMessage(new TextComponent(String.format("modid:%s",MOD_ID)), false);
                                    player.displayClientMessage(new TextComponent(String.format("version: %s", MOD_VERSION)), false);
                                    player.displayClientMessage(new TextComponent(String.format("minecraft version: %s",MINECRAFT_VERSION)), false);
                                    player.displayClientMessage(new TextComponent("modrinth:https://modrinth.com/mod/aftersans53228-fabric-road"), false);
                                    player.displayClientMessage(new TextComponent("code-github:https://github.com/aftersans53228/Minecraft-AFRoads-Mod"), false);
                                    player.displayClientMessage(new TextComponent("thanks"), false);
                                    return 1;
                                }))
                )
                .requires(source -> source.hasPermission(4))
                .then (literal("server-client")
                        .then(literal("disconnection_games")
                                .executes(context ->{
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    AFRoads.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new DisconnectSelfMessage());
                                    return 1;
                                })
                        )
                        .then(literal("server_version")
                                .executes(context ->{
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    player.displayClientMessage(new TextComponent(MOD_VERSION),false);
                                    return 1;
                                })
                        )
                )
        );
    }
}