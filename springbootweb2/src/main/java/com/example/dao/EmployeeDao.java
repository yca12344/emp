package com.example.dao;

import com.example.pojo.Department;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {

        employees = new HashMap<Integer,Employee>();

        employees.put(1001,new Employee(1001,"张三","1877267899@qq.com",0,new Department(101,"后勤部"),"2000-11-22"));
        employees.put(1002,new Employee(1002,"李四","2212344542@qq.com",1,new Department(102,"市场部"),"2000-09-19"));
        employees.put(1003,new Employee(1003,"王五","3251672662@qq.com",0,new Department(103,"运营部"),"1998-08-11"));
        employees.put(1004,new Employee(1004,"小样","8389918377@qq.com",1,new Department(104,"市场部"),"1999-09-23"));
        employees.put(1005,new Employee(1005,"俞锦程","1238737447@qq.com",1,new Department(105,"教学部"),"2000-02-11"));

    }

    private static Integer initId = 1006;
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
