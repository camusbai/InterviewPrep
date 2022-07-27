package com.camusbai.exercise.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC46_Permutations {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> ret = new LC46_Permutations().permute2(new int[]{1, 2, 3});
        System.out.println(ret);
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new Integer[nums.length], 0, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, Integer[] permutation, int depth, boolean[] visited) {
        if(nums.length==depth) {
            result.add(new ArrayList<>(Arrays.asList(permutation)));
            return;
        }

        for(int i=0; i<nums.length;i++) {
            if(!visited[i]) {
                permutation[depth] = nums[i];
                visited[i] = true;
                backtrack(nums,permutation, depth+1,visited);
                visited[i] = false;
            }
        }
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<Integer> permutation = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            permutation.add(-1);
        }
        backtrack2(nums, new boolean[nums.length], permutation, 0);
        return result;
    }

    private void backtrack2(int[] nums, boolean[] visited, List<Integer> permutation, int depth) {
        if(depth==nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(visited[i]) continue;
            permutation.set(depth, nums[i]);
            visited[i]=true;
            backtrack2(nums, visited, permutation, depth+1);
            visited[i]=false;
        }
    }
}
