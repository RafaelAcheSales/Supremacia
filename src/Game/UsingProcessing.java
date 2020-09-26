package Game;
import processing.core.*;
import java.util.ArrayList;
public class UsingProcessing extends PApplet {
	Territorio brazil;
	Territorio venezuela;
	PImage mapa;
	ArrayList<String> front = new ArrayList<String>();
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Game.UsingProcessing");
    }

    // method used only for setting the size of the window
    public void settings(){
    	size(1489, 1060);
    }

    // identical use to setup in Processing IDE except for size()
    public void setup(){
    	this.mapa = loadImage("supremacymap.png");
        image(this.mapa, 0, 0);
        front.add("Venezuela");
        this.brazil = new Territorio(this, "Brasil", front, new PVector(460, 630), 60, 60);
        front.clear();
        front.add("Brasil");
        front.add("Peru");
        this.venezuela = new Territorio(this, "Venezuela", front, new PVector(330, 580), 60, 60);
        
    }

    // identical use to draw in Prcessing IDE
    public void draw(){
    	this.brazil.show();
    	this.venezuela.show();
    }
    public void mouseClicked() {
    	int x = mouseX;
    	int y = mouseY;
    	if (this.brazil.isPointInside(x, y)) {
    		rect(0, 0, 300, 300);
    	} else if(this.venezuela.isPointInside(x, y)){
    		System.out.println(this.venezuela.getFronteiras());
    		image(this.mapa,0, 0);
    		this.brazil.show();
        	this.venezuela.show();
    	}
    }
}
