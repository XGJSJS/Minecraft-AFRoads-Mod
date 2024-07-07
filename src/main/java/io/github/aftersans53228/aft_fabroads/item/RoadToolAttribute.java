package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.network.AttributesItemMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.commands.data.BlockDataAccessor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RoadToolAttribute extends Item {
    public RoadToolAttribute() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(10));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        // 默认为白色文本
        tooltip.add( new TextComponent(" ") );
        tooltip.add( new TranslatableComponent("item.aft_fabroads.road_tool_a.tip1") );
        tooltip.add( new TranslatableComponent("item.aft_fabroads.road_tool_a.tip2") );
        tooltip.add( new TextComponent(" ") );
        tooltip.add( new TranslatableComponent("item.aft_fabroads.road_tool.tip_all") );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        final Level world = context.getLevel();
        if(!world.isClientSide()) {
            final BlockPos pos = context.getClickedPos();
            List<String> attributes = new ArrayList<>();
            if (!world.getBlockState(pos).getProperties().isEmpty()) {
               attributes.add(world.getBlockState(pos).toString());
            }
            else {
                attributes.add("None.");
            }

            if (world.getBlockEntity(pos) != null) {
                final BlockDataAccessor bdo = new BlockDataAccessor(world.getBlockEntity(pos), pos);
                attributes.add(bdo.getData().toString());
            }
            else {
                attributes.add("None.");
            }
            if (context.getPlayer()!=null) {
                sendAttributeItem((ServerPlayer) context.getPlayer(),attributes);
            }

        }
        return InteractionResult.SUCCESS;
    }
    public static void sendAttributeItem(ServerPlayer player,List<String> attributes) {
        AFRoads.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new AttributesItemMessage(attributes.get(0), attributes.get(1)));
    }
    public static void receiveAttributeItem(String s1,String s2, LocalPlayer player) {
        Minecraft client = Minecraft.getInstance();
        client.execute(()->{
            StringBuilder textBuilder = new StringBuilder();
            textBuilder.append(I18n.get("text.return.aft_fabroads.tool_attribute1"));
            textBuilder.append(s1);
            textBuilder.append(I18n.get("text.return.aft_fabroads.tool_attribute2"));
            textBuilder.append(s2);
            textBuilder.append(I18n.get("text.return.aft_fabroads.tool_attribute3"));
            if (player!=null) {
                player.displayClientMessage(new TextComponent(textBuilder.toString()), false);
            }
        });
    }
}