package onewaycraft;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;

public class WorldTypeOneWay extends WorldType {
	
	public WorldTypeOneWay(String name){
		super(name);
	}
	
	@Override
	public net.minecraft.world.chunk.IChunkGenerator getChunkGenerator(World world, String generatorOptions){
		return new ChunkProviderBounded(world, generatorOptions);
	}

}
