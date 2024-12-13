package com.alex.additionsmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MustHaveAdditions implements ModInitializer {
	public static final String MOD_ID = "additionsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("You received important additions!");
	}
}