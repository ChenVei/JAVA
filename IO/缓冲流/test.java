import java.io.*;
public class test
{
	public static void main(String[] args) {
		File f1=new File("test.java");
		File f2=new File("copy.java");
		try{
			Writer w=new FileWriter(f2);
			Reader r=new FileReader(f1);
			BufferedWriter bw=new BufferedWriter(w);
			BufferedReader br=new BufferedReader(r);
			String s=null;
			while((s=br.readLine())!=null)
			{
				s=s+" Nums:"+s.length();
				bw.write(s);
				bw.newLine();
			}
			bw.close();
			w.close();

			r=new FileReader(f2);
			br=new BufferedReader(r);
			s=null;
			System.out.println(f2.getName()+" Content:");
			while((s=br.readLine())!=null)
			{
				System.out.println(s);
			}
			br.close();
			r.close();
		}
		catch(IOException e) {System.out.println(e);}
	}
}