package com.rumo6k.mybackend.controllers;

import com.rumo6k.mybackend.pojo.PaginationParams;
import com.rumo6k.mybackend.pojo.SearchResponse;
import com.rumo6k.mybackend.pojo.SearchResponsePagination;
import com.rumo6k.mybackend.pojo.User;
import com.rumo6k.mybackend.pojo.UserSearchParams;
import com.rumo6k.mybackend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloWorldController {

  private UsersService usersService;

  @Autowired
  public HelloWorldController(UsersService usersService) {
    this.usersService = usersService;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}")
  public ResponseEntity<User> getUserByName(@PathVariable String userId) {

    User user = usersService.getUserById(userId);

    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.GET, path = "/hello")
  public ResponseEntity<String> getHello() {

    return ResponseEntity.status(HttpStatus.OK).body("hello");
  }

  @RequestMapping(method = RequestMethod.POST, path = "/users/search")
  public ResponseEntity<SearchResponse> getUserByAge(@RequestBody UserSearchParams userSearchParams) {

    PaginationParams pagination = userSearchParams.getPagination();
    int age = userSearchParams.getAge();
    Page<User> usersPage = usersService.getUsersByAge(age, pagination);

    SearchResponsePagination searchResponsePagination = new SearchResponsePagination();
    searchResponsePagination.setCurrentPageNumber(usersPage.getNumber()); // página atual
    searchResponsePagination.setTotalResultsCount(usersPage.getTotalElements()); // número total no banco
    searchResponsePagination.setMaxResultsPerPage(usersPage.getSize()); // número máximo de itens por página (foi enviado na request)
    searchResponsePagination.setCurrentResultsCount(usersPage.getNumberOfElements()); // número de itens na página atual
    searchResponsePagination.setTotalPagesCount(usersPage.getTotalPages()); // número total de páginas

    SearchResponse searchResponse = new SearchResponse();
    searchResponse.setPagination(searchResponsePagination);
    searchResponse.setSearchResults(usersPage.getContent());

    return ResponseEntity.status(HttpStatus.OK).body(searchResponse);
  }

  @RequestMapping(method = RequestMethod.POST, path = "/users")
  public ResponseEntity<String> getUserByAge(@RequestBody User user) {

    usersService.createUser(user);

    return ResponseEntity.status(HttpStatus.OK).body("Usuário registrado com sucesso!");
  }
}
