import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Tank {
	public static final int SPEED = 5;
	public static final int WIDTH = 30, HEIGHT = 30;

	enum Direction {
		U, D, L, R, LU, LD, RU, RD, STOP
	};

	int x, y;
	Direction dir;	 //坦克方向
	Direction ptDir = Direction.R; //炮筒方向
	TankClient tc;
	boolean U, D, L, R; // 键盘记录值，默认false
	boolean good = true;
	private boolean live = true;

	Random ran = new Random();
	
	int step = ran.nextInt(12) + 3;
	
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

		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);

		// 画炮筒
		switch (ptDir) {
		case U:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y);
			break;
		case D:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y + HEIGHT);
			break;
		case L:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y + HEIGHT / 2);
			break;
		case R:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y + HEIGHT / 2);
			break;
		case LU:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y);
			break;
		case LD:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y + HEIGHT);
			break;
		case RU:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y);
			break;
		case RD:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y + HEIGHT);
			break;
		}
		move();
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
		case STOP:
			break;
		}
		//坏坦克随机走
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
			//不定时开枪
			if (ran.nextInt(40) > 38) {
				fire();
			}
		}
		
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
		}
		locateDir();
	}

	private void fire() {
		if (!live) { 
			return;  //死了不开枪
		}
		int x = this.x + WIDTH / 2;
		int y = this.y + HEIGHT / 2;
		tc.missiles.add(new Missile(x, y, good, ptDir, tc));
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
