package io.github.aftersans53228.aft_fabroads;

import io.github.aftersans53228.aft_fabroads.network.*;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsTabRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Aftersans53228, XGJS
 * Mod Main Class
 */
@Mod(AFRoadsStatics.MOD_ID)
public class AFRoads {
	// 此记录器用于将文本写入控制台和日志文件。
	// 使用您的 mod id 作为记录器的名称被认为是最佳实践。
	// 这样一来，很清楚哪个 mod 打印了信息、警告和错误。
	public static final Logger LOGGER = LogManager.getLogger("aft_fabroads");
	private static final String CHANNEL_VERSION = "1";
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(AFRoadsStatics.MOD_ID, "main"), () -> CHANNEL_VERSION, CHANNEL_VERSION::equals, CHANNEL_VERSION::equals);
	private static int messageID = 0;

	public AFRoads() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		AFRoadsTabRegistry.load();
		AFRoadsBlockRegistry.BLOCKS.register(bus);
		AFRoadsBlockRegistry.BLOCK_ENTITY_TYPES.register(bus);
		AFRoadsItemRegistry.ITEMS.register(bus);

		LOGGER.info("AFRoads Misc Initialized");
	}

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		CHANNEL.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Event {
		@SubscribeEvent
		public static void commonSetup(FMLCommonSetupEvent event) {
			addNetworkMessage(GuiCloseNetworkRNS.class, GuiCloseNetworkRNS::encoder, GuiCloseNetworkRNS::new, GuiCloseNetworkRNS::handler);
			addNetworkMessage(GuiCloseTLCBMessage.class, GuiCloseTLCBMessage::encoder, GuiCloseTLCBMessage::new, GuiCloseTLCBMessage::handler);
			addNetworkMessage(GuiOpenMessage.class, GuiOpenMessage::encoder, GuiOpenMessage::new, GuiOpenMessage::handler);
			addNetworkMessage(DisconnectSelfMessage.class, DisconnectSelfMessage::encoder, DisconnectSelfMessage::new, DisconnectSelfMessage::handler);
			addNetworkMessage(AttributesItemMessage.class, AttributesItemMessage::encoder, AttributesItemMessage::new, AttributesItemMessage::handler);
		}
	}
	//交通灯计时器
	public static int traffic_lights_timer =0 ;
}