package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.lojaPojo.CarroRegistro;
import com.rumo6k.mybackend.pojo.PaginationParams;
import com.rumo6k.mybackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Lazy
@Repository
public class CarrosRepositoryImpl implements CarrosRepositoryCustom {

  private MongoOperations mongoOperations;

  @Autowired
  public CarrosRepositoryImpl(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public Page<CarroRegistro> findCarrosByParams(Map<String, String> params, PaginationParams pagination) {
    // Serão exibidos primeiro os registros inseridos por último
    Sort sort = Sort.by(Sort.Direction.DESC, "timestamp");

    Pageable pageable = PageRequest.of(pagination.getCurrentPage(), pagination.getPageSize(), sort);

    Query query = new Query().with(pageable);
    Query countQuery = new Query();

    for(String key : params.keySet()) {
      Criteria criteria = Criteria.where(key).is(params.get(key));
      query.addCriteria(criteria);
      countQuery.addCriteria(criteria);
    }

    List<CarroRegistro> carroRegistroList = mongoOperations.find(query, CarroRegistro.class);

    return PageableExecutionUtils.getPage(carroRegistroList, pageable, () -> mongoOperations.count(countQuery, CarroRegistro.class));
  }

  @Override
  public CarroRegistro findCarroById(String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(id));

    return mongoOperations.findOne(query, CarroRegistro.class);
  }
}
