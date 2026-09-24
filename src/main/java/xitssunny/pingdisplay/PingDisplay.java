package xitssunny.pingdisplay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;

public class PingDisplay implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("PingDisplay");

	@Override
	public void init() {
		LOGGER.info("I like bananas! - xItsSunny");
	}
}
