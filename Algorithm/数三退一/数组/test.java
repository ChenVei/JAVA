import java.io.*;
public class test
{
	public static void main(String[] args)
	{
		boolean p[]=new boolean[500];
		for (int i=0;i<p.length ;i++ ) {
			p[i]=true;
		}
		int left=500,k=0;
		int c=0;
		while(left>1)
		{
			
			if (p[k]==true)
				c++;
			if (c==3) {
				c=0;
				p[k]=false;left--;
			}
			k=(k+1)%500;
			
		}
		for (int i=0;i < p.length ;i++ )
			if (p[i])
				System.out.println(i);
	}
}