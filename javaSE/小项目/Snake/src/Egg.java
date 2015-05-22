import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Egg {
	int row, col;
	int w = Yard.BLOCKSIZE;
	int h = Yard.BLOCKSIZE;
	private static Random r = new Random();
	private Color color = Color.YELLOW;
	
	public Egg(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public Egg() {
		this(r.nextInt(Yard.ROWS - 2) + 2, r.nextInt(Yard.COLS));
	}
	
	public void reAppear() {
		this.row = r.nextInt(Yard.ROWS - 2) + 2;
		this.col = r.nextInt(Yard.COLS);
	}
	
	public Rectangle getRect() {
		return new Rectangle(Yard.BLOCKSIZE * col, Yard.BLOCKSIZE * row, w, h);
	}
	
	void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(Yard.BLOCKSIZE * col, Yard.BLOCKSIZE * row, w, h);
		g.setColor(c);
		if (color == color.YELLOW) {
			color = color.RED;
		}else color = Color.YELLOW;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}

	
	
}
