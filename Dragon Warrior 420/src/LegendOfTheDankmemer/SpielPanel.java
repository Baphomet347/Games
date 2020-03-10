package LegendOfTheDankmemer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import LegendOfTheDankmemer.Spieler.facing;

public class SpielPanel extends JPanel {
	int zeichenanfangx, zeichenanfangy;
	int zeichenxpos, zeichenypos;
	Spielfeld sf = new Spielfeld();
	Spieler bob;
	Color color;
	Images im = new Images();

	public SpielPanel() {
		bob = Spieler.load();
		zeichenxpos = bob.getZeichenxpos();
		zeichenypos = bob.getZeichenypos();
		zeichenanfangx = bob.getZeichenanfangx();
		zeichenanfangy = bob.getZeichenanfangy();
	}

	@Override
	public void paintComponent(Graphics g) {
		spielfeldzeichnen(g);
		spielerzeichnen(g);
	}

	private void spielerzeichnen(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(im.facingtoimage(facing.SOUTH), 7 + 64 * zeichenxpos, 7 + 64 * zeichenypos, this);
	}

	public void spielerposition(int keycodeid) {
		if (sf.xmaprandprüfen(bob.getXpos()) == true) {
			if (keycodeid == 68) {
				zeichenxpos++;
			}
			if (keycodeid == 65) {
				zeichenxpos--;
			}
		} else {
			zeichenxpos = 8;
		}
		if (sf.ymaprandprüfen(bob.getYpos()) == true) {
			if (keycodeid == 87) {
				zeichenypos--;
			}
			if (keycodeid == 83) {
				zeichenypos++;
			}
		} else {
			zeichenypos = 8;

		}
	}

	void zeichenanfang() {
		if (sf.xmaprandprüfen(bob.getXpos()) == false) {
			if (bob.getXpos() > 8 || bob.getXpos() <= Spielfeld.feldgröße) {
				zeichenanfangx = bob.getXpos() - 8;
			}
		}
		if (sf.ymaprandprüfen(bob.getYpos()) == false) {
			if (bob.getYpos() > 8 || bob.getYpos() <= Spielfeld.feldgröße) {
				zeichenanfangy = bob.getYpos() - 8;
			}
		}
	}

	private void spielfeldzeichnen(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponents(g2);

		for (int i = 0; i < 17; i++) {
			for (int l = 0; l < 17; l++) {
				g2.drawImage(im.tileidtoimage(sf.tileid[i + zeichenanfangx][l + zeichenanfangy][1]), 64 * i, 64 * l,
						this);
				g2.setColor(Color.BLACK);
				g2.drawRect(0 + 64 * i, 0 + 64 * l, 64, 64);
			}
		}
	}

	public void safevars() {
		bob.setZeichenanfangx(zeichenanfangx);
		bob.setZeichenanfangy(zeichenanfangy);
		bob.setZeichenxpos(zeichenxpos);
		bob.setZeichenypos(zeichenypos);
	}
}
