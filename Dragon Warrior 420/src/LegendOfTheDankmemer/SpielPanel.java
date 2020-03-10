package LegendOfTheDankmemer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import LegendOfTheDankmemer.Spieler.facing;

public class SpielPanel extends JPanel {
	int zeichenanfangx, zeichenanfangy;
	Spielfeld sf = new Spielfeld();
	Spieler bob;
	Color color;
	Images im =new Images();




	public SpielPanel() {
		bob = Spieler.load();
	}



	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Spielfeldzeichnen(g);
		Farbe(g, 2);
		g2.drawImage(im.facingtoimage(facing.SOUTH),7+64 * 8,7+64 * 8, this);
		//g2.fillOval(2 + 64 * 8, 2 + 64 * 8, 60, 60);

	}

	private Color Farbe(Graphics g, int farbnummer) // Vereinfachte Farbauswahl
	{
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponents(g2);
		switch (farbnummer) {
		case 0:
			g2.setColor(Color.GRAY); // Mountain
			break;
		case 1:
			color = new Color(34, 139, 34); // Grass
			g2.setColor(color);
			break;
		case 2:
			color = new Color(30, 144, 255); // Water
			g2.setColor(color);
			break;

		case 3:
			color = new Color(34, 139, 34); // forestgreen
			g2.setColor(color);
			break;
		}

		return color;
	}

	private void Spielfeldzeichnen(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponents(g2);
		if (bob.getXpos() >= 8 && bob.getYpos() >= 8) {
			zeichenanfangx = bob.getXpos() - 8;
			zeichenanfangy = bob.getYpos() - 8;
		}
		for (int i = 0; i < 17; i++) {
			for (int l = 0; l < 17; l++) {
				//Farbe(g, sf.tileid[i + zeichenanfangx][l + zeichenanfangy][1]); // Farbe des Tiles anhand der tileid
				//g2.fillRect(0 + 64 * i, 0 + 64 * l, 64, 64);
				g2.drawImage(im.tileidtoimage(sf.tileid[i + zeichenanfangx][l + zeichenanfangy][1]),64*i, 64*l, this);
				g2.setColor(Color.BLACK);
				g2.drawRect(0 + 64 * i, 0 + 64 * l, 64, 64);
			}
		}
		//g2.drawImage(im.tileidtoimage(0), 0, 0, this);

	}
}
