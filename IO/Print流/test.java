import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
public class test {

	public static void main(String[] args) {
		String s = args[0];
		if (s != null) list(s, System.out);
	}

	private static void list(String s, PrintStream out) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			while ((s=br.readLine()) != null) {
				out.println(s);
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}


