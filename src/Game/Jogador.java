package Game;

import java.util.ArrayList;

import Land.Territorio;

public class Jogador {
	private String nation;
	ArrayList<Territorio> ownedTerrain = new ArrayList<Territorio>();
	public Jogador(String nation) {
		this.nation = nation;
	}
}
