package vista;

import java.util.ArrayList;
import java.util.Collections;


import processing.core.PApplet;

public class Principal extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Principal.class.getName());
	}
	
	ArrayList<Polo> polos;
	//Marco marco;
	// prueba para hacer marcos
	ArrayList<Marco> marcos;
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		polos = new ArrayList<Polo>();
		for (int i = 0; i < 30; i++) {
			polos.add(new Polo(this, random(700), random(500), 30, 30, 2, 2));
			
		}
		
		for (Polo polo : polos) {
			polo.start();
		}
		/*marco = new Marco(this, 50, 50, 30, 30, 1, 1);
		marco.start();*/
		
		//elementos para lo de marcos
		marcos = new ArrayList<Marco>();
		marcos.add(new Marco(this, 50, 50, 30, 30, 1, 1));
		marcos.get(0).start();
		
		
		
		
	
			
		
	}
	
	public void draw() {
		background(240,255,255);
		try {
			for (Polo polo : polos) {
				polo.pintar(255, 150, 150, 1);
				polo.pintarMensaje();
				polo.mover();
				
			}
			
			
			
			
			for (Polo polo : polos) {
				for (Marco marco : marcos) {
					polo.setOnLlamando(marco.isOnLLamar());
				}
				
				
			}
			
			/*marco.pintar(0, 0, 255, 0);
			marco.pintarMensaje();
			marco.mover();*/
			
			//////////////////
			
			for (Marco marco : marcos) {
				marco.pintar(0, 0, 255, 0);
				marco.pintarMensaje();
				marco.mover();
				
				if(marco.isOnLLamar()) {
					calcularTarget();
				}
			}
			
			//////////////////
			
			eliminarElementos();
			
			/*if(marco.isOnLLamar()) {
				calcularTarget();
			}*/
			
			
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
								for (Marco marco : marcos) {
									float ditanciaMarco = dist(polos.get(i).getPosX(), polos.get(i).getPosY(), marco.getPosX(), marco.getPosY());
									polos.get(i).setDistanciaMarco(ditanciaMarco);
								}
								
								
							}
							
							Collections.sort(polos);
							for (Marco marco : marcos) {
								marco.setTarget(polos.get(0).getPosX(), polos.get(0).getPosY());
							}
							
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.getMessage() + " " + e.getCause());
							
						}
					
					
					
					
				}
				).start();
		
	}
	
	public void eliminarElementos() {
		for (int i = 0; i< polos.size(); i++) {
			for (Marco marco : marcos) {
				float ditanciaMarco = dist(polos.get(i).getPosX(), polos.get(i).getPosY(), marco.getPosX(), marco.getPosY());
				if(ditanciaMarco<30) {
					marcos.add(new Marco(this, polos.get(i).getPosX(), polos.get(i).getPosY(), 30, 30, 2, 2));
					polos.remove(polos.get(i));
					
					
					System.out.println("eliminado");
				}
			}
			
		}
	}

}
