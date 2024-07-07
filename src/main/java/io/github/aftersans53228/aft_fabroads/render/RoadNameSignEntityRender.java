package io.github.aftersans53228.aft_fabroads.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSign;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoadNameSignEntityRender implements BlockEntityRenderer<RoadNameSignEntity> {

    private final Font textRenderer;
    public RoadNameSignEntityRender(BlockEntityRendererProvider.Context ctx) {
        this.textRenderer = ctx.getFont();
    }
    @Override
    public void render(RoadNameSignEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        //Content

        final Direction facing = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        //获取路牌属性
        if (true) {//This is used to prepare for something in the future.
            String roadName = entity.getRoadNames().get(0);
            String roadName2rd = entity.getRoadNames().get(1);
            Boolean dirLeft = entity.getBlockState().getValue(RoadNameSign.DirLeft);
            Boolean dirRight = entity.getBlockState().getValue(RoadNameSign.DirRight);
            String leftDir;
            String rightDir;

            int lightAbove = 15728880;
            if (entity.getLevel() != null) {
                lightAbove = LevelRenderer.getLightColor(entity.getLevel(), entity.getBlockPos().above());
            }

            //中文渲染1
            matrices.pushPose();
            matrices.translate(0f, 0.89f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            int strLenHalved = this.textRenderer.width(roadName);
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot()));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case NORTH -> matrices.translate(0.5f, 0f, -0.55f);
                case SOUTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            //MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);

            matrices.scale(0.032f, 0.032F, 0.032f);
            this.textRenderer.drawInBatch(roadName, (float) (-strLenHalved) / 2, 0F, 0xFFFFFF, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            matrices.popPose();

            //中文渲染2
            matrices.pushPose();
            matrices.translate(0f, 0.89f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot() - 180));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case SOUTH -> matrices.translate(0.5f, 0f, -0.55f);
                case NORTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            matrices.scale(0.032f, 0.032F, 0.032f);
            this.textRenderer.drawInBatch(roadName, (float) (-strLenHalved) / 2, 0F, 0xFFFFFF, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            matrices.popPose();

            //中文渲染方向1.1
            matrices.pushPose();
            matrices.translate(0f, 0.85f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot()));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "东";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "西";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "南";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "北";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
             */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.drawInBatch(leftDir, (float) -(this.textRenderer.width(leftDir)) / 2, 0F, 0xFFFFFF, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(-1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(Items.BARRIER), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
            }
            matrices.popPose();

            //中文渲染方向1.2
            matrices.pushPose();
            matrices.translate(0f, 0.85f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot()));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "西";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "东";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "北";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "南";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }

             */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.drawInBatch(rightDir, (float) -(this.textRenderer.width(rightDir)) / 2, 0F, 0xFFFFFF, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(Items.BARRIER), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
            }
            matrices.popPose();

            //中文渲染方向2.1
            matrices.pushPose();
            matrices.translate(0f, 0.85f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot() - 180));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "西";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "东";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "北";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "南";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }
             */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.drawInBatch(leftDir, (float) -(this.textRenderer.width(leftDir)) / 2, 0F, 0xFFFFFF, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(Items.BARRIER), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
            }
            matrices.popPose();

            //中文渲染方向2.2
            matrices.pushPose();
            matrices.translate(0f, 0.85f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot() - 180));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "东";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "西";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "南";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "北";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
            */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.drawInBatch(rightDir, (float) -(this.textRenderer.width(rightDir)) / 2, 0F, 0xFFFFFF, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(-1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(Items.BARRIER), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
            }
            matrices.popPose();

            //英文渲染
            matrices.pushPose();
            matrices.translate(0f, 0.53f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            int Halved2 = this.textRenderer.width(roadName2rd);
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot()));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case NORTH -> matrices.translate(0.5f, 0f, -0.55f);
                case SOUTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            //MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);

            matrices.scale(0.015f, 0.015F, 0.015f);
            this.textRenderer.drawInBatch(roadName2rd, (float) (-Halved2) / 2, 0F, 0x000000, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            matrices.popPose();

            //英文渲染2
            matrices.pushPose();
            matrices.translate(0f, 0.53f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot() - 180));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case SOUTH -> matrices.translate(0.5f, 0f, -0.55f);
                case NORTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            matrices.scale(0.015f, 0.015F, 0.015f);
            this.textRenderer.drawInBatch(roadName2rd, (float) (-Halved2) / 2, 0F, 0x000000, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            matrices.popPose();

            //en渲染方向1.1
            matrices.pushPose();
            matrices.translate(0f, 0.53f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot()));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "E";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "W";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "S";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "N";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
             */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.drawInBatch(leftDir, (float) -(this.textRenderer.width(leftDir)) / 2, 0F, 0x000000, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.popPose();
            //en渲染方向1.2
            matrices.pushPose();
            matrices.translate(0f, 0.53f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot()));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "W";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "E";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "N";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "S";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }

             */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.drawInBatch(rightDir, (float) -(this.textRenderer.width(rightDir)) / 2, 0F, 0x000000, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.popPose();

            //en渲染方向2.1
            matrices.pushPose();
            matrices.translate(0f, 0.53f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot() - 180));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "W";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "E";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "N";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "S";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }
             */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.drawInBatch(leftDir, (float) -(this.textRenderer.width(leftDir)) / 2, 0F, 0x000000, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.popPose();
            //en渲染方向2.2
            matrices.pushPose();
            matrices.translate(0f, 0.53f, 0f);
            matrices.mulPose(Vector3f.ZP.rotation(180));
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot() - 180));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "E";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "W";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "S";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "N";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
            */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.drawInBatch(rightDir, (float) -(this.textRenderer.width(rightDir)) / 2, 0F, 0x000000, false, matrices.last().pose(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.popPose();
        }
        else{
            matrices.pushPose();
            matrices.translate(0f, 0.89f, 0f);
            matrices.mulPose(Vector3f.YP.rotation(facing.toYRot()));
            //System.out.println(facing);
            //System.out.println(facing.toYRot());
            switch (facing) {
                case NORTH -> matrices.translate(0.5f, 0f, -0.55f);
                case SOUTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            matrices.scale(1.1f,1.1f,1.1f);
            Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(Items.BARRIER), ItemTransforms.TransformType.GROUND, 15728880, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);
        }
    }
}