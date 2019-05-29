import java.awt.Color;
import java.awt.Graphics;

public abstract class Characters {

	public int a,b,c,width,height;
	public double x,y;
	
	public void lateral_boundaries() {
		if(this.x + this.width >= Game.WIDTH) {
			this.x = Game.WIDTH - this.width;
		}else {
			if(this.x <= 0) {
				this.x = 0;
			}
		}
	}
	
	public abstract void mecanic();
	
	public void render(Graphics g) {
		g.setColor(Color.getHSBColor(a, b, c));// Cor do player
		g.fillRect((int)x,(int)y, width, height);// as duas primeiras informações são as posições, e as duas ultimas o tamanho
		
		
	}
	
	
	
}
