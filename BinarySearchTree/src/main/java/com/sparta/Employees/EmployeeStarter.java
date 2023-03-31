package com.sparta.Employees;

import com.sparta.Room1.BinarySearchTree;
import com.sparta.model.Employee;
import com.sparta.model.Gender;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class EmployeeStarter {
    public static BinarySearchTree start() throws IOException {
        System.out.println("Enter a number between 1 to 1000 to populate employees details: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = scanner.nextInt();
        List<Employee> employeeData = EmployeeFactory.getEmployees(numberOfEmployees);
        BinarySearchTree employeeBinaryTree = new BinarySearchTree();
        employeeBinaryTree.addElements(employeeData);
        return employeeBinaryTree;
    }
}
