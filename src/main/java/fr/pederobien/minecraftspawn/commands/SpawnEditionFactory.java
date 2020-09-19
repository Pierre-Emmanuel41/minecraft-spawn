package fr.pederobien.minecraftspawn.commands;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class SpawnEditionFactory {

	/**
	 * @return An edition to create a new spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> newSpawn() {
		return new NewSpawn();
	}

	/**
	 * @return An edition to define the spawn's world.
	 */
	public static IMapPersistenceEdition<ISpawn> worldSpawn() {
		return new WorldSpawn();
	}

	/**
	 * @return An edition to define the spawn's center.
	 */
	public static IMapPersistenceEdition<ISpawn> centerSpawn() {
		return new CenterSpawn();
	}

	/**
	 * @return An edition to rename a spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> renameSpawn() {
		return new RenameSpawn();
	}

	/**
	 * @return An edition to set the spawn's dimension.
	 */
	public static IMapPersistenceEdition<ISpawn> dimensionSpawn() {
		return new DimensionSpawn();
	}

	/**
	 * @return An edition to save a spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> saveSpawn() {
		return new SaveSpawn();
	}

	/**
	 * @return An edition to display each existing spawn's name.
	 */
	public static IMapPersistenceEdition<ISpawn> listSpawn() {
		return new ListSpawn();
	}

	/**
	 * @return An edition to delete spawn file.
	 */
	public static IMapPersistenceEdition<ISpawn> deleteSpawn() {
		return new DeleteSpawn();
	}

	/**
	 * @return An edition to extract blocks associated to the spawn dimensions.
	 */
	public static IMapPersistenceEdition<ISpawn> extractSpawn() {
		return new ExtractSpawn();
	}

	/**
	 * @return An edition to remove a spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> removeSpawn() {
		return new RemoveSpawn();
	}

	/**
	 * @return An edition to launch a spawn in the world.
	 */
	public static IMapPersistenceEdition<ISpawn> launchSpawn() {
		return new LaunchSpawn();
	}

	/**
	 * @return An edition to display current spawn's characteristics.
	 */
	public static IMapPersistenceEdition<ISpawn> detailsSpawn() {
		return new DetailsSpawn();
	}

	/**
	 * @return An edition to define the player's spawn in the the spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> playerSpawn() {
		return new PlayerSpawn();
	}

	/**
	 * @return An edition to launch randomly a spawn on the world.
	 */
	public static IMapPersistenceEdition<ISpawn> randomSpawn() {
		return new RandomSpawn();
	}

	/**
	 * @return An edition to allow or not the spawn of mobs under a spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> allowMobsUnderSpawn() {
		return new AllowMobsUnderSpawn();
	}
}
