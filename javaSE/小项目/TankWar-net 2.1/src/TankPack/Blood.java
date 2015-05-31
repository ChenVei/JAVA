package TankPack;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Ѫ��
 * @author ws
 *
 */
public class Blood {
	int x, y, w, h;
	boolean live = true;
	int step = 1;
	
	/**
	 * Ѫ����˶��켣
	 */
	int[][] pos = {
			{350, 300}, {360, 300}, {375, 275}, {400, 200}, {360, 270}, {365, 290}, {340, 280}
	};

	public Blood() {
		x = pos[0][0];
		y = pos[0][1];
		w = h = 15;
	}
	/**
	 * Ѫ��Ļ���
	 * @param g
	 */
	public void draw(Graphics g) {
		if (!live) {
			return;
		}
		Color c = g.getColor();
		g.setColor(Color.PINK);
		g.fillRect(x, y, w, h);
		g.setColor(c);
		move();
	}
	/**
	 * Ѫ���ƶ�
	 */
	private void move() {
		if (step == pos.length) {
			step = 0;
		}
		x = pos[step][0];
		y = pos[step][1];
		step++;
	}
	/**
	 * ���Ѫ�������
	 * @return
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}
}
