package com.rumo6k.mybackend.lojaControllers;

import com.rumo6k.mybackend.lojaPojo.CarroParams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CarrosController {

  @RequestMapping(method = RequestMethod.POST, path = "/carros")
  public void registrarCarro(@RequestBody CarroParams carroParams) {
    System.out.println(carroParams);
  }
}

