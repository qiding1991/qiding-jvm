package com.qiding.jvm;

public class DynamicProxyHandler implements IDynamicProxy{
	@Override
	public void hello() {
		System.out.println("hello qiding");
	}
}
