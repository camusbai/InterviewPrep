package com.camusbai.exercise.map;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("key1", "val1");
        System.out.println(map.get("key1"));

        map.put("key1", "val1Replaced");
        System.out.println(map.get("key1"));

        map.put("key2", "val2");
        System.out.println(map.get("key2"));

        System.out.println(map.get("key3"));

        String str  = null;
        System.out.println(str instanceof String);
    }
}