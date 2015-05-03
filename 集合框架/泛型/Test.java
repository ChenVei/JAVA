public class Test {
	public static void main(String[] args) {
//		ObjectTool oo = new ObjectTool();
//		oo.setObj("xxxx");
//		System.out.println(oo.getObj());
		
		ObjectTool<String> oo =new ObjectTool<String>();
		oo.setObj("xxxx");
		System.out.println(oo.getObj());
		
		Obj2 o2 = new Obj2();
		o2.show("xxxx");
		o2.show(new Integer(100));
		o2.show(true);
		
		Inter<String> in = new InterIm();
		in.show("xxxxx");
		
		Inter<String> in2 = new InterIm2<String>();
		in2.show("aaaaa");
		Inter<Integer> in3 = new InterIm2<Integer>();
		in3.show(100);
	}
}

class ObjectTool<T> {  //泛型类
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}
class Obj2 {
	public <T> void show(T t) { //泛型方法
		System.out.println(t);
	}
}

interface Inter<T> {  //泛型接口
	public void show(T t);
}

class InterIm implements Inter<String> {  //已知类
	public void show(String t) {
		System.out.println(t);
	}
}

class InterIm2<T> implements Inter<T> {  //未知类

	@Override
	public void show(T t) {
		System.out.println(t);
		
	}
	
}






