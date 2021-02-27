package com.rumo6k.mybackend.lojaControllers;

import static com.rumo6k.mybackend.utils.CarroUtils.getCarroRegistroFromParams;

import com.rumo6k.mybackend.lojaPojo.CarroParams;
import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import com.rumo6k.mybackend.pojo.DefaultResponse;
import com.rumo6k.mybackend.pojo.PaginationParams;
import com.rumo6k.mybackend.pojo.SearchResponse;
import com.rumo6k.mybackend.pojo.SearchResponsePagination;
import com.rumo6k.mybackend.services.CarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

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
  public ResponseEntity findCarros(
      @RequestParam(required = false) Integer currentPage,
      @RequestParam(required = false) Integer pageSize,
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

    PaginationParams paginationParams = new PaginationParams();
    paginationParams.setCurrentPage(currentPage);
    paginationParams.setPageSize(pageSize);

    Page<CarroRegistro> carros = carrosService.busca(buscaParams, paginationParams);
    SearchResponse<CarroRegistro> response = new SearchResponse<>();

    SearchResponsePagination searchResponsePagination = new SearchResponsePagination();
    searchResponsePagination.setCurrentPageNumber(carros.getNumber()); // página atual
    searchResponsePagination.setTotalResultsCount(carros.getTotalElements()); // número total no banco
    searchResponsePagination.setMaxResultsPerPage(carros.getSize()); // número máximo de itens por página (foi enviado na request)
    searchResponsePagination.setCurrentResultsCount(carros.getNumberOfElements()); // número de itens na página atual
    searchResponsePagination.setTotalPagesCount(carros.getTotalPages()); // número total de páginas

    response.setSearchResults(carros.getContent());
    response.setPagination(searchResponsePagination);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/carros/{id}")
  public ResponseEntity findCarros(@PathVariable String id) {
    CarroRegistro carroRegistro = carrosService.getCarro(id);

    DefaultResponse<CarroRegistro> response = new DefaultResponse<>(carroRegistro);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @RequestMapping(method = RequestMethod.POST, path = "/carros/update")
  public ResponseEntity updateCarro(@RequestBody CarroParams carroParams) {
    CarroRegistro carroRegistro = getCarroRegistroFromParams(carroParams);
    carrosService.updateCarro(carroRegistro);

    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
