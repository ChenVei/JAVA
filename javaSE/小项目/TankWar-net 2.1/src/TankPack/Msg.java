package TankPack;

import java.io.DataInputStream;
import java.net.DatagramSocket;
/**
 * ��Ϣ�ӿ�
 * @author ws
 *
 */
public interface Msg {
	/**
	 * ̹�˲�������Ϣ
	 */
	public static final int TANK_NEW_MSG = 1;
	/**
	 * ̹���ƶ�����Ϣ
	 */
	public static final int TANK_MOVE_MSG = 2;
	/**
	 * �ӵ���������Ϣ
	 */
	public static final int MISSILE_NEW_MSG = 3;
	/**
	 * ̹����������Ϣ
	 */
	public static final int TANK_DEAD_MSG = 4;
	/**
	 * ��������
	 * @param ds
	 * @param string
	 * @param udpPort
	 */
	public void send(DatagramSocket ds, String string, int udpPort);
	/**
	 * ���ղ���������
	 * @param dis
	 */
	public void parse(DataInputStream dis);
}
