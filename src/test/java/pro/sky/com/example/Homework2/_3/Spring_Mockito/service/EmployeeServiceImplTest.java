package pro.sky.com.example.Homework2._3.Spring_Mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.com.example.Homework2._3.Spring_Mockito.exception.EmployeeAlreadyAddedException;
import pro.sky.com.example.Homework2._3.Spring_Mockito.model.Employee;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    void add() {
        Employee expectedEmployee = new Employee("Иван", "Иванов",1, BigDecimal.valueOf(1000));
        Employee addedEmployee = employeeService.add("Иван", "Иванов",1, BigDecimal.valueOf(1000));
        assertEquals(1, employeeService.getAllEmployess().size());
        assertEquals(expectedEmployee, addedEmployee);
        assertEquals(expectedEmployee, employeeService.find("Иван", "Иванов",1, BigDecimal.valueOf(1000)));
    }

    @Test
    void add1() {
        employeeService.add("Иван", "Иванов",1, BigDecimal.valueOf(1000));
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("Иван", "Иванов",1, BigDecimal.valueOf(1000)));
    }

//    @Test
//    void add2() {
//        employeeService.add("Иван1", "Иванов");
//        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("Иван", "Иванов"));
//    }

    @Test
    void delete() {
        Employee expected = employeeService.add("FIRST_NAME", "LAST_NAME",1, BigDecimal.valueOf(1000));
        assertEquals(1, employeeService.getAllEmployess().size());
        assertTrue(employeeService.getAllEmployess().contains(expected));

        Employee actual = employeeService.delete ("FIRST_NAME", "LAST_NAME",1, BigDecimal.valueOf(1000));
        assertEquals(expected, actual);
        assertTrue(employeeService.getAllEmployess().isEmpty());
//        assertFalse(employeeService.findAll().contains(expected));
    }

    @Test
    void find() {
        Employee existed = employeeService.add("FIRST_NAME", "LAST_NAME",1, BigDecimal.valueOf(1000));
        assertEquals(existed, employeeService.find("FIRST_NAME", "LAST_NAME",1, BigDecimal.valueOf(1000)));
    }

    @Test
    void findAll() {
        Employee employee1 = employeeService.add("FIRST_NAME", "LAST_NAME",1, BigDecimal.valueOf(1000));
        Employee employee2 = employeeService.add("FIRST_NAME", "LAST_NAME",2, BigDecimal.valueOf(2000));

        Collection<Employee> expected= List.of(employee1,employee2);
        Collection<Employee> actual = employeeService.getAllEmployess();
        Assertions.assertFalse(expected.contains(actual));

//        assertIterableEquals(expected,actual);


    }
}