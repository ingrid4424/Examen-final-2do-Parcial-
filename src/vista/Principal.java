package vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
		marco.start();
		
		for (Polo polo : polos) {
			polo.start();
		}
		
		
	
			
		
	}
	
	public void draw() {
		background(240,255,255);
		try {
			for (Polo polo : polos) {
				polo.pintar(255, 150, 150, 1);
				polo.pintarMensaje();
				polo.mover();
				polo.setOnLlamando(marco.isOnLLamar());
				
			}
			
			marco.pintar(0, 0, 255, 0);
			marco.pintarMensaje();
			marco.mover();
			
			if(marco.isOnLLamar()) {
				calcularTarget();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage() + " " + e.getCause());
		}
		
		
	}
	
	public void calcularTarget() {
		
		new Thread(
				() ->{
					
						try {
							Thread.sleep(2000);
							for (int i = 0; i< polos.size(); i++) {
								float ditanciaMarco = dist(polos.get(i).getPosX(), polos.get(i).getPosY(), marco.getPosX(), marco.getPosY());
								polos.get(i).setDistanciaMarco(ditanciaMarco);
							}
							
							Collections.sort(polos);
							
							marco.setTarget(polos.get(0).getPosX(), polos.get(0).getPosY());
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.getMessage() + " " + e.getCause());
							
						}
					
					
					
					
				}
				).start();
		
	}

}
