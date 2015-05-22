import java.io.*;
public class test
{
	public static void main(String[] args)
	{
		KidCircle kc =new KidCircle(500);
		Kid k=kc.first;
		while(kc.count>1)
		{
			for (int i=0; i<3;i++ ) {
				k=k.right;
			}
			kc.delete(k.left);
		}
		System.out.println(k.id);
	}
}
class Kid
{
	int id;
	Kid right,left;
}
class KidCircle
{
	int count=0;
	Kid first,last;

	KidCircle(int n)
	{
		for (int i=0;i < n;i++ ) {
			add();
		}
	}
	void add()
	{
		Kid k=new Kid();
		k.id=count;
		if (count<=0) {
			first=last=k;
			k.left=k.right=k;
		}
		else {
			last.right=k;
			k.left=last;
			k.right=first;
			first.left=k;
			last=k;
		}
		count++;
	}
	void delete(Kid k)
	{
		if (count<=0)
			return;
		else if (count==1)
			first=last=null;
		else
		{
			k.left.right=k.right;
			k.right.left=k.left;
			if (k==first) {
				first=first.right;
			}else if (k==last) {
				last=last.left;
			}
		}
		count--;
	}
}