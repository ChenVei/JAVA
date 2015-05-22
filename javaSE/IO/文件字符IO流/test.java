import java.io.*;
public class test{
    public static void main(String[] args)
    {
        File f1=new File("test.java");
        File f2=new File("copy.txt");
        char[] c=new char[19];
        try{
            Writer w=new FileWriter(f2);
            Reader r=new FileReader(f1);
            int n=-1;
            while((n=r.read(c))!=-1)
                w.write(c,0,n);
            w.flush();
            w.close();
        }catch(IOException e){e.printStackTrace();}
        System.out.println("成功了！");
    }
}