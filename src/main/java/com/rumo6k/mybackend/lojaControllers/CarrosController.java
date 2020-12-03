package com.rumo6k.mybackend.lojaControllers;

import static com.rumo6k.mybackend.utils.CarroUtils.getCarroRegistroFromParams;

import com.rumo6k.mybackend.lojaPojo.CarroParams;
import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import com.rumo6k.mybackend.services.CarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CarrosController {

  private CarrosService carrosService;

  @Autowired
  public CarrosController(CarrosService carrosService) {
    this.carrosService = carrosService;
  }

  @RequestMapping(method = RequestMethod.POST, path = "/carros")
  public ResponseEntity registrarCarro(@RequestBody CarroParams carroParams) {
    CarroRegistro carroRegistro = getCarroRegistroFromParams(carroParams);
    carrosService.registrarCarro(carroRegistro);

    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/carros")
  public ResponseEntity registrarCarro(@RequestParam String marca, @RequestParam String modelo, @RequestParam(required = false) String cor) {
    System.out.println(marca);
    System.out.println(modelo);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
