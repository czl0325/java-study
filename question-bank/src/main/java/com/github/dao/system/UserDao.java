package com.github.dao.system;

import com.github.domain.system.User;

import java.util.List;

public interface UserDao {
  int save(User user);
  int delete(User user);
  int update(User user);
  User findById(String id);
  List<User> findAll();
}
