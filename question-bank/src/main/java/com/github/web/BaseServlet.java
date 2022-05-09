package com.github.web;

import com.github.service.store.CompanyService;
import com.github.service.store.impl.CompanyServiceImpl;
import com.github.service.system.DeptService;
import com.github.service.system.impl.DeptServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
  protected CompanyService companyService;
  protected DeptService deptService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    companyService = new CompanyServiceImpl();
    deptService = new DeptServiceImpl();
  }
}
