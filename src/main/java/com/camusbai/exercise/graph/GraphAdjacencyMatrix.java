package com.camusbai.exercise.graph;

import java.util.List;
import java.util.Map;

/**
 * Created by camusbai on 7/20/16.
 */
public class GraphAdjacencyMatrix<T> {
    Edge<T>[][] adjMatrix;
    List<Vertex> vertices;

    public int numVertices(){
        return vertices.size();
    }

    public int numEdges(){
        int cnt=0;
        for(int i=0;i<adjMatrix.length;i++)
            for(int j=i+1;j<adjMatrix[i].length;j++)
                if(adjMatrix[i][j]!=null)
                    cnt++;

        return cnt;
    }

    public Edge<T> getEdge(int u, int v){
        return adjMatrix[u][v];
    }
}
