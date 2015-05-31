package TankPack;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * ǽ��
 * @author ws
 *
 */
public class Wall {
	int x, y, w, h;

	public Wall(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	/**
	 * ǽ�Ļ���
	 * @param g
	 */
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillRect(x, y, w, h);
		g.setColor(c);
	}
	/**
	 * ���ǽ������
	 * @return
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}
}
