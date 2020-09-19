package fr.pederobien.minecraftspawn.commands;

import fr.pederobien.minecraftgameplateform.commands.common.CommonDetails;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class DetailsSpawn extends CommonDetails<ISpawn> {

	protected DetailsSpawn() {
		super(ESpawnMessageCode.DETAILS_SPAWN__EXPLANATION, ESpawnMessageCode.DETAILS_SPAWN__ON_DETAILS);
	}
}
