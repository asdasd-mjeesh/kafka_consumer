package com.javamaster.service;

import com.javamaster.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    boolean deleteById(Long id);
}
