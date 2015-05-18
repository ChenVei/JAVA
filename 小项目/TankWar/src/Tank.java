import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Tank {
	public int SPEED = 5;
	public static final int WIDTH = 30, HEIGHT = 30;

	enum Direction {
		U, D, L, R, LU, LD, RU, RD, STOP
	};

	int x, y;
	int oldX, oldY; // 记录上一步
	int life = 100; // 坦克生命值
	BloodBar bb = new BloodBar();

	Direction dir; // 坦克方向
	Direction ptDir = Direction.R; // 炮筒方向
	TankClient tc;
	boolean U, D, L, R; // 键盘记录值，默认false
	boolean Q, E, BUG; // 作弊码
	boolean good = true;
	private boolean live = true;

	Random ran = new Random();

	int step = ran.nextInt(12) + 3;

	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Image[] TankImages = null;
	private static Map<String, Image> imgs = new HashMap<String, Image>();
	
	static {
		TankImages = new Image[] {
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/U.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/D.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/L.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/R.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/RD.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/RU.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/LU.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"images/LD.gif")), };
		imgs.put("U", TankImages[0]);
		imgs.put("D", TankImages[1]);
		imgs.put("L", TankImages[2]);
		imgs.put("R", TankImages[3]);
		imgs.put("RU", TankImages[4]);
		imgs.put("RD", TankImages[5]);
		imgs.put("LU", TankImages[6]);
		imgs.put("LD", TankImages[7]);
	}

	public Tank(TankClient tc) {
		x = ran.nextInt(TankClient.GAME_WIDTH - 60) + 30;
		y = ran.nextInt(TankClient.GAME_HEIGHT - 60) + 30;
		dir = Direction.STOP;
		if (!good) {
			dir = Direction.R; // 不是好坦克出发自动向右
		}
		this.tc = tc;
	}

	public Tank(TankClient tc, boolean good) {
		x = ran.nextInt(TankClient.GAME_WIDTH - 60) + 30;
		y = ran.nextInt(TankClient.GAME_HEIGHT - 60) + 30;
		dir = Direction.R;
		this.tc = tc;
		this.good = good;
	}

	// 画坦克
	public void draw(Graphics g) {
		// 死了不画
		if (!live) {
			return;
		}

		Color c = g.getColor();
		if (good) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}

//		g.fillOval(x, y, WIDTH, HEIGHT);
//		g.setColor(c);

		// 画血槽
		if (good) {
			bb.draw(g);
		}
		// 画炮筒
		switch (ptDir) {
		case U:
			g.drawImage(imgs.get("U"), x, y, WIDTH, HEIGHT, null);
			break;
		case D:
			g.drawImage(imgs.get("D"), x, y, WIDTH, HEIGHT, null);
			break;
		case L:
			g.drawImage(imgs.get("L"), x, y, WIDTH, HEIGHT, null);
			break;
		case R:
			g.drawImage(imgs.get("R"), x, y, WIDTH, HEIGHT, null);
			break;
		case LU:
			g.drawImage(imgs.get("LU"), x, y, 42,42, null);
			break;
		case LD:
			g.drawImage(imgs.get("LD"), x, y, 42,42, null);
			break;
		case RU:
			g.drawImage(imgs.get("RU"), x, y, 42,42, null);
			break;
		case RD:
			g.drawImage(imgs.get("RD"), x, y, 42,42, null);
			break;
		}
		move();
	}

	private void move() {
		oldX = x;
		oldY = y;

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
		case STOP:
			break;
		}
		// 坏坦克随机走
		if (!good) {
			if (step == 0) {
				step = ran.nextInt(12) + 3;
				Direction[] dirs = Direction.values();
				int r = ran.nextInt(dirs.length);
				dir = dirs[r];
				if (dir != Direction.STOP) {
					ptDir = dir;
				}
			}
			step--;
			// 不定时开枪
			if (ran.nextInt(40) > 38) {
				fire();
			}
		}
		// 检查作弊码开启
		checkBUG();
		// 检查边界
		if (x < 0)
			x = 0;
		else if (x + WIDTH > TankClient.GAME_WIDTH)
			x = TankClient.GAME_WIDTH - WIDTH;
		if (y < 30)
			y = 30;
		else if (y + HEIGHT > TankClient.GAME_HEIGHT)
			y = TankClient.GAME_HEIGHT - HEIGHT;
	}

	public void checkBUG() {
		// 作弊码，调速度，调子弹大小。。
		if (Q && E) {
			if (!BUG) {
				SPEED = 10;
				BUG = true;
			} else {
				BUG = false;
				SPEED = 5;
			}
		}
	}

	public void locateDir() {
		if (U && !D && !L && !R) {
			dir = Direction.U;
		} else if (!U && D && !L && !R) {
			dir = Direction.D;
		} else if (!U && !D && L && !R) {
			dir = Direction.L;
		} else if (!U && !D && !L && R) {
			dir = Direction.R;
		} else if (U && !D && L && !R) {
			dir = Direction.LU;
		} else if (!U && D && L && !R) {
			dir = Direction.LD;
		} else if (U && !D && !L && R) {
			dir = Direction.RU;
		} else if (!U && D && !L && R) {
			dir = Direction.RD;
		} else
			dir = Direction.STOP;
		if (dir != Direction.STOP) {
			ptDir = dir;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			U = true;
			break;
		case KeyEvent.VK_DOWN:
			D = true;
			break;
		case KeyEvent.VK_LEFT:
			L = true;
			break;
		case KeyEvent.VK_RIGHT:
			R = true;
			break;
		// 作弊码，调速度。。
		case KeyEvent.VK_Q:
			Q = true;
			break;
		case KeyEvent.VK_E:
			E = true;
			break;
		// 作弊码，大招
		case KeyEvent.VK_A:
			superFire();
		}
		locateDir();
	}

	public void KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			U = false;
			break;
		case KeyEvent.VK_DOWN:
			D = false;
			break;
		case KeyEvent.VK_LEFT:
			L = false;
			break;
		case KeyEvent.VK_RIGHT:
			R = false;
			break;
		case KeyEvent.VK_CONTROL:
			fire();
			break;
		// 作弊码，调速度。。
		case KeyEvent.VK_Q:
			Q = false;
			break;
		case KeyEvent.VK_E:
			E = false;
			break;
		// 作弊码，复活
		case KeyEvent.VK_F2:
			life = 100;
			live = true;
			break;
		}
		locateDir();
	}

	private void fire() {
		if (!live) {
			return; // 死了不开枪
		}
		int x = this.x + WIDTH / 2;
		int y = this.y + HEIGHT / 2;
		tc.missiles.add(new Missile(x, y, good, ptDir, tc, BUG));
	}

	private void fire(Direction dir) {
		if (!live) {
			return; // 死了不开枪
		}
		int x = this.x + WIDTH / 2;
		int y = this.y + HEIGHT / 2;
		tc.missiles.add(new Missile(x, y, good, dir, tc, BUG));
	}

	private void superFire() {
		Direction[] dirs = Direction.values();
		for (int i = 0; i < dirs.length - 1; i++) {
			fire(dirs[i]);
		}
	}

	public boolean collidesWithWall(Wall w) {
		if (getRect().intersects(w.getRect())) {
			stay();
			return true;
		}
		return false;
	}

	public boolean collidesWithTanks(List<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			Tank t = tanks.get(i);
			if (t != this && this.getRect().intersects(t.getRect())) {
				t.stay();
				this.stay();
				return true;
			}
		}
		return false;
	}

	public void stay() {
		x = oldX;
		y = oldY;
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

	// 血条，内部类
	class BloodBar {
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.fillRect(x, y - 20, WIDTH * life / 100, 10);
			g.setColor(Color.black);
			g.drawRect(x, y - 20, WIDTH, 10);
			g.setColor(c);
		}
	}

	public boolean eat(Blood b) {
		if (good && getRect().intersects(b.getRect())) {
			b.live = false;
			this.life = 100;
			return true;
		}
		return false;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
