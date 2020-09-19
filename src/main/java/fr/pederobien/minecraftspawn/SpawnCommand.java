package fr.pederobien.minecraftspawn;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractParentCommand;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftspawn.commands.SpawnParent;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class SpawnCommand extends AbstractParentCommand<ISpawn> {

	public SpawnCommand(JavaPlugin plugin) {
		super(plugin, new SpawnParent(plugin));
	}

	@Override
	public <U extends IGame> void onGameIsStarted(U IGame) {
		// Check if a spawn has been launched
		if (getParent().get() != null)
			getParent().get().getListener().setActivated(false);
	}

	@Override
	public <U extends IGame> void onGameIsStopped(U IGame) {
		// Check if a spawn has been launched
		if (getParent().get() != null)
			getParent().get().getListener().setActivated(true);
	}
}
