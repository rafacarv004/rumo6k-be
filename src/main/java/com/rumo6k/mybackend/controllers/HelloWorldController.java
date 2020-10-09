package com.rumo6k.mybackend.controllers;

import static org.springframework.http.HttpStatus.OK;

import com.rumo6k.mybackend.examples.GenericClass;
import com.rumo6k.mybackend.pojo.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.content.text.Generic;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

  @RequestMapping(method = RequestMethod.GET, path = "/")
  public ResponseEntity<Endereco> getAddress(@RequestParam String cep) {

    Endereco endereco = new Endereco();

    if(cep.equals("13272315")) {
      endereco.setRua("João Previtale");
      endereco.setCidade("Valinhos");
      endereco.setEstado("SP");
      endereco.setPais("Brasil");
    } else if(cep.equals("12345679")) {
      endereco.setRua("Rua 1");
      endereco.setCidade("São Paulo");
      endereco.setEstado("SP");
      endereco.setPais("Brasil");
    }

//    Map<String, String> myMap = new HashMap<>();
//    myMap.put("rua", "João Previtale");
//    myMap.put("minhaCidade", "Valinhos");
//    myMap.put("estado", "SP");
//    myMap.put("pais", "Brasil");

    return ResponseEntity
          .status(HttpStatus.OK)
          .body(endereco);

//    if(userHasAccess("1234567890")) {
//      return ResponseEntity
//          .status(HttpStatus.OK)
//          .body("Legal, você está autenticado e conseguiu fazer essa request! :)");
//    }
//    return ResponseEntity
//        .status(HttpStatus.UNAUTHORIZED)
//        .body("Cara, eu não te conheço... você não deveria estar aqui!");

  }

  @RequestMapping(method = RequestMethod.GET, path = "/xablau")
  public String xablau() {
    return "Você está errado no caso!";
  }

  @RequestMapping(method = RequestMethod.POST, path = "/superxablau")
  public String superxablau() {
    return "Você está super errado no caso!";

  }

  // método nullsafe
  private boolean userHasAccess(int userId) {
    return false;
  }

  // método não nullsafe
  private boolean userHasAccess(Integer userId) {
    return false;
  }
}

// auto boxing e auto unboxing -> java
// objetos com valor null NUNCA conseguem usar métodos.
// Nesse caso é lançada uma NullPointerException -> quebrado!
