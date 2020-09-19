package fr.pederobien.minecraftspawn.commands;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum ESpawnLabel implements ILabel {
	PLAYER_SPAWN("playerspawn"), RANDOM("random"), ALLOW_MOBS_TO_SPAWN_UNDER_SPAWN("allowMobsToSpawnUnderSpawn");

	private String label;

	private ESpawnLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
