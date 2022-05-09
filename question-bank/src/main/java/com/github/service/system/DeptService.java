package com.github.service.system;

import com.github.domain.system.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DeptService {
  void save(Dept dept);
  void delete(Dept dept);
  void update(Dept dept);
  Dept findById(String id);
  List<Dept> findAll();
  PageInfo findAll(int page, int size);
}
