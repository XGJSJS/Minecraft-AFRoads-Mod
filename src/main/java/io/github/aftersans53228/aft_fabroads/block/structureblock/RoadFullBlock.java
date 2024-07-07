package io.github.aftersans53228.aft_fabroads.block.structureblock;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;
import java.util.List;

public class RoadFullBlock extends HorizontalDirectionalBlock {
    private String type = "";

    public RoadFullBlock(String type) {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f));
        this.type = type;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
        switch (this.type) {
            case "road_block" -> tooltip.add(new TranslatableComponent("item.aft_fabroads.road_block"));
            case "road_manhole_cover" -> tooltip.add(new TranslatableComponent("item.aft_fabroads.manhole"));
            case "road_seam" -> tooltip.add(new TranslatableComponent("item.aft_fabroads.road_seams"));
            default -> tooltip.add(new TextComponent(""));
        }
    }
}