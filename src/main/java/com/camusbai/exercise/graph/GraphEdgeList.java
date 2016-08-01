package com.camusbai.exercise.graph;

import java.util.List;

/**
 * Created by camusbai on 7/20/16.
 */
public class GraphEdgeList {
    List<Vertex> nodes;
    List<Edge> edges;
    boolean directed = false;

    public int outDegree(Vertex v) {
        int cnt=0;
        for (Edge e : edges)
            if (e.u == v || (!directed && e.v == v))
                cnt++;
        return cnt;
    }

    public int inDegree(Vertex v) {
        if(!directed) {
            return outDegree(v);
        }
        else{
            int cnt = 0;
            for (Edge e : edges)
                if(e.v==v)
                    cnt++;

            return cnt;
        }
    }
}
