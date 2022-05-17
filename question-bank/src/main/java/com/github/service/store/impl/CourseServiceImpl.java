package com.github.service.store.impl;

import com.github.dao.store.CourseDao;
import com.github.domain.store.Course;
import com.github.factory.MapperFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.service.store.CourseService;
import com.github.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class CourseServiceImpl implements CourseService {
  @Override
  public void save(Course course) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
      course.setId(UUID.randomUUID().toString());
      courseDao.save(course);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void delete(Course course) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
      courseDao.delete(course);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void update(Course course) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
      courseDao.update(course);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public Course findById(String id) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
      return courseDao.findById(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public List<Course> findAll() {
    return null;
  }

  @Override
  public PageInfo findAll(int page, int size) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
      PageHelper.startPage(page, size);
      List<Course> all = courseDao.findAll();
      PageInfo pageInfo = new PageInfo(all);
      return pageInfo;
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }
}
