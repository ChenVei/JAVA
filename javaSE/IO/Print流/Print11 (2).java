import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;


public class Print11 {

	public static void main(String[] args) {
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			PrintWriter pr = new PrintWriter(new FileWriter("d:/java/good.txt"),true);
			while ((s = br.readLine())!=null) {
				if (s.equalsIgnoreCase("exit")) break;
				pr.println("-----------");
				pr.println(s.toUpperCase());
				pr.flush();
			}
			pr.println("-----"+new Date()+"-----");
			pr.flush();
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


