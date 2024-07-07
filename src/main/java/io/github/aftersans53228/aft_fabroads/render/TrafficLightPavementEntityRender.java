package io.github.aftersans53228.aft_fabroads.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightPavementEntity;
import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightPavement;
import io.github.aftersans53228.aft_fabroads.item.RoadTool;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;


public class TrafficLightPavementEntityRender implements BlockEntityRenderer<TrafficLightPavementEntity> {
    //获得物品stack
    private static final ItemStack stackRed = new ItemStack(AFRoadsItemRegistry.TrafficLightPavementBulbRed.get(), 1);
    private static final ItemStack stackGreen = new ItemStack(AFRoadsItemRegistry.TrafficLightPavementBulbGreen.get(), 1);


    public TrafficLightPavementEntityRender(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(TrafficLightPavementEntity blockEntity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        /*
        //测试用1
        FabroadsMod.LOGGER.info(blockEntity.getBlockState().get(Properties.HORIZONTAL_FACING));
        FabroadsMod.LOGGER.info(blockEntity.getBlockState().get(TrafficLightPavement.TrafficType));
         */
        /*
        //测试用2
        System.out.println(blockEntity.getBlockState().get(Properties.HORIZONTAL_FACING));
        System.out.println(blockEntity.getBlockState().get(TrafficLightPavement.TrafficType));
        */

        //调用GL
        matrices.pushPose();
        //设置坐标
        matrices.translate(0.5, 0.5, 0.5);
        //设置旋转
        switch (blockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH -> matrices.mulPose(Vector3f.YP.rotation(0));
            case SOUTH -> matrices.mulPose(Vector3f.YP.rotation(180));
            case EAST -> matrices.mulPose(Vector3f.YP.rotation(270));
            case WEST -> matrices.mulPose(Vector3f.YP.rotation(90));
            default -> {
                AFRoads.LOGGER.info("Unexpected traffic light orientation state.");
                matrices.mulPose(Vector3f.YP.rotation(0));
            }
        }
        //选择渲染类型
        switch (blockEntity.getBlockState().getValue(TrafficLightPavement.TrafficType)) {
            case 0, 1 -> Minecraft.getInstance().getItemRenderer().renderStatic(stackRed, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
            case 2 -> Minecraft.getInstance().getItemRenderer().renderStatic(stackGreen, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
            default -> {
                AFRoads.LOGGER.info("Unexpected traffic light color state.");
                Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(new RoadTool(),1), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
            }
        }

        //GL拜拜了您内
        matrices.popPose();
    }
}