package com.rumo6k.mybackend.controllers;

import com.rumo6k.mybackend.pojo.User;
import com.rumo6k.mybackend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private UsersService usersService;

  @Autowired
  public HelloWorldController(UsersService usersService) {
    this.usersService = usersService;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}")
  public ResponseEntity<User> getUser(@PathVariable String userId) {

    User user = usersService.getUserById(userId);

    return ResponseEntity.status(HttpStatus.OK).body(user);
  }
}
