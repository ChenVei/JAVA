
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ReceiveUDP {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(12345);
		byte[] b =new byte[1024];
		DatagramPacket dm = new DatagramPacket(b, b.length);
		
		while (true) {
			ds.receive(dm);
			InetAddress ia = dm.getAddress();
			System.out.println("From:"+ia);
			String data = new String(b, 0, dm.getLength());
			System.out.println("Content:"+data);
		}
		
		
		//ds.close();
	}

}
