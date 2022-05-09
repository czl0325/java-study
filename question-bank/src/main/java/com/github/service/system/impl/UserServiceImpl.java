package com.github.service.system.impl;

import com.github.dao.system.DeptDao;
import com.github.dao.system.UserDao;
import com.github.domain.system.Dept;
import com.github.domain.system.User;
import com.github.factory.MapperFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.service.system.UserService;
import com.github.utils.TransactionUtil;
import com.github.web.BaseServlet;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
  @Override
  public void save(User user) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
      user.setId(UUID.randomUUID().toString());
      userDao.save(user);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void delete(User user) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
      userDao.delete(user);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void update(User user) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
      userDao.update(user);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public User findById(String id) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
      return userDao.findById(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public List<User> findAll() {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
      return userDao.findAll();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public PageInfo findAll(int page, int size) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
      PageHelper.startPage(page, size);
      List<User> all = userDao.findAll();
      return new PageInfo(all);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }
}
