package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonExtract;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class ExtractSpawn extends CommonExtract<ISpawn> {

	protected ExtractSpawn() {
		super(ESpawnMessageCode.EXTRACT_SPAWN__EXPLANATION);
	}

	@Override
	protected void onExtracted(CommandSender sender, String name) {
		sendSynchro(sender, ESpawnMessageCode.EXTRACT_SPAWN__SPAWN_EXTRACTED, name);
	}
}
