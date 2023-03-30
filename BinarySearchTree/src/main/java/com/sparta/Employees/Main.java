package com.sparta.Employees;
import com.sparta.Room1.BinarySearchTree;
import com.sparta.model.Employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static BinarySearchTree employeeBinaryTree=null;

    public static void main(String[] args) throws IOException {
        boolean exit=false;
        employeeBinaryTree=EmployeeStarter.start();
        while(!exit){
            System.out.println("Enter a lastname of employee to find details: ");
            Scanner scanner=new Scanner(System.in);
            String lastname=scanner.nextLine();
            Set<Employee> employeeSet= employeeBinaryTree.findElement(lastname);
            System.out.println(employeeSet);
        }



}
}