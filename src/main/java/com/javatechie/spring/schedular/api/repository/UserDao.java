package com.javatechie.spring.schedular.api.repository;

import com.javatechie.spring.schedular.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>
{

}
