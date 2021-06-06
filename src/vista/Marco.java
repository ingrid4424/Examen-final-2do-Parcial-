package vista;

import processing.core.PApplet;

public class Marco extends Figura{

	private boolean onLLamar;
	private float targetX;
	private float targetY;
	private float dx, dy;

	public Marco(PApplet app, float posX, float posY, int sizeX, int sizeY, int dirX, int dirY) {
		super(app, posX, posY, sizeX, sizeY, dirX, dirY);
		// TODO Auto-generated constructor stub
		onLLamar = false;
		targetX = this.app.mouseX;
		targetY = this.app.mouseY;
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
		
		  this.dx = this.targetX - this.posX;
		  this.posX += this.dx * 0.05;
		  
		  
		  this.dy = this.targetY - this.posY;
		  this.posY += this.dy * 0.05;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
				onLLamar = true;
				Thread.sleep(1000);
				onLLamar = false;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void setTarget(float targetX, float targetY) {
		this.targetX = targetX;
		this.targetY = targetY;
	}

	public boolean isOnLLamar() {
		return onLLamar;
	}

	public void setOnLLamar(boolean onLLamar) {
		this.onLLamar = onLLamar;
	}

}
