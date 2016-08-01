package com.camusbai.exercise.graph;

/**
 * Created by camusbai on 7/20/16.
 */
public class Edge<T> {
    Vertex u, v;
    T w;

    public Edge(Vertex u, Vertex v, T w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
