package io.github.aftersans53228.aft_fabroads.regsitry;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AFRoadsTabRegistry {
    public static final CreativeModeTab NormalRoadBlockGROUP;
    public static final CreativeModeTab RoadStickersGROUP;
    public static final CreativeModeTab RoadDecorationsGROUP;

    public static void load() {
        AFRoads.LOGGER.info("AFRoads Tabs Initialized");
    }

    static {
        NormalRoadBlockGROUP = new CreativeModeTab("normal_road_blocks") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(AFRoadsItemRegistry.RoadBlockItem.get());
            }

            @Override
            public Component getDisplayName() {
                return new TranslatableComponent("itemGroup.aft_fabroads.normal_road_blocks");
            }
        };
        RoadStickersGROUP = new CreativeModeTab("road_stickers") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(AFRoadsItemRegistry.ArrowForwardItem.get());
            }

            @Override
            public Component getDisplayName() {
                return new TranslatableComponent("itemGroup.aft_fabroads.road_stickers");
            }
        };
        RoadDecorationsGROUP = new CreativeModeTab("road_decoration") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(AFRoadsItemRegistry.TrafficLightItem.get());
            }

            @Override
            public Component getDisplayName() {
                return new TranslatableComponent("itemGroup.aft_fabroads.road_decoration");
            }
        };
    }
}