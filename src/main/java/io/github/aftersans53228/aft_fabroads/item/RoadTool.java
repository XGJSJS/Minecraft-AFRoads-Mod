package io.github.aftersans53228.aft_fabroads.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class RoadTool extends Item {
    public RoadTool() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(10));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipContext) {
        // 默认为白色文本
        tooltip.add( new TextComponent(" ") );
        tooltip.add( new TranslatableComponent("item.aft_fabroads.road_tool.tip1") );
        tooltip.add( new TranslatableComponent("item.aft_fabroads.road_tool.tip2") );
        tooltip.add( new TextComponent(" ") );
        tooltip.add( new TranslatableComponent("item.aft_fabroads.road_tool.tip_all") );
    }
}