package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.common.CommonSave;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class SaveSpawn extends CommonSave<ISpawn> {

	protected SaveSpawn() {
		super(ESpawnMessageCode.SAVE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onSave(CommandSender sender, String name) {
		sendSynchro(sender, ESpawnMessageCode.SAVE_SPAWN__SPAWN_SAVED, name);
	}
}
