package com.camusbai.exercise.tree;

import java.util.Stack;

public class LC100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }

        Stack<TreeNode> sp = new Stack<>();
        Stack<TreeNode> sq = new Stack<>();
        sp.push(p);
        sq.push(q);
        while (!sp.isEmpty()) {
            TreeNode np = sp.pop();
            TreeNode nq = sq.pop();
            if (np.val != nq.val) {
                return false;
            }

            if ((np.left == null && nq.left != null)
                    || (np.left != null && nq.left == null)) {
                return false;
            }

            if (np.left != null && nq.left != null) {
                sp.push(np.left);
                sq.push(nq.left);
            }

            if ((np.right == null && nq.right != null)
                    || (np.right != null && nq.right == null)) {
                return false;
            }

            if (np.right != null && nq.right != null) {
                sp.push(np.right);
                sq.push(nq.right);
            }
        }

        return true;
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
