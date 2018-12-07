package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Treasure {

	private int posX;
	private int posY;
	private int numberOfChest;

	public int getPosX() {
		return posX;
	}

	public Treasure(int posX, int posY, int numberOfChest) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.numberOfChest = numberOfChest;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNumberOfChest() {
		return numberOfChest;
	}

	public void setNumberOfChest(int numberOfChest) {
		this.numberOfChest = numberOfChest;
	}

	public static void searchForTreasure(Adventurer adv, Map newMap, Treasure chest) {
		 if((chest.getNumberOfChest() == 0) && (adv.getPosX() == chest.getPosX()) && (adv.getPosY() == chest.getPosY())){
			System.out.println("Only empty chests...");
		}else if ((adv.getPosX() == chest.getPosX()) && (adv.getPosY() == chest.getPosY())) {
			adv.setChest(adv.getChest() + 1);
			chest.setNumberOfChest(chest.getNumberOfChest() - 1);
			System.out.println(adv.getChest());
			System.out.println("You have found a treasure chest!!");
			if (chest.getNumberOfChest() < 0) {
				chest.setNumberOfChest(0);

			}
		} else {
			System.out.println("Keep looking for treasure " + adv.getName());
		}
	}
	
	public static List getChestfromText(String path) throws IOException {

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
	
	public static Treasure setTreasure() throws IOException {
		// Récupération de la Mountain
				List<String> textChest = Treasure.getChestfromText("src/Treasure.txt");
				String getChest = textChest.toString();

				String getChest1 = getChest.substring(1, getChest.length() - 1);
				String[] getChest2 = getChest1.split("-", 5);

				int sizeChest = getChest2.length;

				int posXChest = Integer.parseInt(getChest2[sizeChest - 3]);
				int posYChest = Integer.parseInt(getChest2[sizeChest - 2]);
				int numberOfChest = Integer.parseInt(getChest2[sizeChest - 1]);
				Treasure chest;
				return chest = new Treasure(posXChest, posYChest, numberOfChest);
				// Fin de la file map
	}

}
