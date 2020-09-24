package fr.pederobien.minecraftspawn;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class SpawnPlugin extends JavaPlugin {
	private static Plugin plugin;
	private static IParentCommand<ISpawn> spawnCommand;

	/**
	 * @return The plugin associated to this spawn plugin.
	 */
	public static Plugin get() {
		return plugin;
	}

	/**
	 * @return The current spawn for this plugin.
	 */
	public static ISpawn getCurrentSpawn() {
		return spawnCommand.getParent().get();
	}

	@Override
	public void onEnable() {
		Plateform.getPluginHelper().register(this);
		plugin = this;

		spawnCommand = new SpawnCommand(this);

		registerDictionaries();
	}

	private void registerDictionaries() {
		// Registering French dictionaries
		registerDictionary("French", "Spawn.xml");

		// Registering English dictionaries
		registerDictionary("English", "Spawn.xml");
	}

	private void registerDictionary(String parent, String... dictionaryNames) {
		Path jarPath = Plateform.ROOT.getParent().resolve(getName().concat(".jar"));
		String dictionariesFolder = "resources/dictionaries/".concat(parent).concat("/");
		for (String name : dictionaryNames)
			registerDictionary(Plateform.getDefaultDictionaryParser(dictionariesFolder.concat(name)), jarPath);
	}

	private void registerDictionary(IDictionaryParser parser, Path jarPath) {
		try {
			Plateform.getNotificationCenter().getDictionaryContext().register(parser, jarPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
