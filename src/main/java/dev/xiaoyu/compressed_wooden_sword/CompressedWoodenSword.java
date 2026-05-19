package dev.xiaoyu.compressed_wooden_sword;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CompressedWoodenSword implements ModInitializer {
	public static final String MOD_ID = "compressed_wooden_sword";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final List<Item> COMPRESSED_STICKS = new ArrayList<>();

	static final String[] SIZES = {
		"single", "double", "triple", "quadruple", "quintuple", "hextuple", "septuple", "octuple"
	};

	@Override
	public void onInitialize() {
		for (String size : SIZES) {
			Item item = new Item(new Item.Properties());
			Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, size + "_compressed_stick"), item);
			COMPRESSED_STICKS.add(item);
		}

		Item stickSword = new SwordItem(
			StickTier.INSTANCE,
			new Item.Properties().attributes(SwordItem.createAttributes(StickTier.INSTANCE, 3, -2.4f))
		);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "super_stick_sword"), stickSword);
		COMPRESSED_STICKS.add(stickSword);

		CreativeModeTab tab = FabricItemGroup.builder()
			.icon(() -> new ItemStack(COMPRESSED_STICKS.getLast()))
			.title(Component.translatable("itemGroup.compressed_wooden_sword.compressed_wooden_sword_tab"))
			.displayItems((parameters, output) -> {
				for (Item item : COMPRESSED_STICKS) {
					output.accept(item);
				}
			})
			.build();

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, "compressed_wooden_sword_tab"), tab);
	}
}