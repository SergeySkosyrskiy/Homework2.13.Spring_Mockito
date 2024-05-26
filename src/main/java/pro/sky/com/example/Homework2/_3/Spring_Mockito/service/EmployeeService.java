package pro.sky.com.example.Homework2._3.Spring_Mockito.service;

import pro.sky.com.example.Homework2._3.Spring_Mockito.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, Integer department, BigDecimal salary);

    Employee delete(String firstName, String lastName, Integer department, BigDecimal salary);

    Employee find(String firstName, String lastName, Integer department, BigDecimal salary);

    List<Employee> getAllEmployess();

}
