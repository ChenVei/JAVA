import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) throws ParseException {
		
		Date d = new Date();
		System.out.println(d);
		System.out.println(new Date(3600*1000)); //1h
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(d));
		sdf = new SimpleDateFormat("y年, MM月, dd日 H:m:s");
		System.out.println(sdf.format(d));
		
		String str = "2005年, 21月, 20日 15:24:51";
		Date dd = sdf.parse(str);
		System.out.println(dd);
		
	}
}


