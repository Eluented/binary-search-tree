package com.sparta.service;

//import com.sparta.Room1.BinarySearchTree;
import com.sparta.Room1.BinaryTree;
import com.sparta.model.Employee;

import java.util.List;

public class EmployeeService {
    BinaryTree employeeTree ;

    public void addEmployees(List<Employee> employees) {
       // employeeTree = new BinarySearchTree();
        employeeTree.addElements(employees);
    }

}
