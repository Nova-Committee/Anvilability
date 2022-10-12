package committee.nova.anvilability.config

import committee.nova.anvilability.config.CommonConfig._
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.common.config.Configuration

object CommonConfig {
  def init(e: FMLPreInitializationEvent): Unit = new CommonConfig(e)

  private var config: Configuration = _
  var anvilBreakChance: Float = _
  var noRepairCost: Boolean = _
  var maxLevel: Int = _
  var maxEnchantmentLevel: Int = _
  var repairCostForcedItems: Array[String] = _
}

class CommonConfig(e: FMLPreInitializationEvent) {
  config = new Configuration(e.getSuggestedConfigurationFile)
  config.load()
  anvilBreakChance = config.getFloat("anvilBreakChance", Configuration.CATEGORY_GENERAL, -1.0F, -1.0F, 1.0F, "The anvil's break chance. If it's -1.0, the break chance will be determined by the AnvilRepairEvent.")
  noRepairCost = config.getBoolean("noRepairCost", Configuration.CATEGORY_GENERAL, true, "Remove the itemStack's repair cost.")
  maxLevel = config.getInt("maxLevel", Configuration.CATEGORY_GENERAL, -1, -1, Int.MaxValue, "The max experience cost in a single operation on the anvil. If it's -1, there will be no limit for the experience cost")
  maxEnchantmentLevel = config.getInt("maxEnchantmentLevel", Configuration.CATEGORY_GENERAL, -1, -1, Int.MaxValue, "The max enchantment level can be applied. If it's -1, use the enchantment's initial max level")
  repairCostForcedItems = config.getStringList("repairCostForcedItems", Configuration.CATEGORY_GENERAL, Array("examplemodid:item1", "vanillaItem1"), "The items here will be forced to have repair costs, even if noRepairCost is true")
  config.save()
}
