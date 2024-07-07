package io.github.aftersans53228.aft_fabroads;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public abstract class AFRoadsStatics {
    public static final String MOD_ID = "aft_fabroads";
    public static final ResourceLocation MOD_ID_UTIL = new ResourceLocation(MOD_ID,"aft_fabroads");
    public static final String MOD_VERSION = "1.0.0";
    public static final String MINECRAFT_VERSION = "1.17.x";
    public static final List<RegistryObject<Block>> PILLAR_BLOCKS = new ArrayList<>();
    public static final List<RegistryObject<Block>> CAN_PILLAR_CONNECT = new ArrayList<>();
}