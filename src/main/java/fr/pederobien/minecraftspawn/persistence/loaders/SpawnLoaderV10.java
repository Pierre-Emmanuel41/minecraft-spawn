package fr.pederobien.minecraftspawn.persistence.loaders;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.pederobien.minecraftarea.impl.AreaBlock;
import fr.pederobien.minecraftarea.interfaces.IAreaBlock;
import fr.pederobien.minecraftarea.persistence.AreaXmlTag;
import fr.pederobien.minecraftspawn.interfaces.ISpawn;
import fr.pederobien.minecraftspawn.persistence.SpawnXmlTag;
import fr.pederobien.persistence.interfaces.xml.IXmlPersistenceLoader;

public class SpawnLoaderV10 extends AbstractSpawnLoader {

	public SpawnLoaderV10() {
		super(1.0);
	}

	@Override
	public IXmlPersistenceLoader<ISpawn> load(Element root) {
		createNewElement();

		// Getting the spawn's name
		Node name = getElementsByTagName(root, AreaXmlTag.NAME).item(0);
		get().setName(name.getChildNodes().item(0).getNodeValue());

		// Getting the spawn's world
		Node world = getElementsByTagName(root, AreaXmlTag.WORLD).item(0);
		get().setWorld(world.getChildNodes().item(0).getNodeValue());

		// Getting the dimensions of the spawn
		Element dimensions = (Element) getElementsByTagName(root, AreaXmlTag.DIMENSIONS).item(0);
		get().setWidth(getIntAttribute(dimensions, AreaXmlTag.WIDTH));
		get().setHeight(getIntAttribute(dimensions, AreaXmlTag.HEIGHT));
		get().setDepth(getIntAttribute(dimensions, AreaXmlTag.DEPTH));

		// Getting the spawn's center
		Element center = (Element) getElementsByTagName(root, AreaXmlTag.CENTER).item(0);
		get().setCenter(getXCoordinates(center), getYCoordinates(center), getZCoordinates(center));

		// Getting the spawn's player spawn
		Element playerSpawn = (Element) getElementsByTagName(root, SpawnXmlTag.PLAYER_SPAWN).item(0);
		get().setRelativePlayerSpawn(getXCoordinates(playerSpawn), getYCoordinates(playerSpawn), getZCoordinates(playerSpawn));

		// Getting the allow mobs under spawn
		Element allowMobsUnderSpawn = (Element) getElementsByTagName(root, SpawnXmlTag.ALLOW_MOBS_UNDER_SPAWN).item(0);
		get().setAllowMobsUnderSpawn(getBooleanNodeValue(allowMobsUnderSpawn.getChildNodes().item(0)));

		// Getting spawn's blocks
		NodeList blocks = getElementsByTagName(root, AreaXmlTag.BLOCK);
		List<IAreaBlock> spawnBlocks = new ArrayList<IAreaBlock>();
		for (int i = 0; i < blocks.getLength(); i++) {
			Element block = (Element) blocks.item(i);
			spawnBlocks.add(new AreaBlock(getXCoordinates(block), getYCoordinates(block), getZCoordinates(block), getStringAttribute(block, AreaXmlTag.BLOCK_DATA)));
		}
		get().setBlocks(spawnBlocks);
		return this;
	}
}
