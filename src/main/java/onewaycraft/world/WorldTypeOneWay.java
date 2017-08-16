package onewaycraft.world;

import net.minecraft.world.World;
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
	 

}
