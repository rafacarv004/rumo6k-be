package com.rumo6k.mybackend.lojaControllers;

import static com.rumo6k.mybackend.utils.CarroUtils.getCarroRegistroFromParams;

import com.rumo6k.mybackend.lojaPojo.CarroParams;
import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import com.rumo6k.mybackend.pojo.SearchResponse;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  public ResponseEntity registrarCarro(
      @RequestParam(required = false) String marca,
      @RequestParam(required = false) String modelo,
      @RequestParam(required = false) String cor,
      @RequestParam(required = false) String ano,
      @RequestParam(required = false) String combustivel,
      @RequestParam(required = false) String motor,
      @RequestParam(required = false) String categoria,
      @RequestParam(required = false) String placa,
      @RequestParam(required = false) String km) {

    Map<String, String> buscaParams = new HashMap<>();

    if(marca != null) {
      buscaParams.put("marca", marca);
    }

    if(modelo != null) {
      buscaParams.put("modelo", modelo);
    }

    if(cor != null) {
      buscaParams.put("cor", cor);
    }

    if(ano != null) {
      buscaParams.put("ano", ano);
    }

    if(combustivel != null) {
      buscaParams.put("combustivel", combustivel);
    }

    if(motor != null) {
      buscaParams.put("motor", motor);
    }

    if(categoria != null) {
      buscaParams.put("categoria", categoria);
    }

    if(placa != null) {
      buscaParams.put("placa", placa);
    }

    if(km != null) {
      buscaParams.put("km", km);
    }

    List<CarroRegistro> carros = carrosService.busca(buscaParams);
    SearchResponse<CarroRegistro> response = new SearchResponse<>();
    response.setSearchResults(carros);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
