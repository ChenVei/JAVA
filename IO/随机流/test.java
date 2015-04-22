import java.io.*;
public class test
{
	public static void main(String[] args) {
		
		File f=new File("test.txt");
		RandomAccessFile raf=null;
		int data[]={1,2,3,4,5,6,7,8,9,10};
		try{
			raf=new RandomAccessFile(f,"rw");
			for (int i=0;i<data.length ;i++ ) {
				raf.writeInt(data[i]);
			}
			for (int i=data.length-1;i>=0 ;i-- ) {
				raf.seek(i*4);
				System.out.printf("\t%d",raf.readInt());
			}
			raf.close();
		}
		catch(IOException e) {System.out.println(e);}
	}
}