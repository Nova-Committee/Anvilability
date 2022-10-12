package committee.nova.anvilability

import committee.nova.anvilability.proxies.CommonProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}
import org.apache.logging.log4j.LogManager

@Mod(modid = Anvilability.MODID, useMetadata = true, modLanguage = "scala")
object Anvilability {
  final val LOGGER = LogManager.getLogger
  final val MODID = "anvilability"
  final val packagePrefix = "committee.nova." + MODID + ".proxies."

  @SidedProxy(serverSide = packagePrefix + "CommonProxy", clientSide = packagePrefix + "ClientProxy")
  var proxy: CommonProxy = _

  @EventHandler def preInit(e: FMLPreInitializationEvent): Unit = proxy.preInit(e)

  @EventHandler def init(e: FMLInitializationEvent): Unit = proxy.init(e)

  @EventHandler def postInit(e: FMLPostInitializationEvent): Unit = proxy.postInit(e)
}
