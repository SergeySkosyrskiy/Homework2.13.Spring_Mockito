package pro.sky.com.example.Homework2._3.Spring_Mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.com.example.Homework2._3.Spring_Mockito.model.Employee;
import pro.sky.com.example.Homework2._3.Spring_Mockito.service.DepartmentService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path ="/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/employees")
    public BigDecimal sumSalary(@PathVariable Integer department){
        return departmentService.getSumSalary(department);
    }


    @GetMapping(path = "/{id}/salary/max")
    public BigDecimal maxSalary(@PathVariable Integer department){
        return departmentService.getMaxSalary(department);
    }
    @GetMapping(path = "/{id}/salary/min")
    public BigDecimal minSalary(@PathVariable Integer department){
        return departmentService.getMinSalary(department);
    }
    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> allEmpoyees(){
        return departmentService.getGroupedEmployeeByDepartnent();
    }
}
