import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) throws ParseException {
		System.out.println("xxxx");
		System.out.println("xxxx1");
		Date d = new Date();
		System.out.println(d);
		System.out.println(new Date(3600*1000));
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(d));
		sdf = new SimpleDateFormat("y��, M��, d�� H:m:s");
		System.out.println(sdf.format(d));
		String str = "2005��, 21��, 20�� 15:24:51";
		Date dd = sdf.parse(str);
		System.out.println(dd);
		
		
		long t=System.currentTimeMillis();
		System.out.println(t);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println((System.currentTimeMillis()-t)/1000);
		System.out.println(d);  //and once it set, it won't move
	}
}


