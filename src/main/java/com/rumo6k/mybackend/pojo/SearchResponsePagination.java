package com.rumo6k.mybackend.pojo;

public class SearchResponsePagination {
  private Long totalResultsCount;
  private Integer totalPagesCount;
  private Integer currentResultsCount;
  private Integer currentPageNumber;
  private Integer maxResultsPerPage;

  public Long getTotalResultsCount() {
    return totalResultsCount;
  }

  public void setTotalResultsCount(Long totalResultsCount) {
    this.totalResultsCount = totalResultsCount;
  }

  public Integer getTotalPagesCount() {
    return totalPagesCount;
  }

  public void setTotalPagesCount(Integer totalPagesCount) {
    this.totalPagesCount = totalPagesCount;
  }

  public Integer getCurrentResultsCount() {
    return currentResultsCount;
  }

  public void setCurrentResultsCount(Integer currentResultsCount) {
    this.currentResultsCount = currentResultsCount;
  }

  public Integer getCurrentPageNumber() {
    return currentPageNumber;
  }

  public void setCurrentPageNumber(Integer currentPageNumber) {
    this.currentPageNumber = currentPageNumber;
  }

  public Integer getMaxResultsPerPage() {
    return maxResultsPerPage;
  }

  public void setMaxResultsPerPage(Integer maxResultsPerPage) {
    this.maxResultsPerPage = maxResultsPerPage;
  }
}
