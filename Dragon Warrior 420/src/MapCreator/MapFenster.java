package MapCreator;

import java.awt.Container;
import java.awt.Dimension;
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
		setPreferredSize(new Dimension(1500, 1500));
		pack();
		setVisible(true);
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
