package model;

import java.io.IOException;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException {
		
		Map map = Map.setMapFromText();
		Mountain mount = Mountain.setMountain();
		Treasure treasure = Treasure.setTreasure();
		
		Adventurer lara = new Adventurer("Lara", 2, 2, 'O', 0);
		char[] moves = { 'A', 'A', 'D', 'A', 'G', 'A' };
		lara.setMoves(moves);

		System.out.println("En avant!");
		Map.createMap(map, mount, treasure, lara);
		Adventurer.moveAdventurer(map, mount, treasure, lara);

	}

}
