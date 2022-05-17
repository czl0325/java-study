package com.github.service.store;

import com.github.domain.store.Course;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseService {
  void save(Course course);
  void delete(Course course);
  void update(Course course);
  Course findById(String id);
  List<Course> findAll();
  PageInfo findAll(int page, int size);
}
