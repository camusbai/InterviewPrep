package com.camusbai.exercise.tree;

import java.util.*;

/**
 * Created by camusbai on 6/18/16.
 */
public class BinaryTreeNode<T> {
    T val;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> root = generateTree();
        System.out.println("InOrderTraversal");
        InOrderTraversal(root);

        System.out.println("PreOrderTraversal");
        PreOrderTraversal(root);

        System.out.println("PostOrderTraversal");
        PostOrderTraversal(root);

        System.out.println(root.isBalanced());
        System.out.println(minDepth(root));
    }

    public static <T> int minDepth(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public boolean isBalanced(){
        Map<BinaryTreeNode<T>, Integer> mapOfDepth = new HashMap<>();
        mapOfDepth.put(this, 0);
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(this);
        List<BinaryTreeNode<T>> leafNodes = new ArrayList<>();
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                int leftDepth = mapOfDepth.get(node) + 1;
                mapOfDepth.put(node.left, leftDepth);
            }

            if (node.right != null) {
                stack.push(node.right);
                int leftDepth = mapOfDepth.get(node) + 1;
                mapOfDepth.put(node.right, leftDepth);
            }

            if (node.left == null && node.right == null) {
                leafNodes.add(node);
            }
        }

        Integer min = null;
        Integer max = null;
        for (BinaryTreeNode<T> leaf : leafNodes) {
            Integer depth = mapOfDepth.get(leaf);
            if (min == null || depth < min) {
                min = depth;
            }

            if (max == null || depth > max) {
                max = depth;
            }
        }
        if ((this.left == null && this.right != null) || (this.left != null && this.right == null)) {
            if (min > 1) {
                return false;
            } else {
                return true;
            }
        }
        return max - min <= 1;
    }

    public static <T> void InOrderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        } else {
            InOrderTraversal(node.left);
            visitNode(node);
            InOrderTraversal(node.right);
        }
    }

    public static <T> void PreOrderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        } else {
            visitNode(node);
            PreOrderTraversal(node.left);
            PreOrderTraversal(node.right);
        }
    }

    public static <T> void PostOrderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        } else {
            PostOrderTraversal(node.left);
            PostOrderTraversal(node.right);
            visitNode(node);
        }
    }

    public static <T> void visitNode(BinaryTreeNode<T> node) {
        System.out.println(node.val);
    }

    public static BinaryTreeNode<String> generateTree() {
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> nodeD = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> nodeE = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> nodeF = new BinaryTreeNode<>("F");

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeC.left = nodeE;
        nodeC.right = nodeF;

        return nodeA;
    }
}
