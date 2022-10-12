package committee.nova.anvilability.util

import committee.nova.anvilability.config.CommonConfig
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.{Item, ItemStack}

object Utilities {
  def hasRepairCost(stack: ItemStack): Boolean = hasRepairCost(stack.getItem)

  def hasRepairCost(item: Item): Boolean = (!CommonConfig.noRepairCost) || CommonConfig.repairCostForcedItems.contains(item.getUnlocalizedName.substring(5))

  def getMaxLevel: Int = if (CommonConfig.maxLevel < 0) Int.MaxValue else CommonConfig.maxLevel + 1

  def getMaxEnchantmentLevel(enchantment: Enchantment): Int = if (CommonConfig.maxEnchantmentLevel < 0) enchantment.getMaxLevel else CommonConfig.maxEnchantmentLevel

  def getAnvilBreakChance(initial: Float): Float = if (CommonConfig.anvilBreakChance == -1.0F) initial else CommonConfig.anvilBreakChance
}
