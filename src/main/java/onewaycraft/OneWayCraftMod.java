package onewaycraft;

import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import onewaycraft.world.WorldTypeOneWay;

@Mod(modid = OneWayCraftMod.MODID, version = OneWayCraftMod.VERSION)
public class OneWayCraftMod
{
    public static final String MODID = "onewaycraft";
    public static final String VERSION = "1.0";
	private WorldTypeOneWay worldType;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        worldType = new WorldTypeOneWay("one_way");
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }
    
    @EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
    
    
    
    
}
