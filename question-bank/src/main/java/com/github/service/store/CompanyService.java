package com.github.service.store;

import com.github.domain.store.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyService {
  void save(Company company);
  void delete(Company company);
  void update(Company company);
  Company findById(String id);
  List<Company> findAll();
  PageInfo findAll(int page, int size);
}
