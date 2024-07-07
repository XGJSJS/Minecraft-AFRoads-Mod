package io.github.aftersans53228.aft_fabroads.regsitry;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.block.*;
import io.github.aftersans53228.aft_fabroads.block.pillarblock.*;
import io.github.aftersans53228.aft_fabroads.block.signblock.SignNormal;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.ArrowBlocks;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.IconBlocks;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.LineBlocks;
import io.github.aftersans53228.aft_fabroads.block.structureblock.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static io.github.aftersans53228.aft_fabroads.block.voxelshapes.RailingsFacing.*;

public class AFRoadsBlockRegistry {
    public static final DeferredRegister<Block> BLOCKS;
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES;
    
    private static RegistryObject<Block> register(String id, Block block) {
        return BLOCKS.register(id, () -> block);
    }

    private static RegistryObject<Block> registerPillar(String id, Block block) {
        final RegistryObject<Block> TEMP = register(id, block);
        AFRoadsStatics.PILLAR_BLOCKS.add(TEMP);
        return TEMP;
    }

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(BlockEntityType.BlockEntitySupplier<T> blockEntity, RegistryObject<Block> block) {
        return BLOCK_ENTITY_TYPES.register(block.getId().getPath(), () -> BlockEntityType.Builder.of(blockEntity, block.get()).build(null));
    }

    private static RegistryObject<Block> setPillarConnect(RegistryObject<Block> block) {
        AFRoadsStatics.CAN_PILLAR_CONNECT.add(block);
        return block;
    }

    public static final RegistryObject<Block> RoadBlock;
    public static final RegistryObject<Block> RoadBlockConcrete;
    public static final RegistryObject<Block> ManholeCover;
    public static final RegistryObject<Block> ManholeCoverConcrete;
    public static final RegistryObject<Block> RoadSeamsBlock;
    public static final RegistryObject<Block> RoadSeamsBlockConcrete;
    public static final RegistryObject<Block> ConcreteSlab;
    public static final RegistryObject<Block> ConcreteStairs;
    public static final RegistryObject<Block> ConcreteStairsSmooth ;
    public static final RegistryObject<Block> ConcreteColumnsCorner;
    //创建划线贴纸
    public static final RegistryObject<Block> LineStraight;
    public static final RegistryObject<Block> LineCorner ;
    public static final RegistryObject<Block> LineTshaped ;
    public static final RegistryObject<Block> LineCross ;
    public static final RegistryObject<Block> LineDiagonal ;
    public static final RegistryObject<Block> LineLeftBend ;
    public static final RegistryObject<Block> LineRightBend ;
    public static final RegistryObject<Block> LineForkLeft ;
    public static final RegistryObject<Block> LineForkRight ;
    public static final RegistryObject<Block> LineStraightThick;
    public static final RegistryObject<Block> LineStraightDuoLine;
    public static final RegistryObject<Block> LineStraightDuoThick;
    public static final RegistryObject<Block> LineStraightDuoThickDashed;
    public static final RegistryObject<Block> LineDecelerateWithLine ;
    public static final RegistryObject<Block> LineDecelerateWithLineFlip ;
    public static final RegistryObject<Block> LineDecelerateNoLine ;
    public static final RegistryObject<Block> LineDecelerateNoLineFlip ;
    public static final RegistryObject<Block> LineDecelerateDoubleNL ;
    public static final RegistryObject<Block> LineDecelerateDoubleWL ;
    public static final RegistryObject<Block> LineReversibleLanes  ;
    public static final RegistryObject<Block> LineReversibleLanesFlip  ;
    public static final RegistryObject<Block> LineReversibleLanesDouble ;
    //创建箭头贴纸
    public static final RegistryObject<Block> ArrowForward;
    public static final RegistryObject<Block> ArrowLeft ;
    public static final RegistryObject<Block> ArrowRight;
    public static final RegistryObject<Block> ArrowForwardLeft ;
    public static final RegistryObject<Block> ArrowForwardRight ;
    public static final RegistryObject<Block> ArrowBack ;
    public static final RegistryObject<Block> ArrowLeftRight ;
    public static final RegistryObject<Block> ArrowBackLeft ;
    public static final RegistryObject<Block> ArrowBackForward ;
    public static final RegistryObject<Block> ArrowConfluenceLeft ;
    public static final RegistryObject<Block> ArrowConfluenceRight ;
    //创建图标贴纸
    public static final RegistryObject<Block> IconDecelerateSticker;
    public static final RegistryObject<Block> IconStopSticker;
    public static final RegistryObject<Block> IconGiverWaySticker;
    //创建装饰方块
    public static final RegistryObject<Block> Railings ;
    public static final RegistryObject<Block> PavementRailings ;
    public static final RegistryObject<Block> ExpresswayRailingsBase ;
    public static final RegistryObject<Block> ExpresswayIronRailings;
    public static final RegistryObject<Block> ExpresswayIronRailings2;
    public static final RegistryObject<Block> ExpresswayRailings ;
    public static final RegistryObject<Block> ExpresswayRailingsType2 ;
    public static final RegistryObject<Block> InsulationPanelsRailings ;
    public static final RegistryObject<Block> InsulationPanelsGrayPart1 ;
    public static final RegistryObject<Block> InsulationPanelsGrayPart2;
    public static final RegistryObject<Block> InsulationPanelsGrayPart3 ;
    public static final RegistryObject<Block> InsulationPanelsGrayPart4;
    public static final RegistryObject<Block> InsulationPanelsGrayPart5;
    public static final RegistryObject<Block> InsulationPanelsGrayPart6 ;

    public static final RegistryObject<Block> BarrierBar;
    public static final RegistryObject<Block> TrafficLightsControlBox;
    public static final RegistryObject<Block> TrafficLight;
    public static final RegistryObject<Block> TrafficLightPavement ;
    public static final RegistryObject<Block> RoadLight ;

    public static final RegistryObject<Block> PillarBase ;
    public static final RegistryObject<Block> HorizontalStraightPillar;
    public static final RegistryObject<Block> VerticalStraightPillar ;
    public static final RegistryObject<Block> HorizontalCornerPillar ;
    public static final RegistryObject<Block> VerticalCornerPillar ;
    public static final RegistryObject<Block> HorizontalTshapedPillar ;
    public static final RegistryObject<Block> VerticalTshapedPillar ;
    public static final RegistryObject<Block> VerticalTshapedPillarType2 ;
    public static final RegistryObject<Block> RoadMastPillarBase ;
    public static final RegistryObject<Block> RoadMastPillar;
    public static final RegistryObject<Block> HorizontalStraightPillarThin ;
    public static final RegistryObject<Block> VerticalStraightPillarThin ;
    public static final RegistryObject<Block> VerticalCornerPillarThin;
    public static final RegistryObject<Block> SmartPillar;
    public static final RegistryObject<Block> SmartPillarThin;

    public static final RegistryObject<Block> SignIndicatorDirectionLeft ;
    public static final RegistryObject<Block> SignIndicatorDirectionRight;
    public static final RegistryObject<Block> SignIndicatorDirectionCar ;
    public static final RegistryObject<Block> SignIndicatorDirectionBicycle ;
    public static final RegistryObject<Block> SignBanNoDrive ;
    public static final RegistryObject<Block> SignBanStop;
    public static final RegistryObject<Block> SignBanSpeedLimit05 ;
    public static final RegistryObject<Block> SignBanSpeedLimit20 ;
    public static final RegistryObject<Block> SignBanSpeedLimit30 ;
    public static final RegistryObject<Block> SignBanSpeedLimit40 ;
    public static final RegistryObject<Block> SignBanSpeedLimit50 ;
    public static final RegistryObject<Block> SignBanSpeedLimit60 ;
    public static final RegistryObject<Block> SignBanSpeedLimit70 ;
    public static final RegistryObject<Block> SignBanSpeedLimit80 ;

    public static final RegistryObject<Block> RubbishBinMetal;
    public static final RegistryObject<Block> TrashBinGreen;
    public static final RegistryObject<Block> RoadNameSign ;

    //misc
    // public static final RegistryObject<Block> LightSource;


    //方块实体
    public static final RegistryObject<BlockEntityType<TrafficLightEntity>> TRAFFIC_LIGHT_ENTITY;
    public static final RegistryObject<BlockEntityType<TrafficLightPavementEntity>> TRAFFIC_LIGHT_PAVEMENT_ENTITY;
    public static final RegistryObject<BlockEntityType<RoadLightEntity>> ROAD_LIGHT_ENTITY;
    public static final RegistryObject<BlockEntityType<RoadNameSignEntity>> ROAD_NAME_SIGN_ENTITY;
    public static final RegistryObject<BlockEntityType<TrafficLightsControlEntity>> TRAFFIC_LIGHTS_CONTROL_ENTITY;


    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AFRoadsStatics.MOD_ID);
        BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, AFRoadsStatics.MOD_ID);

        RoadBlock = register("road_block", new RoadFullBlock("road_block"));
        RoadBlockConcrete = register("road_block_concrete", new RoadFullBlock("road_block"));
        ManholeCover = register("manhole_cover", new RoadFullBlock("road_manhole_cover"));
        ManholeCoverConcrete = register("manhole_cover_concrete", new RoadFullBlock("road_manhole_cover"));
        RoadSeamsBlock = register("road_seams_block", new RoadFullBlock("road_seam"));
        RoadSeamsBlockConcrete = register("road_seams_block_concrete", new RoadFullBlock("road_seam"));
        ConcreteSlab = register("concrete_slab", new ConcreteSlab());
        ConcreteStairs = register("concrete_stairs", new ConcreteStairs());
        ConcreteStairsSmooth =register("concrete_stairs_smooth",new ConcreteStairs());
        ConcreteColumnsCorner =register("concrete_columns_corner",new ConcreteColumnsCorner());
        //创建划线贴纸
        LineStraight =register("line_straight",new LineBlocks());
        LineCorner =register("line_corner",new LineBlocks());
        LineTshaped =register("line_tshaped",new LineBlocks());
        LineCross =register("line_cross",new LineBlocks());
        LineDiagonal =register("line_diagonal",new LineBlocks());
        LineLeftBend =register("line_left_bend",new LineBlocks());
        LineRightBend =register("line_right_bend",new LineBlocks());
        LineForkLeft =register("line_fork_left",new LineBlocks());
        LineForkRight =register("line_fork_right",new LineBlocks());
        LineStraightThick =register("thick_line_straight",new LineBlocks());
        LineStraightDuoLine =register("line_duo_straight",new LineBlocks());
        LineStraightDuoThick =register("thick_line_duo_straight",new LineBlocks());
        LineStraightDuoThickDashed =register("thick_line_duo_straight_dashed",new LineBlocks());
        LineDecelerateWithLine =register("line_decelerate_w_line",new LineBlocks());
        LineDecelerateWithLineFlip =register("line_decelerate_w_line_flip",new LineBlocks());
        LineDecelerateNoLine =register("line_decelerate",new LineBlocks());
        LineDecelerateNoLineFlip =register("line_decelerate_flip",new LineBlocks());
        LineDecelerateDoubleWL =register("line_decelerate_d_w_l",new LineBlocks());
        LineDecelerateDoubleNL =register("line_decelerate_d_n_l",new LineBlocks());
        LineReversibleLanes=register("line_reversible_lanes",new LineBlocks());
        LineReversibleLanesFlip=register("line_reversible_lanes_flip",new LineBlocks());
        LineReversibleLanesDouble = register("line_reversible_lanes_double",new LineBlocks());
        //创建箭头贴纸
        ArrowForward = register("arrow_forward", new ArrowBlocks());
        ArrowLeft =register("arrow_left",new ArrowBlocks());
        ArrowRight =register("arrow_right",new ArrowBlocks());
        ArrowForwardLeft =register("arrow_forward_left",new ArrowBlocks());
        ArrowForwardRight =register("arrow_forward_right",new ArrowBlocks());
        ArrowBack =register("arrow_back",new ArrowBlocks());
        ArrowLeftRight =register("arrow_left_right",new ArrowBlocks());
        ArrowBackLeft =register("arrow_back_left",new ArrowBlocks());
        ArrowBackForward =register("arrow_back_forward",new ArrowBlocks());
        ArrowConfluenceLeft =register("arrow_confluence_left",new ArrowBlocks());
        ArrowConfluenceRight =register("arrow_confluence_right",new ArrowBlocks());
        //创建图标贴纸
        IconDecelerateSticker = register("icon_decelerate_sticker", new IconBlocks());
        IconStopSticker =register("icon_stop_sticker",new IconBlocks());
        IconGiverWaySticker =register("icon_give_way_sticker",new IconBlocks());
        //创建装饰方块
        Railings =register("railings",new HorizontalRailings().setVoxelShapes(getRoad()));
        PavementRailings =register("pavement_railings",new HorizontalRailings().setVoxelShapes(getPavement()));
        ExpresswayRailingsBase =register("expressway_railings_base",new HorizontalRailings().setVoxelShapes(getExpresswayBase()));
        ExpresswayIronRailings =register("expressway_iron_railings",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner1()).setTipsMode(false));
        ExpresswayIronRailings2 =register("expressway_iron_railings2",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner1()).setTipsMode(false));
        ExpresswayRailings =register("expressway_railings",new HorizontalRailings().setVoxelShapes(getExpresswayRailings()));
        ExpresswayRailingsType2 =register("expressway_railings_type2",new HorizontalRailings().setVoxelShapes(getExpresswayRailings()));
        InsulationPanelsRailings =register("insulation_panels_railings",new HorizontalRailings().setVoxelShapes(getExpresswayGreenPanels()));
        InsulationPanelsGrayPart1 =register("insulation_panels_gray_part1",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsVertical()));
        InsulationPanelsGrayPart2 =register("insulation_panels_gray_part2",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsVertical()));
        InsulationPanelsGrayPart3 =register("insulation_panels_gray_part3",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner1()));
        InsulationPanelsGrayPart4 =register("insulation_panels_gray_part4",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner2()));
        InsulationPanelsGrayPart5 =register("insulation_panels_gray_part5",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsHorizontal()));
        InsulationPanelsGrayPart6 =register("insulation_panels_gray_part6",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsHorizontal()));

        BarrierBar =register("barrier_bar",new BarrierBar());
        TrafficLightsControlBox =register("traffic_lights_control_box",new TrafficLightsControlBox());
        TrafficLight = setPillarConnect(register("traffic_light", new TrafficLight()));
        TrafficLightPavement =setPillarConnect(register("traffic_light_pavement",new TrafficLightPavement()));
        RoadLight =setPillarConnect(register("road_light",new RoadLight()));

        PillarBase =registerPillar("pillar_base",new PillarBase());
        HorizontalStraightPillar =registerPillar("horizontal_straight_pillar",new HorizontalStraightPillar());
        VerticalStraightPillar =registerPillar("vertical_straight_pillar",new VerticalStraightPillar());
        HorizontalCornerPillar =registerPillar("horizontal_corner_pillar",new HorizontalCornerPillar());
        VerticalCornerPillar =registerPillar("vertical_corner_pillar",new VerticalCornerPillar());
        HorizontalTshapedPillar =registerPillar("horizontal_tshaped_pillar",new HorizontalTshapedPillar());
        VerticalTshapedPillar =registerPillar("vertical_tshaped_pillar",new VerticalTshapedPillar());
        VerticalTshapedPillarType2 =registerPillar("vertical_tshaped_pillar_type2",new VerticalTshapedPillarType2());
        RoadMastPillarBase =registerPillar("road_mast_pillar_base",new RoadMastPillarBase());
        RoadMastPillar =registerPillar("road_mast_pillar",new RoadMastPillar());
        HorizontalStraightPillarThin =registerPillar("horizontal_straight_pillar_thin",new HorizontalStraightPillarThin());
        VerticalStraightPillarThin =registerPillar("vertical_straight_pillar_thin",new VerticalStraightPillarThin());
        VerticalCornerPillarThin =registerPillar("vertical_corner_pillar_thin",new VerticalCornerPillarThin());
        SmartPillar =registerPillar("smart_pillar",new SmartPillar());
        SmartPillarThin =registerPillar("smart_pillar_thin",new SmartPillar());

        SignIndicatorDirectionLeft =setPillarConnect(register("sign_indicator_direction_left",new SignNormal()));
        SignIndicatorDirectionRight =setPillarConnect(register("sign_indicator_direction_right",new SignNormal()));
        SignIndicatorDirectionCar =setPillarConnect(register("sign_indicator_direction_car",new SignNormal()));
        SignIndicatorDirectionBicycle =setPillarConnect(register("sign_indicator_direction_bicycle",new SignNormal()));
        SignBanNoDrive =setPillarConnect(register("sign_ban_no_drive",new SignNormal()));
        SignBanStop =setPillarConnect(register("sign_ban_stop",new SignNormal()));
        SignBanSpeedLimit05 =setPillarConnect(register("sign_ban_speed_limit_05",new SignNormal()));
        SignBanSpeedLimit20 =setPillarConnect(register("sign_ban_speed_limit_20",new SignNormal()));
        SignBanSpeedLimit30 =setPillarConnect(register("sign_ban_speed_limit_30",new SignNormal()));
        SignBanSpeedLimit40 =setPillarConnect(register("sign_ban_speed_limit_40",new SignNormal()));
        SignBanSpeedLimit50 =setPillarConnect(register("sign_ban_speed_limit_50",new SignNormal()));
        SignBanSpeedLimit60 =setPillarConnect(register("sign_ban_speed_limit_60",new SignNormal()));
        SignBanSpeedLimit70 =setPillarConnect(register("sign_ban_speed_limit_70",new SignNormal()));
        SignBanSpeedLimit80 =setPillarConnect(register("sign_ban_speed_limit_80",new SignNormal()));

        RubbishBinMetal =register("rubbish_bin_metal",new RubbishBinMetal());
        TrashBinGreen =register("trash_bin_green",new TrashBinGreen());
        RoadNameSign =setPillarConnect(register("road_name_sign",new RoadNameSign()));
        //misc
        //LightSource =register("light_source",new Block(BlockBehaviour.Properties.of(Material.AIR).hardness(0.5f).luminance(15).noCollision().noOcclusion()));

        TRAFFIC_LIGHT_ENTITY = register(TrafficLightEntity::new, TrafficLight);
        TRAFFIC_LIGHT_PAVEMENT_ENTITY = register(TrafficLightPavementEntity::new, TrafficLightPavement);
        ROAD_LIGHT_ENTITY = register(RoadLightEntity::new, RoadLight);
        ROAD_NAME_SIGN_ENTITY = register(RoadNameSignEntity::new, RoadNameSign);
        TRAFFIC_LIGHTS_CONTROL_ENTITY = register(TrafficLightsControlEntity::new, TrafficLightsControlBox);

        AFRoads.LOGGER.info("AFRoads Blocks Initialized");
    }
}