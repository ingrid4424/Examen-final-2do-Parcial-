package vista;

import processing.core.PApplet;

public abstract class Figura implements Runnable{
	
	protected float posX;
	protected float posY;
	protected int sizeX;
	protected int sizeY;
	protected PApplet app;
	protected int dirX;
	protected int dirY;
	
	
	public Figura(PApplet app, float posX, float posY, int sizeX, int sizeY,  int dirX, int dirY) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.dirX = dirX;
		this.dirY = dirY;
	}

	
	
	public void pintar(int r, int g,int b, int tipo) {
		switch (tipo) {
		case 0:
			this.app.noStroke();
			this.app.fill(r, g, b);
			this.app.ellipse(posX, posY, sizeX, sizeY);
			break;
		case 1:
			this.app.stroke(r, g, b);
			this.app.fill(255);
			this.app.ellipse(posX, posY, sizeX, sizeY);
			break;
		}
	}
	
	public abstract void mover();
	
	public void run() {
		while(true) {
			System.out.println("Se ha ejecutado el programa");
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}