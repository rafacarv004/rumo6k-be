package com.rumo6k.mybackend.services;

import com.rumo6k.mybackend.pojo.User;
import com.rumo6k.mybackend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

  private UsersRepository usersRepository;

  @Autowired
  public UsersService(UsersRepository usersRepository){
    this.usersRepository = usersRepository;
  }

  public List<User> getUsersByName(String name) {
    return usersRepository.findUsersByName(name);
  }

  public List<User> getUsersByAge(Integer age) {
    return usersRepository.findUsersByAge(age);
  }
}
