package com.sparta.Employees;
import com.sparta.model.Employee;
import com.sparta.model.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import java.io.*;
import java.util.*;

public class EmployeeFactory {
    // returns an array containing numEmployees Strings, each representing an Employee as a row from the CSV file
    // 1 <= numEmployees <= 1000
    // may throw IOExceptions, which need to be dealt with in the client code
    // employees.csv should be in the src/main/resources folder in the project
    private static final String[] FIRST_NAMES = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "George", "Hannah", "Isabelle", "James"};
    private static final String[] LAST_NAMES = {"Adams", "Brown", "Clark", "Davis", "Edwards", "Ford", "Garcia", "Hill", "Irwin", "Johnson"};

    private static final Random random = new Random();

//    public static Employee[] getEmployees(int n) {
//        Employee[] employees = new Employee[n];
//        for (int i = 0; i < n; i++) {
//            employees[i] = createRandomEmployee();
//        }
//        return employees;
//    }
    private static Employee createRandomEmployee() {
        String empNo = String.format("%08d", random.nextInt(99999999));
        LocalDate birthDate = LocalDate.of(random.nextInt(50) + 1950, random.nextInt(12) + 1, random.nextInt(28) + 1);
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        LocalDate hireDate = LocalDate.of(random.nextInt(20) + 2000, random.nextInt(12) + 1, random.nextInt(28) + 1);
        return new Employee(empNo, birthDate, firstName, lastName, gender, hireDate);
    }

    public static List<Employee> getEmployees(int numEmployees) throws IOException {
        List<Employee> employees = new ArrayList<>();
        if (numEmployees < 1 || numEmployees > 1000)
            throw new IllegalArgumentException("Argument 'numEmployees' must be between 1 and 1000");
        String employeeLine;
        List<String> result = new ArrayList<>();
        BufferedReader f = new BufferedReader(new FileReader("BinarySearchTree/src/main/resources/employees.csv"));
        // read all the records from the file and add them to the list
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        while ((employeeLine = f.readLine()) != null){
            result.add(employeeLine);
            String[] columns = employeeLine.split("\t");
            if(columns[7].length() == 9) {
                columns[7] = "0" + columns[7];
            }
            if(columns[8].length() == 9) {
                columns[8] = "0" + columns[8];
            }
            Employee employee = new Employee(columns[0], LocalDate.parse(columns[7], formatter), columns[2], columns[4], Gender.valueOf(columns[5]), LocalDate.parse(columns[8], formatter));
            employees.add(employee);
        }

        // randomisefff
        Collections.shuffle(result);
        // return the first numEmployees values as an array
        return employees.subList(0,numEmployees);
    }

}