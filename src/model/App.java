package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException {

//		Map map = Map.setMapFromText();
//		Mountain mount = Mountain.setMountain();
//		Treasure treasure = Treasure.setTreasure();
		Map map = new Map();
		Mountain mount = new Mountain();
		Treasure chest = new Treasure();
		setMapFromText(map, mount, chest);

	
		
		

	}

	public static List getMapfromText(String path) throws IOException {

		List list = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));

			String line;

			while ((line = reader.readLine()) != null) {
				list.add(line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reader.close();
		System.out.println(list);
		return list;

	}

	public static void setMapFromText(Map map, Mountain mount, Treasure chest) throws IOException {
		// Récupération de la map
		List<String> textMap = Map.getMapfromText("src/Map.txt");
		String get = textMap.toString();

		String getMap1 = get.substring(1, get.length() - 1);

		String[] getMap = getMap1.split("\\,", 5);

		String beforeFirstComa = getMap[0];
		String beforeSecondComa = getMap[1];
		String afterSecondComa = getMap[2];

		String[] mapFromText = beforeFirstComa.split("-", 5);
		String[] mountFromText = beforeSecondComa.split("-", 5);
		String[] chestFromText = afterSecondComa.split("-", 5);

		int sizeC = mapFromText.length;
		int sizeM = mapFromText.length;
		int sizeT = mapFromText.length;

		int width = Integer.parseInt(mapFromText[sizeC - 2]);
		int height = Integer.parseInt(mapFromText[sizeC - 1]);
		map = new Map(width, height);
		
		int posXM = Integer.parseInt(mountFromText[sizeM - 2]);
		int posYM = Integer.parseInt(mountFromText[sizeM - 1]);
		mount = new Mountain(posXM, posYM);
		
		int posXT = Integer.parseInt(chestFromText[sizeT - 2]);
		int posYT = Integer.parseInt(chestFromText[sizeT - 1]);
		int numberOfChest = Integer.parseInt(chestFromText[sizeT - 0]);

		chest = new Treasure(posXT, posYT, numberOfChest);
		
		Adventurer lara = new Adventurer("Lara", 2, 2, 'O', 0);
		char[] moves = { 'A', 'A', 'D', 'A', 'G', 'A' };
		lara.setMoves(moves);

		System.out.println("En avant!");
		Map.createMap(map, mount, chest, lara);
		Adventurer.moveAdventurer(map, mount, chest, lara);
		
	}

}
