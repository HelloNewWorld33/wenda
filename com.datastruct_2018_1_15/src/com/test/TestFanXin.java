package com.test;
/*
 * 测试泛型
 */
public class TestFanXin<T> {
	public Node<T>[] crateArr(){
		Node<T> tt[]=(Node<T>[]) new Node[10];
		return tt;
	}
   public static void main(String[] args) {
	   TestFanXin<Apple> t=new TestFanXin<Apple>();
	   Node<Apple>[] a= t.crateArr();
	   a[0]=new Node<Apple>();
	  /* a[0].t.n*/
}
}
