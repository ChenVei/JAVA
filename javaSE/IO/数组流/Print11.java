
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class Print11 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		PrintStream ps = null;
		try {
			FileOutputStream fis = new FileOutputStream("d:/java/hello.txt");
			ps = new PrintStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (ps != null) {
			System.setOut(ps);
		}
		for (char i = 0; i < 60000; i++) {
			if ((int)i % 100 == 0) {
				System.out.println();
			}
			System.out.print(i);
		}
		
	}

}
