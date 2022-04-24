package com.camusbai.exercise.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class All {
    public static int sum(Node current) {
        if (current == null) {
            return 0;
        } else {
            return sum(current.next) + current.val;
        }
    }

    public static Node nthToLast(Node head, int n) {
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        int cnt = 0;
        while (!stack.isEmpty() && cnt < n) {
            node = stack.pop();
            cnt++;
        }

        if (stack.isEmpty()) {
            return null;
        } else {
            return node;
        }
    }

    public static int nthToLastRecursive(Node head, int n) {
        if (head == null) {
            return 0;
        } else {
            int cnt = nthToLastRecursive(head.next, n) + 1;

            if (cnt == n) {
                System.out.println(head.val);
            }
            return cnt;
        }
    }

    public static Node nthToLastIteration(Node head, int n) {
        Node runner1 = head;
        int i = 1;
        while (i < n && runner1 != null) {
            runner1 = runner1.next;
            i++;
        }
        if (runner1 == null) {
            return null;
        }

        Node runner2 = head;
        while (runner1.next != null) {
            runner1 = runner1.next;
            runner2 = runner2.next;
        }

        return runner2;
    }

    public static Node removeValue(Node head, int val) {
        if (head == null) {
            return null;
        }

        Node currentNode = head;

        if (head.val == val) {
            currentNode = head.next;
            head.next = null;
            return currentNode;
        } else if (head.next == null) {
            return head;
        }

        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                Node toDelete = currentNode.next;
                currentNode.next = toDelete.next;
                toDelete.next = null;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static Node removeValue2(Node head, int val) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.val == val) {
                if (prev == null) {
                    prev = current;
                    current = current.next;
                    prev.next = null;
                    return current;
                } else {
                    prev.next = current.next;
                    current.next = null;
                    current = prev.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void removeDuplicates(Node node) {
        Map<Integer, Boolean> dupMap = new HashMap<>();
        Node prev = null;
        Node current = node;
        while (current != null) {
            if (dupMap.containsKey(current.val)) {
                if (prev == null) {
                    // shouldn't happen
                } else {
                    prev.next = current.next;
                    current.next = null;
                    current = prev.next;
                }
            } else {
                dupMap.put(current.val, true);
                prev = current;
                current = current.next;
            }
        }
    }

    public static void removeDuplicatesNoMap(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        while (node != null) {
            Node prev = node;
            Node runner = node.next;
            while (runner != null) {
                if (runner.val == node.val) {
                    prev.next = runner.next;
                    runner.next = null;
                    runner = prev.next;
                } else {
                    prev = runner;
                    runner = runner.next;
                }
            }
            node = node.next;
        }
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void deleteCurrentNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        Node nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}