package vista;

import processing.core.PApplet;

public class Marco extends Figura{

	private boolean onLLamar;

	public Marco(PApplet app, float posX, float posY, int sizeX, int sizeY, int dirX, int dirY) {
		super(app, posX, posY, sizeX, sizeY, dirX, dirY);
		// TODO Auto-generated constructor stub
		onLLamar = false;
	}
	
	
	public void pintarMensaje() {
		if(onLLamar) {
			app.fill(0);
			app.textSize(16);
			app.text("Marco",posX-(sizeX), posY+ sizeY);
		}
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		 float targetX = this.app.mouseX;
		  float dx = targetX - this.posX;
		  this.posX += dx * 0.05;
		  
		  float targetY = this.app.mouseY;
		  float dy = targetY - this.posY;
		  this.posY += dy * 0.05;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				onLLamar = true;
				Thread.sleep(1500);
				onLLamar = false;
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public boolean isOnLLamar() {
		return onLLamar;
	}

	public void setOnLLamar(boolean onLLamar) {
		this.onLLamar = onLLamar;
	}

}
