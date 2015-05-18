import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.List;

public class Missile {
	public int SPEED = 10;
	public int WIDTH = 8, HEIGHT = 8;

	int x, y;
	Tank.Direction dir;
	TankClient tc;
	boolean good = true;
	boolean BUG;
	private boolean live = true;

	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Image img = tk.getImage(Explode.class.getClassLoader().getResource(
			"images/mis.gif"));

	public Missile(int x, int y, boolean good, Tank.Direction dir,
			TankClient tc, boolean BUG) {
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
		this.tc = tc;
		this.BUG = BUG;
	}

	public void draw(Graphics g) {
		// 死了不画
		if (!live) {
			tc.missiles.remove(this);
			return;
		}
		move();
		Color c = g.getColor();
		// 子弹变色
		if (BUG) {
			g.setColor(Color.RED);
		}
		// else {
		// g.setColor(Color.yellow);
		// }
		if (!good) {
			g.setColor(Color.white);
			g.fillOval(x, y, WIDTH, HEIGHT);
		} else
			g.drawImage(img, x, y, 20, 20, null);
		g.setColor(c);
	}

	private void move() {
		switch (dir) {
		case U:
			y -= SPEED;
			break;
		case D:
			y += SPEED;
			break;
		case L:
			x -= SPEED;
			break;
		case R:
			x += SPEED;
			break;
		case LU:
			x -= SPEED;
			y -= SPEED;
			break;
		case LD:
			x -= SPEED;
			y += SPEED;
			break;
		case RU:
			x += SPEED;
			y -= SPEED;
			break;
		case RD:
			x += SPEED;
			y += SPEED;
			break;
		}
		checkBUG();
	}

	private void checkBUG() {
		if (BUG) {
			SPEED = 20;
			WIDTH = 20;
			HEIGHT = 20;
		}
		if (!BUG) {
			SPEED = 10;
			WIDTH = 8;
			HEIGHT = 8;
		}
	}

	public boolean hitTank(Tank t) {
		if (this.good != t.good && t.getRect().intersects(this.getRect())
				&& t.isLive()) {
			if (t.good) {
				t.setLife(t.getLife() - 20);
				if (t.getLife() <= 0) {
					t.setLive(false);
				}
			} else
				t.setLive(false);
			this.setLive(false);

			tc.explodes.add(new Explode(x, y, tc));
			tc.tanks.remove(t); // 移坦克
			tc.missiles.remove(this); // 移子弹
			return true;
		}
		return false;
	}

	public boolean hitTanks(List<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			if (hitTank(tanks.get(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean hitWall(Wall w) {
		if (getRect().intersects(w.getRect())) {
			live = false;
			return false;
		}
		return true;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
