
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2649810867385413194L;
	public static int WIDTH = 140;
	public static int HEIGHT = 90;
	public static int SCALE = 3;
	public static int player_score;
	public static int enemy_score;
	
	public BufferedImage Layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
	
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	
	public Game() {
		
		this.setPreferredSize(new Dimension(WIDTH * SCALE ,HEIGHT * SCALE));
		this.addKeyListener(this);
		player = new Player((WIDTH - 20)/2, HEIGHT - 2);
		enemy = new Enemy((WIDTH - 20)/2, -3);
		ball = new Ball();
		
	}

	
	public static void main (String[] args) {
		
		Game game = new Game();
		
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		
		new Thread(game).start();
		
		
	}
	
	
	
	public void update() {
		
		player.mecanic();
		enemy.mecanic();
		ball.mecanic();
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = Layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGHT);
		enemy.render(g);
		ball.render(g);
		player.render(g);
		
		g =  bs.getDrawGraphics();
		g.drawImage(Layer,0,0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		
		bs.show();
	}
	
	
	@Override
	public void run() {
		while(true) {
			update();
			render();
			//Faz rodar a 60 frames por segundo....
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}


	
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = true;
			
		}else {
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				 player.left = true;	
		
			}
		}
		
	}


	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = false;
			
		}else {
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.left = false;
				
			}
			
		}
		
		
		
	}


	
	public void keyTyped(KeyEvent e) {
		
		
	}
	
}