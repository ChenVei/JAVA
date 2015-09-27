package com.compiler.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.proxy.Moveable;
import com.proxy.Tank;

public class Test1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String rt = "\r\n";
		String src = "package com.proxy;" + rt
				+ "public class TankTimeProxy implements Moveable {" + rt
				+ "Moveable t;" + rt +

				"public TankTimeProxy(Moveable t) {" + rt + "this.t = t;"
				+ "	}" + rt +

				"	@Override" + " public void move() {" + rt
				+ "System.out.println(\"Tank time start...\");" + "t.move();"
				+ rt + "System.out.println(\"Tank time end...\");" + "}" + "}";

		String fileName = System.getProperty("user.dir")
				+ "/src/com/proxy/TankTimeProxy.java";
System.out.println(fileName);
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.close();

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
System.out.println(compiler);	
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		URL[] u = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
System.out.println("file:/"+System.getProperty("user.dir")+"/src");
		URLClassLoader uc = new URLClassLoader(u);
		Class c = uc.loadClass("com.proxy.TankTimeProxy");
		
		Constructor cn = c.getConstructor(Moveable.class);
		Moveable m = (Moveable) cn.newInstance(new Tank());
		m.move();
	}
}
