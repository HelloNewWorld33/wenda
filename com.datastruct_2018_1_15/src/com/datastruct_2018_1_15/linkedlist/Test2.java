package com.datastruct_2018_1_15.linkedlist;

public class Test2 {
    public static void add(Person i){
    	i.age=i.age*5;
    }
    public static void main(String[] args){
    	//Integer i=new Integer(10);
    	Person p=new Person(10);
    	add(p);
    	System.out.println(p.age);
    }
}
