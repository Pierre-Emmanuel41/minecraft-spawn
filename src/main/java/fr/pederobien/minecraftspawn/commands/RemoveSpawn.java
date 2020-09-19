package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonRemove;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class RemoveSpawn extends CommonRemove<ISpawn> {

	protected RemoveSpawn() {
		super(ESpawnMessageCode.REMOVE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onRemoved(CommandSender sender, String name, String world) {
		sendSynchro(sender, ESpawnMessageCode.REMOVE_SPAWN__SPAWN_REMOVED, name, world);
		get().getListener().setActivated(false);
	}
}
