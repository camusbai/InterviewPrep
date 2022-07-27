package com.camusbai.exercise.tree;

import java.util.*;

public class LC102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> valOfLevel = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                valOfLevel.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(valOfLevel);
        }
        return result;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs2(Collections.singletonList(root), result);
        return result;
    }

    private void dfs2(List<TreeNode> nodesOfLevel, List<List<Integer>> result) {
        if (nodesOfLevel == null || nodesOfLevel.size() == 0) return;
        List<TreeNode> nextLvl = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        for (TreeNode n : nodesOfLevel) {
            vals.add(n.val);
            if (n.left != null) nextLvl.add(n.left);
            if (n.right != null) nextLvl.add(n.right);
        }
        result.add(vals);
        dfs2(nextLvl, result);
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs3(root, result, 0);
        return result;
    }

    private void dfs3(TreeNode node, List<List<Integer>> result, int height) {
        if (node == null) return;
        if (height == result.size()) result.add(new ArrayList<>());
        result.get(height).add(node.val);
        if (node.left != null) dfs3(node.left, result, height + 1);
        if (node.right != null) dfs3(node.right, result, height + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}