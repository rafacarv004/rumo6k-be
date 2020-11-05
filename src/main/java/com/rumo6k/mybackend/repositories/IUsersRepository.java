package com.rumo6k.mybackend.repositories;

import com.rumo6k.mybackend.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "users")
public interface IUsersRepository extends PagingAndSortingRepository<User, String>{}
