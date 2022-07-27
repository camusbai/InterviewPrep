package com.camusbai.exercise.java8;

public class ClassWithPrivateField {
    private int intField;

    public int combine(ClassWithPrivateField other) {
        return this.intField + other.intField;  // can access even private
    }

    public static void main(String[] args) {
        ClassWithPrivateField obj = new ClassWithPrivateField();
        System.out.println(obj.intField);   // can access even private
    }

    static class ChildClass{
        public void accessParent() {
            ClassWithPrivateField obj = new ClassWithPrivateField();
            System.out.println(obj.intField);   // can access even private
        }
    }
}
