package com.sparta.Employees;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


    List<Employee> employees = new ArrayList<>();
        String[] employeeData = new String[0];
        try {
            employeeData = EmployeeFactory.getEmployees(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String data: employeeData)

    {
        String[] fields = data.split(",");
        Employee employee = new Employee(fields[0], LocalDate.parse(fields[1]), fields[2], fields[3], fields[4],  LocalDate.parse(fields[5]));
        employees.add(employee);
    }
}
}