import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getByName("PC-201407312058");
		String name = ia.getHostName();
		String ip = ia.getHostAddress();
		System.out.println(name+"----"+ip);
	}
}