package TankPack;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 坦克移动消息类
 * @author ws
 *
 */
public class TankMoveMsg implements Msg {
	int msgType = Msg.TANK_MOVE_MSG;
	
	TankClient tc;
	Tank tank;
	
	TankMoveMsg(Tank t) {
		this.tank = t;
	}

	TankMoveMsg(TankClient tc) {
		this.tc = tc;
	}

	public void send(DatagramSocket ds, String string, int udpPort) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(msgType);
			dos.writeInt(tank.id);
			dos.writeInt(tank.x);
			dos.writeInt(tank.y);
			dos.writeInt(tank.dir.ordinal());
			dos.writeInt(tank.ptDir.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buf;
		buf = baos.toByteArray();  //将数据打包
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
			int id = dis.readInt();
			if (id == tc.myTank.id) {
				return;
			}
			int x = dis.readInt();
			int y = dis.readInt();
			Dir dir = Dir.values()[dis.readInt()];
			Dir ptDir = Dir.values()[dis.readInt()];
			for (int i = 0; i < tc.tanks.size(); i++) {
				Tank t = tc.tanks.get(i);
				if (t.id == id) {
					t.x = x;
					t.y = y;
					t.dir = dir;
					t.ptDir = ptDir;
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
