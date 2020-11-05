package com.rumo6k.mybackend.pojo;

import java.util.List;

public class SearchResponse {

  private List<User> searchResults;
  private SearchResponsePagination pagination;

  public List<User> getSearchResults() {
    return searchResults;
  }

  public void setSearchResults(List<User> searchResults) {
    this.searchResults = searchResults;
  }

  public SearchResponsePagination getPagination() {
    return pagination;
  }

  public void setPagination(SearchResponsePagination pagination) {
    this.pagination = pagination;
  }
}
