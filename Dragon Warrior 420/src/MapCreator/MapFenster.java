package MapCreator;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MapFenster extends JFrame {

	public MapFenster() {
		MapPanel mp = new MapPanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MapCreator");
		Container c = getContentPane();
		c.add(mp);

		setPreferredSize(new Dimension(1700, 1500));
		pack();
		setVisible(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mp.cursorzeichen(e.getExtendedKeyCode());
				repaint();
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mp.md.safe();
			}});
	}

	public static void main (String[] args) {
		new MapFenster();
	}



}
