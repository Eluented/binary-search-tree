package com.sparta.Room1;

import com.sparta.model.Employee;

import java.util.HashSet;
import java.util.Set;

public class Node {
    String lastName;
    Set<Employee> employees;
    Node left, right;

    Node(Employee employee) {

        this.lastName = employee.getLastName();
        if(null == employees) {
            employees = new HashSet<>();
        }
        employees.add(employee);
    }
}
