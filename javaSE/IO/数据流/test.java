import java.io.*;
public class test
{
	public static void main(String[] args) {
		try{
			FileOutputStream fos=new FileOutputStream("test.txt");
			DataOutputStream dos=new DataOutputStream(fos);
			dos.writeInt(100);
			dos.writeLong(1234560);
			dos.writeFloat(123.456f);
			dos.writeDouble(123456.456321);
			dos.writeBoolean(true);
			/*dos.writeChars("How do you do?");*/
			dos.writeUTF("HOW OLD ARE YOU?");
			FileInputStream fis=new FileInputStream("test.txt");
			DataInputStream dis=new DataInputStream(fis);
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
			System.out.println(dis.readFloat());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			char c='\0';
			/*while((c=dis.readChar())!='\0')
				System.out.print(c);*/
			System.out.println(dis.readUTF());
		}
		catch(IOException e) {System.out.println(e);}
	}
}