package TankPack;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
/**
 * 网络连接的客户端类
 * @author ws
 *
 */
public class NetClient {
	
	private int udpPort;
	
	TankClient tc;
	
	DatagramSocket ds = null;

	public NetClient(TankClient tc) {
		this.tc = tc;
	}
	
	/**
	 * 连接服务器
	 * @param IP 服务器IP
	 * @param port 服务器端口
	 */
	public void connect(String IP, int tcpPort) {
		Socket s = null;
		try {
			ds = new DatagramSocket(udpPort);
			
			s = new Socket(IP, tcpPort);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(udpPort);  //传给服务器端 自身udp端口号
			DataInputStream dis = new DataInputStream(s.getInputStream());
			int id = dis.readInt();  //接收服务器分配的ID
			tc.myTank.id = id;
			System.out.println("The server gives me an ID:" + id);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();  //客户端 TCP端口关闭
					s = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		TankNewsMsg msg = new TankNewsMsg(tc.myTank);
		send(msg);
		
		new Thread(new UDPRecvThread()).start();
	}
	/**
	 * 发送消息
	 * @param msg 待发送的消息
	 */
	public void send(Msg msg) {
		msg.send(ds, "127.0.0.1", TankServer.UDP_PORT);
		
	}
	
	private class UDPRecvThread implements Runnable {
		byte[] buf = new byte[1024];
		public void run() {
			
			/*客户端 UDP端口一直监听*/
			while (ds != null) {
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				try {
					ds.receive(dp);
					parse(dp);
				} catch (IOException e) {
					e.printStackTrace();
				}
//				System.out.println("a package received from server!!");
			}
		}
		
		private void parse(DatagramPacket dp) {
			ByteArrayInputStream bais = new ByteArrayInputStream(buf, 0, buf.length);
			DataInputStream dis = new DataInputStream(bais);
			int msgType = 0;
			try {
				msgType = dis.readInt();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (msgType) {
			case Msg.TANK_NEW_MSG:
				new TankNewsMsg(tc).parse(dis);
				break;
			case Msg.TANK_MOVE_MSG:
				new TankMoveMsg(tc).parse(dis);
				break;
			case Msg.MISSILE_NEW_MSG:
				new MissileNewMsg(tc).parse(dis);
				break;
			case Msg.TANK_DEAD_MSG:
				new TankDeadMsg(tc).parse(dis);
			default:
				break;
			}
		}
		
	}

	public int getUdpPort() {
		return udpPort;
	}

	public void setUdpPort(int udpPort) {
		this.udpPort = udpPort;
	}
}









