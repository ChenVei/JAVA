import java.net.*;
import java.io.*;
public class UDPClient
{
	public static void main(String[] args) throws Exception{
		long n=1000000000L;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		dos.writeLong(n);

		byte[] buf=baos.toByteArray();
		//byte[] buf="Hello World!".getBytes();
		DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",5678));
		DatagramSocket ds=new DatagramSocket(9999); //the clients' own port.
		ds.send(dp);
		ds.close();
	}
}