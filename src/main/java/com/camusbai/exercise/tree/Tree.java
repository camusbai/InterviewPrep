package com.camusbai.exercise.tree;

/**
 * Created by camusbai on 6/18/16.
 */
public class Tree<T> {
    TreeNode root;

    public Tree(T val){
        root = new TreeNode(val);
    }

    class TreeNode<T> {
        T val;
        TreeNode next;

        public TreeNode(T val) {
            this.val = val;
        }

        public T getValue() {
            return val;
        }

        public boolean hasNext() {
            return next != null;
        }

        public TreeNode getNext(){
            return next;
        }
    }
}
