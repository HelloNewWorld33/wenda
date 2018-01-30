package com.datastruct_2018_1_15.linkedlist;
/**
 * 结点类 
 * 两大属性： 数据域、指针域
 * @author Administrator
 *
 */
public class MyNode<T> {
   //数据域	
   public T data;
   //指针域
   public MyNode<T> next;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public MyNode<T> getNext() {
		return next;
	}
	public void setNext(MyNode<T> next) {
		this.next = next;
	}
	//头结点数据域不存数据的构造方法  next值动态生成 因为创建的时候并不知道下一个元素是谁
	public MyNode() {
		super();
		
	}
	//头结点数据域存数据的构造方法或者普通节点的构造方法  next值动态生成 因为创建的时候并不知道下一个元素是谁
	public MyNode(T data) {
		super();
		this.data = data;
		
	}
	

}
