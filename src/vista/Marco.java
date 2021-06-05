package vista;

import processing.core.PApplet;

public class Marco extends Figura{

	public Marco(PApplet app, float posX, float posY, int sizeX, int sizeY, int dirX, int dirY) {
		super(app, posX, posY, sizeX, sizeY, dirX, dirY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		 float targetX = this.app.mouseX;
		  float dx = targetX - this.posX;
		  this.posX += dx * dirX;
		  
		  float targetY = this.app.mouseY;
		  float dy = targetY - this.posY;
		  this.posY += dy * dirY;
	}

}
