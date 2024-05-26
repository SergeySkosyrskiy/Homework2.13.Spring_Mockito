package pro.sky.com.example.Homework2._3.Spring_Mockito.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.com.example.Homework2._3.Spring_Mockito.model.Employee;
import pro.sky.com.example.Homework2._3.Spring_Mockito.service.EmployeeService;

import java.math.BigDecimal;
@RestController
@RequestMapping("department")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer deparmentId, @RequestParam BigDecimal salary) {
        return employeeService.add(firstName, lastName, deparmentId, salary);
    }


    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer department, @RequestParam BigDecimal salary) {
        return employeeService.delete(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer department, @RequestParam BigDecimal salary) {
        return employeeService.find(firstName, lastName, department, salary);
    }
}
