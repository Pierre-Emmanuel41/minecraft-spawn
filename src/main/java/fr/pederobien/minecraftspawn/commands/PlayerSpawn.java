package fr.pederobien.minecraftspawn.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.AbstractAreaEdition;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class PlayerSpawn extends AbstractAreaEdition<ISpawn> {

	protected PlayerSpawn() {
		super(ESpawnLabel.PLAYER_SPAWN, ESpawnMessageCode.PLAYER_SPAWN__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			get().setPlayerSpawn(args[0], args[1], args[2]);
			onPlayerSpawnDefined(sender, get().getPlayerSpawn().getX(), get().getPlayerSpawn().getY(), get().getPlayerSpawn().getZ());
		} catch (IndexOutOfBoundsException e) {
			// When X or Y or Z is missing
			sendSynchro(sender, ECommonMessageCode.COMMON_MISSING_COORDINATES);
			return false;
		} catch (NumberFormatException e) {
			// When the coordinates are not integer
			sendSynchro(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			// Check if the first argument is an integer
			return check(args[0], e -> isNotStrictInt(e), Arrays.asList("<X> <Y> <Z>"));
		case 2:
			// Check if the second argument is an integer
			return check(args[1], e -> isNotStrictInt(e), check(args[0], e -> isStrictInt(e), Arrays.asList("<Y> <Z>")));
		case 3:
			// Check if the third argument is an integer
			return check(args[2], e -> isNotStrictInt(e), check(args[1], e -> isStrictInt(e), Arrays.asList("<Z>")));
		default:
			return emptyList();
		}
	}

	private void onPlayerSpawnDefined(CommandSender sender, int x, int y, int z) {
		sendSynchro(sender, ESpawnMessageCode.PLAYER_SPAWN__PLAYER_SPAWN_DEFINED, x, y, z);
	}
}
