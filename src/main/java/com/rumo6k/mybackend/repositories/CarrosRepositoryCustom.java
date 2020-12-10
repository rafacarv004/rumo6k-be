package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.lojaPojo.CarroRegistro;

import java.util.List;
import java.util.Map;

public interface CarrosRepositoryCustom {
  List<CarroRegistro> findCarrosByParams(Map<String, String> params);
}
