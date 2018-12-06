package model;
import java.util.ArrayList;
import java.util.List;

public class Adventurer {
	
	private String name;
	private int posX;
	private int posY;
	private char orientation;
	private char[] moves;
	private int chest;
	
	
	public Adventurer(String name, int posX, int posY, char orientation, char[] moves, int chest) {
		super();
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.orientation = orientation;
		this.moves = moves;
		this.chest = chest;
	}
	public Adventurer(String name, int posX, int posY, char orientation, int chest) {
		super();
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.orientation = orientation;
		this.chest = chest;
		
	}
	
	public int getChest() {
		return chest;
	}
	public void setChest(int chest) {
		this.chest = chest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosX() {
		return posX;
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
	public char getOrientation() {
		return orientation;
	}
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	public char[] getMoves() {
		return moves;
	}
	public void setMoves(char[] moves) {
		this.moves = moves;
	}
	
	public static void moveAdventurer(Map newMap, Mountain mount, Treasure chest, Adventurer adv) {

		for (char move : adv.getMoves()) {
			switch (move) {
			case 'A':
				if (adv.getOrientation() == 'N') {
					adv.setPosY(adv.getPosY() - 1);
				} else if (adv.getOrientation() == 'O') {
					adv.setPosX(adv.getPosX() - 1);
				} else if (adv.getOrientation() == 'S') {
					adv.setPosY(adv.getPosY() + 1);
				} else if (adv.getOrientation() == 'E') {
					adv.setPosX(adv.getPosX() + 1);
				}
				Map.checkForBorder(newMap, adv);
				Treasure.searchForTreasure(adv, newMap, chest);
				Mountain.checkForMountain(mount, adv);
//				
				break;
			case 'G':

				if (adv.getOrientation() == 'N') {
					adv.setOrientation('O');
				} else if (adv.getOrientation() == 'O') {
					adv.setOrientation('S');
				} else if (adv.getOrientation() == 'S') {
					adv.setOrientation('E');
				} else if (adv.getOrientation() == 'E') {
					adv.setOrientation('N');
				}
				break;
			case 'D':

				if (adv.getOrientation() == 'N') {
					adv.setOrientation('E');
				} else if (adv.getOrientation() == 'O') {
					adv.setOrientation('N');
				} else if (adv.getOrientation() == 'S') {
					adv.setOrientation('O');
				} else if (adv.getOrientation() == 'E') {
					adv.setOrientation('S');
				}
				break;

			}

			Map.createMap(newMap, mount, chest, adv);
			System.out.println(" ");

		}

	}

	

}
