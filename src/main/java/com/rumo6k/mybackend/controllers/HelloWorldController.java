package com.rumo6k.mybackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @RequestMapping(method = RequestMethod.GET, path = "/")
  public String helloWorld() {
    String teste = "abcdef";
    teste = teste.replace('b', 'x');

    int x = 8;
    int y = 9;
    int z = x + y;

    if(z < 1000) {
      x = 9;
    }

    teste = teste + x + y;
    return "Olá! Você acabou de criar seu primeiro endpoint! :)" + teste;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/xablau")
  public String xablau() {
    return "Você está errado no caso!";
  }

  @RequestMapping(method = RequestMethod.POST, path = "/superxablau")
  public String superxablau() {
    return "Você está super errado no caso!";
  }
}
