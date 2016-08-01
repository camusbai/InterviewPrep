package com.camusbai.exercise.linkedlist;

import java.util.LinkedList;

/**
 * Created by camusbai on 7/10/16.
 */
public class MergeLinkedList<T extends Comparable> {

    public LinkedList<T> merge(LinkedList<T> target, LinkedList<T> b) {
        if (target.peek().compareTo(b.peek()) < 0) {
        }
        return target;
    }

    public static class SinglyLinkedList<T extends Comparable> {
        SinglyNode<T> head;

        public SinglyLinkedList() {
        }

        public SinglyNode<T> getHead() {
            return head;
        }

        public SinglyNode<T> getNext() {
            return head.getNext();
        }
    }

    public static class SinglyNode<T extends Comparable> {
        T val;
        SinglyNode next;

        public SinglyNode(T val) {
            this.val = val;
        }

        public SinglyNode getNext() {
            return next;
        }

        public void setNext(SinglyNode node) {

        }

        public T getValue() {
            return null;
        }
    }

    public static void testGeneric(LinkedList<String> arg){}

    public static void main(String[] args) {
        LinkedList<Boolean> bool = new LinkedList<>();
        LinkedList<String> str = new LinkedList<>();
//        testGeneric(bool);
        testGeneric(str);
    }
}
