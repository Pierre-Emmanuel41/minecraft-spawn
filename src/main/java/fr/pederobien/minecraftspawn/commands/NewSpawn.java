package fr.pederobien.minecraftspawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.EAreaCommonLabel;
import fr.pederobien.minecraftgameplateform.commands.common.CommonNew;
import fr.pederobien.minecraftgameplateform.commands.common.ECommonLabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftspawn.impl.Spawn;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;

public class NewSpawn extends CommonNew<ISpawn> {

	protected NewSpawn() {
		super(ESpawnMessageCode.NEW_SPAWN__EXPLANATION);
	}

	@Override
	protected void onNameAlreadyTaken(CommandSender sender, String name) {
		sendSynchro(sender, ESpawnMessageCode.NEW_SPAWN__NAME_ALREADY_TAKEN, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendSynchro(sender, ESpawnMessageCode.NEW_SPAWN__NAME_IS_MISSING);
	}

	@Override
	protected ISpawn create(String name) {
		return new Spawn(name);
	}

	@Override
	protected void onCreated(CommandSender sender, String name) {
		sendSynchro(sender, ESpawnMessageCode.NEW_SPAWN__SPAWN_CREATED, name);
		setAllAvailable();
	}

	private void setAllAvailable() {
		for (ILabel label : ECommonLabel.values())
			setAvailableLabelEdition(label);
		for (ILabel label : EAreaCommonLabel.values())
			setAvailableLabelEdition(label);
		for (ILabel laebl : ESpawnLabel.values())
			setAvailableLabelEdition(laebl);
	}
}
