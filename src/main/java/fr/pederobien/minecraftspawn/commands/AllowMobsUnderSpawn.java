package fr.pederobien.minecraftspawn.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.AbstractAreaEdition;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class AllowMobsUnderSpawn extends AbstractAreaEdition<ISpawn> {

	protected AllowMobsUnderSpawn() {
		super(ESpawnLabel.ALLOW_MOBS_TO_SPAWN_UNDER_SPAWN, ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			String isAllowMobsUnderSpawn = args[0];
			if (isAllowMobsUnderSpawn.equals("true"))
				get().setAllowMobsUnderSpawn(true);
			else if (isAllowMobsUnderSpawn.equals("false"))
				get().setAllowMobsUnderSpawn(false);
			else {
				sendSynchro(sender, ECommonMessageCode.COMMON_BAD_BOOLEAN_FORMAT);
				return false;
			}
			sendSynchro(sender, ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__DEFINED, get().isAllowMobsUnderSpawn());
		} catch (IndexOutOfBoundsException e) {
			sendSynchro(sender, ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__VALUE_IS_MISSING);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(asList("true", "false").stream(), args[0]);
		default:
			return emptyList();
		}
	}
}
