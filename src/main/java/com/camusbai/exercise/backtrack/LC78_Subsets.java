package com.camusbai.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC78_Subsets {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            backtrack(nums, new Stack<>(), i);
        }
        result.add(new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, Stack<Integer> subset, int idx) {
        subset.push(nums[idx]);
        result.add(new ArrayList<>(subset));
        for (int runenr = idx + 1; runenr < nums.length; runenr++) {
            backtrack(nums, subset, runenr);
        }
        subset.pop();
    }
}
