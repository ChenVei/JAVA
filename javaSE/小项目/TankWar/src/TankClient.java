import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TankClient extends Frame {
	public static final int GAME_WIDTH = 800, GAME_HEIGHT = 500;

	Tank myTank;
	Wall w1 = new Wall(100, 100, 30, 200);
	Wall w2 = new Wall(600, 100, 30, 200);
	Blood b = new Blood();

	List<Missile> missiles = new ArrayList<Missile>();
	List<Tank> tanks = new ArrayList<>();
	List<Explode> explodes = new ArrayList<>();

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.launchFrame();

	}

	private void launchFrame() {
		//��ʼ���л�
		for (int i = 0; i < 10; i++) {
			//��ֹǶǽ
			Tank t = new Tank(this,false);
			//��ֹ�л���Ƕ
			boolean loop = true;
			while (loop || t.getRect().intersects(w1.getRect()) || t.getRect().intersects(w2.getRect())) {
				t = new Tank(this,false);
				int j = 0;
				for ( ; j < tanks.size(); j++) {
					Tank et = tanks.get(j);
					if (t.getRect().intersects(et.getRect())) 
						break;
				}
				if (j == tanks.size()) {
					loop = false;
				}
			}
			tanks.add(t);
		}
		//��ʼ���Լ�
		myTank = new Tank(this);
		//��ֹǶǽ
		while (myTank.getRect().intersects(w1.getRect()) || myTank.getRect().intersects(w2.getRect())) {
			myTank = new Tank(this);
		}
		
		setTitle("TankWar");
		setBounds(250, 100, GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new KeyMonitor());
		new Thread(new PaintThread()).start();
	}

	public class PaintThread implements Runnable {

		public void run() {
			while (true) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		}
	}

	Image im;
	Graphics gra;

	public void update(Graphics g) {
		if (im == null) {
			im = this.createImage(getWidth(), getHeight());
			gra = im.getGraphics();
		}
		gra.clearRect(0, 0, getWidth(), getHeight());
		paint(gra);
		g.drawImage(im, 0, 0, null);
	}

	public void paint(Graphics g) {
		// ��ʾ
		g.drawString("Missiles C:" + missiles.size(), 30, 50);
		g.drawString("Enemy Tank:" + tanks.size(), 30, 70);
		g.drawString("Explodes:" + explodes.size(), 30, 90);

		// �Զ����ӵл�
		if (tanks.size() == 0) {
			for (int i = 0; i < 10; i++) {
				//��ֹǶǽ
				Tank t = new Tank(this,false);
				boolean loop = true;
				while (loop || t.getRect().intersects(w1.getRect()) || t.getRect().intersects(w2.getRect())) {
					t = new Tank(this,false);
					int j = 0;
					for ( ; j < tanks.size(); j++) {
						Tank et = tanks.get(j);
						if (t.getRect().intersects(et.getRect())) 
							break;
					}
					if (j == tanks.size()) {
						loop = false;
					}
				}
				tanks.add(t);
			}
		}
		// ��̹��
		myTank.draw(g);
		for (int i = 0; i < tanks.size(); i++) {
			Tank t = tanks.get(i);
			// ײǽ
			myTank.collidesWithWall(w1);
			myTank.collidesWithWall(w2);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			// ײ̹��
			t.collidesWithTanks(tanks);
			myTank.collidesWithTanks(tanks);
			t.draw(g);
		}
		// ����ը
		for (int i = 0; i < explodes.size(); i++) {
			explodes.get(i).draw(g);
		}

		// ��Ϊ�ػ�̫�죬size()�ı仯Ҳ��Ҫ��
		// ���ӵ�
		for (int i = 0; i < missiles.size(); i++) {
			Missile mis = missiles.get(i);
			mis.hitTanks(tanks);
			mis.hitTank(myTank); // �ӵ����Լ�
			mis.hitWall(w1); // �ӵ���ǽ
			mis.hitWall(w2);
			mis.draw(g);
			// �жϳ���
			if (mis.x < 0 || mis.y < 0 || mis.x > TankClient.GAME_WIDTH
					|| mis.y > TankClient.GAME_HEIGHT) {
				missiles.remove(mis);
			}
		}
		// ��ǽ
		w1.draw(g);
		w2.draw(g);
		// ��ҩ��
		b.draw(g);
		myTank.eat(b);
	}

	public class KeyMonitor extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			myTank.KeyReleased(e);
		}
	}
}
