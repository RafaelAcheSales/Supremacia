package Land;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

import Combat.Tropa;
import Game.Jogador;

public class MarAzulClaro extends Territorio{
//    Apenas um ocupante por vez
    public MarAzulClaro(PApplet p, String name, ArrayList<String> fronteiras, PVector pos, int width, int height, ArrayList<Tropa> ocupante) {
        super(p, name, fronteiras, pos, width, height, ocupante);
    }



}
