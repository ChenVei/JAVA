package TankPack;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 子弹产生消息类
 * @author ws
 *
 */
public class MissileNewMsg implements Msg {
	int msgType = Msg.MISSILE_NEW_MSG;

	TankClient tc;
	Missile mis;

	MissileNewMsg(Missile mis) {
		this.mis = mis;
	}

	MissileNewMsg(TankClient tc) {
		this.tc = tc;
	}

	public void send(DatagramSocket ds, String string, int udpPort) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(msgType);
			dos.writeInt(mis.tankID);
			dos.writeInt(mis.x);
			dos.writeInt(mis.y);
			dos.writeInt(mis.dir.ordinal());
			dos.writeBoolean(mis.BUG);
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
		try {
			int tankID = dis.readInt();
			if (tankID == tc.myTank.id) {
				return;
			}
			int x = dis.readInt();
			int y = dis.readInt();
			Dir dir = Dir.values()[dis.readInt()];
			boolean good = false;
			boolean BUG = dis.readBoolean();
			Missile m = new Missile(tankID, x, y, good, dir, tc, BUG);
			tc.missiles.add(m);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
