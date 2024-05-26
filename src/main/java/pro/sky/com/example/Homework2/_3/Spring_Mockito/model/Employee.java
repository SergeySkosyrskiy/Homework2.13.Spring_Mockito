package pro.sky.com.example.Homework2._3.Spring_Mockito.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private String address;
    private Integer department;
    private BigDecimal salary;

    public Employee(String firstName, String lastName, Integer department, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

//    private Double salary;


    public String getAddress() {
        return address;
    }


    public Integer getDepartment() {
        return department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Integer getDepartmentNumber() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(address, employee.address) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
