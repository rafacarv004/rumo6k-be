package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.pojo.Endereco;
import com.rumo6k.mybackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

  private MongoOperations mongoOperations;

  @Autowired
  public UsersRepository(MongoOperations mongoOperations){
    this.mongoOperations = mongoOperations;
  }

  public List<User> findUsersByName(String name) {

    Query query = new Query();
    Criteria criteria = Criteria.where("name").is(name);
    query.addCriteria(criteria);

    return mongoOperations.find(query, User.class);
  }

  public List<User> findUsersByAge(Integer age) {
    Query query = new Query();
    Criteria criteria = Criteria.where("age").is(age);
    query.addCriteria(criteria);

    return mongoOperations.find(query, User.class);
  }
}
