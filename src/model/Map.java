package model;

import java.util.ArrayList;
import java.util.List;

public class Map {

	private int width;
	private int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static char[][] createMap(Map map, Mountain mount, Treasure chest, Adventurer adv) {

		char[][] newMap = new char[map.getHeight()][map.getWidth()];

		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				newMap[i][j] = '.';
				newMap[mount.getPosY() - 1][mount.getPosX() - 1] = 'M';
				newMap[chest.getPosY() - 1][chest.getPosX() - 1] = 'T';
				newMap[adv.getPosY() - 1][adv.getPosX() - 1] = 'A';
				System.out.print(newMap[i][j] + " ");
			}
			System.out.println("");
		}
		return newMap;

	}

	public Map(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	};

	public static void checkForBorder(Map map, Adventurer adv) {
		if (adv.getPosX() > map.getWidth()) {
			adv.setPosX(adv.getPosX() - 1);
			System.out.println("Don't go out of boundaries");
		} else if (adv.getPosX() == 0) {
			adv.setPosX(adv.getPosX() + 1);
			System.out.println("Don't go out of boundaries");
		} else if (adv.getPosY() > map.getHeight()) {
			adv.setPosY(adv.getPosY() - 1);
			System.out.println("Don't go out of boundaries");
		} else if (adv.getPosY() == 0) {
			adv.setPosY(1);
			System.out.println("Don't go out of boundaries");
		}
	}

}
