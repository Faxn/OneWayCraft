package onewaycraft;

import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent
	public static void watchEvent(ChunkWatchEvent.Watch event){
		// TODO: darken near edge and nuke off edge chunks.
	}
}
