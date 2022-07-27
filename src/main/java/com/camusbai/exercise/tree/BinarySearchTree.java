package com.camusbai.exercise.tree;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node root = addNode(null, 9);
        addNode(root, 5);
        addNode(root, 11);
        addNode(root, 3);
        addNode(root, 6);
        addNode(root, 7);
        addNode(root, 10);
        addNode(root, 8);

        inorderTraversal(root);
        System.out.println(getTreeHeight(root));
    }

    public static int getTreeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeHeight(root.left) + 1;
        int right = getTreeHeight(root.right) + 1;
        return Math.max(left, right);
    }

    public static void preorderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.val);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public static void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.val);
            inorderTraversal(node.right);
        }
    }

    public static Node addNode(Node node, int val){
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            if (node.left == null) {
                node.left = new Node(val);
            } else {
                addNode(node.left, val);
            }
        }else {
            if (node.right == null) {
                node.right = new Node(val);
            } else {
                addNode(node.right, val);
            }
        }
        return node;
    }

    static class Node {
        Node left;
        Node right;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
}
