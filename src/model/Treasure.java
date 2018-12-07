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
	

	public Treasure() {
		super();
	}

}
