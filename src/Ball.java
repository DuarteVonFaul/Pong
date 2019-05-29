import java.util.Random;

public class Ball extends Characters{
	
	double speed = 1.2;
	double dx, dy;
	Random  random = new Random();
	
	public Ball() {
		System.out.println("Bola instanciada");
		this.position();
		this.width = 4;
		this.height = 4;
		this.a = 220;
		this.b = 220;
		this.c = 220;
	}

	@Override
	public void mecanic() {
		//movimentação
		this.x += dx * speed;
		this.y += dy * speed;
		//Colisão com os personagens
		if(this.y <= Game.enemy.y + 5 && (this.x + width > Game.enemy.x && this.x < Game.enemy.x + Game.enemy.width)) {
			this.dy *= -1;
		}else {
			if(this.y - 2 >= Game.player.y - 5 && (this.x + width > Game.player.x && this.x < Game.player.x + Game.player.width)) {
				this.dy *= -1;
			}
		}
		
		//Colisão com as paredes
		if(this.x + this.width >= Game.WIDTH) {
			this.dx *= -1;
		}else {
			if(this.x <= 0) {
				this.dx *= -1;
			}
		}
		
		//pontuação
		if(this.y < 0) {
			Game.player_score ++;
			this.position();
		}else {
			if(this.y > Game.HEIGHT - this.height) {
				Game.enemy_score ++;
				this.position();
				
			}
		}
		
		
	}
	
	
	
	
	
	public void position() {
		this.x = (Game.WIDTH - 4)/2;
		this.y = 45;
		this.dx = random.nextDouble()*2 - 1;
		this.dy = random.nextDouble()*2 - 1;
	}
}
