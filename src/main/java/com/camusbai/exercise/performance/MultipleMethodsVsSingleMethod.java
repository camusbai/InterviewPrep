package com.camusbai.exercise.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleMethodsVsSingleMethod {
    public static void main(String[] args) {
        List<String> testData = generateTestData();

        long start = System.nanoTime();
        for (String str : testData) {
            convertStringInOne(str);
        }
        long end = System.nanoTime();
        System.out.println("convertStringInOne   - " + (end - start));

        start = System.nanoTime();
        for (String str : testData) {
            convertStringDivided(str);
        }
        end = System.nanoTime();
        System.out.println("convertStringDivided - " + (end - start));
    }

    public static List<String> generateTestData() {
        List<String> data = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int length = rand.nextInt(30);
            StringBuilder builder = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                builder.append((char) ('a' + rand.nextInt(25)));
            }
            data.add(builder.toString());
        }
        return data;
    }

    public static void convertStringInOne(String input) {
        String newStr = input.toUpperCase();
        String finalStr = newStr.toLowerCase();
    }

    public static void convertStringDivided(String input) {
        String newStr = convertToUppdercase(input);
        String finalStr = convertToLowercase(newStr);
    }

    private static String  convertToLowercase(String input) {
        return input.toLowerCase();
    }

    private static String  convertToUppdercase(String input) {
        return input.toUpperCase();
    }
}
