package vista;

import processing.core.PApplet;

public abstract class Figura extends Thread{
	
	protected float posX;
	protected float posY;
	protected int sizeX;
	protected int sizeY;
	protected PApplet app;
	
	public Figura(PApplet app, float posX, float posY, int sizeX, int sizeY) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	public void run() {
		try {
			System.out.println("Se ha ejecutado el programa");
		} catch (Exception e) {
			// TODO: handle exception
		}
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
}