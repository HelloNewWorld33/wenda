package com.datastruct_2018_1_15.linkedlist.staticLinkedList;
/**
 * 静态链表结点类
 * 静态链表 用于高级语言没有指针的语言去实现链表的一种方式
 * @author Administrator
 *
 */
public class Node<T> {
    //数据域
	private T data;
	//游标域 (指针域) 为了便于访问就用public域修饰
	public int cur;
	public T getData() {
		return data;
	}
	public void setData(T t) {
		this.data = t;
	}
	public Node(T t,int cur){
		this.data=t;
		this.cur=cur;
	}
	public Node(T t){
		this.data=t;
		
	}
	
	
}
