package com.datastruct_2018_1_15.linkedlist;
/*
 * 实现链表需求
 * 1.构造方法中提供带有头结点和不带头结点的两种构造器(为了操作统一采用带头结点的)
 * 2.插入位置在索引之后即插入后顶替了原索引后一位的地址 (要想插入在此之索引之前,只需插入在上个索引元素之后)；
 * 2.1.1:插入合法性的判断 插入索引大于有效长度返回插入失败即-1
 * 2.1.2:根据索引找到该索引的对象比如:索引=0 则找到0这个对象 举例为node0
 * 2.1.3:判断是否为尾结点
 * 2.1.4:不是尾结点先将node0.next赋值给需要插入的新结点的next 接着让新结点地址赋值给node0.next
 * 2.1.5:是尾结点 让新结点地址赋值给node0.next
 */

public class MyLinkedListImpl<T> implements MyLinkedlist<T> {
	//头指针的next也就是头结点 L.next也就是headNode
	public MyNode<T> next;
	//头结点
	private MyNode<T> headNode;
	//有效链表长度(以前本来想存在头结点发现头结点MyNode<Integer>有可能和MyNode<T>类型不同) 所以在定义一个长度
	//头结点不算所以默认初始化为0
	public int validLength;
	
	
   //链表构造器 初始化的时候默认创建头结点(方便统一操作)头结点数据域存放长度(方便对插入和删除索引合法性的判断)
  public MyLinkedListImpl() {
	  //头结点创建 初始化为0(代表只有头结点没有真正的插入数据的结点对象)
	  headNode=new MyNode<T>();
	  validLength=0;
	  next=headNode;
	  
	}

	@Override
	//插入操作 
	/**
	 * 1.index 代表索引从0开始
	 */
	public int insert(T t, int index) {
		//当前结点也就是索引前一位结点 一开始对应的是头结点
		MyNode<T> currentNode=headNode;
		//遍历的索引 从0开始
		int startPos=0;
		//创建新的结点 并且把值传入
		MyNode<T> newNode=new MyNode<T>(t);
//		System.out.println("测试");
		//判断合法性 不合法的时候
		if(index>validLength)
		 return -1;
		//合法的时候		
		//2.循环遍历找到该索引对应的结点
		while(index!=startPos){
			currentNode=currentNode.next;
			startPos++;		
		}
		//判断是否为尾结点  
		if(index!=validLength)
		//插入的索引对应的不是尾结点
		newNode.next=currentNode.next;
		currentNode.next=newNode;
		validLength++;
		return 1;
	}

	
    /**
     * 3.1删除结点 按索引删除
     * 3.1.1:合法性的判断,不合法范围(index==0||index>validLength)
     * 3.1.2:合法的时候 判断是否为尾结点
     * 3.1.3:是尾结点的时候(索引前一个结点记为node0) 表述如下
     * node0.next=null;node1.data=null;node1.next=null;node0=null;node1=null;(注 这里尾结点也加上node1.next=null是为了当不是尾结点的时候省去一步判断)
     * 3.1.4:不是是尾结点的时候(索引前一个结点记为node0) 表述如下
     * node0.next=node1.next;node1.data=null;node1.next=null;node0=null;node1=null;    
     */
	@Override
	public int delete(int index) {
		//当前结点也就是索引前一位结点 一开始对应的是头结点
		MyNode<T> previoustNode=headNode;
		//遍历的索引 从0开始
		int startPos=0;
		//需要删除的结点
		MyNode<T> needDelNode=new MyNode<T>();
//		System.out.println("测试");
		//判断合法性 不合法的时候
		if(index==0||index>validLength)
		 return -1;
		//合法的时候		
		//2.循环遍历找到该索引前一个对应的结点
		while((index-1)!=startPos){
			previoustNode=previoustNode.next;
			startPos++;		
		}
		//需要删除的结点赋值 index=1 即代表node1
		needDelNode=previoustNode.next;
		//中间过度结点 默认为空
		MyNode<T> tempCommNode=null;
		//判断是否为尾结点
		if(index!=validLength){
			tempCommNode=needDelNode.next;
		}
		//重新指向
		previoustNode.next=tempCommNode;
		//手动清理引用
		needDelNode.next=null;
		needDelNode.data=null;
		needDelNode=null;
		tempCommNode=null;
		previoustNode=null;
		validLength--;
		return 1;
	}

}
