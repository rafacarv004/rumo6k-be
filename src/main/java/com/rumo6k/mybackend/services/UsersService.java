package com.rumo6k.mybackend.services;

import com.rumo6k.mybackend.pojo.User;
import com.rumo6k.mybackend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  private UsersRepository usersRepository;

  @Autowired
  public UsersService(UsersRepository usersRepository){
    this.usersRepository = usersRepository;
  }

  public User getUserById(String userId) {
    User user = usersRepository.findUserById(userId);
    user.setActive(true);

    return user;
  }
}
