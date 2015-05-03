import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) throws ParseException {
		String born = "1995.8.26";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.m.d");
		Date date = sdf.parse(born);
		long k = (new Date().getTime() - date.getTime())/3600/24/1000;
		System.out.println("I have lived "+k+" days..");
	}
}


