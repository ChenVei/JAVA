import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
	
	PaintThread paintThread = new PaintThread();
	private boolean gameOver = false;
	public static final int ROWS = 30, COLS = 30, BLOCKSIZE = 15;
	
	private int score = 0;
	
	Snake s = new Snake(this);
	Egg e = new Egg();
	Image offScreenImage = null;
	private Font fontGameOver = new Font("华文彩云", Font.BOLD, 50);
	
	public void launch() {
		this.setLocation(100, 100);
		this.setSize(COLS * BLOCKSIZE, ROWS * BLOCKSIZE);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
		});
		this.setVisible(true);
		this.addKeyListener(new KeyMonitor());

		new Thread(paintThread).start();
	}
	
	@Override
	public void paint(Graphics g) {
		
		Color c=g.getColor();
		g.setColor(Color.gray);
		//set background color
		g.fillRect(0, 0, COLS * BLOCKSIZE, ROWS * BLOCKSIZE);
		g.setColor(Color.BLACK);
		//draw lines
		for (int i = 0; i < ROWS-1; i++) {
			g.drawLine(0, BLOCKSIZE * i, COLS * BLOCKSIZE, BLOCKSIZE * i);
		}
		for (int i = 0; i < COLS-1; i++) {
			g.drawLine(BLOCKSIZE * i, 0, BLOCKSIZE * i, ROWS * BLOCKSIZE);
		}
		
		g.setColor(Color.yellow);
		g.drawString("SCORE:"+score,10,60);
		
		if (gameOver) {
			g.setFont(fontGameOver);
			g.drawString("Game Over", 30, 180);
			paintThread.gameOver();
		}
		
		g.setColor(c);
		
		s.eat(e);
		e.draw(g);
		s.draw(g);
		
		
	}

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(COLS * BLOCKSIZE, ROWS * BLOCKSIZE);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	public static void main(String[] args) {
		 new Yard().launch();
	}
	
	public void stop() {
		gameOver = true;
	}
	
	private class PaintThread implements Runnable {
		private boolean running = true;
		public void run() {
			while (running) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		public void gameOver() {
			running = false;
		}
	}

	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			s.keyPressed(e);
		} 
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
