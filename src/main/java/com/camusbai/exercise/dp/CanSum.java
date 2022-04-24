package com.camusbai.exercise.dp;

public class CanSum {
    public static boolean canSum(int target, int[] numbers) {
        if (target < 0 || numbers == null || numbers.length < 1) {
            return false;
        } else if (target == 0) {
            return true;
        }
        boolean[] deadEndFound = new boolean[target + 1];
        return canSumFunc(target, numbers, false, deadEndFound);
    }

    private static boolean canSumFunc(int target, int[] numbers, boolean found, boolean[] deadEndFound) {
        if (found) {
            return true;
        } else {
            for (int num : numbers) {
                int child = target - num;
                if (child == 0) {
                    found = true;
                    break;
                } else if (child > 0) {
                    if (deadEndFound[child]) {
                        continue;
                    }
                    found |= canSumFunc(child, numbers, found, deadEndFound);
                }
            }
            if (!found) {
                deadEndFound[target] = true;
            }
            return found;
        }
    }

    public static boolean canSum1(int target, int[] numbers) {
        boolean[] cache = new boolean[target];
        return canSumFunc1(target, numbers, cache);
    }

    public static boolean canSumFunc1(int target, int[] numbers, boolean[] deadEndFound) {
        if (target == 0)  return true;
        if (target < 0) return false;

        int idx = target - 1;
        if (deadEndFound[idx]) {
            return false;
        }

        for (int num : numbers) {
            int child = target - num;
            if (canSumFunc1(child, numbers, deadEndFound)) {
                return true;
            }
        }
        deadEndFound[idx] = true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2,3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));

        boolean result;
        long lap1 = System.nanoTime();
        result = canSum(300, new int[]{7, 14});
        long lap2 = System.nanoTime();
        System.out.println("canSum(300, new int[]{7, 14}) - " + result + " : " + (lap2 - lap1) + "ns");

        lap1 = System.nanoTime();
        result = canSum1(300, new int[]{7, 14});
        lap2 = System.nanoTime();
        System.out.println("canSum1(300, new int[]{7, 14}) - " + result + " : " + (lap2 - lap1) + "ns");
    }
}