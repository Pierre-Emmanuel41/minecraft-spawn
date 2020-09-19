package fr.pederobien.minecraftspawn.persistence.loaders;

import fr.pederobien.minecraftarea.persistence.loaders.AbstractAreaLoader;
import fr.pederobien.minecraftspawn.impl.Spawn;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public abstract class AbstractSpawnLoader extends AbstractAreaLoader<ISpawn> {

	protected AbstractSpawnLoader(Double version) {
		super(version);
	}

	@Override
	protected ISpawn create() {
		return new Spawn("DefaultSpawn");
	}
}
