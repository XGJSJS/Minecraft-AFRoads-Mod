package io.github.aftersans53228.aft_fabroads.regsitry;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.item.RoadTool;
import io.github.aftersans53228.aft_fabroads.item.RoadToolAttribute;
import io.github.aftersans53228.aft_fabroads.item.RoadToolLinked;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsTabRegistry.*;

public class AFRoadsItemRegistry {
    public static final DeferredRegister<Item> ITEMS;

    private static RegistryObject<Item> register(String id, Item item) {
        return ITEMS.register(id, () -> item);

    }
    private static RegistryObject<Item> registerBlock(String id, RegistryObject<Block> block) {
        return ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(NormalRoadBlockGROUP)));
    }
    private static RegistryObject<Item> registerSticker(String id, RegistryObject<Block> block) {
        return ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(RoadStickersGROUP)));
    }
    private static RegistryObject<Item> registerDecoration(String id, RegistryObject<Block> block) {
        return ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(RoadDecorationsGROUP)));
    }

    private static RegistryObject<Item> registerBlock(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(NormalRoadBlockGROUP)));
    }

    private static RegistryObject<Item> registerSticker(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(RoadStickersGROUP)));
    }
    
    public static final RegistryObject<Item> RoadTool;
    public static final RegistryObject<Item> RoadToolLinked;
    public static final RegistryObject<Item> RoadToolAttribute;
    public static final RegistryObject<Item> TrafficLightBulbRed;
    public static final RegistryObject<Item> TrafficLightBulbGreen;
    public static final RegistryObject<Item> TrafficLightBulbYellow;
    public static final RegistryObject<Item> TrafficLightPavementBulbRed;
    public static final RegistryObject<Item> TrafficLightPavementBulbGreen;
    public static final RegistryObject<Item> RoadLightBulbCold;
    public static final RegistryObject<Item> RoadLightBulbWarm;

    public static final RegistryObject<Item> RoadBlockItem;
    public static final RegistryObject<Item> RoadBlockConcreteItem;
    public static final RegistryObject<Item> ManholeCoverItem;
    public static final RegistryObject<Item> ManholeCoverConcreteItem;
    public static final RegistryObject<Item> RoadSeamsBlockItem ;
    public static final RegistryObject<Item> RoadSeamsBlockConcreteItem ;
    public static final RegistryObject<Item> ConcreteSlabItem ;
    public static final RegistryObject<Item> ConcreteStairsItem;
    public static final RegistryObject<Item> ConcreteStairsSmoothItem ;
    public static final RegistryObject<Item> ConcreteColumnsCornerItem;
    //创建划线贴纸
    public static final RegistryObject<Item> LineStraightItem;
    public static final RegistryObject<Item> LineCornerItem ;
    public static final RegistryObject<Item> LineTshapedItem ;
    public static final RegistryObject<Item> LineCrossItem ;
    public static final RegistryObject<Item> LineDiagonalItem ;
    public static final RegistryObject<Item> LineLeftBendItem ;
    public static final RegistryObject<Item> LineRightBendItem ;
    public static final RegistryObject<Item> LineForkLeftItem ;
    public static final RegistryObject<Item> LineForkRightItem ;
    public static final RegistryObject<Item> LineStraightThickItem;
    public static final RegistryObject<Item> LineStraightDuoLineItem;
    public static final RegistryObject<Item> LineStraightDuoThickItem;
    public static final RegistryObject<Item> LineStraightDuoThickDashedItem;
    public static final RegistryObject<Item> LineDecelerateWithLineItem ;
    public static final RegistryObject<Item> LineDecelerateWithLineFlipItem ;
    public static final RegistryObject<Item> LineDecelerateNoLineItem ;
    public static final RegistryObject<Item> LineDecelerateNoLineFlipItem ;
    public static final RegistryObject<Item> LineDecelerateDoubleWLItem ;
    public static final RegistryObject<Item> LineDecelerateDoubleNLItem ;
    public static final RegistryObject<Item> LineReversibleLanesItem ;
    public static final RegistryObject<Item> LineReversibleLanesFlipItem ;
    public static final RegistryObject<Item> LineReversibleLanesDoubleItem ;
    //创建箭头贴纸
    public static final RegistryObject<Item> ArrowForwardItem;
    public static final RegistryObject<Item> ArrowLeftItem ;
    public static final RegistryObject<Item> ArrowRightItem;
    public static final RegistryObject<Item> ArrowForwardLeftItem ;
    public static final RegistryObject<Item> ArrowForwardRightItem ;
    public static final RegistryObject<Item> ArrowBackItem ;
    public static final RegistryObject<Item> ArrowLeftRightItem ;
    public static final RegistryObject<Item> ArrowBackLeftItem ;
    public static final RegistryObject<Item> ArrowBackForwardItem ;
    public static final RegistryObject<Item> ArrowConfluenceLeftItem ;
    public static final RegistryObject<Item> ArrowConfluenceRightItem ;
    //创建图标贴纸
    public static final RegistryObject<Item> IconDecelerateStickerItem;
    public static final RegistryObject<Item> IconStopStickerItem;
    public static final RegistryObject<Item> IconGiveWayStickerItem;
    //创建装饰方块
    public static final RegistryObject<Item> RailingsItem ;
    public static final RegistryObject<Item> PavementRailingsItem ;
    public static final RegistryObject<Item> ExpresswayRailingsBaseItem ;
    public static final RegistryObject<Item> ExpresswayIronRailingsItem;
    public static final RegistryObject<Item> ExpresswayIronRailings2Item;
    public static final RegistryObject<Item> ExpresswayRailingsItem ;
    public static final RegistryObject<Item> ExpresswayRailingsType2Item ;
    public static final RegistryObject<Item> InsulationPanelsRailingsItem ;
    public static final RegistryObject<Item> InsulationPanelsGrayPart1Item ;
    public static final RegistryObject<Item> InsulationPanelsGrayPart2Item;
    public static final RegistryObject<Item> InsulationPanelsGrayPart3Item ;
    public static final RegistryObject<Item> InsulationPanelsGrayPart4Item;
    public static final RegistryObject<Item> InsulationPanelsGrayPart5Item;
    public static final RegistryObject<Item> InsulationPanelsGrayPart6Item ;

    public static final RegistryObject<Item> BarrierBarItem;
    public static final RegistryObject<Item> TrafficLightsControlBoxItem ;
    public static final RegistryObject<Item> TrafficLightItem;
    public static final RegistryObject<Item> TrafficLightPavementItem ;
    public static final RegistryObject<Item> RoadLightItem ;

    public static final RegistryObject<Item> PillarBaseItem ;
    public static final RegistryObject<Item> HorizontalStraightPillarItem;
    public static final RegistryObject<Item> VerticalStraightPillarItem ;
    public static final RegistryObject<Item> HorizontalCornerPillarItem ;
    public static final RegistryObject<Item> VerticalCornerPillarItem ;
    public static final RegistryObject<Item> HorizontalTshapedPillarItem ;
    public static final RegistryObject<Item> VerticalTshapedPillarItem ;
    public static final RegistryObject<Item> VerticalTshapedPillarType2Item ;
    public static final RegistryObject<Item> RoadMastPillarBaseItem ;
    public static final RegistryObject<Item> RoadMastPillarItem;
    public static final RegistryObject<Item> HorizontalStraightPillarThinItem ;
    public static final RegistryObject<Item> VerticalStraightPillarThinItem ;
    public static final RegistryObject<Item> VerticalCornerPillarThinItem;
    public static final RegistryObject<Item> SmartPillarItem;
    public static final RegistryObject<Item> SmartPillarThinItem;

    public static final RegistryObject<Item> SignIndicatorDirectionLeftItem ;
    public static final RegistryObject<Item> SignIndicatorDirectionRightItem;
    public static final RegistryObject<Item> SignIndicatorDirectionCarItem ;
    public static final RegistryObject<Item> SignIndicatorDirectionBicycleItem ;
    public static final RegistryObject<Item> SignBanNoDriveItem ;
    public static final RegistryObject<Item> SignBanStopItem;
    public static final RegistryObject<Item> SignBanSpeedLimit05Item ;
    public static final RegistryObject<Item> SignBanSpeedLimit20Item ;
    public static final RegistryObject<Item> SignBanSpeedLimit30Item ;
    public static final RegistryObject<Item> SignBanSpeedLimit40Item ;
    public static final RegistryObject<Item> SignBanSpeedLimit50Item ;
    public static final RegistryObject<Item> SignBanSpeedLimit60Item ;
    public static final RegistryObject<Item> SignBanSpeedLimit70Item ;
    public static final RegistryObject<Item> SignBanSpeedLimit80Item ;

    public static final RegistryObject<Item> RubbishBinMetalItem;
    public static final RegistryObject<Item> TrashBinGreenItem;
    public static final RegistryObject<Item> RoadNameSignItem ;
    
    
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AFRoadsStatics.MOD_ID);

        //Items
        RoadTool=register("road_tool",new RoadTool());
        RoadToolLinked=register("road_tool_linked",new RoadToolLinked());
        RoadToolAttribute =register("road_tool_attribute",new RoadToolAttribute());
        TrafficLightBulbRed=register("traffic_light_red_bulb", new Item(new Item.Properties()));
        TrafficLightBulbGreen=register("traffic_light_green_bulb", new Item(new Item.Properties()));
        TrafficLightBulbYellow=register("traffic_light_yellow_bulb", new Item(new Item.Properties()));
        TrafficLightPavementBulbRed=register("traffic_light_pavement_red_bulb", new Item(new Item.Properties()));
        TrafficLightPavementBulbGreen=register("traffic_light_pavement_green_bulb", new Item(new Item.Properties()));
        RoadLightBulbCold=register("road_light_bulb_cold", new Item(new Item.Properties()));
        RoadLightBulbWarm=register("road_light_bulb_warm", new Item(new Item.Properties()));
        ////BlockItems
        RoadBlockItem = registerBlock(RoadBlock);
        RoadBlockConcreteItem =registerBlock("road_block_concrete",RoadBlockConcrete);
        ManholeCoverItem =registerBlock("manhole_cover",ManholeCover);
        ManholeCoverConcreteItem =registerBlock("manhole_cover_concrete",ManholeCoverConcrete);
        RoadSeamsBlockItem =registerBlock("road_seams_block",RoadSeamsBlock);
        RoadSeamsBlockConcreteItem =registerBlock("road_seams_block_concrete",RoadSeamsBlockConcrete);
        ConcreteSlabItem =registerBlock("concrete_slab",ConcreteSlab);
        ConcreteStairsItem =registerBlock("concrete_stairs",ConcreteStairs);
        ConcreteStairsSmoothItem =registerBlock("concrete_stairs_smooth",ConcreteStairsSmooth);
        ConcreteColumnsCornerItem =registerBlock("concrete_columns_corner",ConcreteColumnsCorner);
        //创建划线贴纸
        LineStraightItem =registerSticker("line_straight",LineStraight);
        LineCornerItem =registerSticker("line_corner",  LineCorner);
        LineTshapedItem =registerSticker("line_tshaped",LineTshaped);
        LineCrossItem =registerSticker("line_cross", LineCross);
        LineDiagonalItem =registerSticker("line_diagonal",  LineDiagonal);
        LineLeftBendItem =registerSticker("line_left_bend", LineLeftBend);
        LineRightBendItem =registerSticker("line_right_bend", LineRightBend);
        LineForkLeftItem =registerSticker("line_fork_left",   LineForkLeft);
        LineForkRightItem =registerSticker("line_fork_right",LineForkRight);
        LineStraightThickItem =registerSticker("thick_line_straight",  LineStraightThick);
        LineStraightDuoLineItem =registerSticker("line_duo_straight", LineStraightDuoLine);
        LineStraightDuoThickItem =registerSticker("thick_line_duo_straight",LineStraightDuoThick);
        LineStraightDuoThickDashedItem =registerSticker("thick_line_duo_straight_dashed",LineStraightDuoThickDashed);
        LineDecelerateWithLineItem =registerSticker("line_decelerate_w_line",     LineDecelerateWithLine);
        LineDecelerateWithLineFlipItem =registerSticker("line_decelerate_w_line_flip"   ,LineDecelerateWithLineFlip);
        LineDecelerateNoLineItem =registerSticker("line_decelerate", LineDecelerateNoLine);
        LineDecelerateNoLineFlipItem =registerSticker("line_decelerate_flip",LineDecelerateNoLineFlip);
        LineDecelerateDoubleWLItem =registerSticker("line_decelerate_d_w_l",LineDecelerateDoubleWL);
        LineDecelerateDoubleNLItem =registerSticker("line_decelerate_d_n_l",LineDecelerateDoubleNL);
        LineReversibleLanesItem =registerSticker("line_reversible_lanes",LineReversibleLanes);
        LineReversibleLanesFlipItem =registerSticker("line_reversible_lanes_flip",LineReversibleLanesFlip);
        LineReversibleLanesDoubleItem =registerSticker("line_reversible_lanes_double",LineReversibleLanesDouble);
        //创建箭头贴纸
        ArrowForwardItem = registerSticker(ArrowForward);
        ArrowLeftItem =registerSticker("arrow_left",ArrowLeft);
        ArrowRightItem =registerSticker("arrow_right", ArrowRight);
        ArrowForwardLeftItem =registerSticker("arrow_forward_left",ArrowForwardLeft);
        ArrowForwardRightItem =registerSticker("arrow_forward_right",ArrowForwardRight);
        ArrowBackItem =registerSticker("arrow_back",ArrowBack);
        ArrowLeftRightItem =registerSticker("arrow_left_right", ArrowLeftRight);
        ArrowBackLeftItem =registerSticker("arrow_back_left",ArrowBackLeft);
        ArrowBackForwardItem =registerSticker("arrow_back_forward",   ArrowBackForward);
        ArrowConfluenceLeftItem =registerSticker("arrow_confluence_left", ArrowConfluenceLeft);
        ArrowConfluenceRightItem =registerSticker("arrow_confluence_right",  ArrowConfluenceRight);
        //创建图标贴纸
        IconDecelerateStickerItem = registerSticker(IconDecelerateSticker);
        IconStopStickerItem = registerSticker("icon_stop_sticker",IconStopSticker);
        IconGiveWayStickerItem =registerSticker("icon_give_way_sticker",IconGiverWaySticker);
        //创建装饰方块
        RailingsItem =registerDecoration("railings",Railings);
        PavementRailingsItem =registerDecoration("pavement_railings",PavementRailings);
        ExpresswayRailingsBaseItem =registerDecoration("expressway_railings_base",ExpresswayRailingsBase);
        ExpresswayIronRailingsItem =registerDecoration("expressway_iron_railings",ExpresswayIronRailings);
        ExpresswayIronRailings2Item =registerDecoration("expressway_iron_railings2",ExpresswayIronRailings2);
        ExpresswayRailingsItem =registerDecoration("expressway_railings",ExpresswayRailings);
        ExpresswayRailingsType2Item =registerDecoration("expressway_railings_type2",ExpresswayRailingsType2);
        InsulationPanelsRailingsItem =registerDecoration("insulation_panels_railings",InsulationPanelsRailings);
        InsulationPanelsGrayPart1Item =registerDecoration("insulation_panels_gray_part1",InsulationPanelsGrayPart1);
        InsulationPanelsGrayPart2Item =registerDecoration("insulation_panels_gray_part2",InsulationPanelsGrayPart2);
        InsulationPanelsGrayPart3Item =registerDecoration("insulation_panels_gray_part3",InsulationPanelsGrayPart3);
        InsulationPanelsGrayPart4Item =registerDecoration("insulation_panels_gray_part4",InsulationPanelsGrayPart4);
        InsulationPanelsGrayPart5Item =registerDecoration("insulation_panels_gray_part5",InsulationPanelsGrayPart5);
        InsulationPanelsGrayPart6Item =registerDecoration("insulation_panels_gray_part6",InsulationPanelsGrayPart6);

        BarrierBarItem =registerDecoration("barrier_bar",BarrierBar);
        TrafficLightsControlBoxItem =registerDecoration("traffic_lights_control_box", TrafficLightsControlBox);
        TrafficLightItem = registerDecoration("traffic_light", TrafficLight);
        TrafficLightPavementItem =registerDecoration("traffic_light_pavement",TrafficLightPavement);
        RoadLightItem =registerDecoration("road_light",RoadLight);

        PillarBaseItem =registerDecoration("pillar_base",PillarBase);
        HorizontalStraightPillarItem =registerDecoration("horizontal_straight_pillar",HorizontalStraightPillar);
        VerticalStraightPillarItem =registerDecoration("vertical_straight_pillar",VerticalStraightPillar);
        HorizontalCornerPillarItem =registerDecoration("horizontal_corner_pillar",HorizontalCornerPillar);
        VerticalCornerPillarItem =registerDecoration("vertical_corner_pillar",VerticalCornerPillar);
        HorizontalTshapedPillarItem =registerDecoration("horizontal_tshaped_pillar",HorizontalTshapedPillar);
        VerticalTshapedPillarItem =registerDecoration("vertical_tshaped_pillar",VerticalTshapedPillar);
        VerticalTshapedPillarType2Item =registerDecoration("vertical_tshaped_pillar_type2",VerticalTshapedPillarType2);
        RoadMastPillarBaseItem =registerDecoration("road_mast_pillar_base",RoadMastPillarBase);
        RoadMastPillarItem =registerDecoration("road_mast_pillar",RoadMastPillar);
        HorizontalStraightPillarThinItem =registerDecoration("horizontal_straight_pillar_thin",HorizontalStraightPillarThin);
        VerticalStraightPillarThinItem =registerDecoration("vertical_straight_pillar_thin",VerticalStraightPillarThin);
        VerticalCornerPillarThinItem =registerDecoration("vertical_corner_pillar_thin",VerticalCornerPillarThin);
        SmartPillarItem =registerDecoration("smart_pillar",SmartPillar);
        SmartPillarThinItem =registerDecoration("smart_pillar_thin",SmartPillarThin);

        SignIndicatorDirectionLeftItem =registerDecoration("sign_indicator_direction_left",SignIndicatorDirectionLeft);
        SignIndicatorDirectionRightItem =registerDecoration("sign_indicator_direction_right",SignIndicatorDirectionRight);
        SignIndicatorDirectionCarItem =registerDecoration("sign_indicator_direction_car",SignIndicatorDirectionCar);
        SignIndicatorDirectionBicycleItem =registerDecoration("sign_indicator_direction_bicycle",SignIndicatorDirectionBicycle);
        SignBanNoDriveItem =registerDecoration("sign_ban_no_drive",SignBanNoDrive);
        SignBanStopItem =registerDecoration("sign_ban_stop",SignBanStop);
        SignBanSpeedLimit05Item =registerDecoration("sign_ban_speed_limit_05",SignBanSpeedLimit05);
        SignBanSpeedLimit20Item =registerDecoration("sign_ban_speed_limit_20",SignBanSpeedLimit20);
        SignBanSpeedLimit30Item =registerDecoration("sign_ban_speed_limit_30",SignBanSpeedLimit30);
        SignBanSpeedLimit40Item =registerDecoration("sign_ban_speed_limit_40",SignBanSpeedLimit40);
        SignBanSpeedLimit50Item =registerDecoration("sign_ban_speed_limit_50",SignBanSpeedLimit50);
        SignBanSpeedLimit60Item =registerDecoration("sign_ban_speed_limit_60",SignBanSpeedLimit60);
        SignBanSpeedLimit70Item =registerDecoration("sign_ban_speed_limit_70",SignBanSpeedLimit70);
        SignBanSpeedLimit80Item =registerDecoration("sign_ban_speed_limit_80",SignBanSpeedLimit80);

        RubbishBinMetalItem =registerDecoration("rubbish_bin_metal",RubbishBinMetal);
        TrashBinGreenItem =registerDecoration("trash_bin_green",TrashBinGreen);
        RoadNameSignItem =registerDecoration("road_name_sign",RoadNameSign);

        AFRoads.LOGGER.info("AFRoads Items Initialized");
    }
}
