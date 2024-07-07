package io.github.aftersans53228.aft_fabroads.gui;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSign;
import io.github.aftersans53228.aft_fabroads.network.GuiCloseNetworkRNS;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;


/**
 * @author aftersans53228
 */
@OnlyIn(Dist.CLIENT)
public class RoadNameSignGui extends Screen {
    protected int leftPos;
    protected int topPos;

    private final Direction leftFace;
    private final Direction rightFace;
    private final boolean dirLeft;
    private final boolean dirRight;
    private final String name1;
    private final String name2;

    EditBox roadName;
    EditBox roadName2rd;
    Button apply;
    Button cancel;
    Button reset;

    public RoadNameSignGui(BlockPos posOfBlock, List<String> names, ClientLevel clientWorld) {
        super(TextComponent.EMPTY);
        //获得已设置信息
        Direction dirBlock = clientWorld.getBlockState(posOfBlock).getValue(BlockStateProperties.HORIZONTAL_FACING);
        switch (dirBlock) {
            case EAST :
                this.leftFace =Direction.NORTH;
                this.rightFace = Direction.SOUTH;
                break;
            case WEST :
                this.leftFace =Direction.SOUTH;
                this.rightFace = Direction.NORTH;
                break;
            case NORTH :
                this.leftFace =Direction.WEST;
                this.rightFace = Direction.EAST;
                break;
            case SOUTH :
                this.leftFace =Direction.EAST;
                this.rightFace = Direction.WEST;
                break;
            default:
                this.leftFace =Direction.UP;
                this.rightFace = Direction.UP;
                break;

        }

        this.dirLeft = clientWorld.getBlockState(posOfBlock).getValue(RoadNameSign.DirLeft);
        this.dirRight = clientWorld.getBlockState(posOfBlock).getValue(RoadNameSign.DirRight);
        this.name1 = names.get(0);
        this.name2 = names.get(1);
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = (this.width - 176) / 2;
        this.topPos = (this.height - 166) / 2;

        //TODO implement GUI
        /*//标题
        WLabel title = new WLabel(new TranslatableComponent("block.aft_fabroads.road_name_sign"));
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title,0, 0, 12, 3);

        //内容
        WLabel label = new WLabel(new TranslatableComponent("text.gui.aft_fabroads.road_name_sign_name"));
        root.add(label,0, 2, 8, 2);


        WLabel label2 = new WLabel(new TranslatableComponent("text.gui.aft_fabroads.road_name_sign_name2"));
        root.add(label2, 0, 7, 8, 2);

        //路牌名输入
        WTextField roadName = new WTextField(new TranslatableComponent("text.gui.aft_fabroads.road_name_sign_name-tip"));
        roadName.setText(name1);
        root.add(roadName,0,4,11,2);
        WTextField roadName2rd = new WTextField(new TranslatableComponent("text.gui.aft_fabroads.road_name_sign_name-tip2rd"));
        roadName2rd.setText(name2);
        root.add(roadName2rd,0,9,11,2);

        //放置于左右的方向设置开关
        WToggleButton toggleButtonLeft = new WToggleButton();
        toggleButtonLeft.setToggle(dirLeft);
        root.add(toggleButtonLeft, 13, 8, 3, 3);

        WToggleButton toggleButtonRight = new WToggleButton();
        toggleButtonRight.setToggle(dirRight);
        root.add(toggleButtonRight, 20,8, 3, 3);

        //开关动态文字
        WDynamicLabel labelLeftDir = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.road_name_sign_dir_left",this.leftFace.getName().toUpperCase()));
        root.add(labelLeftDir, 12, 6, 2, 1);
        WDynamicLabel labelRightDir = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.road_name_sign_dir_right",this.rightFace.getName().toUpperCase()));
        root.add(labelRightDir, 19,6, 2, 1);

        //应用和取消
        WButton apply = new WButton(new TranslatableComponent("text.gui.aft_fabroads.apply"));
        root.add(apply, 22, 16, 4, 3);

        //重置
        WButton reset = new WButton(new TranslatableComponent("text.gui.aft_fabroads.reset"));
        root.add(reset, 0, 13, 11, 3);*/

        //当取消被按下后关闭gui
        cancel = new Button(0, 0, 0, 0, new TranslatableComponent("text.gui.aft_fabroads.cancel"), e -> {
            // Close gui
            AFRoads.LOGGER.info("Close the\"Road Name Sign\"'s gui. ");
            Minecraft.getInstance().setScreen(null);
        });
        this.addRenderableWidget(cancel);
        /*apply.setOnClick(()->{
            String roadName1 = roadName.getText();
            String roadName2 = roadName2rd.getText();
            //output value
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBlockPos(posOfBlock);//方块坐标
            buf.writeString(roadName1);//道路名称
            buf.writeString(roadName2);//英语名称
            buf.writeBoolean(toggleButtonLeft.getToggle());//左侧方向指示
            buf.writeBoolean(toggleButtonRight.getToggle());//右侧方向指示

            AFRoads.LOGGER.info("Close the\"Road Name Sign\"'s gui. ");
            GuiCloseNetworkRNS.sendGuiClose(new Identifier(AFRoadsStatics.MOD_ID,"road_name_sign_gui_close"),buf);
            MinecraftClient.getInstance().setScreen((Screen) null);

        });
        reset.setOnClick(()->{
            roadName.setText("未命名");
            roadName2rd.setText("Unnamed");
            toggleButtonLeft.setToggle(true);
            toggleButtonRight.setToggle(true);
        });*/
    }
}