package pro.sky.com.example.Homework2._3.Spring_Mockito.service;

import pro.sky.com.example.Homework2._3.Spring_Mockito.model.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    BigDecimal getMaxSalary(Integer department);

    BigDecimal getMinSalary(Integer department);

    BigDecimal getSumSalary(Integer department);

    List<Employee> getEmployeeDepartment(Integer department);

    Map<Integer,List<Employee>> getGroupedEmployeeByDepartnent();
}
