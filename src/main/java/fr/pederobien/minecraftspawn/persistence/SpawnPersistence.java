package fr.pederobien.minecraftspawn.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.minecraftarea.interfaces.IAreaBlock;
import fr.pederobien.minecraftarea.persistence.AreaXmlTag;
import fr.pederobien.minecraftdevelopmenttoolkit.utils.FileWriterHelper;
import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;
import fr.pederobien.minecraftspawn.persistence.loaders.SpawnLoaderV10;

public class SpawnPersistence extends AbstractMinecraftPersistence<ISpawn> {
	private static final String ROOT_XML_DOCUMENT = "spawn";

	private SpawnPersistence() {
		super(Plateform.ROOT.resolve("Spawns"), "DefaultSpawn");
		register(new SpawnLoaderV10());
	}

	public static IMinecraftPersistence<ISpawn> getInstance() {
		return SingletonHolder.PERSISTENCE;
	}

	private static class SingletonHolder {
		public static final IMinecraftPersistence<ISpawn> PERSISTENCE = new SpawnPersistence();
	}

	@Override
	public void saveDefault() {
		FileWriterHelper.write(getAbsolutePath(getDefault()), new DefaultSpawnContent().get());
	}

	@Override
	public boolean save() {
		if (get() == null)
			return false;
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = createElement(doc, ROOT_XML_DOCUMENT);
		doc.appendChild(root);

		Element version = createElement(doc, VERSION);
		version.appendChild(doc.createTextNode("" + getVersion()));
		root.appendChild(version);

		Element name = createElement(doc, AreaXmlTag.NAME);
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

		Element world = createElement(doc, AreaXmlTag.WORLD);
		world.appendChild(doc.createTextNode(get().getWorld().getName()));
		root.appendChild(world);

		Element dimensions = createElement(doc, AreaXmlTag.DIMENSIONS);
		setAttribute(dimensions, AreaXmlTag.WIDTH, get().getWidth());
		setAttribute(dimensions, AreaXmlTag.HEIGHT, get().getHeight());
		setAttribute(dimensions, AreaXmlTag.DEPTH, get().getDepth());
		root.appendChild(dimensions);

		Element center = createElement(doc, AreaXmlTag.CENTER);
		addCoordinates(center, get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
		root.appendChild(center);

		Element playerSpawn = createElement(doc, SpawnXmlTag.PLAYER_SPAWN);
		addCoordinates(playerSpawn, get().getRelativePlayerSpawn().getX(), get().getRelativePlayerSpawn().getY(), get().getRelativePlayerSpawn().getZ());
		root.appendChild(playerSpawn);

		Element allowMobsUnderSpawn = createElement(doc, SpawnXmlTag.ALLOW_MOBS_UNDER_SPAWN);
		allowMobsUnderSpawn.appendChild(doc.createTextNode("" + get().isAllowMobsUnderSpawn()));
		root.appendChild(allowMobsUnderSpawn);

		Element blocks = createElement(doc, AreaXmlTag.BLOCKS);
		for (IAreaBlock b : get().getBlocks()) {
			Element block = createElement(doc, AreaXmlTag.BLOCK);
			addCoordinates(block, b.getX(), b.getY(), b.getZ());
			setAttribute(block, AreaXmlTag.BLOCK_DATA, b.getBlockData().getAsString());
			blocks.appendChild(block);
		}
		root.appendChild(blocks);

		saveDocument(doc, get().getName());
		return true;
	}

	private void addCoordinates(Element element, Object xCoordinate, Object yCoordinate, Object zCoordinate) {
		setAttribute(element, AreaXmlTag.X_COORDINATES, xCoordinate);
		setAttribute(element, AreaXmlTag.Y_COORDINATES, yCoordinate);
		setAttribute(element, AreaXmlTag.Z_COORDINATES, zCoordinate);
	}
}
