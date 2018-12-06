package model;

public class App {

	public static void main(String[] args) {

		Mountain mount = new Mountain(2, 3);
		Treasure treasure = new Treasure(1, 1, 3);
		Map map = new Map(3, 4);
		Adventurer lara = new Adventurer("Lara", 2, 2, 'O', 0);
		char[] moves = { 'A', 'A', 'D', 'A'  };
		lara.setMoves(moves);

		System.out.println("En avant!");
		Map.createMap(map, mount, treasure, lara);
		Adventurer.moveAdventurer(map, mount, treasure, lara);
		

	}

	
}
