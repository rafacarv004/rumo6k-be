package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {

  private DatabaseOperations operations;

  @Autowired
  public UsersRepository(DatabaseOperations operations){
    this.operations = operations;
  }

  public User findUserById(String userId) {
    return operations.findUser(userId);
  }
}
