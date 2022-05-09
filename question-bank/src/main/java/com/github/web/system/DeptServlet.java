package com.github.web.system;

import com.github.domain.system.Dept;
import com.github.pagehelper.PageInfo;
import com.github.utils.BeanUtil;
import com.github.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/system/dept")
public class DeptServlet extends BaseServlet {
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
    PageInfo pageInfo = deptService.findAll(page, size);
    req.setAttribute("page", pageInfo);
    req.getRequestDispatcher("/WEB-INF/pages/system/dept/list.jsp").forward(req, resp);
  }

  private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Dept> all = deptService.findAll();
    req.setAttribute("deptList",all);
    req.getRequestDispatcher("/WEB-INF/pages/system/dept/add.jsp").forward(req, resp);
  }

  private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Dept dept = BeanUtil.fillBean(req, Dept.class, "yyyy-MM-dd");
    deptService.save(dept);
    resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
  }

  private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    Dept dept = deptService.findById(id);
    req.setAttribute("dept", dept);
    List<Dept> all = deptService.findAll();
    req.setAttribute("deptList",all);
    req.getRequestDispatcher("/WEB-INF/pages/system/dept/update.jsp").forward(req, resp);
  }

  private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Dept dept = BeanUtil.fillBean(req, Dept.class, "yyyy-MM-dd");
    deptService.update(dept);
    resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
  }

  private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Dept dept = BeanUtil.fillBean(req, Dept.class);
    deptService.delete(dept);
    resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
  }
}
