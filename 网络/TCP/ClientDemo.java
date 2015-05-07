package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",12345);
		OutputStream os = socket.getOutputStream();  //send
		
		os.write("Hello FuckingworldŒ“¿¥¡À".getBytes());
		
		InputStream is = socket.getInputStream();  //receive
		byte[] b = new byte[1024];
		int len = is.read(b);
		
		System.out.println("Receive:"+new String(b, 0, len));
		socket.close();
	}

}
