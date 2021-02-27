package com.rumo6k.mybackend.utils;

import com.rumo6k.mybackend.lojaPojo.CarroParams;
import com.rumo6k.mybackend.lojaPojo.CarroRegistro;

public class CarroUtils {

  public static CarroRegistro getCarroRegistroFromParams(CarroParams carroParams) {
    CarroRegistro carroRegistro = new CarroRegistro();
    carroRegistro.setId(carroParams.getId());
    carroRegistro.setAno(carroParams.getAno());
    carroRegistro.setCategoria(carroParams.getCategoria());
    carroRegistro.setCombustivel(carroParams.getCombustivel());
    carroRegistro.setCor(carroParams.getCor());
    carroRegistro.setKm(carroParams.getKm());
    carroRegistro.setMarca(carroParams.getMarca());
    carroRegistro.setModelo(carroParams.getModelo());
    carroRegistro.setMotor(carroParams.getMotor());
    carroRegistro.setPlaca(carroParams.getPlaca());

    return carroRegistro;
  }
}
