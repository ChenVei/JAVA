import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class SendUDP {

	public static void main(String[] args) throws SocketException, IOException {
		DatagramSocket ds = new DatagramSocket();
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line=buf.readLine())!=null) {
			if (line == "886") break;
			//byte[] b = "Hello Fucking world我来了".getBytes();
			byte[] b = line.getBytes();
			InetAddress ia = InetAddress.getByName("localhost");
			DatagramPacket dp = new DatagramPacket(b, b.length, ia, 12345);
			ds.send(dp);
		}
		ds.close();
	}

}
