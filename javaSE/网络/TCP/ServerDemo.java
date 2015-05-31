package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(12345);
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		byte[] b = new byte[1024];
		int len = is.read(b);
		System.out.println("From:" + s.getInetAddress().getHostAddress());
		System.out.println("Content:" + new String(b, 0, len));
		
		OutputStream os = s.getOutputStream();
		os.write("数据已收到".getBytes());
		
		s.close();
		ss.close();
	}
}
