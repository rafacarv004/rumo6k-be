package com.rumo6k.mybackend.services;

import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import com.rumo6k.mybackend.repositories.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarrosService {

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

  public List<CarroRegistro> busca(Map<String, String> buscaParams) {
    return carrosRepository.findCarrosByParams(buscaParams);
  }
}
