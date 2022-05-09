package com.github.service.system;

import com.github.domain.system.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
  void save(User user);
  void delete(User user);
  void update(User user);
  User findById(String id);
  List<User> findAll();
  PageInfo findAll(int page, int size);
}
