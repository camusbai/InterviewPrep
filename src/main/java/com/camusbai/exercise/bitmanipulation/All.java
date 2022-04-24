package com.camusbai.exercise.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class All {
    public static void main(String[] args) {
        System.out.println(convertToString(8));
        System.out.println(~8);
        System.out.println(convertToString(~8));
        System.out.println(convertToString(-1));
        System.out.println(convertToString(Integer.MIN_VALUE));
        System.out.println(convertToString(Integer.MAX_VALUE));
        Map<String, String> map = new HashMap<>();
        map.put("S", "S");
        System.out.println(map.size());
    }

    public static String convertToString(int number) {
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            if ((number & 1) == 1) {
                builder.append("1");
            } else {
                builder.append("0");
            }
            number = number >>> 1;
        }
        return builder.reverse().toString();
    }
}