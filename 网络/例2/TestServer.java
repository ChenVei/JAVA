import java.net.*;
import java.io.*;
public class TestServer{
	public static void main(String[] args)
	{
		try{
			ServerSocket ss=new ServerSocket(8888);
			while(true)
			{
			Socket s = ss.accept();
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Hello, "+s.getInetAddress()+" port:"+s.getPort()+" Byebye~");
			dos.close();
			s.close();
			}
		}
		catch(IOException e){e.printStackTrace();}
	}
}