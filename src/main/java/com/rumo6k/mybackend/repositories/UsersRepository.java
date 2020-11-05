package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.pojo.Endereco;
import com.rumo6k.mybackend.pojo.PaginationParams;
import com.rumo6k.mybackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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

@Repository
public class UsersRepository {

  private MongoOperations mongoOperations;

  @Autowired
  public UsersRepository(MongoOperations mongoOperations){
    this.mongoOperations = mongoOperations;
  }

  public User findUsersByUserId(String userId) {
    return mongoOperations.findById(userId, User.class);
  }

   /*
    Paginação:
    - pageSize
    - currentPage
    - sort
   */

  public Page<User> findUsersByAge(Integer age, PaginationParams pagination) {
    Sort sort = Sort.by(Sort.Direction.ASC, "name");
    Pageable pageable = PageRequest.of(pagination.getCurrentPage(), pagination.getPageSize(), sort);

    Query query = new Query().with(pageable);

    Criteria criteria = Criteria.where("age").is(age); // aqui dá pra trocar o tipo de comparação
    query.addCriteria(criteria);

    List<User> usersList = mongoOperations.find(query, User.class);

    Query countQuery = new Query();
    countQuery.addCriteria(criteria);

    return PageableExecutionUtils.getPage(usersList, pageable, () -> mongoOperations.count(countQuery, User.class));
  }

  public void createUser(User user) {
    mongoOperations.insert(user);
  }
}
