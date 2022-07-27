
package com.camusbai.exercise.backtrack;

import java.util.*;

public class LC40_CombinationSumII {
    public static void main(String[] args) {
        List<List<Integer>> ret = new LC40_CombinationSumII().combinationSumII(new int[]{4, 4, 2, 1, 4, 2, 2, 1, 3}, 6);
        System.out.println(ret);
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack2_2(0, new ArrayList<>(candidates.length), 0, target, candidates);
        return result;
    }

    private void backtrack(int depth, List<Integer> combo, int sum, int target, int[] candidates) {
        if(sum==target) {
            result.add(new ArrayList<>(combo));
            return;
        } else if(depth==candidates.length || sum>target) {
            return;
        }

        int num = candidates[depth];
        combo.add(num);
        backtrack(depth+1, combo, sum+num, target, candidates);

        combo.remove(combo.size()-1);
        while(depth<candidates.length && num==candidates[depth]) depth++;
        backtrack(depth, combo, sum, target, candidates);
    }

    private void backtrack2(int idx, List<Integer> combo, int sum, int target, int[] candidates) {
        if(sum==target) {
            result.add(new ArrayList<>(combo));
            return;
        } else if(sum>target || idx==candidates.length) {
            return;
        }

        for(int i=idx;i<candidates.length;i++) {
            if(i==idx || candidates[i]!=candidates[i-1]) {
                combo.add(candidates[i]);
                backtrack2(i+1, combo, sum+candidates[i], target, candidates);
                combo.remove(combo.size()-1);
            }else {
                while(i<candidates.length && candidates[i]==candidates[i-1]) {
                    i++;
                }
                if (i == candidates.length) {
                    return;
                }
                combo.add(candidates[i]);
                backtrack2(i+1, combo, sum+candidates[i], target, candidates);
                combo.remove(combo.size()-1);
            }
        }
    }

    private void backtrack2_2(int idx, List<Integer> combo, int sum, int target, int[] candidates) {
        if(sum==target) {
            result.add(new ArrayList<>(combo));
            return;
        } else if(sum>target || idx==candidates.length) {
            return;
        }

        for(int i=idx;i<candidates.length;i++) {
            if(i!=idx && candidates[i]==candidates[i-1]) continue;
            combo.add(candidates[i]);
            backtrack2_2(i+1, combo, sum+candidates[i], target, candidates);
            combo.remove(combo.size()-1);
        }
    }
}
