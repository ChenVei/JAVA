package TankPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.List;

/**
 * 子弹类
 * 
 * @author ws
 *
 */
public class Missile {
	/**
	 * 子弹的速度
	 */
	public int SPEED = 10;
	/**
	 * 子弹的宽度
	 */
	public int WIDTH = 8;
	/**
	 * 子弹的高度
	 */
	public int HEIGHT = 8;
	/**
	 * 发射子弹的坦克ID
	 */
	int tankID;
	
	int x, y;
	Dir dir;
	TankClient tc;
	boolean good = true;
	boolean BUG;
	private boolean live = true;

	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Image img = tk.getImage(Explode.class.getClassLoader().getResource(
			"images/mis.gif"));
	/**
	 * 
	 * @param tankID 所属坦克的id号(用于网络版)
	 * @param x 子弹产生的x坐标
	 * @param y 子弹产生的y坐标
	 * @param good 子弹的立场是好还是坏
	 * @param dir 子弹的方向
	 * @param tc 坦克主战场
	 * @param BUG 是否开BUG
	 * @see Dir
	 */
	public Missile(int tankID, int x, int y, boolean good, Dir dir,
			TankClient tc, boolean BUG) {
		this.tankID = tankID;
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
		this.tc = tc;
		this.BUG = BUG;
	}

	/**
	 * 子弹的绘图
	 * 
	 * @param g 画笔
	 * @return
	 */
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

	/**
	 * 子弹移动
	 */
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

	/**
	 * 是否开挂
	 */
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

	/**
	 * 子弹是否击中坦克
	 * 
	 * @param t 坦克
	 * @return 击中返回true
	 */
	public boolean hitTank(Tank t) {
		if ((this.good != t.good || t.id != this.tankID)
				&& t.getRect().intersects(this.getRect()) && t.isLive()) {
			if (t.id >= 100) {
				t.setLife(t.getLife() - 20);
				if (t.getLife() <= 0) {
					t.setLive(false);
				}
			} else
				t.setLive(false);

			this.setLive(false);

			tc.explodes.add(new Explode(x, y, tc));
			if (!t.isLive()) {
				tc.tanks.remove(t); // 移坦克
			}
			tc.missiles.remove(this); // 移子弹
			return true;
		}
		return false;
	}

	/**
	 * 子弹是否击中坦克集
	 * 
	 * @param tanks　坦克集
	 * @return 击中返回true
	 */
	public boolean hitTanks(List<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			if (hitTank(tanks.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 子弹是否击中墙
	 * 
	 * @param w 墙
	 * @return 击中返回true
	 */
	public boolean hitWall(Wall w) {
		if (getRect().intersects(w.getRect())) {
			live = false;
			return false;
		}
		return true;
	}

	/**
	 * 获得子弹区域
	 * 
	 * @return 返回子弹区域
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	/**
	 * 检测子弹是否存活
	 * 
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * 设置子弹存活
	 * 
	 * @param live 是否存活
	 * @return
	 */
	public void setLive(boolean live) {
		this.live = live;
	}

}
