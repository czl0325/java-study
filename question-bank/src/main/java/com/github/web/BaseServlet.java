package com.github.web;

import com.github.service.store.CompanyService;
import com.github.service.store.impl.CompanyServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
  protected CompanyService companyService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    companyService = new CompanyServiceImpl();
  }
}
