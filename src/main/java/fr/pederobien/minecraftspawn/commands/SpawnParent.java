package fr.pederobien.minecraftspawn.commands;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftarea.commands.AbstractAreaPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;
import fr.pederobien.minecraftspawn.persistence.SpawnPersistence;

public class SpawnParent extends AbstractAreaPersistenceEdition<ISpawn> {

	public SpawnParent(Plugin plugin) {
		super("spawn", ESpawnMessageCode.SPAWN_PARENT_EXPLANATION, plugin, SpawnPersistence.getInstance());
		addEdition(SpawnEditionFactory.playerSpawn());
		addEdition(SpawnEditionFactory.randomSpawn().setModifiable(false));
		addEdition(SpawnEditionFactory.allowMobsUnderSpawn());
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getWorldEdition() {
		return SpawnEditionFactory.worldSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getCenterEdition() {
		return SpawnEditionFactory.centerSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getDimensionEdition() {
		return SpawnEditionFactory.dimensionSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getExtractEdition() {
		return SpawnEditionFactory.extractSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getLaunchEdition() {
		return SpawnEditionFactory.launchSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getRemoveEdition() {
		return SpawnEditionFactory.removeSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getNewEdition() {
		return SpawnEditionFactory.newSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getRenameEdition() {
		return SpawnEditionFactory.renameSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getSaveEdition() {
		return SpawnEditionFactory.saveSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getListEdition() {
		return SpawnEditionFactory.listSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getDeleteEdition() {
		return SpawnEditionFactory.deleteSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getDetailsEdition() {
		return SpawnEditionFactory.detailsSpawn();
	}
}
