import java.net.*;
import java.io.*;
public class UDPServer
{
	public static void main(String[] args) throws Exception{
		

		byte[] buf=new byte[1024],buf2;
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		DatagramSocket ds=new DatagramSocket(5678);
		while(true){
			ds.receive(dp);  // blocking
			ByteArrayInputStream bais=new ByteArrayInputStream(buf);
			DataInputStream dis=new DataInputStream(bais);
			System.out.println(dis.readLong());
			//System.out.println(new String(buf,0,dp.getLength()));
		}
	}
}