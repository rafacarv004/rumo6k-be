package com.rumo6k.mybackend.pojo;

public class DefaultResponse<T> {
  private T payload;

  public DefaultResponse(T payload) {
    this.payload = payload;
  }

  public T getPayload() {
    return payload;
  }
}
