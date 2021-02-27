package com.rumo6k.mybackend.services;

import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import com.rumo6k.mybackend.pojo.PaginationParams;
import com.rumo6k.mybackend.repositories.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarrosService {

  private static final int DEFAULT_CURRENT_PAGE = 0;
  private static final int DEFAULT_PAGE_SIZE = 10;
  private CarrosRepository carrosRepository;

  @Autowired
  public CarrosService(CarrosRepository carrosRepository) {
    this.carrosRepository = carrosRepository;
  }

  public void registrarCarro(CarroRegistro carroRegistro) {
    enrichCarroData(carroRegistro);
    carrosRepository.save(carroRegistro);
  }

  private void enrichCarroData(CarroRegistro carroRegistro) {
    carroRegistro.setTimestamp(System.currentTimeMillis());
  }

  public Page<CarroRegistro> busca(Map<String, String> buscaParams, PaginationParams pagination) {
    if(pagination == null) {
      pagination = new PaginationParams();
    }
    if(pagination.getPageSize() == null) {
      pagination.setPageSize(DEFAULT_PAGE_SIZE);
    }
    if(pagination.getCurrentPage() == null) {
      pagination.setCurrentPage(DEFAULT_CURRENT_PAGE);
    }

    return carrosRepository.findCarrosByParams(buscaParams, pagination);
  }

  public CarroRegistro getCarro(String id) {
    return carrosRepository.findCarroById(id);
  }

  public void updateCarro(CarroRegistro carroRegistro) {
    carrosRepository.save(carroRegistro);
  }
}
