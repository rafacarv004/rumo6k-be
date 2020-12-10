package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "carros")
public interface CarrosRepository extends PagingAndSortingRepository<CarroRegistro, String>, CarrosRepositoryCustom {}
