package onewaycraft;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderOverworld;

// TODO Make it wrap any Chunk Generator instead of being a child of the default one. 
//public class BoundedChunkGenerator implements IChunkGenerator {
// private IChunkGenerator wrappedGenerator;

public class ChunkProviderBounded extends ChunkProviderOverworld {

	private World world;



	public ChunkProviderBounded(World world, String generatorOptions) {
		super(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
		this.world = world;
		world.setSpawnPoint(new BlockPos(0, 200, 0));
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * Returns true if the provided coordinates refer to a chunk on the strip
	 * that is going to be generated.
	 * 
	 * @param x Chunk x coordinate
	 * @param z Chunk z coordinate
	 */
	public boolean isChunkOnStrip(int x, int z){
		return z < 4 && z > -4 && x > -2 ;
	}
	
	
	@Override
	public void populate(int x, int z){
		if(isChunkOnStrip(x,z)){
			super.populate(x, z);
		} 
	}
	
	@Override
	public Chunk provideChunk(int x, int z){
		if(isChunkOnStrip(x, z)){
			return super.provideChunk(x, z);
		} else {
			return new Chunk(world, x, z);
		}
	}

}
