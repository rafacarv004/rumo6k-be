package com.rumo6k.mybackend.services;

import com.rumo6k.mybackend.pojo.PaginationParams;
import com.rumo6k.mybackend.pojo.User;
import com.rumo6k.mybackend.repositories.IUsersRepository;
import com.rumo6k.mybackend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

  private static final int DEFAULT_CURRENT_PAGE = 1;
  private static final int DEFAULT_PAGE_SIZE = 10;
  private UsersRepository usersRepository;
  private IUsersRepository iUsersRepository;

  @Autowired
  public UsersService(UsersRepository usersRepository, IUsersRepository iUsersRepository){
    this.usersRepository = usersRepository;
    this.iUsersRepository = iUsersRepository;
  }

  public User getUserById(String userId) {
    return usersRepository.findUsersByUserId(userId);
  }

  public Page<User> getUsersByAge(Integer age, PaginationParams pagination) {

    // Se o brother não passou dados de paginação
    // hydrate ou enrich -> "hidratar" ou "enriquecer" o objeto, colocando dados que estavam faltando e que precisam ser usados

    if(pagination == null) {
      pagination = new PaginationParams();
    }
    if(pagination.getPageSize() == null) {
      pagination.setPageSize(DEFAULT_PAGE_SIZE);
    }
    if(pagination.getCurrentPage() == null) {
      pagination.setCurrentPage(DEFAULT_CURRENT_PAGE);
    }

    return usersRepository.findUsersByAge(age, pagination);
  }

  public void createUser(User user) {
    usersRepository.createUser(user);
  }
}
