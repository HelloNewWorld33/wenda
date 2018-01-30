package com.datastruct_2018_1_15.linkedlist.staticLinkedList;

import java.util.Arrays;

/*
 * 静态单链表实现类
 */
public class StaticLinkedList<T> {
   //静态链表 代表长度一开始就是固定的  
	private int maxSize=10000;//默认大小10000
	//结点数组  这个是个泛型数组
	private Node<T> nodeArr[];
	//静态链表的初始化工作 生成一个不含数据的结点数组(静态单链表)
	//有效长度判断合法性  初始化默认为0
	public int validLength=0;
	 
	public void init(){
		//泛型数组 利用类型转化 因为new Node<T>[maxSize]编译不通过
		nodeArr=(Node<T>[])new Node[maxSize];
		/**
		 * ---------------------------------------------------------------->
		 * 注意游标指向
		 * nodeArr[0].cur的值为第一个nodeArr[i].getData==null的i 告知第一个空闲的位置 插入的时候优先插入
		 * nodeArr[maxSize-1].cur的值为第一个nodeArr[i].getData!=null的i 告知第一个有数据的位置 初始化的时候为0代表后面无引用 类似于头结点
		 * 其余的nodeArr[i].cur=i+1;
		 * ----------------------------------------------------------------->
		 * nodeArr[0]与nodeArr[maxSize-1]只存cur不存data
		 * 在初始化静态单链表(结点data暂都为null的时候) 则
		 * nodeArr[0].cur=1; //第一个代表的就是nodeArr[i]
		 * nodeArr[maxSize-1].cur=0;//cur=0代表空指针 后面没有引用 
		 * nodeArr[i].cur=i+1;
		 */
		
		for(int i=0;i<maxSize;i++)
			nodeArr[i]=new Node<T>(null,i+1);
		nodeArr[maxSize-1].cur=0;//cur=0代表空指针 后面没有引用
		
	}
	
	//调用者自己提供大小的初始化方法
	public StaticLinkedList(int maxSize){
		this.maxSize=maxSize;
		//进行初始化
		init();
	}
	//使用默认大小的构造方法
	public StaticLinkedList(){
		//进行初始化
		init();
	}
	
	//插入的方法在索引之后插入
	public int insert(T t,int index){
		//合法性判断
		if(index<0||index>validLength)
			return -1;
		//老版
		/*//类比于动态单链表 nodeArr[maxSize-1]相当于头结点的指针
		Node<T> currentNode=nodeArr[maxSize-1];//当前结点也就是头结点 
		int startPos=0;
		//遍历到有数据的index
		while(index!=startPos){
			currentNode=nodeArr[currentNode.cur];//下一位结点 一直遍历
			startPos++;
		}*/
		
		//新版
		Node<T> currentNode=search(index);
		
		//第一个空闲数组位置
		int firstEmptyPos=nodeArr[0].cur;
		//下一个空闲的地方  当插入完成后重新赋值nodeArr[0].cur
		int nextEmptyPos=nodeArr[firstEmptyPos].cur;
		//创建结点
		Node<T> newtNode=new Node<T>(t);
		//连接起来  类比动态单链表
		/*
		 * 1.如果不是最后一个结点
		 * newtNode.next=currentNode.next;currentNode.next=newtNode;
		 * 2.如果是最后一个结点
		 * newtNode.next=null;currentNode.next=newtNode;
		 */
		//判断是否为尾结点
		if(currentNode.cur!=0){//不是尾结点
			//newtNode.next=currentNode.next;的转化 
			newtNode.cur=currentNode.cur;
		}else{
			//newtNode.next=null;的转化
			newtNode.cur=0;
		}
		//currentNode.next=newtNode;的转化  firstEmptyPos相当于引用
		currentNode.cur=firstEmptyPos;
		//往引用里面放入结点
		nodeArr[firstEmptyPos]=newtNode;
		//重新指向空闲结点
		nodeArr[0].cur=nextEmptyPos;
		//长度加一
		validLength++;
		return 1;
	}
	
	//添加的方法  始终在尾结点添加
	public void add(T t){
		//再次调用插入 添加就是特殊的插入 插入位置位于最后
		insert(t,validLength);
	}
	
	@Override
	public String toString() {
		String str="StaticLinkedList :";
		for(int i=0;i<maxSize;i++){
			if(nodeArr[i].getData()!=null){//里面有数据
				str+="["+i+" ,"+ "{ 值："+nodeArr[i].getData().toString()+" cur："+nodeArr[i].cur+"}]";
			}else{//没有值  
				str+="["+i+" ,"+"{值：*   cur："+nodeArr[i].cur+"}]";
			}
		}
		return str;
	}
   
	public void printLink(){
		/*//类比于动态单链表 nodeArr[maxSize-1]相当于头结点的指针
		Node<T> currentNode=nodeArr[maxSize-1];//当前结点也就是头结点 
		int index=0;
		while(index!=validLength){
			currentNode=nodeArr[currentNode.cur];//下一位结点 一直遍历
			index++;
			System.out.print(" 值为"+currentNode.getData().toString()+"下一个引用  "+currentNode.cur+"----->");
		}*/
		System.out.println(toString());
	}
	
	//删除操作
	public int delete(int index){
		//合法性判断
		if(index<=0||index>validLength){//不合法
			return -1;
		}
		//合法情况
		//找到该索引下的前一个结点
		Node<T> preivoustNode=search(index-1);
		//找到当前结点
		Node<T> currentNode=nodeArr[preivoustNode.cur];
		//当前结点所在的数组下标 用局部变量保存 等下释放该数组可以用到
		int currentNodeArrayIndex=preivoustNode.cur;
		//判断是否为尾结点
		if(index!=validLength){//不是尾结点的时候
			//类比于动态单链表
			//preivoustNode.next=currentNode.next;的转化 
			preivoustNode.cur=currentNode.cur;
			
		}else{//是尾结点的时候
			//类比于动态单链表
			//preivoustNode.next=null;的转化 
			preivoustNode.cur=0;
		}
		//释放需要删除的结点1.删除数据 2.游标指向nodeArr[0].cur即指向空闲结点
		//
		/**
		 * 注意这里用局部变量currentNodeArrayIndex 不要用  preivoustNode.cur
		 * 因为 preivoustNode.cur在上面已经重新赋值了 
		 * 代表的是需要删除的下一个结点的数组所在位置 
		 */
		nodeArr[currentNodeArrayIndex].setData(null);
		nodeArr[currentNodeArrayIndex].cur=nodeArr[0].cur;
		//nodeArr[0].cur重新指向空闲结点(下次插入优先考虑刚删除的结点,所以指向preivoustNode.cur)
		//这里同理用currentNodeArrayIndex不用preivoustNode.cur
		nodeArr[0].cur=currentNodeArrayIndex;
		//有效长度减一
		validLength--;
		return 1;
	}
	
	//搜索的方法
		public Node<T> search(int index){
		//类比于动态单链表 nodeArr[maxSize-1]相当于头结点的指针
				Node<T> currentNode=nodeArr[maxSize-1];//当前结点也就是头结点 
				int startPos=0;
				//遍历到有数据的index
				while(index!=startPos){
					currentNode=nodeArr[currentNode.cur];//下一位结点 一直遍历
					startPos++;
				}
				return currentNode;
		}
}
