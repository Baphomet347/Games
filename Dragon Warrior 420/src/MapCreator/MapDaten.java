package MapCreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MapDaten {
	int feldgröße=LegendOfTheDankmemer.Spielfeld.feldgröße;
	int tileid[][][] = new int[feldgröße][feldgröße][2];
	public MapDaten() {

	}
	public void maplayout() {
		for (int i = 0; i < feldgröße; i++) {
			for (int l = 0; l < feldgröße; l++) {
				tileid[l][i][1] = 0;
			}
		}
		for (int i = 4; i < feldgröße-4; i++) {
			for (int l = 4; l < feldgröße-4; l++) {
				tileid[l][i][1] = 1;
			}
		}

	}

	public void safe() {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("mapdata.csv"), '\t');
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < feldgröße; i++) {
				for (int l = 0; l < feldgröße; l++) {
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
			for (int i = 0; i < feldgröße; i++) {
				String s = br.readLine();
				String[] integerStrings = s.split(",");
				// Splits each spaced integer into a String array.
				int[] integers = new int[integerStrings.length];
				// Parses the integer for each string.
				for (int l = 0; l < feldgröße; l++) {
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
