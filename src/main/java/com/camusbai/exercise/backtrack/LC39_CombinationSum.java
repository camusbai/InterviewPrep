package com.camusbai.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC39_CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        LC39_CombinationSum runObj = new LC39_CombinationSum();
        runObj.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(runObj.result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for(int i=0;i<candidates.length; i++) {
            backtrack(i, new Stack<>(), 0, target, candidates);
        }
        return result;
    }

    private void backtrack(int idx, Stack<Integer> stack, int sum, int target, int[] candidates) {
        sum+=candidates[idx];
        stack.push(candidates[idx]);

        if(sum==target){
            result.add(new ArrayList<>(stack));
        } else if(sum<target){
            for(int i=idx; i<candidates.length; i++) {
                backtrack(i, stack, sum, target, candidates);
            }
        }
        stack.pop();
    }
}
