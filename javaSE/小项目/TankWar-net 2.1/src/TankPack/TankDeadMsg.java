package TankPack;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
/**
 * 坦克死亡消息类
 * @author ws
 *
 */
public class TankDeadMsg implements Msg {

	int msgType = Msg.TANK_DEAD_MSG;

	TankClient tc;
	int id;

	TankDeadMsg(TankClient tc) {
		this.tc = tc;
	}

	TankDeadMsg(int id) {
		this.id = id;
	}

	public void send(DatagramSocket ds, String string, int udpPort) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(msgType);
			dos.writeInt(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buf;
		buf = baos.toByteArray(); // 将数据打包
		DatagramPacket dp = new DatagramPacket(buf, buf.length,
				new InetSocketAddress("127.0.0.1", TankServer.UDP_PORT));
		try {
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parse(DataInputStream dis) {
		DataOutputStream dos;
		Socket s = null;
		try {
			int id = dis.readInt();
			
			s = new Socket("127.0.0.1", TankServer.TCP_PORT_OUT);
			dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(id);
			
			if (id == tc.myTank.id) {
				return; // 是自己则退出，否则是敌机
			}
			
			for (int i = 0; i < tc.tanks.size(); i++) {
				Tank t = tc.tanks.get(i);
				if (t.id == id) {
					tc.tanks.remove(i);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
