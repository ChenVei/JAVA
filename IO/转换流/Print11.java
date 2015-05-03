import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Print11 {

	public static void main(String[] args) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:/java/good.txt"));
			osw.write("xxxxx111xxx");
			System.out.println(osw.getEncoding());
			osw.close();
			
			osw = new OutputStreamWriter(new FileOutputStream("d:/java/good.txt",true), "ISO8859_1");
			osw.write("qqqq22qqqqqqqqqq");
			System.out.println(osw.getEncoding());
			osw.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}


