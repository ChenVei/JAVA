import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Missile {
	public static final int SPEED = 10;
	public static final int WIDTH = 5, HEIGHT = 5;

	int x, y;
	Tank.Direction dir;
	TankClient tc;
	boolean good = true;
	private boolean live = true;

	public Missile(int x, int y, boolean good, Tank.Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
		this.tc = tc;
	}

	public void draw(Graphics g) {
		// 死了不画
		if (!live) {
			return;
		}
		move();
		g.fillOval(x, y, WIDTH, HEIGHT);
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
	}

	public boolean hitTank(Tank t) {
		if (this.good != t.good && t.getRect().intersects(this.getRect()) && t.isLive()) {
			t.setLive(false);
			this.setLive(false);
			
			tc.explodes.add(new Explode(x, y, tc));
			tc.tanks.remove(t);  //移坦克
			tc.missiles.remove(this);  //移子弹
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
