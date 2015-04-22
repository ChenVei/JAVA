import java.io.*;
public class test
{
	public static void main(String[] args)
	{
		Date[]days=new Date[5];
		days[0]=new Date(2006,5,4);
		days[1]=new Date(2006,7,4);
		days[2]=new Date(2008,5,4);
		days[3]=new Date(2004,5,9);
		days[4]=new Date(2004,5,4);
		sort(days);
		for (int i=0;i < days.length ;i++ ) {
			System.out.println(days[i]);
		}
	}
	public static Date[] sort(Date[] d)
	{
		int len=d.length;
		int i=1;
		while(i<len)
		{
			int k=i++;
			while(k>0 && d[k-1].compare(d[k])==1)
			{
					Date t=d[k];
					d[k]=d[k-1];
					d[k-1]=t;
					k--;
			}
		}
		return d;
	}
}
class Date
{
	int year,month,day;
	Date(int y,int m,int d)
	{
		year=y;month=m;day=d;
	}
	public int compare(Date date)
	{
		return year>date.year?1:year<date.year?-1:month>date.month?1:month<date.month?-1:day>date.day?1:day<date.day?-1:0;
	}
	public String toString()
	{
		return "Year-Month-Day:"+year+"-"+month+"-"+day;
	}
}