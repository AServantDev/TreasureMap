package model;

public class Mountain {

	private int posX;
	private int posY;

	public Mountain(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
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

	public static void checkForMountain(Mountain mount, Adventurer adv) {

		if ((adv.getPosX() == mount.getPosX()) && (adv.getPosY() == mount.getPosY())) {
			System.out.println("You can't pass the mountain !!");
			if (adv.getOrientation() == 'N') {
				adv.setPosY(adv.getPosY() + 1);
			} else if (adv.getOrientation() == 'O') {
				adv.setPosX(adv.getPosX() + 1);
			} else if (adv.getOrientation() == 'S') {
				adv.setPosY(adv.getPosY() - 1);
			} else if (adv.getOrientation() == 'E') {
				adv.setPosX(adv.getPosX() - 1);

			} else {

			}
		}

	}
}
