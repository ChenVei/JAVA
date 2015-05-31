package TankPack;

import java.io.DataInputStream;
import java.net.DatagramSocket;
/**
 * 信息接口
 * @author ws
 *
 */
public interface Msg {
	/**
	 * 坦克产生的消息
	 */
	public static final int TANK_NEW_MSG = 1;
	/**
	 * 坦克移动的消息
	 */
	public static final int TANK_MOVE_MSG = 2;
	/**
	 * 子弹产生的消息
	 */
	public static final int MISSILE_NEW_MSG = 3;
	/**
	 * 坦克死掉的消息
	 */
	public static final int TANK_DEAD_MSG = 4;
	/**
	 * 发送数据
	 * @param ds
	 * @param string
	 * @param udpPort
	 */
	public void send(DatagramSocket ds, String string, int udpPort);
	/**
	 * 接收并处理数据
	 * @param dis
	 */
	public void parse(DataInputStream dis);
}
