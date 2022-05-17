package com.github.web;

import com.github.domain.store.Course;
import com.github.service.store.CompanyService;
import com.github.service.store.CourseService;
import com.github.service.store.impl.CompanyServiceImpl;
import com.github.service.store.impl.CourseServiceImpl;
import com.github.service.system.DeptService;
import com.github.service.system.UserService;
import com.github.service.system.impl.DeptServiceImpl;
import com.github.service.system.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
  protected CompanyService companyService;
  protected DeptService deptService;
  protected UserService userService;
  protected CourseService courseService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    companyService = new CompanyServiceImpl();
    deptService = new DeptServiceImpl();
    userService = new UserServiceImpl();
    courseService = new CourseServiceImpl();
  }
}
