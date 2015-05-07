package Internet11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class tcpClient {

	public static void main(String[] args) {
		String addr = "169.254.201.34";
		int port = 8888;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		byte[] b = new byte[1024];

		try {
			s = new Socket(addr, port);
			os = s.getOutputStream();
			os.write("Hello FuckingWorld我来了".getBytes());
			
			is = s.getInputStream();
			int len = is.read(b);
			System.out.println("The server reflects:" + new String(b, 0, len));

		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
				s.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

}
