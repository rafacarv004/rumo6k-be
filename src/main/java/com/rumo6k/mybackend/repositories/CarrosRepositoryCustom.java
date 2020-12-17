package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import com.rumo6k.mybackend.pojo.PaginationParams;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface CarrosRepositoryCustom {
  Page<CarroRegistro> findCarrosByParams(Map<String, String> params, PaginationParams pagination);
}
