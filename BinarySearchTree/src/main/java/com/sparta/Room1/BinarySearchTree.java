package com.sparta.Room1;

import java.util.NoSuchElementException;

public class BinarySearchTree implements com.sparta.anu.BinaryTree {
        private Node root;
        private int size;

        private class Node {
            int value;
            Node left, right;

            Node(int value) {
                this.value = value;
            }
        }

        public int getRootElement() {
            if (root == null) {
                throw new NoSuchElementException("BinarySearchTree is empty.");
            }

            return root.value;
        }

        public int getNumberOfElements() {
            return size;
        }

        public void addElement(int element) {
            root = addElement(root, element);
            size++;
        }

        private Node addElement(Node node, int element) {
            if (node == null) {
                return new Node(element);
            }

            if (element < node.value) {
                node.left = addElement(node.left, element);
            } else if (element > node.value) {
                node.right = addElement(node.right, element);
            }

            return node;
        }

        public void addElements(int[] elements) {
            for (int element : elements) {
                addElement(element);
            }
        }

        public boolean findElement(int value) {
            return findElement(root, value);
        }

        private boolean findElement(Node node, int value) {
            if (node == null) {
                return false;
            }

            if (value == node.value) {
                return true;
            } else if (value < node.value) {
                return findElement(node.left, value);
            } else {
                return findElement(node.right, value);
            }
        }

        public int[] getSortedTreeAsc() {
            int[] result = new int[size];
            int i = 0;
            inOrder(root, result, i);
            return result;
        }

        private int inOrder(Node node, int[] result, int i) {
            if (node == null) {
                return i;
            }
            i = inOrder(node.left, result, i);
            result[i++] = node.value;
            return inOrder(node.right, result, i);
        }

        public int[] getSortedTreeDesc() {
            int[] result = new int[size];
            int i = 0;
            reverseInOrder(root, result, i);
            return result;
        }

        private int reverseInOrder(Node node, int[] result, int i) {
            if (node == null) {
                return i;
            }
            i = reverseInOrder(node.right, result, i);
            result[i++] = node.value;
            return reverseInOrder(node.left, result, i);
        }
    }


