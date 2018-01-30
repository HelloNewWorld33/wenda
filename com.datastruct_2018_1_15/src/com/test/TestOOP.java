package com.test;

public class TestOOP {
  public Fruit ani;
  public Fruit crate(Fruit a){
	  ani=a;
	  return ani;
  }
  
  public static void main(String[] args) {
	Plante<? super Fruit> fruit=new Plante<Fruit>();
	//fruit.set(new Apple());
}
}
