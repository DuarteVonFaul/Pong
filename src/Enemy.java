
public class Enemy extends Characters {
	
	
	public Enemy(int x, int y) {
		System.out.println("Inimigo instanciado");
		this.x = x;
		this.y = y;
		this.width = 20;
		this.height = 5;
		this.a = 1;
		this.b = 1;
		this.c = 1;
	}

	public void mecanic() {
		
		if(Game.ball.x > (this.x + this.width)) {
			x++;
		}else {
			if(Game.ball.x < (this.x)) {
				x--;
			}
		}
		
		this.lateral_boundaries();
	}
	
	

}
