package com.camusbai.exercise.graph;

/**
 * Created by camusbai on 7/20/16.
 */
public class Vertex<T> {
    T value;

    public Vertex(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
