import java.io.*;
import java.net.*;
public class TalkClient
{
	public static void main(String[] args) {
		
		try{
			Socket socket = new Socket("127.0.0.1",4700);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			
			String s = br1.readLine();
			while(!s.equals("bye"))
			{
				pw.println(s);
				pw.flush();
				System.out.println("Client:" + s);
				System.out.println("Server:" + br.readLine());
				s = br1.readLine();
			}
			
			br1.close();
			br.close();
			pw.close();
			socket.close();
		}
		catch(Exception e) {System.out.println("Error:"+e);}
	}
}