package TankPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.List;

/**
 * �ӵ���
 * 
 * @author ws
 *
 */
public class Missile {
	/**
	 * �ӵ����ٶ�
	 */
	public int SPEED = 10;
	/**
	 * �ӵ��Ŀ��
	 */
	public int WIDTH = 8;
	/**
	 * �ӵ��ĸ߶�
	 */
	public int HEIGHT = 8;
	/**
	 * �����ӵ���̹��ID
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
	 * @param tankID ����̹�˵�id��(���������)
	 * @param x �ӵ�������x����
	 * @param y �ӵ�������y����
	 * @param good �ӵ��������Ǻû��ǻ�
	 * @param dir �ӵ��ķ���
	 * @param tc ̹����ս��
	 * @param BUG �Ƿ�BUG
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
	 * �ӵ��Ļ�ͼ
	 * 
	 * @param g ����
	 * @return
	 */
	public void draw(Graphics g) {
		// ���˲���
		if (!live) {
			tc.missiles.remove(this);
			return;
		}
		move();
		Color c = g.getColor();
		// �ӵ���ɫ
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
	 * �ӵ��ƶ�
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
	 * �Ƿ񿪹�
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
	 * �ӵ��Ƿ����̹��
	 * 
	 * @param t ̹��
	 * @return ���з���true
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
				tc.tanks.remove(t); // ��̹��
			}
			tc.missiles.remove(this); // ���ӵ�
			return true;
		}
		return false;
	}

	/**
	 * �ӵ��Ƿ����̹�˼�
	 * 
	 * @param tanks��̹�˼�
	 * @return ���з���true
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
	 * �ӵ��Ƿ����ǽ
	 * 
	 * @param w ǽ
	 * @return ���з���true
	 */
	public boolean hitWall(Wall w) {
		if (getRect().intersects(w.getRect())) {
			live = false;
			return false;
		}
		return true;
	}

	/**
	 * ����ӵ�����
	 * 
	 * @return �����ӵ�����
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	/**
	 * ����ӵ��Ƿ���
	 * 
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * �����ӵ����
	 * 
	 * @param live �Ƿ���
	 * @return
	 */
	public void setLive(boolean live) {
		this.live = live;
	}

}
