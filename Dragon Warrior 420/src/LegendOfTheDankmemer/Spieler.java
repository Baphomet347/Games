package LegendOfTheDankmemer;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Spieler {

	enum facing {
		NORTH, SOUTH, EAST, WEST;
	}

	facing richtung;
	private int xpos;
	private int ypos;

	int getXpos() {
		return xpos;
	}

	void setXpos(int xpos) {
		this.xpos = xpos;
	}

	int getYpos() {
		return ypos;
	}

	void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public Spieler() {

	}

	public void bewegen(int keycodeid) {
		if (keycodeid == 68) {
			richtung = facing.EAST;
			if (xpos < Spielfeld.feldgröße - 9) {
				xpos++;
			}
		}
		if (keycodeid == 65) {
			richtung = facing.WEST;
			if (xpos > 8) {
				xpos--;
			}
		}
		if (keycodeid == 87) {
			richtung = facing.NORTH;
			if (ypos > 8) {
				ypos--;
			}
		}
		if (keycodeid == 83) {
			richtung = facing.SOUTH;
			if (ypos < Spielfeld.feldgröße - 9) {
				ypos++;
			}
		}
	}

	public static Spieler load() {
		try {
			final JAXBContext context = JAXBContext.newInstance(Spieler.class);
			return (Spieler) context.createUnmarshaller().unmarshal(new File("PlayerData.xml"));
		} catch (final JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Spieler Geladen.");
		return new Spieler();
	}

	public void safe() {
		try {
			final JAXBContext context = JAXBContext.newInstance(Spieler.class);
			final Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(this, System.out);
			m.marshal(this, new File("Playerdata.xml"));
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
		System.out.println("Spieler Gespeichert.");
	}

}
