package com.camusbai.exercise.graph;

import java.util.List;
import java.util.Map;

/**
 * Created by camusbai on 7/20/16.
 */
public class GraphAdjacencyList {
    Map<Vertex, List<Edge>> adjList;

    public int inDegree(Vertex v) {
        return adjList.get(v).size();
    }
}