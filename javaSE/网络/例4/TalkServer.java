import java.io.*;
import java.net.*;
public class TalkServer
{
	public static void main(String[] args) {
		
	ServerSocket server=null;
	try{
		server=new ServerSocket(4700);
	}
	catch(Exception e){
		System.out.println("Is executing!");
		System.exit(0);
	}
	try{
		Socket socket=server.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw=new PrintWriter(socket.getOutputStream());
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Client:"+br.readLine());
		String s=br1.readLine();  //man-made Scanner
		while(!s.equals("bye"))
		{
			pw.println(s);
			pw.flush();
			System.out.println("Server:"+s);
			System.out.println("Client:"+br.readLine());
			s=br1.readLine();
		}
		br1.close();
		br.close();
		pw.close();
		socket.close();
		server.close();
	}
	catch(Exception e){System.out.println("Error:"+e);}
	
  }
}