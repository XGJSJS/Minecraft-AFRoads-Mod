package io.github.aftersans53228.aft_fabroads.gui;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.network.GuiCloseNetworkRNS;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;

/**
 * @author aftersans53228, XGJS
 */
@OnlyIn(Dist.CLIENT)
public class TrafficControlBoxGui extends Screen {
    protected int leftPos;
    protected int topPos;

    private final BlockPos posOfBlock;
    private final boolean enabled;
    private final ArrayList<Integer> timeData;

    public TrafficControlBoxGui(BlockPos posOfBlock, boolean enabled, ArrayList<Integer> timeData) {
        super(TextComponent.EMPTY);
        this.posOfBlock = posOfBlock;
        this.enabled = enabled;
        this.timeData = timeData;
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = (this.width - 176) / 2;
        this.topPos = (this.height - 166) / 2;

        //TODO implement GUI
        /*WGridPanel root = new WGridPanel(9);
        root.setSize(254,160);
        root.setInsets(Insets.ROOT_PANEL);
        setRootPanel(root);

        //标题
        WLabel title = new WLabel(new TranslatableComponent("block.aft_fabroads.traffic_lights_control_box"));
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title,0, 0, 12, 3);

        //内容
        WLabel labelRed = new WLabel(new TranslatableComponent("text.gui.aft_fabroads.traffic_control_box_red"));
        root.add(labelRed,0, 2, 8, 2);
        WLabel labelGreen = new WLabel(new TranslatableComponent("text.gui.aft_fabroads.traffic_control_box_green"));
        root.add(labelGreen,0, 6, 8, 2);
        WLabel labelRedTurn = new WLabel(new TranslatableComponent("text.gui.aft_fabroads.traffic_control_box_red_turn"));
        root.add(labelRedTurn,0, 10, 8, 2);
        WLabel labelGreenTurn = new WLabel(new TranslatableComponent("text.gui.aft_fabroads.traffic_control_box_green_turn"));
        root.add(labelGreenTurn,0, 14, 8, 2);

        //滑块
        WSlider sliderRed =new WSlider(10,60, Axis.HORIZONTAL);
        WSlider sliderGreen =new WSlider(10,60, Axis.HORIZONTAL);
        WSlider sliderRedTurn =new WSlider(0,5, Axis.HORIZONTAL);
        WSlider sliderGreenTurn =new WSlider(0,30, Axis.HORIZONTAL);
        //设置滑块当前值
        sliderRed.setValue(timeData.get(1));
        sliderGreen.setValue(timeData.get(0));
        sliderRedTurn.setValue(timeData.get(3));
        sliderGreenTurn.setValue(timeData.get(2));
        //显示滑块
        root.add(sliderRed,0,3,10,2);
        root.add(sliderGreen,0,7,10,2);
        root.add(sliderRedTurn,0,11,10,2);
        root.add(sliderGreenTurn,0,15,10,2);

        //预览值
        WDynamicLabel labelShowRed = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderRed.getValue()));
        root.add(labelShowRed,11, 4, 4, 1);
        WDynamicLabel labelShowGreen = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderGreen.getValue()));
        root.add(labelShowGreen,11, 8, 4, 1);
        WDynamicLabel labelShowRedTurn = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderRedTurn.getValue()));
        root.add(labelShowRedTurn,11, 12, 4, 1);
        WDynamicLabel labelShowGreenTurn = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderGreenTurn.getValue()));
        root.add(labelShowGreenTurn,11, 16, 4, 1);

        //应用和取消
        WButton apply = new WButton(new TranslatableComponent("text.gui.aft_fabroads.apply"));
        root.add(apply, 22, 16, 4, 3);

        WButton cancel = new WButton(new TranslatableComponent("text.gui.aft_fabroads.cancel"));
        root.add(cancel, 17, 16, 4, 3);

        //重置
        WButton reset = new WButton(new TranslatableComponent("text.gui.aft_fabroads.reset"));
        root.add(reset, 20, 3, 4, 3);

        //是否启用灯箱
        WLabel whetherEnabled = new WLabel(new TranslatableComponent("text.gui.aft_fabroads.traffic_control_box_whether_enabled"));
        WToggleButton toggleButtonTimer = new WToggleButton();
        toggleButtonTimer.setToggle(enabled);
        root.add(whetherEnabled, 20, 9, 2, 2);
        root.add(toggleButtonTimer, 21, 10, 2, 2);



        //当取消被按下后关闭gui
        cancel.setOnClick(() -> {
            // Close gui
            AFRoads.LOGGER.info("Close the\"Traffic Control Box\"'s gui. ");
            MinecraftClient.getInstance().setScreen((Screen)null);
        });
        reset.setOnClick(()->{
            // 这其实是默认值
            sliderRed.setValue(30);
            sliderGreen.setValue(30);
            sliderRedTurn.setValue(0);
            sliderGreenTurn.setValue(0);
            toggleButtonTimer.setToggle(false);
        });
        apply.setOnClick(()->{
            //output value
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBlockPos(posOfBlock);//方块坐标
            buf.writeIntArray(new int[]{sliderGreen.getValue(), sliderRed.getValue(), sliderGreenTurn.getValue(), sliderRedTurn.getValue()});
            buf.writeBoolean(toggleButtonTimer.getToggle());
            AFRoads.LOGGER.info("Close the\"Traffic Control Box\"'s gui. ");
            GuiCloseNetworkRNS.sendGuiClose(new Identifier(AFRoadsStatics.MOD_ID,"traffic_lights_control_box_gui_close"),buf);
            MinecraftClient.getInstance().setScreen((Screen) null);
        });*/
    }
}