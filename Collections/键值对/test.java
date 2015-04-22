import java.util.*;
public class test
{
	public static final int One=1;
	public static void main(String[] args)
	{
		Map<String,Integer> m=new HashMap<String,Integer>();

		for (int i=0;i<args.length;i++ ) {
			Integer fre=m.get(args[i]);
			m.put(args[i],(fre==null)?1:(fre+1));
		}
		System.out.println("There are "+m.size()+" distinct KVs.");
		System.out.println(m);
	}
}
