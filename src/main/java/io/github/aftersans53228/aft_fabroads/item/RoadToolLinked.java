package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.block.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlBox;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

public class RoadToolLinked extends Item {
    private BlockPos boxPos = null;
    private static final List<Block> canLinkBlock = new ArrayList<>();
    private static boolean init;

    public RoadToolLinked() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(10));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipContext) {
        // 默认为白色文本
        tooltip.add(TextComponent.EMPTY);
        tooltip.add(new TranslatableComponent("item.aft_fabroads.road_tool_l.tip1") );
        tooltip.add(new TranslatableComponent("item.aft_fabroads.road_tool_l.tip2") );
        tooltip.add(TextComponent.EMPTY);
        tooltip.add(new TranslatableComponent("item.aft_fabroads.road_tool.tip_all") );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null)
            return InteractionResult.PASS;
        if (this.canLinkBlock.contains(context.getLevel().getBlockState(context.getClickedPos()).getBlock()) && context.getLevel().getBlockEntity(context.getClickedPos()) != null) {
            if (!context.getLevel().isClientSide() && context.getLevel().getBlockEntity(context.getClickedPos()).getType().equals(AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY.get())) {
                if (this.boxPos == null) {
                    this.boxPos = context.getClickedPos();
                    context.getPlayer().displayClientMessage(new TextComponent("Select the CONTROL BOX."), true);
                } else {
                    context.getPlayer().displayClientMessage(new TextComponent("Can't set CONTROL BOX as another."), true);
                }
                return InteractionResult.SUCCESS;
            }
            if (!context.getLevel().isClientSide() && context.getLevel().getBlockEntity(context.getClickedPos()).getType().equals(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY.get())) {
                if (this.boxPos != null) {
                    TrafficLightEntity entity = (TrafficLightEntity) context.getLevel().getBlockEntity(context.getClickedPos());
                    entity.setControlBoxPos(this.boxPos);
                    context.getPlayer().displayClientMessage(new TextComponent("Set Traffic Light the CONTROL BOX."), true);
                    this.boxPos=null;
                } else {
                    context.getPlayer().displayClientMessage(new TextComponent("Traffic Lights aren't the linking starting."), true);
                }
                return InteractionResult.SUCCESS;
            }
        } else {
            context.getPlayer().displayClientMessage(new TextComponent("This block can't be linked."), true);
        }
        return InteractionResult.PASS;
    }

    public static void init() {
        if (!init) {
            canLinkBlock.add(TrafficLightsControlBox.get());
            canLinkBlock.add(TrafficLight.get());
            canLinkBlock.add(TrafficLightPavement.get());
            init = true;
        }
    }
}