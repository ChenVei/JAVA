package TankPack;
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
/**
 * 
 * ̹����
 *
 */
public class Tank {
	/**
	 * ̹���ٶ�
	 */
	public int SPEED = 5;
	/**
	 * ̹�˿�ȣ��߶�
	 */
	public static final int WIDTH = 30, HEIGHT = 30;
	
	int id;  //̹��id��
	
	int x, y;
	int oldX, oldY; // ��¼��һ��
	int life = 100; // ̹������ֵ
	BloodBar bb = new BloodBar();

	Dir dir; // ̹�˷���
	Dir ptDir = Dir.R; // ��Ͳ����
	TankClient tc;
	boolean U, D, L, R; // ���̼�¼ֵ��Ĭ��false
	boolean Q, E, BUG; // ������
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
		dir = Dir.STOP;
		if (!good) {
			dir = Dir.R; // ���Ǻ�̹�˳����Զ�����
		}
		this.tc = tc;
	}

	public Tank(TankClient tc, boolean good) {
		x = ran.nextInt(TankClient.GAME_WIDTH - 60) + 30;
		y = ran.nextInt(TankClient.GAME_HEIGHT - 60) + 30;
		dir = Dir.R;
		this.tc = tc;
		this.good = good;
	}

	public Tank(int x, int y, boolean good, TankClient tc, Dir dir, int id) {
		this.x = x;
		this.y = y;
		this.good = good;
		this.tc  =tc;
		this.dir = dir;
		this.id = id;
	}

	/**
	 * ̹�˵Ļ���
	 * @param g
	 */
	public void draw(Graphics g) {
		// ���˲���
		if (!live) {
			return;
		}

		Color c = g.getColor();
		if (good) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}
		
		//��ID
		g.drawString("ID:" + id, x, y + 50);
		
//		g.fillOval(x, y, WIDTH, HEIGHT);
//		g.setColor(c);

		// ��Ѫ��
		if (id >= 100) {
			bb.draw(g);
		}
		// ����Ͳ
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
	/**
	 * ̹�˵��ƶ�
	 */
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
		// ��̹�������
		if (!good && id < 100) {
			if (step == 0) {
				step = ran.nextInt(12) + 3;
				Dir[] dirs = Dir.values();
				int r = ran.nextInt(dirs.length);
				dir = dirs[r];
				if (dir != Dir.STOP) {
					ptDir = dir;
				}
			}
			step--;
			// ����ʱ��ǹ
			if (ran.nextInt(40) > 38) {
				fire();
			}
		}
		// ��������뿪��
		checkBUG();
		// ���߽�
		if (x < 0)
			x = 0;
		else if (x + WIDTH > TankClient.GAME_WIDTH)
			x = TankClient.GAME_WIDTH - WIDTH;
		if (y < 30)
			y = 30;
		else if (y + HEIGHT > TankClient.GAME_HEIGHT)
			y = TankClient.GAME_HEIGHT - HEIGHT;
	}

	/**
	 * ���������
	 * ���ٶȣ����ӵ���С
	 */
	public void checkBUG() {
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
	/**
	 * �ض�λ̹�˷���
	 */
	public void locateDir() {
		Dir oldDir = dir;
		
		if (U && !D && !L && !R) {
			dir = Dir.U;
		} else if (!U && D && !L && !R) {
			dir = Dir.D;
		} else if (!U && !D && L && !R) {
			dir = Dir.L;
		} else if (!U && !D && !L && R) {
			dir = Dir.R;
		} else if (U && !D && L && !R) {
			dir = Dir.LU;
		} else if (!U && D && L && !R) {
			dir = Dir.LD;
		} else if (U && !D && !L && R) {
			dir = Dir.RU;
		} else if (!U && D && !L && R) {
			dir = Dir.RD;
		} else
			dir = Dir.STOP;
		if (dir != Dir.STOP) {
			ptDir = dir;
		}
		
		if (dir != oldDir && tc.nc.ds != null) {
			tc.nc.send(new TankMoveMsg(this));
		}
	}
	/**
	 * ̹�˵İ�����Ӧ
	 * @param e
	 */
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
		// �����룬���ٶȡ���
		case KeyEvent.VK_Q:
			Q = true;
			break;
		case KeyEvent.VK_E:
			E = true;
			break;
		// �����룬����
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
		// �����룬���ٶȡ���
		case KeyEvent.VK_Q:
			Q = false;
			break;
		case KeyEvent.VK_E:
			E = false;
			break;
		// �����룬����
		case KeyEvent.VK_F2:
			life = 100;
			live = true;
			tc.nc.send(new TankNewsMsg(this));
			break;
		}
		locateDir();
	}
	
	/**
	 * ̹�˿���
	 */
	private void fire() {
		if (!live) {
			return; // ���˲���ǹ
		}
		int x = this.x + WIDTH / 2;
		int y = this.y + HEIGHT / 2;
		Missile mis = new Missile(id, x, y, good, ptDir, tc, BUG);
		tc.missiles.add(mis);
		
		if (tc.nc.ds != null) {
			tc.nc.send(new MissileNewMsg(mis));
		}
	}

	private void fire(Dir dir) {
		if (!live) {
			return; // ���˲���ǹ
		}
		int x = this.x + WIDTH / 2;
		int y = this.y + HEIGHT / 2;
		Missile mis = new Missile(id, x, y, good, dir, tc, BUG);
		tc.missiles.add(mis);
		
		if (tc.nc.ds != null) {
			tc.nc.send(new MissileNewMsg(mis));
		}
	}
	/**
	 * ̹�˳�������
	 */
	private void superFire() {
		Dir[] dirs = Dir.values();
		for (int i = 0; i < dirs.length - 1; i++) {
			fire(dirs[i]);
		}
	}
	/**
	 * ײǽ
	 * @param w ��ײ��ǽ
	 * @return ײ�Ϸ���true,����false
	 */
	public boolean collidesWithWall(Wall w) {
		if (getRect().intersects(w.getRect())) {
			stay();
			return true;
		}
		return false;
	}
	/**
	 * ײǽ��
	 * @param tanks ��ײ��ǽ��
	 * @return ײ�Ϸ���true,����false
	 */
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
	
	/**
	 * ԭ�ز���
	 */
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

	/**
	 * Ѫ��
	 * @author ws
	 * ����Ϊ�ڲ���
	 */
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
	/**
	 * ��Ѫ��
	 * @param b Ѫ��
	 * @return �Ե�����true,���򷵻�false
	 */
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
