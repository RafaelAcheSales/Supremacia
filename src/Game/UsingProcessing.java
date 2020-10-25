package Game;
import javax.swing.JOptionPane;

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
    private java.util.ArrayList<Botao> botoes = new java.util.ArrayList<Botao>();
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        //PApplet.main("Game.UsingProcessing");
        javax.swing.JFrame frame = new SupremaciaGUI("Supremacia");
        frame.setVisible(true);
    }

    public void setupBotoesEstagio(){
        // Pagar Salarios
        int botoesX=1707,salarioY=109;
        int width=120, height=30;
        Botao botaoSalario = new Botao(this,"Pagar Salarios",new PVector(botoesX,salarioY),width,height);
        botoes.add(botaoSalario);

        // Vender Suprimentos
        int venderY=159;
        Botao botaoSuprimentos = new Botao(this,"Vender Suprimentos",new PVector(botoesX,venderY),width,height);
        botoes.add(botaoSuprimentos);

        // Atacar
        int atacarY=209;
        Botao botaoAtacar = new Botao(this,"Atacar",new PVector(botoesX,atacarY),width,height);
        botoes.add(botaoAtacar);

        // Movimentar tropas
        int movimentarY=259;
        Botao botaoMovimentar = new Botao(this,"Movimentar Tropas",new PVector(botoesX,movimentarY),width,height);
        botoes.add(botaoMovimentar);

        // Construir
        int contruirY=309;
        Botao botaoConstruir = new Botao(this,"Construir",new PVector(botoesX,contruirY),width,height);
        botoes.add(botaoConstruir);

        // Comprar
        int comprarY=359;
        Botao botaoComprar = new Botao(this,"Comprar Suprimentos",new PVector(botoesX,comprarY),width,height);
        botoes.add(botaoComprar);
    }
    
    public void setup(){
    	this.tabuleiro.start();
        setupBotoesEstagio();
        
    }
    public void draw(){
        this.tabuleiro.show();
        for (int i = 0; i < botoes.size(); i++) {
            botoes.get(i).show();
        }
    }
    public void mouseClicked() {
    	int x = mouseX;
    	int y = mouseY;
    	this.tabuleiro.click(x, y, this.getCurrentPlayer());
    	for (int i = 0; i < botoes.size(); i++) {
            Botao botao = botoes.get(i);
            if (botao.isPointInside(x,y)){
                switch (botao.getName()){
                    case "Pagar Salarios":
                        JOptionPane.showMessageDialog(null,"Selecione as tropas e companhias");
                        break;
                    case "Vender Suprimentos":
                        JOptionPane.showMessageDialog(null,"Selecione o suprimento para vender");
                        break;
                    case "Atacar":
                        JOptionPane.showMessageDialog(null,"Selecione a tropa e o territorio para atacar");
                        break;
                    case "Movimentar Tropas":
                        JOptionPane.showMessageDialog(null,"Selecione a tropa e o caminho para o territorio desejado");
                        break;
                    case "Construir":
                        JOptionPane.showMessageDialog(null,"Selecione o que deseje construir");
                        break;
                    case "Comprar Suprimentos":
                        JOptionPane.showMessageDialog(null,"Selecione o suprimento desejado");
                        break;
                }
            }
        }
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
	public int getCurrentState() {
		return currentState;
	}
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
}
