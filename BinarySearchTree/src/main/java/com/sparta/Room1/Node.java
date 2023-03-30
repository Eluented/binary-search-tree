package com.sparta.Room1;

import com.sparta.model.Employee;

import java.util.Set;

public class Node {
    String lastName;
    Set<Employee> employees;
    Node left, right;

    Node(String  value) {

        this.lastName = value;
    }
}
