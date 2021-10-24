package com.camusbai.exercise.dp;

import java.util.ArrayList;
import java.util.List;

public class HowSum {
    public static List<Integer> howSum(int target, int[] numbers) {
        if (target == 0) {
            return new ArrayList<>();
        }

        for (int num : numbers) {
            int childVal = target - num;
            if (childVal >= 0) {
                List<Integer> result = howSum(childVal, numbers);
                if (result != null) {
                    result.add(num);
                    return result;
                }
            }
        }
        return null;
    }

    public static List<Integer> howSumMemoized(int target, int[] numbers) {
        boolean[] deadEndFound = new boolean[target + 1];
        return howSumFunc(target, numbers, deadEndFound);
    }

    public static List<Integer> howSumFunc(int target, int[] numbers, boolean[] deadEndFound) {
        if (deadEndFound[target]) {
            return null;
        }

        if (target == 0) {
            return new ArrayList<>();
        }

        for (int num : numbers) {
            int childVal = target - num;
            if (childVal >= 0) {
                List<Integer> result = howSumFunc(childVal, numbers, deadEndFound);
                if (result != null) {
                    result.add(num);
                    return result;
                }
            }
        }
        deadEndFound[target] = true;
        return null;
    }



    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(7, new int[]{2, 4}));
        System.out.println(howSum(8, new int[]{2, 3, 5}));
        long start = System.nanoTime();
        System.out.print(howSumMemoized(300, new int[]{7, 14}));
        long end = System.nanoTime();
        System.out.println(" - " + (end - start));
        start = System.nanoTime();
        System.out.print(howSum(300, new int[]{7, 14}));
        end = System.nanoTime();
        System.out.println(" - " + (end - start));
    }
}
