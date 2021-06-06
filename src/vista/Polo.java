package vista;

import java.math.BigDecimal;
import java.math.RoundingMode;

import processing.core.PApplet;

public class Polo extends Figura implements Comparable<Polo> {

	private boolean onLlamando;
	private float distanciaMarco;

	public float getDistanciaMarco() {
		return distanciaMarco;
	}

	public void setDistanciaMarco(float distanciaMarco) {
		this.distanciaMarco = distanciaMarco;
	}

	public Polo(PApplet app, float posX, float posY, int sizeX, int sizeY, int dirX, int dirY) {
		super(app, posX, posY, sizeX, sizeY, dirX, dirY);
		// TODO Auto-generated constructor stub

	}

	public void pintarMensaje() {
		if (onLlamando) {
			BigDecimal pposX = new BigDecimal(posX).setScale(1, RoundingMode.HALF_EVEN);
			BigDecimal pposY = new BigDecimal(posY).setScale(1, RoundingMode.HALF_EVEN);
			app.fill(0);
			app.text(pposX + " " + pposY, posX - (sizeX), posY + sizeY);
		}

	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		if (this.posX < 0 || this.posX > 800) {
			this.dirX *= -1;
		}

		if (this.posY < 0 || this.posY > 600) {
			this.dirY *= -1;
		}

		this.posX += this.dirX;
		this.posY += this.dirY;

	}

	public boolean isOnLlamando() {
		return onLlamando;
	}

	public void setOnLlamando(boolean onLlamando) {
		this.onLlamando = onLlamando;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {

			try {

				this.dirX = (int) this.app.random(-2, 2);

				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void movimientoRandomico() {
		new Thread(() -> {
			
			
			try {
				
				Thread.sleep(500);
				float vx = (float) (this.app.random((float) 2.0) - 1.0);
			    vx *= .96;
			    float vy = (float) (this.app.random((float) 2.0) - 1.0);
			    vy *= .96;
			      // update the position
			      this.posX += vx;
			      this.posY += vy;
				Thread.sleep(500);
				  this.posX -= vx;
			      this.posY -= vy;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		).start();
	}

	@Override
	public int compareTo(Polo o) {
		// TODO Auto-generated method stub
		return (int) (this.getDistanciaMarco() - o.getDistanciaMarco());
	}

}
