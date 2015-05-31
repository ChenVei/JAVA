import java.net.*;
import java.io.*;
public class TestSockServer
{
	public static void main(String[] args)
	{
		InputStream in = null;
		OutputStream out = null;
		try{
			ServerSocket ss = new ServerSocket(5888);
			Socket socket = ss.accept();
			in = socket.getInputStream();
			out = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			String s = null;
			if ((s = dis.readUTF()) != null) {
				System.out.println(s);
				System.out.println("from:" + socket.getInetAddress());
				System.out.println("Port:" + socket.getPort());
			}
			dos.writeUTF("Hi~Hello");
			dos.close();
			dis.close();
			socket.close();
		}
		catch(IOException e){e.printStackTrace();}
	}
}