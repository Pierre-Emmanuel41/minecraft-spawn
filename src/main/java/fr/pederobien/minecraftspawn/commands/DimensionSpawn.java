package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonDimension;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class DimensionSpawn extends CommonDimension<ISpawn> {

	protected DimensionSpawn() {
		super(ESpawnMessageCode.DIMENSION_SPAWN__EXPLANATION);
	}

	@Override
	protected void onDimensionDefined(CommandSender sender, String name, int width, int height, int depth) {
		sendSynchro(sender, ESpawnMessageCode.DIMENSION_SPAWN__DEFINED, name, width, height, depth);
	}
}
