package vista;

import processing.core.PApplet;

public class Polo extends Figura{

	private boolean onLlamando;

	public Polo(PApplet app, float posX, float posY, int sizeX, int sizeY, int dirX, int dirY) {
		super(app, posX, posY, sizeX, sizeY,  dirX, dirY);
		// TODO Auto-generated constructor stub
		
		new Thread(
				() -> {
					while (true) {
						
						try {
							Thread.sleep(5000);
							System.out.println("Se ha ejecutado el programa");
							this.dirX = (int) this.app.random(-2, 2);
							Thread.sleep(5000);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
				).start();
		
	}
	
	public void pintarMensaje() {
		if(onLlamando) {
			app.text(this.posX + " "+ this.posY, posX, posY);
		}
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		if(this.posX<0 || this.posX>800) {
			this.dirX*=-1;
		}
		
		if(this.posY<0 || this.posY>600) {
			this.dirY*=-1;
		}
		
		this.posX += this.dirX;
		this.posY += this.dirY;
		

	
	}

}
