package LegendOfTheDankmemer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class SpielFenster extends JFrame {

	SpielPanel sp = new SpielPanel();

	public SpielFenster() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		sp.bob = Spieler.load();
		sp.sf.load();
		setTitle("Slime Quest");
		Container c = getContentPane();
		setPreferredSize(new Dimension(1200, 1200));
		c.add(sp);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (sp.sf.begehbarkeitprüfen(e.getExtendedKeyCode(), sp.bob.getXpos(), sp.bob.getYpos(), 1)==true) {
					sp.bob.bewegen(e.getExtendedKeyCode());

					sp.spielerposition(e.getExtendedKeyCode());
					sp.repaint();
				}
				System.out.print("amMaprandx: "+ sp.sf.amMaprandx+"  |  ");
				System.out.print("amMaprandy: "+sp.sf.amMaprandy+"\n");
				System.out.println("Xpos: "+sp.bob.getXpos() + "  |  Ypos: " + sp.bob.getYpos());
				System.out.println("Zeichenxpos: "+sp.zeichenxpos + "  |  Zeichenypos: " + sp.zeichenypos);
				System.out.println("Zeichenanfangx: "+sp.zeichenanfangx + "  |  Zeichenanfangy: " + sp.zeichenanfangy);


			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				sp.safevars();
				sp.bob.safe();
				sp.sf.safe();
			}
		});

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new SpielFenster();

	}

}
