package com.camusbai.exercise.graph;

import java.util.*;

/**
 * Created by camusbai on 7/20/16.
 */
public class GraphAdjacencyList2 {
    Vertex<Integer>[] vertices;
    List<Integer>[] adjList;

    public static void main(String[] args) {
        GraphAdjacencyList2 graph = generateGraph2();
        graph.DFS(1);
        graph.DFS_recursion(0);
    }

    public GraphAdjacencyList2(Vertex<Integer>[] vertices, List<Integer>[] adjList) {
        this.vertices = vertices;
        this.adjList = adjList;
    }

    public void DFS(Integer vertexIdx) {
        if (vertices == null || vertices.length < 1 || adjList == null || adjList.length < 1) {
            return;
        }
        boolean[] visited = new boolean[vertices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(vertexIdx);
        while (!stack.isEmpty()) {
            Integer idx = stack.pop();
            if (!visited[idx]) {
                visit(vertices[idx]);
                visited[idx] = true;
                for (Integer neighbour : adjList[idx]) {
                    stack.push(neighbour);
                }
            }
        }
    }

    public void DFS_recursion(Integer index) {
        boolean[] visited = new boolean[vertices.length];
        DFS_recursion_util(index, visited);
    }

    private void DFS_recursion_util(Integer index, boolean[] visited) {
        if (visited[index]) {
            return;
        }

        visit(vertices[index]);
        visited[index] = true;
        for (Integer neighbour : adjList[index]) {
            DFS_recursion_util(neighbour, visited);
        }
    }

    public void visit(Vertex<Integer> vertex) {
        System.out.println(vertex.value);
    }

    public static GraphAdjacencyList2 generateGraph1() {
        Vertex<Integer>[] vertices = new Vertex[6];
        vertices[0] = new Vertex<>(0);
        vertices[1] = new Vertex<>(1);
        vertices[2] = new Vertex<>(2);
        vertices[3] = new Vertex<>(3);
        vertices[4] = new Vertex<>(4);
        vertices[5] = new Vertex<>(5);

        ArrayList<Integer>[] adjList = new ArrayList[6];
        adjList[0] = new ArrayList<>(Arrays.asList(1));
        adjList[1] = new ArrayList<>(Arrays.asList(2, 3));
        adjList[2] = new ArrayList<>(Arrays.asList(1, 3, 4));
        adjList[3] = new ArrayList<>(Arrays.asList(1, 2));
        adjList[4] = new ArrayList<>(Arrays.asList(2, 5));
        adjList[5] = new ArrayList<>(Arrays.asList(4));

        return new GraphAdjacencyList2(vertices, adjList);
    }

    public static GraphAdjacencyList2 generateGraph2() {
        Vertex<Integer>[] vertices = new Vertex[6];
        vertices[0] = new Vertex<>(0);
        vertices[1] = new Vertex<>(1);
        vertices[2] = new Vertex<>(2);
        vertices[3] = new Vertex<>(3);
        vertices[4] = new Vertex<>(4);
        vertices[5] = new Vertex<>(5);

        ArrayList<Integer>[] adjList = new ArrayList[6];
        adjList[0] = new ArrayList<>(Arrays.asList(2, 3, 4));
        adjList[1] = new ArrayList<>(Arrays.asList(5));
        adjList[2] = new ArrayList<>(Arrays.asList(0));
        adjList[3] = new ArrayList<>(Arrays.asList(0, 5));
        adjList[4] = new ArrayList<>(Arrays.asList(0));
        adjList[5] = new ArrayList<>(Arrays.asList(1, 3));

        return new GraphAdjacencyList2(vertices, adjList);
    }
}