package MapCreator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import LegendOfTheDankmemer.Spielfeld;

public class MapPanel extends JPanel {
	Color color;
	MapDaten md;

	public MapPanel() {
		md = new MapDaten();
		md.maplayout();
		//md.load();

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int tilegröße = 1408 /Spielfeld.feldgröße;
		int anzahltiles = 1408/tilegröße;
		super.paintComponents(g2);
		for (int i = 0; i < anzahltiles; i++) {
			for (int l = 0; l < anzahltiles; l++) {
				Farbe(g, md.tileid[i][l][1]);
				g2.fillRect(0 + tilegröße * i, 0 + tilegröße * l, tilegröße, tilegröße);
				g2.setColor(Color.black);
				g2.drawRect(0 + tilegröße * i, 0 + tilegröße * l, tilegröße, tilegröße);
			}
		}
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

}
