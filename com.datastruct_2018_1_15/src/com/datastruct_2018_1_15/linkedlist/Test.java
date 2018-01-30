package com.datastruct_2018_1_15.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Test  {
    static Person p=new Person(18);
    static Person pp=new Person(36);
  
  public static void main(String[] args){
	  MyLinkedListImpl<Person> l=new MyLinkedListImpl<Person>();
	  //System.out.println(l.insert(new Person(18), 0));
	  //System.out.println(l.insert(new Person(18), 1));
	  //System.out.println(l.next.next.getData().getAge());
	 /* l.insert(new Person(18), 0);
	  l.insert(new Person(19), 1);
	 l.insert(new Person(20), 2);
	l.insert(new Person(21), 3);
	  System.out.println(l.next.next.getData().getAge()+"-->"+l.next.next.next.getData().getAge()+"-->"+l.next.next.next.next.getData().getAge()+"-->"+l.next.next.next.next.next.getData().getAge());
	  System.out.println("------------------------------------------------------------");
	  System.out.println(l.delete(2));
	 // System.out.println(l.validLength);
	  System.out.println(l.next.next.getData().getAge()+"-->"+l.next.next.next.getData().getAge()+"-->"+l.next.next.next.next.getData().getAge());*/
	  Person p1=p;
	  Person p2=p1;
	  p1=pp;
	  //p1.setAge(30);;
	  System.out.println(p2+"---->"+p);
  }
}
