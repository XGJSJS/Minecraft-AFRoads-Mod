package io.github.aftersans53228.aft_fabroads;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import io.github.aftersans53228.aft_fabroads.render.RoadLightEntityRender;
import io.github.aftersans53228.aft_fabroads.render.RoadNameSignEntityRender;
import io.github.aftersans53228.aft_fabroads.render.TrafficLightEntityRender;
import io.github.aftersans53228.aft_fabroads.render.TrafficLightPavementEntityRender;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

/**
 * @author Aftersans53228, XGJS
 * Mod Client Main Class
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AFRoadsClient {
    @SuppressWarnings("all")
    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        //client Initialize
        // 如果有半透明纹理，可以将 renderType -> renderType == RenderType.cutout() 替换为 RenderLayer.getTranslucent()。
        //普通方块
        setRenderLayer(RoadBlock, RenderType.cutoutMipped());
        setRenderLayer(RoadBlockConcrete, RenderType.cutoutMipped());
        setRenderLayer(ManholeCover, RenderType.cutoutMipped());
        setRenderLayer(ManholeCoverConcrete, RenderType.cutoutMipped());
        setRenderLayer(RoadSeamsBlock, RenderType.cutoutMipped());
        setRenderLayer(RoadSeamsBlockConcrete, RenderType.cutoutMipped());
        setRenderLayer(ConcreteSlab, RenderType.cutout());
        setRenderLayer(ConcreteStairs, RenderType.cutout());
        setRenderLayer(ConcreteStairsSmooth, RenderType.cutout());
        setRenderLayer(ConcreteColumnsCorner, RenderType.cutout());
        //地面划线
        setRenderLayer(LineStraight, RenderType.cutout());
        setRenderLayer(LineCorner, RenderType.cutout());
        setRenderLayer(LineTshaped, RenderType.cutout());
        setRenderLayer(LineCross, RenderType.cutout());
        setRenderLayer(LineDiagonal, RenderType.cutout());
        setRenderLayer(LineLeftBend, RenderType.cutout());
        setRenderLayer(LineRightBend, RenderType.cutout());
        setRenderLayer(LineForkLeft, RenderType.cutout());
        setRenderLayer(LineForkRight, RenderType.cutout());
        setRenderLayer(LineStraightThick, RenderType.cutout());
        setRenderLayer(LineStraightDuoLine, RenderType.cutout());
        setRenderLayer(LineStraightDuoThick, RenderType.cutout());
        setRenderLayer(LineStraightDuoThickDashed, RenderType.cutout());
        setRenderLayer(LineDecelerateNoLine, RenderType.cutout());
        setRenderLayer(LineDecelerateNoLineFlip, RenderType.cutout());
        setRenderLayer(LineDecelerateWithLine, RenderType.cutout());
        setRenderLayer(LineDecelerateWithLineFlip, RenderType.cutout());
        setRenderLayer(LineDecelerateDoubleWL, RenderType.cutout());
        setRenderLayer(LineDecelerateDoubleNL, RenderType.cutout());
        setRenderLayer(LineReversibleLanes, RenderType.cutout());
        setRenderLayer(LineReversibleLanesFlip, RenderType.cutout());
        setRenderLayer(LineReversibleLanesDouble, RenderType.cutout());
        //地面箭头
        setRenderLayer(ArrowForward, RenderType.cutout());
        setRenderLayer(ArrowLeft, RenderType.cutout());
        setRenderLayer(ArrowRight, RenderType.cutout());
        setRenderLayer(ArrowForwardLeft, RenderType.cutout());
        setRenderLayer(ArrowForwardRight, RenderType.cutout());
        setRenderLayer(ArrowBack, RenderType.cutout());
        setRenderLayer(ArrowLeftRight, RenderType.cutout());
        setRenderLayer(ArrowBackLeft, RenderType.cutout());
        setRenderLayer(ArrowBackForward, RenderType.cutout());
        setRenderLayer(ArrowConfluenceLeft, RenderType.cutout());
        setRenderLayer(ArrowConfluenceRight, RenderType.cutout());
        //地面图标
        setRenderLayer(IconDecelerateSticker, RenderType.cutout());
        setRenderLayer(IconStopSticker, RenderType.cutout());
        setRenderLayer(IconGiverWaySticker, RenderType.cutout());
        //道路装饰
        setRenderLayer(Railings, RenderType.cutout());
        setRenderLayer(BarrierBar, RenderType.cutout());
        setRenderLayer(PavementRailings, RenderType.cutout());
        setRenderLayer(ExpresswayRailingsBase, RenderType.cutout());
        setRenderLayer(ExpresswayIronRailings, RenderType.cutout());
        setRenderLayer(ExpresswayIronRailings2, RenderType.cutout());
        setRenderLayer(ExpresswayRailings, RenderType.cutout());
        setRenderLayer(ExpresswayRailingsType2, RenderType.cutout());
        setRenderLayer(InsulationPanelsRailings, RenderType.translucent());
        setRenderLayer(InsulationPanelsGrayPart1, RenderType.cutout());
        setRenderLayer(InsulationPanelsGrayPart2, RenderType.translucent());
        setRenderLayer(InsulationPanelsGrayPart3, RenderType.cutout());
        setRenderLayer(InsulationPanelsGrayPart4, RenderType.cutout());
        setRenderLayer(InsulationPanelsGrayPart5, RenderType.cutout());
        setRenderLayer(InsulationPanelsGrayPart6, RenderType.translucent());
        setRenderLayer(TrafficLightsControlBox, RenderType.cutoutMipped());
        setRenderLayer(TrafficLight, RenderType.cutout());
        setRenderLayer(TrafficLightPavement, RenderType.cutout());
        setRenderLayer(RoadLight, RenderType.cutout());
        setRenderLayer(PillarBase, RenderType.cutout());
        setRenderLayer(HorizontalStraightPillar, RenderType.cutout());
        setRenderLayer(VerticalStraightPillar, RenderType.cutout());
        setRenderLayer(VerticalCornerPillar, RenderType.cutout());
        setRenderLayer(HorizontalCornerPillar, RenderType.cutout());
        setRenderLayer(VerticalTshapedPillar, RenderType.cutout());
        setRenderLayer(VerticalTshapedPillarType2, RenderType.cutout());
        setRenderLayer(HorizontalTshapedPillar, RenderType.cutout());
        setRenderLayer(HorizontalStraightPillarThin, RenderType.cutout());
        setRenderLayer(VerticalStraightPillarThin, RenderType.cutout());
        setRenderLayer(VerticalCornerPillarThin, RenderType.cutout());
        setRenderLayer(RoadMastPillarBase, RenderType.cutout());
        setRenderLayer(RoadMastPillar, RenderType.cutout());
        setRenderLayer(SmartPillar, RenderType.cutout());
        setRenderLayer(SmartPillarThin, RenderType.cutout());
        setRenderLayer(SignIndicatorDirectionLeft, RenderType.cutout());
        setRenderLayer(SignIndicatorDirectionRight, RenderType.cutout());
        setRenderLayer(SignIndicatorDirectionCar, RenderType.cutout());
        setRenderLayer(SignIndicatorDirectionBicycle, RenderType.cutout());
        setRenderLayer(SignBanNoDrive, RenderType.cutout());
        setRenderLayer(SignBanStop, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit05, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit20, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit30, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit40, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit50, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit60, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit70, RenderType.cutout());
        setRenderLayer(SignBanSpeedLimit80, RenderType.cutout());
        setRenderLayer(RubbishBinMetal, RenderType.cutout());
        setRenderLayer(TrashBinGreen, RenderType.cutout());
        setRenderLayer(RoadNameSign, RenderType.cutout());

        //注册方块实体渲染
        BlockEntityRenderers.register(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY.get(), TrafficLightEntityRender::new);
        BlockEntityRenderers.register(AFRoadsBlockRegistry.TRAFFIC_LIGHT_PAVEMENT_ENTITY.get(), TrafficLightPavementEntityRender::new);
        BlockEntityRenderers.register(AFRoadsBlockRegistry.ROAD_LIGHT_ENTITY.get(), RoadLightEntityRender::new);
        BlockEntityRenderers.register(AFRoadsBlockRegistry.ROAD_NAME_SIGN_ENTITY.get(), RoadNameSignEntityRender::new);
    }

    private static void setRenderLayer(RegistryObject<Block> block, RenderType renderType) {
        ItemBlockRenderTypes.setRenderLayer(block.get(), render_Type -> render_Type == renderType);
    }
}