package com.github.service.system.impl;

import com.github.dao.system.DeptDao;
import com.github.domain.system.Dept;
import com.github.factory.MapperFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.service.system.DeptService;
import com.github.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class DeptServiceImpl implements DeptService {
  @Override
  public void save(Dept dept) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
      dept.setId(UUID.randomUUID().toString());
      deptDao.save(dept);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void delete(Dept dept) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
      deptDao.delete(dept);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void update(Dept dept) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
      deptDao.update(dept);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public Dept findById(String id) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
      return deptDao.findById(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public List<Dept> findAll() {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
      return deptDao.findAll();
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
      DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
      PageHelper.startPage(page, size);
      List<Dept> all = deptDao.findAll();
      return new PageInfo(all);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }
}
