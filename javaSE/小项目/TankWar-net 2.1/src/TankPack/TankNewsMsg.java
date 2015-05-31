package TankPack;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 新增坦克消息类
 * @author ws
 *
 */
public class TankNewsMsg implements Msg {
	int msgType = Msg.TANK_NEW_MSG;
	
	Tank tank;
	TankClient tc;
	
	public TankNewsMsg(Tank tank) {
		this.tank = tank;
	}

	public TankNewsMsg(TankClient tc) {
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
				return;  //是自己则退出，否则是敌机
			}
			int x = dis.readInt();
			int y = dis.readInt();
			Dir dir = Dir.values()[dis.readInt()];
			boolean good = false;
			
			boolean exist = false;
			for (int i = 0; i < tc.tanks.size(); i++) {
				Tank t = tc.tanks.get(i);
				if (t.id == id) {
					exist = true;
					break;
				}
			}
			if (!exist) { //若是新来敌机
				TankNewsMsg tnMsg = new TankNewsMsg(tc.myTank);
				tc.nc.send(tnMsg); //通知新来敌机
				
				Tank t = new Tank(x, y, good, tc, dir, id);
				tc.tanks.add(t);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
