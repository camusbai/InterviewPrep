package com.camusbai.exercise.array;

public class LC238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf_sol1(int[] nums) {
        int size = nums.length;
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        prefix[0] = nums[0];
        suffix[size - 1] = nums[size - 1];
        for (int i = 1, j = size - 2; i < size && j > -1; i++, j--) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[j] = nums[j] * suffix[j + 1];
        }

        int[] result = new int[size];
        result[0] = suffix[1];
        result[size - 1] = prefix[size - 2];
        for (int i = 1; i < size - 1; i++) {
            result[i] = prefix[i - 1] * suffix[i + 1];
        }
        return result;
    }

    public int[] productExceptSelf_sol2(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        result[0] = 1;
        for (int i = 1; i < size; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int product = 1;
        for (int j = size - 2; j > -1; j--) {
            product = product * nums[j + 1];
            result[j] = result[j] * product;
        }
        return result;
    }
}