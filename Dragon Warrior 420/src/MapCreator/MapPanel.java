package MapCreator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import LegendOfTheDankmemer.Spielfeld;

public class MapPanel extends JPanel {
	Color color;
	MapDaten md;
	int controllery;
	String tilenamen[] = { "BERG", "GRAS", "MEER", "TEST" };

	public MapPanel() {
		md = new MapDaten();
		// md.maplayout();
		md.load();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int tilegröße = 1408 / Spielfeld.feldgröße;
		int anzahltiles = 1408 / tilegröße;
		super.paintComponents(g2);
		for (int i = 0; i < anzahltiles; i++) {
			for (int l = 0; l < anzahltiles; l++) {
				Farbe(g, md.tileid[i][l][1]);
				g2.fillRect(0 + tilegröße * i, 0 + tilegröße * l, tilegröße, tilegröße);
				g2.setColor(Color.black);
				g2.drawRect(0 + tilegröße * i, 0 + tilegröße * l, tilegröße, tilegröße);
			}
		}
		controllerzeichnen(g);
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
			color = new Color(34, 139, 35); // forestgreen
			g2.setColor(color);
			break;
		}

		return color;
	}

	private void controllerzeichnen(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < 4; i++) {
			g2.setColor(Color.black);
			g2.fillRect(1408, 128 * i, 128, 128);
			Farbe(g, i);
			g2.fillRect(1424, 16 + 128 * i, 96, 96);
			g2.setFont(new Font("Yu Gothic", Font.BOLD, 30));
			g2.drawString(tilenamen[i], 1550, 64 + 128 * i);
			g2.setColor(Color.RED);
			g2.fillOval(1408 + 32, 32 + controllery * 128, 64, 64);
			char ch = '\u0095';
			System.out.println(ch);
			System.out.println("\u0061");


		}
	}

	public void cursorzeichen(int keycodeid) {

		if (keycodeid == 37) {
		}
		if (keycodeid == 38) {
			controllery--;
			if (controllery < 0) {
				controllery = 4;
			}
		}
		if (keycodeid == 39) {
		}
		if (keycodeid == 40) {
			controllery++;
			if (controllery > 4) {
				controllery = 0;
			}
		}
	}

}
