package Game;
import Combat.CombatManager;
import processing.core.*;

public class UsingProcessing extends PApplet {
	class State {
		int initialState = 0;
		int state1 = 1;
		int state2 = 2;
		int state3 = 3;
		int state4 = 4;
		int state5 = 5;
		int state7 = 7;
		int gameOver = 8;
	}
	Jogador p1 = new Jogador("Brazil");
	CombatManager CombatMng = new CombatManager(p1);
	
	State states = new State();
	private int currentState = this.states.initialState;
    Game.Tabuleiro tabuleiro = new Tabuleiro(this);
	
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Game.UsingProcessing");
//        JFrame frame = new SupremaciaGUI("Supremacia");
//        frame.setVisible(true);
    }
    public void setup(){
        this.tabuleiro.start();
    }
    public void draw(){
        this.tabuleiro.show();
    }
    public void mouseClicked() {
    	this.tabuleiro.click(mouseX, mouseY, this.getCurrentPlayer());
    }
    public Jogador getCurrentPlayer() {
    	return this.CombatMng.getCurrentPlayer();
    }
    public void setCurrentPlayer(Jogador p) {
    	this.CombatMng.setCurrentPlayer(p);
    }
    public void keyPressed() {
    	if (keyCode == ENTER) {
    		this.tabuleiro.confirm();
    	}
    }
    // method used only for setting the size of the window
    public void settings(){
    	size(displayWidth, displayHeight);
    }
}
