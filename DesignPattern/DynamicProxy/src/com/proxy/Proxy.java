package com.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception{
		String rt = "\r\n";
		
		String methodStr = "";
		Method[] methods = infce.getMethods();
		/*for (Method method : methods) {
			System.out.println(method.getName());
			methodStr += "@Override" + " public void "+method.getName()+"() {" + rt
					+ "System.out.println(\"Tank time start...\");" + "t."+method.getName()+"();"
					+ rt + "System.out.println(\"Tank time end...\");" + "}" + "}" + rt;
		}*/
		for (Method method : methods) {
			methodStr += "@Override" + " public void "+method.getName()+"() {" + rt
					+ "Method md = null;" + rt +
					"try{"+rt+
						"md = "+infce.getName()+".class.getMethod(\""+method.getName()+"\");" + rt +
						"h.invoke(this, md);"+ rt +
					"} catch (Exception e) {e.printStackTrace();}"+rt+
						"}";
		}
		
		String src = "package com.proxy;" + rt
				+"import java.lang.reflect.Method;"+rt
				+ "public class TankTimeProxy implements "+infce.getName()+" {" + rt
				+ "InvocationHandler h;" + rt +

				"public TankTimeProxy(InvocationHandler h) {" + rt + "this.h = h;"
				+ "	}" + rt +

				methodStr+"}";
//*************************************************************
		String fileName = System.getProperty("user.dir") + "/src/com/proxy/TankTimeProxy.java" ;
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
			
			URL[] u = new URL[]{new URL("file:\\"+System.getProperty("user.dir")+"/src/")};
			URLClassLoader uc = new URLClassLoader(u);
			Class c = uc.loadClass("com.proxy.TankTimeProxy");
			Constructor cn = c.getConstructor(InvocationHandler.class);
//************************************************************* get the TankTimeProxy class
			Object m = cn.newInstance(h);
			return m;
			
	}
}
