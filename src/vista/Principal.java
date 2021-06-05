package vista;

import java.util.ArrayList;

import processing.core.PApplet;

public class Principal extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Principal.class.getName());
	}
	
	ArrayList<Polo> polos;
	Marco marco;
	
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		polos = new ArrayList<Polo>();
		for (int i = 0; i < 20; i++) {
			polos.add(new Polo(this, random(700), random(500), 30, 30, 2, 2));
			
		}
		marco = new Marco(this, 50, 50, 30, 30, 1, 1);
		
		for (Polo polo : polos) {
			polo.start();
		}
	}
	
	public void draw() {
		background(240,255,255);
		
		for (Polo polo : polos) {
			polo.pintar(255, 150, 150, 1);
			polo.pintarMensaje();
			polo.mover();
		}
		
		marco.pintar(0, 0, 255, 0);
		marco.mover();
	}

}
