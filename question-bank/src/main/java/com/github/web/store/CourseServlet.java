package com.github.web.store;

import com.github.domain.store.Course;
import com.github.pagehelper.PageInfo;
import com.github.utils.BeanUtil;
import com.github.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/store/course")
public class CourseServlet extends BaseServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String operation = req.getParameter("operation");
    if ("list".equals(operation)) {
      this.list(req, resp);
    } else if ("toAdd".equals(operation)) {
      this.toAdd(req, resp);
    } else if ("save".equals(operation)) {
      this.save(req, resp);
    } else if ("toEdit".equals(operation)) {
      this.toEdit(req, resp);
    } else if ("edit".equals(operation)) {
      this.edit(req, resp);
    } else if ("delete".equals(operation)) {
      this.delete(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }

  private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int page = 1;
    int size = 5;
    if (StringUtils.isNotBlank(req.getParameter("page"))) {
      page = Integer.parseInt(req.getParameter("page"));
    }
    if (StringUtils.isNotBlank(req.getParameter("size"))) {
      size = Integer.parseInt(req.getParameter("size"));
    }
    PageInfo all = courseService.findAll(page, size);
    req.setAttribute("page", all);
    req.getRequestDispatcher("/WEB-INF/pages/store/course/list.jsp").forward(req, resp);
  }

  private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/pages/store/course/add.jsp").forward(req, resp);
  }

  private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Course course = BeanUtil.fillBean(req, Course.class, "yyyy-MM-dd");
    courseService.save(course);
    resp.sendRedirect(req.getContextPath() + "/store/course?operation=list");
  }

  private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    Course course = courseService.findById(id);
    req.setAttribute("course", course);
    req.getRequestDispatcher("/WEB-INF/pages/store/course/update.jsp").forward(req, resp);
  }

  private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Course course = BeanUtil.fillBean(req, Course.class,"yyyy-MM-dd");
    courseService.update(course);
    resp.sendRedirect(req.getContextPath() + "/store/course?operation=list");
  }

  private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Course course = BeanUtil.fillBean(req, Course.class);
    courseService.delete(course);
    resp.sendRedirect(req.getContextPath() + "/store/course?operation=list");
  }
}
