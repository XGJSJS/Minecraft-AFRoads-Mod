package io.github.aftersans53228.aft_fabroads.block.structureblock;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class ConcreteStairs extends StairBlock {
    public ConcreteStairs() {
        super(Blocks.WHITE_CONCRETE::defaultBlockState, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).noOcclusion());
    }
}
