package com.rumo6k.mybackend.pojo;

public class ProductSearchParams {
  private PaginationParams pagination;
  private int productType;

  public PaginationParams getPagination() {
    return pagination;
  }

  public void setPagination(PaginationParams pagination) {
    this.pagination = pagination;
  }

  public int getProductType() {
    return productType;
  }

  public void setProductType(int productType) {
    this.productType = productType;
  }
}
