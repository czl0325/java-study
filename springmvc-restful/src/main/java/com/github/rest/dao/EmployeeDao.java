package com.github.rest.dao;

import com.github.rest.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@qq.com", 1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@qq.com", 2));
        employees.put(1003, new Employee(1003, "E-CC", "cc@qq.com", 1));
        employees.put(1004, new Employee(1004, "E-DD", "dd@qq.com", 2));
        employees.put(1005, new Employee(1005, "E-EE", "ee@qq.com", 1));
    }

    private static Integer initId = 1006;
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getById(Integer id) {
        return employees.get(id);
    }
}
