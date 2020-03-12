package MapCreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MapDaten {
	int feldgr��e=LegendOfTheDankmemer.Spielfeld.feldgr��e;
	int tileid[][][] = new int[feldgr��e][feldgr��e][2];
	public MapDaten() {

	}
	public void maplayout() {
		for (int i = 0; i < feldgr��e; i++) {
			for (int l = 0; l < feldgr��e; l++) {
				tileid[l][i][1] = 0;
			}
		}
		for (int i = 4; i < feldgr��e-4; i++) {
			for (int l = 4; l < feldgr��e-4; l++) {
				tileid[l][i][1] = 1;
			}
		}

	}

	public void safe() {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("mapdata.csv"), '\t');
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < feldgr��e; i++) {
				for (int l = 0; l < feldgr��e; l++) {
					sb.append(tileid[l][i][1]);
					sb.append(",");
				}
				sb.append("\n");
			}
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Map gespeichert.");
	}

	public void load() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("mapdata.csv"), '\t');
			for (int i = 0; i < feldgr��e; i++) {
				String s = br.readLine();
				String[] integerStrings = s.split(",");
				// Splits each spaced integer into a String array.
				int[] integers = new int[integerStrings.length];
				// Parses the integer for each string.
				for (int l = 0; l < feldgr��e; l++) {
					tileid[l][i][1] = Integer.parseInt(integerStrings[l]);
					System.out.print(tileid[l][i][1]+" ");
				}
				System.out.println("\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Map geladen.");
	}

}
