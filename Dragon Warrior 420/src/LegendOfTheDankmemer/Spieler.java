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
	private int zeichenanfangx, zeichenanfangy;
	private int zeichenxpos, zeichenypos;


	public Spieler() {

	}

	public void bewegen(int keycodeid) {
		if (keycodeid == 68) {
			richtung = facing.EAST;
			xpos++;
		}
		if (keycodeid == 65) {
			richtung = facing.WEST;
			xpos--;
		}
		if (keycodeid == 87) {
			richtung = facing.NORTH;
			ypos--;
		}
		if (keycodeid == 83) {
			richtung = facing.SOUTH;
			ypos++;
		}
	}

	public static Spieler load() {
		try {
			final JAXBContext context = JAXBContext.newInstance(Spieler.class);
			return (Spieler) context.createUnmarshaller().unmarshal(new File("gamedata.xml"));
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
			m.marshal(this, new File("gamedata.xml"));
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
		System.out.println("Spieler Gespeichert.");
	}

	int getZeichenanfangx() {
		return zeichenanfangx;
	}

	void setZeichenanfangx(int zeichenanfangx) {
		this.zeichenanfangx = zeichenanfangx;
	}

	int getZeichenanfangy() {
		return zeichenanfangy;
	}

	void setZeichenanfangy(int zeichenanfangy) {
		this.zeichenanfangy = zeichenanfangy;
	}

	int getZeichenxpos() {
		return zeichenxpos;
	}

	void setZeichenxpos(int zeichenxpos) {
		this.zeichenxpos = zeichenxpos;
	}

	int getZeichenypos() {
		return zeichenypos;
	}

	void setZeichenypos(int zeichenypos) {
		this.zeichenypos = zeichenypos;
	}

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
}
