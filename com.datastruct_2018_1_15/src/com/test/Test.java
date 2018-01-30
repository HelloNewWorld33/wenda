package com.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a=new Apple("a");
		Apple b=a;
		System.out.println("之前"+a.name);
		b.name="b";
		System.out.println("之前"+a.name);
	}

}
