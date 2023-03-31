package com.sparta.Room1;

import com.sparta.model.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BinarySearchTree {
        private Node root;
        private int size;
        Employee employee;

        public int getRootElement() {
            if (root == null) {
                throw new NoSuchElementException("BinarySearchTree is empty.");
            }

            return 0;
        }

        public int getNumberOfElements() {
            return size;
        }


    public void addElement(Employee employee) {
            root = addElement(root, employee);
            size++;             //The size of the tree
        }

        private Node addElement(Node node, Employee employee) {
            if (node == null) {
                return new Node(employee);
            }

            if(employee.getLastName().equals(node.lastName)) {
                node.employees.add(employee);
            } else if (employee.getLastName().compareTo(node.lastName) < 0) {
                node.left = addElement(node.left, employee);
            } else {
                node.right = addElement(node.right, employee);
            }

            return node;
        }

        public void addElements(List<Employee> employees) {
            for (Employee employee : employees) {
                addElement(employee);
            }
        }

        public Set<Employee> findElement(String lastName) {

            Set<Employee> result;
            int compare = lastName.compareTo(root.lastName);
            if(compare == 0) {
                result = root.employees;
            }
            else
                result= findElement(root,lastName);

            return result;
        }

    private Set<Employee> findElement(Node node, String lastName) {
        Set<Employee> result;
        int compare = lastName.compareTo(node.lastName);
        if(compare == 0) {
            result = node.employees;
        } else if( compare < 0) {
            result = findElement(node.left, lastName);
        } else {
            result = findElement(node.right, lastName);
        }
        return result;
    }


    public Employee[] getSortedTreeAsc() {
            Employee[] result = new Employee[size];
            int i = 0;
            inOrder(root, result, i);
            return result;
        }

        private int inOrder(Node node, Employee[] result, int i) {
            if (node == null) {
                return i;
            }
            i = inOrder(node.left, result, i);
            result[i++] = employee;
            return inOrder(node.right, result, i);
        }

        public Employee[] getSortedTreeDesc() {
            Employee[] result = new Employee[size];
            int i = 0;
            reverseInOrder(root, result, i);
            return result;
        }

        private int reverseInOrder(Node node, Employee[] result, int i) {
            if (node == null) {
                return i;
            }
            i = reverseInOrder(node.right, result, i);
            result[i++] = employee;
            return reverseInOrder(node.left, result, i);
        }

}


