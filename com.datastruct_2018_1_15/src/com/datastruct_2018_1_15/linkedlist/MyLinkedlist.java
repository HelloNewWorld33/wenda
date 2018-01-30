package com.datastruct_2018_1_15.linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
 * 自定义的链表接口
 * 提供方法如下
 * 1.插入(*)、2.删除(*)、3.修改、4.查询。注意带(*)的为重点方法
 * 
 */
public interface MyLinkedlist<T> {
  //头结点在实现类里面创建
	//为同一操作 实现类默认都加头结点
	
	/*
	 * 1.插入  index代表插入索引 如index=3 代表插在第2个节点后成为新的第3个节点
	 * 返回-1代表失败 返回1代表成功
	 *    
	 */
	public int insert(T t,int index);
	/*
	 * 2.删除  通过索引index的方式删除
	 * 返回-代表失败 返回1代表成功
	 */
	public int delete(int index);
}
