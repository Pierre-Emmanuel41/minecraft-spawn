package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonWorld;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class WorldSpawn extends CommonWorld<ISpawn> {

	protected WorldSpawn() {
		super(ESpawnMessageCode.WORLD_SPAWN__EXPLANATION);
	}

	@Override
	protected void onWorldNameIsMissing(CommandSender sender) {
		sendSynchro(sender, ESpawnMessageCode.WORLD_SPAWN__WORLD_NAME_IS_MISSING);
	}

	@Override
	protected void onWorldDefined(CommandSender sender, String name, String worldName) {
		sendSynchro(sender, ESpawnMessageCode.WORLD_SPAWN__WORLD_DEFINED, name, worldName);
	}
}
