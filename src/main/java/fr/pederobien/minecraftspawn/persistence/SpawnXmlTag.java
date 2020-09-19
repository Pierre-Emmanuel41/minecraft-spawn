package fr.pederobien.minecraftspawn.persistence;

public enum SpawnXmlTag {
	PLAYER_SPAWN("playerspawn"), ALLOW_MOBS_UNDER_SPAWN("allowmobsunderspawn");

	private String name;

	private SpawnXmlTag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
