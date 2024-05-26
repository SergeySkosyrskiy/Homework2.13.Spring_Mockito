package pro.sky.com.example.Homework2._3.Spring_Mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import pro.sky.com.example.Homework2._3.Spring_Mockito.model.Employee;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    //    DepartmentServiceImpl departmentService = new DepartmentServiceImpl(new EmployeeServiceListImpl());
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentServiceImpl departmentService;
    Collection<Employee> employees = List.of(
            new Employee("Пётр", "Петров", 1, new BigDecimal(1000)),
            new Employee("Пётр1", "Петров", 2, new BigDecimal(2000)),
            new Employee("Пётр2", "Петров", 1, new BigDecimal(3000))
    );
    Map<Integer, List<Employee>> employeeByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

    @BeforeEach
    void setUp() {
        Mockito.when(employeeService.getAllEmployess()).thenReturn((List<Employee>) employees);
//    employees=List.of(
//            new Employee("Пётр","Петров",1, BigDecimal.valueOf(1000)),
//            new Employee("Пётр1","Петров",2, BigDecimal.valueOf(2000)),
//            new Employee("Пётр2","Петров",2, BigDecimal.valueOf(3000))
//    );
    }

    @Test
    void getMaxSalary() {

        BigDecimal result = departmentService.getMaxSalary(1);
        Assertions.assertEquals(new BigDecimal(3000), result);
    }

    @Test
    void getMinSalary() {
        BigDecimal result = departmentService.getMinSalary(1);
        Assertions.assertEquals(new BigDecimal(1000), result);
    }

    @Test
    void getSumSalary() {
        BigDecimal result = departmentService.getSumSalary(1);
        Assertions.assertEquals(new BigDecimal(4000), result);
    }

    @Test
    void getEmployeeDepartment() {
        List<Employee> employeeDepartment = departmentService.getEmployeeDepartment(1);
        Assertions.assertEquals(2, employeeDepartment.size());
        Assertions.assertTrue(employeeByDepartment.get(1).containsAll(employeeDepartment));
    }

    @Test
    void getGroupedEmployeeByDepartnent() {
        Map<Integer, List<Employee>> groupedEmployeeByDepartnent = departmentService.getGroupedEmployeeByDepartnent();
        Assertions.assertEquals(groupedEmployeeByDepartnent,employeeByDepartment);
//        Assertions.assertTrue(employeeByDepartment.get(1).containsAll(employeeDepartment));
}
}