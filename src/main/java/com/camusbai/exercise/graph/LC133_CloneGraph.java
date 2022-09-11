package com.camusbai.exercise.graph;

import java.util.*;

public class LC133_CloneGraph {
    // SOLUTION 1
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Map<Integer, Node> idxToClone = new HashMap<>();
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            Node clone;
            if (idxToClone.containsKey(n.val)) {
                clone = idxToClone.get(n.val);
            } else {
                clone = new Node(n.val);
                idxToClone.put(n.val, clone);
            }

            for (Node neighbor : n.neighbors) {
                int idx = neighbor.val;
                Node neighborClone;
                if (!idxToClone.containsKey(idx)) {
                    neighborClone = new Node(idx);
                    idxToClone.put(idx, neighborClone);
                    stack.push(neighbor);
                } else {
                    neighborClone = idxToClone.get(idx);
                }
                clone.neighbors.add(neighborClone);
            }
        }

        return idxToClone.get(node.val);
    }

    private Map<Integer, Node> idxToNode = new HashMap<>();

    // SOLUTION 2
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }

        Node clone;
        int idx = node.val;
        if (idxToNode.containsKey(idx)) {
            clone = idxToNode.get(idx);
        } else {
            clone = new Node(idx);
            idxToNode.put(idx, clone);
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }

        return clone;
    }

    // SOLUTION 3
    public Node cloneGraph3(Node node) {
        if (node == null)
            return null;

        Map<Integer, Node> nodeCopy = new HashMap<>();
        createNodeCopy(node, nodeCopy);
        Set<Integer> visited = new HashSet<>();
        populateCopyWithNeighbor(node, visited, nodeCopy);

        return nodeCopy.get(node.val);
    }

    private void createNodeCopy(Node node, Map<Integer, Node> nodeCopy) {
        if (!nodeCopy.containsKey(node.val)) {
            Node copy = new Node(node.val);
            nodeCopy.put(node.val, copy);
            for (Node neighbor : node.neighbors) {
                createNodeCopy(neighbor, nodeCopy);
            }
        }
    }

    private void populateCopyWithNeighbor(Node node, Set<Integer> visited, Map<Integer, Node> nodeCopy) {
        if (!visited.contains(node.val)) {
            visited.add(node.val);
            Node copy = nodeCopy.get(node.val);
            for (Node n : node.neighbors) {
                copy.neighbors.add(nodeCopy.get(n.val));
                populateCopyWithNeighbor(n, visited, nodeCopy);
            }
        }
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}