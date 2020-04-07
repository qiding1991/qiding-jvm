package com.qiding.jvm;

import org.objectweb.asm.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class JvmClassEngine {

	public static  void helloWorld(String name){
		byte[] placeHolder = new byte[64 * 1024 * 1024];
	}


	public static void getMethodParamNames(Class cls,String methodName) throws IOException {
		Method method=Stream.of(cls.getMethods()).filter(method1 ->method1.getName().equals(methodName)).collect(Collectors.toList()).get(0);
		int i= method.getParameterCount();
		if(i==0){
			return;
		}

		final String[] parameterNames = new String[method.getParameterCount()];
		String className=cls.getName().replace(".","/")+".class";
		System.out.println(className);
		InputStream inputStream= cls.getClassLoader().getResourceAsStream(className);
		//InputStream inputStream= cls.getResourceAsStream(cls.getName()+".class");
		ClassReader reader=new ClassReader(inputStream);
		reader.accept(new ClassVisitor(Opcodes.ASM7) {
			@Override
			public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
				return new MethodVisitor(Opcodes.ASM7) {
					@Override
					public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
						  if(Modifier.isStatic(method.getModifiers())){
							  parameterNames[index]=name;
						  }
						  else if(index>0){
						  	parameterNames[index-1]=name;
						  }
						 System.out.println(name);
					}
				};
			}
		},0);
		System.out.println(parameterNames[0]);
	}



	public static void main(String[] args) throws IOException {
		helloWorld("hello");
		//int a = 0;
//		placeHolder=null;
		System.gc();
		getMethodParamNames(ParamTestClass.class,"helloWorld");
	}
}
