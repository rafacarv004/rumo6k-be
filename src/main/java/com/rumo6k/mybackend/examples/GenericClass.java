package com.rumo6k.mybackend.examples;

public class GenericClass<T, V> {

  private T type1;
  private V type2;


  public T getItemType1() {
    return type1;
  }

  public V getItemType2() {
    return type2;
  }

}