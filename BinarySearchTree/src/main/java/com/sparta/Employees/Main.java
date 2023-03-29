package com.sparta.Employees;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


    List<Employee> employees = new ArrayList<>();
    String[] employeeData = EmployeeFactory.getEmployees(n);
    for (String data: employeeData)

    {
        String[] fields = data.split(",");
        Employee employee = new Employee(fields[0], LocalDate.parse(fields[1]), fields[2], fields[3], fields[4], charAt(0), LocalDate.parse(fields[5]));
        employees.add(employee);
    }
}
}