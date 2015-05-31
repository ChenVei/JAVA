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
 * ̹����Ϸ��������
 * @author ws
 *
 */
public class TankServer {
	/**
	 * ������ͻ��˵�ID
	 */
	private static int ID = 100;  
	/**
	 * �Լ���TCP�˿ںţ���������ͻ���
	 */
	public static final int TCP_PORT = 8888;
	/**
	 * �Լ���TCP�˿ںţ����նϿ��ͻ���
	 */
	public static final int TCP_PORT_OUT = 7777;
	/**
	 * �Լ���UDP�˿ں�
	 */
	public static final int UDP_PORT = 6666; 
	/**
	 * ̹�˼�
	 */
	List<Client> clients = new ArrayList<Client>();
	/**
	 * �ͻ��˴���
	 */
	ServerFrame window = new ServerFrame();
	
	/*tcpЭ�� ��������udp�˿ں�*/
	public void start() {
		
		new Thread(new UDPThread()).start(); //�������� ��udp���������߳�
		new Thread(new TCPThreadOut()).start();  //�������� ��tcp���նϿ� �߳�
		ServerSocket ss;
		Socket s;
		DataInputStream dis;
		DataOutputStream dos;
		int udpPort;
		String IP;

		try {
			ss = new ServerSocket(TCP_PORT);
			
			while (true) {  //�������� TCP�˿�һֱ����
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				udpPort = dis.readInt();  //���տͻ��˴����� udp�˿ں�
				IP = s.getInetAddress().getHostAddress();
				
				
				dos = new DataOutputStream(s.getOutputStream());
				dos.writeInt(ID);  //������ͻ���ID
				
				clients.add(new Client(IP, udpPort, ID++));  //clients���տͻ���ip��ַ��udp�˿� 

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
	 * ���� �ͻ��˼�
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
	 * UDP�߳� ������Ϣ
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
				
				/*�������� UDP�˿�һֱ����*/
				while (ds != null) {  
					dp = new DatagramPacket(buf, buf.length);
					ds.receive(dp);
					
					/*�����ͻ���*/
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
	 * TCP�߳� ���ն�����Ϣ
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
	 * �������˴���
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
