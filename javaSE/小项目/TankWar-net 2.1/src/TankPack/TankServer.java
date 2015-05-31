package TankPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
/**
 * 坦克游戏服务器端
 * @author ws
 *
 */
public class TankServer {
	/**
	 * 分配给客户端的ID
	 */
	private static int ID = 100;  
	/**
	 * 自己的TCP端口号，接收连入客户端
	 */
	public static final int TCP_PORT = 8888;
	/**
	 * 自己的TCP端口号，接收断开客户端
	 */
	public static final int TCP_PORT_OUT = 7777;
	/**
	 * 自己的UDP端口号
	 */
	public static final int UDP_PORT = 6666; 
	/**
	 * 坦克集
	 */
	List<Client> clients = new ArrayList<Client>();
	/**
	 * 客户端窗体
	 */
	ServerFrame window = new ServerFrame();
	
	/*tcp协议 用来接收udp端口号*/
	public void start() {
		
		new Thread(new UDPThread()).start(); //服务器端 打开udp接收数据线程
		new Thread(new TCPThreadOut()).start();  //服务器端 打开tcp接收断开 线程
		ServerSocket ss;
		Socket s;
		DataInputStream dis;
		DataOutputStream dos;
		int udpPort;
		String IP;

		try {
			ss = new ServerSocket(TCP_PORT);
			
			while (true) {  //服务器端 TCP端口一直监听
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				udpPort = dis.readInt();  //接收客户端传来的 udp端口号
				IP = s.getInetAddress().getHostAddress();
				
				
				dos = new DataOutputStream(s.getOutputStream());
				dos.writeInt(ID);  //分配给客户端ID
				
				clients.add(new Client(IP, udpPort, ID++));  //clients接收客户端ip地址和udp端口 

				window.ta.append("A client connects! Addr:" + s.getInetAddress()+ ":udpPort:" + udpPort + "\n");
//				System.out.println("A client connects! Addr:" + s.getInetAddress()+ ":udpPort:" + udpPort);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TankServer().start();
	}
	/**
	 * 接收 客户端集
	 * @author ws
	 *
	 */
	private class Client {
		String IP;
		int udpPort;
		int tankID;
		private Client(String IP, int udpPort, int id) {
			this.IP = IP;
			this.udpPort = udpPort;
			tankID = id;
		}

	}
	/**
	 * UDP线程 接收信息
	 * @author ws
	 *
	 */
	private class UDPThread implements Runnable {

		public void run() {
			window.ta.setText("UDPThread starts at Port:" + UDP_PORT + "\n");
//			System.out.println("UDPThread starts at Port:" + UDP_PORT);
			DatagramSocket ds;
			DatagramPacket dp;
			DataInputStream dis;
			byte[] buf = new byte[1024];
			
			try {
				ds = new DatagramSocket(UDP_PORT);
				
				/*服务器端 UDP端口一直监听*/
				while (ds != null) {  
					dp = new DatagramPacket(buf, buf.length);
					ds.receive(dp);
					
					/*发给客户端*/
					for (int i = 0; i < clients.size(); i++) {
						Client c = clients.get(i);
						dp.setSocketAddress(new InetSocketAddress(c.IP, c.udpPort));
						ds.send(dp);
					}
//					window.ta.append("a package received from Client!!\n");
//					System.out.println("a package received from Client!!");
				}
				
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
	}
	/**
	 * TCP线程 接收断线信息
	 * @author ws
	 *
	 */
	private class TCPThreadOut implements Runnable {

		public void run() {
			window.ta.append("TCPThreadOut starts at Port:" + TCP_PORT_OUT + "\n");
			
			ServerSocket ss = null;
			Socket s = null;
			DataInputStream dis = null;
			try {
				ss = new ServerSocket(TCP_PORT_OUT);
				while (true) {
					s = ss.accept();
					dis = new DataInputStream(s.getInputStream());
					int id = dis.readInt();
					for (int i = 0; i < clients.size(); i++) {
						if (id == clients.get(i).tankID) {
							clients.remove(i);
							window.ta.append("ID:" + id + " has disconnected the service!!\n");
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					dis.close();
					s.close();
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		
	}
	/**
	 * 服务器端窗体
	 * @author ws
	 *
	 */
	private class ServerFrame extends Frame {
//		TextField tf = new TextField();
		TextArea ta = new TextArea();
		ServerFrame() {
			ta.setBackground(Color.black);
			ta.setForeground(Color.white);
			ta.setFont(new Font("Consolas", Font.BOLD, 12));
			ta.setEditable(false);
			setVisible(true);
			setTitle("TankServer");
			setBounds(400, 300, 310, 300);
			add(ta);
			addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}
	}
}
