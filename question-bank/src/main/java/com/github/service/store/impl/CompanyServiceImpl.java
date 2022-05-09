package com.github.service.store.impl;

import com.github.dao.store.CompanyDao;
import com.github.domain.store.Company;
import com.github.factory.MapperFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.service.store.CompanyService;
import com.github.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class CompanyServiceImpl implements CompanyService {
  @Override
  public void save(Company company) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
      company.setId(UUID.randomUUID().toString());
      companyDao.save(company);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void delete(Company company) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
      companyDao.delete(company);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public void update(Company company) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
      companyDao.update(company);
      TransactionUtil.commit(sqlSession);
    } catch (Exception e) {
      TransactionUtil.rollback(sqlSession);
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public Company findById(String id) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
      return companyDao.findById(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }

  @Override
  public List<Company> findAll() {
    return null;
  }

  @Override
  public PageInfo findAll(int page, int size) {
    SqlSession sqlSession = null;
    try {
      sqlSession = MapperFactory.getSqlSession();
      CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
      PageHelper.startPage(page, size);
      List<Company> all = companyDao.findAll();
      PageInfo pageInfo = new PageInfo(all);
      return pageInfo;
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      TransactionUtil.close(sqlSession);
    }
  }
}
