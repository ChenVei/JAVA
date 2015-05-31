package Internet11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		byte[] b = new byte[1024];
		
		try {
			ss = new ServerSocket(8888);
			s = ss.accept();
			is = s.getInputStream();
			int len = is.read(b);
			System.out.println("From:"+s.getInetAddress());
			System.out.println("Content:"+new String(b,0,len));
			
			os = s.getOutputStream();
			os.write("啊啊The fuckingworld!!".getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
