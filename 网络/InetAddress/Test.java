import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName("www.163.com");
			System.out.println(ia);
			ia = InetAddress.getByName("127.0.0.1");
			System.out.println(ia);
			ia = InetAddress.getLocalHost();
			System.out.println(ia);
			System.out.println("host name:"+ia.getHostName());
			System.out.println("host address:"+ia.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
