package onewaycraft.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldTypeOneWay extends WorldType {

	public WorldTypeOneWay(String name){
		super(name);
	}

	@Override
	public net.minecraft.world.chunk.IChunkGenerator getChunkGenerator(World world, String generatorOptions){
		return new ChunkProviderBounded(world, generatorOptions);
	}

	public boolean isCustomizable() {
		return true;
	}

	@Override
	public int getSpawnFuzz(WorldServer world, net.minecraft.server.MinecraftServer server){
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void onCustomizeButton(net.minecraft.client.Minecraft mc, net.minecraft.client.gui.GuiCreateWorld guiCreateWorld)
	{
		//TODO: Implement Options Screen
		mc.displayGuiScreen(new net.minecraft.client.gui.GuiCreateFlatWorld(guiCreateWorld, guiCreateWorld.chunkProviderSettingsJson));
	}

}
