package LegendOfTheDankmemer;

import java.awt.Image;
import java.awt.Toolkit;

import LegendOfTheDankmemer.Spieler.facing;

public class Images {
	Image BergImage = Toolkit.getDefaultToolkit().getImage("textures/Berg.png");
	Image GrassImage = Toolkit.getDefaultToolkit().getImage("textures/Grass.png");
	Image WuesteImage = Toolkit.getDefaultToolkit().getImage("textures/Wueste.png");
	Image MeerImage = Toolkit.getDefaultToolkit().getImage("textures/Meer.png");

	Image testImage = Toolkit.getDefaultToolkit().getImage("textures/test.gif");

	Image bobSOUTH = Toolkit.getDefaultToolkit().getImage("textures/bob_SOUTH.gif");

	public Image tileidtoimage(int bild) {
		switch (bild) {
		case 0:
			;
			return BergImage;
		case 1:
			return GrassImage;
		case 2:
			return MeerImage; //MeerImage eigentlich
		case 3:
			return WuesteImage;
		case 404:
			return testImage;
		}
		return null;
	}

	public Image facingtoimage(facing richtung) {
		switch (richtung) {
		case NORTH:
			return bobSOUTH;
		case SOUTH:
			return bobSOUTH;
		case EAST:
			return bobSOUTH;
		case WEST:
			return bobSOUTH;
		}
		return null;
	}

}
