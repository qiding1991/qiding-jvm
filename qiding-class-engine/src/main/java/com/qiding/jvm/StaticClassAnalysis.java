package com.qiding.jvm;

public class StaticClassAnalysis {

	static abstract  class Human{}
	static   class Man extends Human{}
	static   class Women extends Human{}

	public    void sayHello(Human human){
		System.out.println("Human");
	}

	public    void sayHello(Man human){
		System.out.println("Man");
	}
	public    void sayHello(Women human){
		System.out.println("Women");
	}

	static class HelloWorld{
		static void hello(){
			System.out.println(1111);
		}
	}

	public static void main(String[] args) {
		HelloWorld.hello();

		Human a=new Man();
		Human b=new Women();

		Man c=new Man();


		StaticClassAnalysis staticClassAnalysis=	new StaticClassAnalysis();
		staticClassAnalysis.sayHello(a);
		staticClassAnalysis.sayHello(b);
		staticClassAnalysis.sayHello(c);

	}
}

