package Combat;

import Game.Jogador;

public class CombatManager {
	Jogador player1, player2;
	private Jogador currentPlayer;
	public CombatManager(Jogador p1){
		this.setCurrentPlayer(p1);
	}
	public Jogador getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Jogador currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}
