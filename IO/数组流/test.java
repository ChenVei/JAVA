import java.io.*;
public class test
{
	public static void main(String[] args) {
		try{
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		byte[] b="mid-autumn festival~".getBytes();
		baos.write(b);
		ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
		byte[] b1=new byte[baos.toByteArray().length];
		bais.read(b1);
		System.out.println(new String(b1));

		CharArrayWriter caw=new CharArrayWriter();
		char[] c="中秋快乐".toCharArray();
		caw.write(c);
		CharArrayReader car=new CharArrayReader(caw.toCharArray());
		char[] c1=new char[caw.toCharArray().length];
		car.read(c1);
		System.out.println(new String(c1));
		}
		catch(IOException e) {System.out.println(e);}
	}
}