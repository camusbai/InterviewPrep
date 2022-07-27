package com.camusbai.exercise.java8;

import java.util.List;

public class Animal {
    Category category;
    List<String> behaviors;

    public List<String> getBehavior(){
        return behaviors;
    }

    public Category getCategory(){
        return this.category;
    }
}
