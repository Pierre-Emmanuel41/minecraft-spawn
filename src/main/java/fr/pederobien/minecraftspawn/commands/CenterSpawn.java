package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonCenter;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class CenterSpawn extends CommonCenter<ISpawn> {

	public CenterSpawn() {
		super(ESpawnMessageCode.CENTER_SPAWN__EXPLANATION);
	}

	@Override
	protected void onCenterDefined(CommandSender sender, String name, int x, int y, int z) {
		sendSynchro(sender, ESpawnMessageCode.CENTER_SPAWN__CENTER_DEFINED, x, y, z);
	}
}
