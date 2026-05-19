package dev.xiaoyu.compressed_wooden_sword;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class StickTier implements Tier {
	public static final StickTier INSTANCE = new StickTier();

	@Override
	public int getUses() {
		return 2500;
	}

	@Override
	public float getSpeed() {
		return 2;
	}

	@Override
	public float getAttackDamageBonus() {
		return 0;
	}

	@Override
	public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
		return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
	}

	@Override
	public int getEnchantmentValue() {
		return 20;
	}

	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return Ingredient.of(CompressedWoodenSword.COMPRESSED_STICKS.get(CompressedWoodenSword.SIZES.length - 1));
	}
}