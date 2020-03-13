package LegendOfTheDankmemer;

public class Tile {
	Tile tile;

	enum tiletype {
		BERG, GRASS, MEER, WUESTE
	}

	tiletype tt;
	boolean begehbarkeit;
	int risikofaktor;
	public Tile() {

	}
	public Tile(tiletype tt, boolean begehbarkeit, int risikofaktor) {
		this.tt = tt;
		this.begehbarkeit = begehbarkeit;
		this.risikofaktor = risikofaktor;
	}

	public Tile tileidtotileobject(int id) {
		switch (id) {
		case 0:
			tile = new Tile(tiletype.BERG, false, 0);
			break;
		case 1:
			tile = new Tile(tiletype.GRASS, true, 1);
			break;
		case 2:
			tile = new Tile(tiletype.MEER, false, 1);
			break;
		case 3:
			tile = new Tile(tiletype.WUESTE, false, 1);
			break;
		}
		return tile;
	}

	public boolean begehbarkeitprüfen(int id) {
		tileidtotileobject(id);
		if (tile.begehbarkeit == true) {
			System.out.println("Begehbarkeit: true");
			return true;
		} else {
			System.out.println("Begehbarkeit: false");
			return false;
		}
	}

}
