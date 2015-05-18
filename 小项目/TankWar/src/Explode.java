import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Explode {
	int x, y;
	TankClient tc;
	private boolean live = true;
	
	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img = tk.getImage(Explode.class.getClassLoader().getResource("images/explode.gif"));
	
	int[] diameter = {4,7,12,18,26,32,49,30,14,6};
	
	int step = 0;
	public void draw(Graphics g) {
		if (!live) {
			tc.explodes.remove(this);
			return;
		}
		
		if (step == 35) {  //35
			step = 0;
			live = false;
			return;
		}
		
		g.drawImage(img, x - 10, y - 25 ,50,50, null);
//		Color c = g.getColor();
//		g.setColor(Color.orange);
//		g.fillOval(x, y, diameter[step], diameter[step]);
//		g.setColor(c);
		step++;
	}
}
