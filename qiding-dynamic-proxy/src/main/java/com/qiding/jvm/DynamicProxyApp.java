package com.qiding.jvm;

/**
 * Hello world!
 *
 */
public class DynamicProxyApp
{
    public static void main( String[] args )
    {
    	IDynamicProxy dynamicProxy= (IDynamicProxy) new DynamicProxy().bind(new DynamicProxyHandler());
		dynamicProxy.hello();
        System.out.println( "Hello World!" );
    }
}
