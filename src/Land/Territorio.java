package Land;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;
import java.util.ArrayList;

import Combat.Tropa;
import Game.Jogador;

public class Territorio {
	class Color {
		private String currentColor;
		public int[] getColor(String color, boolean isNotOwned) {
			int[] cor = {150, 150,150};
			if (color == "verde" || !isNotOwned) {
				cor[0] = 0;
				cor[1] = 255;
				cor[2] = 0;
			} else if (color == "vermelho") {
				cor[0] = 255;
				cor[1] = 0;
				cor[2] = 0;
			} else if (color == "cinza") {
				cor[0] = 150;
				cor[1] = 150;
				cor[2] = 150;
			}  else if (color == "branco") {
				cor[0] = 255;
				cor[1] = 255;
				cor[2] = 255;
			}
			return cor;
		}
		public String getCurrentColor() {
			return currentColor;
		}
		public void setCurrentColor(String currentColor) {
			this.currentColor = currentColor;
		}
	}
	Color colorMng = new Color();
	private String name;
	private final ArrayList<String> fronteiras;
	private PVector pos;
	private final PApplet p;
	private int width, height;
	private Jogador owner;
	private ArrayList<Tropa> ocupantes;
	private int custo;

//	Apenas um ocupante
	public Territorio(PApplet p, String name, ArrayList<String> fronteiras, PVector pos, int width, int height, ArrayList<Tropa> ocupantes) {
		this.name = name;
		this.fronteiras = fronteiras;
		this.pos = pos;
		this.width = width;
		this.height = height;
		this.p = p;
		if (ocupantes != null) {
			this.ocupantes = ocupantes;
		} else {
			this.ocupantes = new ArrayList<Tropa>();
		}
		this.custo = 1;
	}
	public String getName() {
		return name;
	}
	public ArrayList<String> getFronteiras() {
		return this.fronteiras;
	}
	
	

	public void show() {
		if (this.getName() == "Eastern Australia") {
		}
		int[] rgb = this.colorMng.getColor(this.colorMng.getCurrentColor(), this.getOcupantes().isEmpty());
		p.fill(rgb[0], rgb[1], rgb[2]);
		p.rectMode(PConstants.CENTER);
		p.rect(this.pos.x, this.pos.y, this.width, this.height);
		p.fill(0, 0, 0);
		p.textAlign(PConstants.CENTER, PConstants.BOTTOM);
		String text = this.name;
		if(this.getOcupantes().size() > 0) {
			
			p.fill(255, 0, 0);
			p.text(this.ocupantes.size(), this.pos.x, this.pos.y+10);
		}
		p.text(text , this.pos.x, this.pos.y);
		
	}
	
	public void setColor(String colorName) {
		this.getColorMng().setCurrentColor(colorName);
	}
	public Color getColorMng() {
		return this.colorMng;
	}
	public boolean isPointInside(int x, int y) {
		return x > this.pos.x - this.width/2 && x < this.pos.x + this.width/2 &&
				y > this.pos.y - this.height/2 && y < this.pos.y + this.height/2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PVector getPos() {
		return pos;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
	}

	public PApplet getP() {
		return p;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<Tropa> getOcupantes() {
		return (ArrayList<Tropa>) this.ocupantes.clone();
	}

	public void addOcupantes(ArrayList<Tropa> ocupantes) {
		System.out.println(ocupantes);
		System.out.println("setado");
		this.ocupantes.addAll(ocupantes);
	}
	public void removeOcupantes(int mortos) {
		if(this.ocupantes.size() - mortos <= 0) {
			this.ocupantes.clear();
		} else {
			for (int i = this.ocupantes.size(); i > 0; i--) {
				//this.ocupantes.remove(index)
			}
		}
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}

	public Jogador getOwner() {
		return owner;
	}
	public void setOwner(Jogador owner) {
		this.owner = owner;
	}
}
