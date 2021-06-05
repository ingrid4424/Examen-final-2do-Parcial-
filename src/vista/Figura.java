package vista;

import processing.core.PApplet;

public abstract class Figura extends Thread{
	
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
			this.app.strokeWeight(3);
			this.app.stroke(r, g, b);
			this.app.fill(255);
			this.app.ellipse(posX, posY, sizeX, sizeY);
			break;
		}
	}
	
	public abstract void mover();
	
	public abstract void run();



	public float getPosX() {
		return posX;
	}



	public void setPosX(float posX) {
		this.posX = posX;
	}



	public float getPosY() {
		return posY;
	}



	public void setPosY(float posY) {
		this.posY = posY;
	}



	public int getSizeX() {
		return sizeX;
	}



	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}



	public int getSizeY() {
		return sizeY;
	}



	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}



	public PApplet getApp() {
		return app;
	}



	public void setApp(PApplet app) {
		this.app = app;
	}



	public int getDirX() {
		return dirX;
	}



	public void setDirX(int dirX) {
		this.dirX = dirX;
	}



	public int getDirY() {
		return dirY;
	}



	public void setDirY(int dirY) {
		this.dirY = dirY;
	}
		
}