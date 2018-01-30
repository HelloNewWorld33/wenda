package com.datastruct_2018_1_15.linkedlist.staticLinkedList;

import com.test.Apple;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticLinkedList<Apple>  stt=new StaticLinkedList<Apple>(10);
		Apple a=new Apple("李");
		stt.insert(a, 0);//2
		stt.insert(new Apple("大"), 1);//3
		stt.insert(new Apple("红"), 2);//4
		stt.insert(new Apple("冰"), 0);//1
		stt.add(new Apple("天使"));
		stt.printLink();
		System.out.println("长度："+stt.validLength);
		//删除后
		System.out.println("-------------------删除后----------------------");
		stt.delete(1);
		stt.printLink();
		System.out.println("长度："+stt.validLength);
		//删除后
				System.out.println("-------------------再次删除后----------------------");
				stt.delete(3);
				stt.printLink();
				System.out.println("长度："+stt.validLength);
				//删除最后一个
				System.out.println("-------------------删除最后一个后----------------------");
				stt.delete(3);
				stt.printLink();
				System.out.println("长度："+stt.validLength);
	}
	

}
