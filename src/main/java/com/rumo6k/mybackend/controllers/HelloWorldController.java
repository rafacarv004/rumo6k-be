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

import java.util.List;

@RestController
public class HelloWorldController {

  private UsersService usersService;

  @Autowired
  public HelloWorldController(UsersService usersService) {
    this.usersService = usersService;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/users/byname/{name}")
  public ResponseEntity<List<User>> getUserByName(@PathVariable String name) {

    List<User> users = usersService.getUsersByName(name);

    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/users/byage/{age}")
  public ResponseEntity<List<User>> getUserByAge(@PathVariable Integer age) {

    List<User> users = usersService.getUsersByAge(age);

    return ResponseEntity.status(HttpStatus.OK).body(users);
  }
}
