package fr.pederobien.minecraftspawn.commands;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.AbstractAreaEdition;
import fr.pederobien.minecraftarea.commands.EAreaCommonLabel;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftmanagers.WorldManager;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class RandomSpawn extends AbstractAreaEdition<ISpawn> {

	protected RandomSpawn() {
		super(ESpawnLabel.RANDOM, ESpawnMessageCode.RANDOM_SPAWN__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<String> spawns = getPersistence().list();
		String name = spawns.get(new Random().nextInt(spawns.size()));
		if (get() != null) {
			get().remove();
			getPersistence().save();
		}

		// Args : world + X + Y + Z
		if (args.length < 4) {
			sendSynchro(sender, ESpawnMessageCode.RANDOM_SPAWN__WORLD_OR_COORDINATES_ARE_MISSING);
			return false;
		}

		String[] arguments = new String[args.length + 1];
		arguments[0] = name;
		for (int i = 0; i < args.length; i++)
			arguments[i + 1] = args[i];
		IMapPersistenceEdition<ISpawn> launch = getParent().getChildrenByLabelName(EAreaCommonLabel.LAUNCH.getLabel()).get(0);
		launch.onCommand(sender, command, launch.getLabel(), arguments);
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> worlds = WorldManager.getWorldNormalisedNames();
		switch (args.length) {
		case 1:
			return filter(worlds.stream(), args[args.length - 1]);
		case 2:
			// Check if the first argument is known world
			return check(args[0], e -> worlds.contains(e), Arrays.asList("<X> <Y> <Z>"));
		case 3:
			// Check if the second argument is an integer
			return check(args[2], e -> isNotStrictInt(e), check(args[1], e -> isStrictInt(e), Arrays.asList("<Y> <Z>")));
		case 4:
			// Check if the third argument is an integer
			return check(args[3], e -> isNotStrictInt(e), check(args[2], e -> isStrictInt(e), Arrays.asList("<Z>")));
		default:
			return emptyList();
		}
	}
}
