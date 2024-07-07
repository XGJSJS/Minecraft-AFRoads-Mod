package io.github.aftersans53228.aft_fabroads.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.core.Direction.*;

@OnlyIn(Dist.CLIENT)
public class TrafficLightEntityRender implements BlockEntityRenderer<TrafficLightEntity> {
    //获得物品stack
    private static final ItemStack stackRed = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbRed.get(), 1);
    private static final ItemStack stackGreen = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbGreen.get(), 1);
    private static final ItemStack stackYellow = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbYellow.get(), 1);

    public TrafficLightEntityRender(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(TrafficLightEntity blockEntity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        /*
        //测试用1
        FabroadsMod.LOGGER.info(blockEntity.getBlockState().get(Properties.HORIZONTAL_FACING));
        FabroadsMod.LOGGER.info(blockEntity.getBlockState().get(TrafficLight.TrafficType));
         */
        /*
        //测试用2
        System.out.println(blockEntity.getBlockState().get(Properties.HORIZONTAL_FACING));
        System.out.println(blockEntity.getBlockState().get(TrafficLight.TrafficType));
        */

        //调用GL
        matrices.pushPose();
        //设置坐标
        matrices.translate(0.5, 0.5, 0.5);
        //设置旋转
        Direction dir =blockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        if (dir==SOUTH){
            matrices.mulPose(Vector3f.YP.rotation(180));
        }
        else if (dir==NORTH){
            matrices.mulPose(Vector3f.YP.rotation(0));
        }
        else if (dir==EAST){
            matrices.mulPose(Vector3f.YP.rotation(270));
        }
        else if (dir==WEST){
            matrices.mulPose(Vector3f.YP.rotation(90));
        }
        else{
            AFRoads.LOGGER.info("Unexpected traffic light orientation state.");
            matrices.mulPose(Vector3f.YP.rotation(0));
        }
        //选择渲染类型
        if (blockEntity.getLevel() != null) {
            TrafficLightsControlEntity controlBox;
            if (blockEntity.getControlBoxPos() != null) {
                 controlBox = (TrafficLightsControlEntity) blockEntity.getLevel().getBlockEntity(blockEntity.getControlBoxPos());
            } else {
                controlBox = null;
            }
            if (controlBox != null) {
                switch (dir) {
                    case SOUTH, NORTH -> {
                        String type = controlBox.getLightType("NS");
                        switch (type) {
                            case "forward_green" ->
                                    Minecraft.getInstance().getItemRenderer().renderStatic(stackGreen, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
                            case "forward_yellow", "disable" ->
                                    Minecraft.getInstance().getItemRenderer().renderStatic(stackYellow, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
                            default ->
                                    Minecraft.getInstance().getItemRenderer().renderStatic(stackRed, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
                        }
                    }
                    case EAST, WEST -> {
                        String type = controlBox.getLightType("WE");
                        switch (type) {
                            case "forward_green" ->
                                    Minecraft.getInstance().getItemRenderer().renderStatic(stackGreen, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
                            case "forward_yellow", "disable" ->
                                    Minecraft.getInstance().getItemRenderer().renderStatic(stackYellow, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
                            default ->
                                    Minecraft.getInstance().getItemRenderer().renderStatic(stackRed, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
                        }
                    }

                }
            }
        }

        //GL拜拜了您内
        matrices.popPose();
    }
}