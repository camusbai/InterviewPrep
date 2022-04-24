package com.camusbai.exercise.tree;

import java.util.*;

public class TreeNode<T> {
    T val;
    List<TreeNode<T>> children;

    public TreeNode(T val){
        this.val = val;
        children = null;
    }

    public static void main(String[] args) {
        TreeNode<String> root = generateTree();
        System.out.println("BFS:");
        BFS(root);

        System.out.println("BFSRecursive:");
        BFSRecursive(root);

        System.out.println("DFS:");
        DFS(root);

        System.out.println("DFSRecursive:");
        DFSRecursive(root);
    }

    public static <T> void BFS(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode<T> node = q.poll();
            visit(node);
            if (node.children != null) {
                for (TreeNode<T> child : node.children) {
                    q.offer(child);
                }
            }
        }
    }

    public static <T> void BFSRecursive(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.offer(root);
        BFSRecursiveCall(q);
    }

    public static <T> void BFSRecursiveCall(Queue<TreeNode<T>> q){
        if (q.isEmpty()) {
            return;
        }
        Queue<TreeNode<T>> q2 = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode<T> node = q.poll();
            visit(node);
            if (node.children != null) {
                for (TreeNode<T> child : node.children) {
                    q2.offer(child);
                }
            }
        }
        BFSRecursiveCall(q2);
    }

    public static <T> void DFS(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            visit(node);
            if (node.children != null) {
                for (TreeNode<T> child : node.children) {
                    stack.push(child);
                }
            }
        }
    }

    public static <T> void DFSRecursive(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        visit(root);
        if (root.children != null) {
            for (int i = root.children.size() - 1; i != -1; i--) {
                TreeNode<T> node = root.children.get(i);
                DFSRecursive(node);
            }
        }
    }

    public static <T> void visit(TreeNode<T> node) {
        System.out.println(node.val);
    }

    public static TreeNode<String> generateTree(){
        TreeNode<String> n1 = new TreeNode<>("A");
        TreeNode<String> n2 = new TreeNode<>("B");
        TreeNode<String> n3 = new TreeNode<>("C");
        TreeNode<String> n4 = new TreeNode<>("D");
        TreeNode<String> n5 = new TreeNode<>("E");
        TreeNode<String> n6 = new TreeNode<>("F");
        TreeNode<String> n7 = new TreeNode<>("G");

        n1.children = Arrays.asList(n2, n3, n4);
        n3.children = Arrays.asList(n5, n6);
        n2.children = Arrays.asList(n7);

        return n1;
    }
}
