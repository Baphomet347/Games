package LegendOfTheDankmemer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Spielfeld {
	public static int feldgröße = 24;
	Tile ti = new Tile();
	int tileid[][][] = new int[feldgröße+1][feldgröße+1][2];
	boolean amMaprandx, amMaprandy;

	public Spielfeld() {

	}

	public boolean xmaprandprüfen(int xpos) {
		if (xpos < 8 || xpos >= feldgröße - 8) {
			amMaprandx = true;
		} else {
			amMaprandx = false;
		}
		return amMaprandx;
	}

	public boolean ymaprandprüfen(int ypos) {
		if (ypos < 8 || ypos>= feldgröße - 8) {
			amMaprandy = true;
		} else {
			amMaprandy = false;
		}
		return amMaprandy;
	}

	public boolean begehbarkeitprüfen(int keycodeid, int xpos, int ypos, int zpos) {
		if (keycodeid == 68) {
			xpos++;
		}
		if (keycodeid == 65) {
			xpos--;
		}
		if (keycodeid == 87) {
			ypos--;
		}
		if (keycodeid == 83) {
			ypos++;
		}
		return ti.begehbarkeitprüfen(tileid[xpos][ypos][zpos]);
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
	}

	public void load() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("mapdata.csv"), '\t');
			for (int i = 0; i < feldgröße; i++) {
				String s = br.readLine();
				String[] integerStrings = s.split(",");
				for (int l = 0; l < feldgröße; l++) {
					tileid[l][i][1] = Integer.parseInt(integerStrings[l]);
					System.out.print(tileid[l][i][1] + " ");
				}
				System.out.println("\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
