package com.qiding.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	private Object realObject;


	public Object bind(Object bindObject){
		this.realObject=bindObject;
		return Proxy.newProxyInstance(bindObject.getClass().getClassLoader(),
			bindObject.getClass().getInterfaces(),this);
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("hello world");
		return method.invoke(realObject,args);
	}
}
