
public class Player extends Characters {
	
	
	
	boolean rigth, left;
	
	
	public Player(int x, int y){
		System.out.println("Player instanciado");
		this.x = x;
		this.y = y;
		this.width = 20;
		this.height = 5;
		this.a = 1;
		this.b = 30;
		this.c = 7;
		
	}
	
	
	
	public void mecanic() {
		
		if(this.rigth) {
			this.x++;
		}else {
			if(this.left) {
				this.x--;
			}
		}
		
		this.lateral_boundaries();
			
	}

	
	
}
