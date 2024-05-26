package pro.sky.com.example.Homework2._3.Spring_Mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.com.example.Homework2._3.Spring_Mockito.exception.ArrayIsFullException;
import pro.sky.com.example.Homework2._3.Spring_Mockito.exception.EmployeeAlreadyAddedException;
import pro.sky.com.example.Homework2._3.Spring_Mockito.exception.EmployeeNotFoundException;
import pro.sky.com.example.Homework2._3.Spring_Mockito.model.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int COUNT_EMPLOYEE = 15;
    private final List<Employee> employees = new ArrayList<>(COUNT_EMPLOYEE);

    @Override
    public Employee add(String firstName, String lastName, Integer department, BigDecimal salary) {
        if (employees.size() >= COUNT_EMPLOYEE) {
            throw new ArrayIsFullException("ArrayIsFullException");
        }
        Employee employee = new Employee(firstName, lastName,department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAddedException");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee delete(String firstName, String lastName, Integer department, BigDecimal salary) {
        Employee newEmployee = new Employee(firstName, lastName,department, salary);
        boolean deleted = false;
        for (int i=0; i< employees.size();i++){
            Employee employee = employees.get(i);
            if ( employee.equals(newEmployee)){
                employees.remove(i);
            }
        }
        return newEmployee;
    }

    @Override
    public Employee find(String firstName, String lastName, Integer department, BigDecimal salary) {
        Integer dept = 0;
        Employee newEmployee = new Employee(firstName, lastName,department, salary);
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден " + firstName);
    }

    @Override
    public List<Employee> getAllEmployess() {
        return Collections.unmodifiableList(employees);
    }


}
