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
			tanks.add(new Tank(this,false));
		}
		//��ʼ���Լ�
		myTank = new Tank(this);
		
		setTitle("TankWar");
		setBounds(250, 100, GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setBackground(Color.GREEN);
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

	public void paint (Graphics g) {
		//��ʾ
		g.drawString("Missiles C:"+missiles.size(), 30,50);
		g.drawString("Enemy Tank:"+tanks.size(), 30, 70);
		g.drawString("Explodes:"+explodes.size(), 30, 90);
		
		//��̹��
		myTank.draw(g);
		for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).draw(g);
		}
		//����ը
		for (int i = 0; i < explodes.size(); i++) {
			explodes.get(i).draw(g);
		}
		
		//��Ϊ�ػ�̫�죬size()�ı仯Ҳ��Ҫ��
		for (int i = 0; i < missiles.size(); i++) {
			Missile mis = missiles.get(i);
			mis.hitTanks(tanks);
			mis.hitTank(myTank);  //�ӵ����Լ�
			mis.draw(g);
			//�жϳ���
			if (mis.x < 0 || mis.y < 0 || mis.x > TankClient.GAME_WIDTH || mis.y > TankClient.GAME_HEIGHT) {
				missiles.remove(mis);
			}
		}
	}
	
	public class KeyMonitor extends KeyAdapter{

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			myTank.KeyReleased(e);
		}
	}
}



