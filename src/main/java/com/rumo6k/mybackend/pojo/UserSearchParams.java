package com.rumo6k.mybackend.pojo;

public class UserSearchParams {

  private PaginationParams pagination;
  private int age;

  public PaginationParams getPagination() {
    return pagination;
  }

  public void setPagination(PaginationParams pagination) {
    this.pagination = pagination;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
