import java.net.*;
import java.io.*;
public class TestSockClient
{
	public static void main(String[] args)
	{
		InputStream in=null;
		OutputStream out=null;
		try{
			Socket socket=new Socket("localhost",5888);
			in=socket.getInputStream();
			out=socket.getOutputStream();
			DataInputStream dis=new DataInputStream(in);
			DataOutputStream dos=new DataOutputStream(out);
			dos.writeUTF("Hey!");
			String s=null;
			if ((s=dis.readUTF())!=null) {
				System.out.println(s);
			}
			dis.close();
			dos.close();
			socket.close();
		}
		catch(UnknownHostException e){e.printStackTrace();}
		catch(IOException e){e.printStackTrace();}
	}
}