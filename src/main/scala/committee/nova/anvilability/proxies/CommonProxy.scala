package committee.nova.anvilability.proxies

import committee.nova.anvilability.config.CommonConfig
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}

class CommonProxy {
  def preInit(event: FMLPreInitializationEvent): Unit = CommonConfig.init(event)

  def init(event: FMLInitializationEvent): Unit = {}

  def postInit(event: FMLPostInitializationEvent): Unit = {}
}
