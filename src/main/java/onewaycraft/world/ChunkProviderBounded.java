package onewaycraft.world;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderOverworld;

// TODO Make it wrap any Chunk Generator instead of being a child of the default one. 
//public class BoundedChunkGenerator implements IChunkGenerator {
// private IChunkGenerator wrappedGenerator;

public class ChunkProviderBounded implements IChunkGenerator {

	private World world;
	private IChunkGenerator wrapped;



	public ChunkProviderBounded(World world, String generatorOptions) {
		this.wrapped = new ChunkProviderOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
		this.world = world;
		world.setSpawnPoint(new BlockPos(0, 200, 0));
	}
	
	/**
	 * Returns true if the provided coordinates refer to a chunk on the strip
	 * that is going to be generated.
	 * 
	 * @param x Chunk x coordinate
	 * @param z Chunk z coordinate
	 */
	public boolean isChunkOnStrip(int x, int z){
		return z < 10 && z > -10 && x > -4 ;
	}
	
	
	@Override
	public void populate(int x, int z){
		if(isChunkOnStrip(x,z)){
			wrapped.populate(x, z);
		} else {
			int x0 = x*16;
			int z0 = z*16;
			for(int xi = x0+1; xi <= x0+16; xi++){
				for(int yi=0; yi<256; yi++){
					for(int zi=z0+1; zi <= z0+16; zi++){
						BlockPos pos = new BlockPos(xi, yi, zi);
						world.setBlockState(pos, Blocks.BARRIER.getDefaultState());
					}
				}
			}
		}
	}
	
	@Override
	public Chunk provideChunk(int x, int z){
		if(isChunkOnStrip(x, z)){
			return wrapped.provideChunk(x, z);
		} else {
			return new Chunk(world, x, z);
		}
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		if(isChunkOnStrip(x,z)){
			return wrapped.generateStructures(chunkIn, x, z);
		} else {
			return false;
		}
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		return wrapped.getPossibleCreatures(creatureType, pos);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position, boolean p_180513_4_) {
		//TODO make a way to reach the end in this type of world
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		wrapped.recreateStructures(chunkIn, x, z);
	}

}
