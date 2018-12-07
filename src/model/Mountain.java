package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public static List getMountfromText(String path) throws IOException {

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
	
	public static Mountain setMountain() throws IOException {
		// Récupération de la Mountain
				List<String> textMount = Mountain.getMountfromText("src/Mountain.txt");
				String getMount = textMount.toString();

				String getMount1 = getMount.substring(1, getMount.length() - 1);
				String[] getMount2 = getMount1.split("-", 5);

				int sizeMount = getMount2.length;

				int PosXMount = Integer.parseInt(getMount2[sizeMount - 2]);
				int PosYMount = Integer.parseInt(getMount2[sizeMount - 1]);
				Mountain mount;
				return mount = new Mountain(PosXMount, PosYMount);
				// Fin de la file map
	}

}
