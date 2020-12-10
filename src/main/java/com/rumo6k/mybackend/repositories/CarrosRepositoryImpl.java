package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Lazy
@Repository
public class CarrosRepositoryImpl implements CarrosRepositoryCustom {

  private MongoOperations mongoOperations;

  @Autowired
  public CarrosRepositoryImpl(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public List<CarroRegistro> findCarrosByParams(Map<String, String> params) {
    // Serão exibidos primeiro os registros inseridos por último
    Sort sort = Sort.by(Sort.Direction.DESC, "timestamp");
    //TODO: Inserir esquema de paginação aqui
    Query query = new Query().with(sort);

    for(String key : params.keySet()) {
      Criteria criteria = Criteria.where(key).is(params.get(key));
      query.addCriteria(criteria);
    }

    return mongoOperations.find(query, CarroRegistro.class);
  }
}
