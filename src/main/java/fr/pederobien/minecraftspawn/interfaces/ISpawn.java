package fr.pederobien.minecraftspawn.interfaces;

import org.bukkit.block.Block;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftarea.interfaces.IAreaBlock;

public interface ISpawn extends IArea {

	/**
	 * Get the block from Minecraft world above which players will spawn.
	 * 
	 * @return The block above which players will spawn. The coordinates of this block are absolute.
	 */
	Block getPlayerSpawn();

	/**
	 * Set the coordinates of the block above which players will spawn. The following coordinates are absolute.
	 * 
	 * @param x The x-Coordinates of the block.
	 * @param y The y-Coordinates of the block.
	 * @param z The z-Coordinates of the block.
	 */
	void setPlayerSpawn(String x, String y, String z);

	/**
	 * Get a virtual block above which players will spawn. This block correspond to {@link #getPlayerSpawn()} but the coordinates are
	 * relative.
	 * 
	 * @return A virtual block above which players will spawn.
	 */
	IAreaBlock getRelativePlayerSpawn();

	/**
	 * Set the coordinates of the block above which players will spawn. The following coordinates are relative to the center.
	 * 
	 * @param x The x-Coordinates of the block.
	 * @param y The y-Coordinates of the block.
	 * @param z The z-Coordinates of the block.
	 */
	void setRelativePlayerSpawn(String x, String y, String z);

	/**
	 * @return True if mobs are allowed to spawn under the spawn, false otherwise.
	 */
	boolean isAllowMobsUnderSpawn();

	/**
	 * If mobs are allowed to spawn under the spawn, then set to true, false otherwise.
	 * 
	 * @param isAllowMobsUnderSpawn true to allow mobs to spawn under the spawn, false otherwise.
	 */
	void setAllowMobsUnderSpawn(boolean isAllowMobsUnderSpawn);
}
