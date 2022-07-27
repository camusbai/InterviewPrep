package com.camusbai.exercise.linkedlist;

public class LC143_ReorderList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        reorderList(n1);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode runner = head;
        ListNode runner2x = head.next;
        boolean isOddSize = false;
        while (true) {
            runner = runner.next;
            if (runner2x.next == null) {
                isOddSize = false;
                break;
            }
            runner2x = runner2x.next;
            if (runner2x.next == null) {
                isOddSize = true;
                break;
            }
            runner2x = runner2x.next;
        }
        if (isOddSize) {
            runner = runner.next;
        }

        // reverse the second part of the list
        ListNode prev = null;
        while (runner != null) {
            ListNode nextNode = runner.next;
            runner.next = prev;
            prev = runner;
            runner = nextNode;
        }
        // prev is going to be the head of the reversed 2nd half list
        ListNode head2 = prev;
        ListNode resHead = new ListNode();
        while (head2 != null) {
            resHead.next = head;
            head = head.next;
            resHead = resHead.next;

            resHead.next = head2;
            head2 = head2.next;
            resHead = resHead.next;
        }
        if (isOddSize) {
            resHead.next = head;
            head.next = null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
