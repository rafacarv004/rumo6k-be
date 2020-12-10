package com.rumo6k.mybackend.pojo;

import java.util.List;

public class SearchResponse<T> {

  private List<T> searchResults;
  private SearchResponsePagination pagination;

  public List<T> getSearchResults() {
    return searchResults;
  }

  public void setSearchResults(List<T> searchResults) {
    this.searchResults = searchResults;
  }

  public SearchResponsePagination getPagination() {
    return pagination;
  }

  public void setPagination(SearchResponsePagination pagination) {
    this.pagination = pagination;
  }
}
