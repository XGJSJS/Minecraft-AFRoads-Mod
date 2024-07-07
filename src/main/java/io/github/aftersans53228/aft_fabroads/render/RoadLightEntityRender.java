package io.github.aftersans53228.aft_fabroads.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.RoadLight;
import io.github.aftersans53228.aft_fabroads.block.RoadLightEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoadLightEntityRender implements BlockEntityRenderer<RoadLightEntity> {
    //获得物品stack
    private static final ItemStack RoadLightBulbCold = new ItemStack(AFRoadsItemRegistry.RoadLightBulbCold.get(), 1);
    private static final ItemStack RoadLightBulbWarm = new ItemStack(AFRoadsItemRegistry.RoadLightBulbWarm.get(), 1);

    public RoadLightEntityRender(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(RoadLightEntity blockEntity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
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
                AFRoads.LOGGER.info("Unexpected road light orientation state.");
                matrices.mulPose(Vector3f.YP.rotation(0));
            }
        }
        //选择渲染类型
        if (blockEntity.getBlockState().getValue(RoadLight.LightType) == 0) {
            Minecraft.getInstance().getItemRenderer().renderStatic(RoadLightBulbCold, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
        } else {
            Minecraft.getInstance().getItemRenderer().renderStatic(RoadLightBulbWarm, ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
        }

        //GL拜拜了您内
        matrices.popPose();
    }
}