package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.common.CommonDelete;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class DeleteSpawn extends CommonDelete<ISpawn> {

	protected DeleteSpawn() {
		super(ESpawnMessageCode.DELETE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onDidNotDelete(CommandSender sender, String name) {
		sendSynchro(sender, ESpawnMessageCode.DELETE_SPAWN__DIT_NOT_DELETE, name);
	}

	@Override
	protected void onDeleted(CommandSender sender, String name) {
		sendSynchro(sender, ESpawnMessageCode.DELETE_SPAWN__SPAWN_DELETED, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendSynchro(sender, ESpawnMessageCode.DELETE_SPAWN__NAME_IS_MISSING);
	}
}
