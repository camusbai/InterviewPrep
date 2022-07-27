package com.camusbai.exercise.backtrack;

import java.util.*;

public class LC90_SubSetsII {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> ret = new LC90_SubSetsII().subsetsWithDup2(new int[]{1, 2, 2});
        System.out.println(ret);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        for(int num: nums) {
            numCnt.put(num, numCnt.getOrDefault(num, 0)+1);
        }
        Integer[] distinctNums = numCnt.keySet().toArray(new Integer[0]);
        backtrack(0, distinctNums, numCnt, new Stack<>(), new HashSet<>());
        return result;
    }

    private void backtrack(int depth, Integer[] distinctNums, Map<Integer, Integer> numCnt, Stack<Integer> stack, Set<Integer> dupNumSet) {
        if (depth == distinctNums.length) {
            if (dupNumSet.isEmpty()) {
                result.add(new ArrayList<>(stack));
            } else {
                Stack<Integer> stack2 = new Stack<>();
                for (int num : stack) {
                    if (!dupNumSet.contains(num)) {
                        stack2.push(num);
                    }
                }
                backtrackInner(0, dupNumSet.toArray(new Integer[0]), numCnt, stack2);
            }
            return;
        }

        int num = distinctNums[depth];
        stack.push(num);
        if (numCnt.get(num) > 1) {
            dupNumSet.add(num);
        }
        backtrack(depth + 1, distinctNums, numCnt, stack, dupNumSet);

        dupNumSet.remove(num);
        stack.pop();
        backtrack(depth + 1, distinctNums, numCnt, stack, dupNumSet);
    }

    private void backtrackInner(int depth, Integer[] dupNums, Map<Integer, Integer> numCnt, Stack<Integer> stack) {
        if (depth == dupNums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        int num = dupNums[depth];
        for (int i = 1; i <= numCnt.get(num); i++) {
            for (int j = 0; j < i; j++) {
                stack.push(num);
            }
            backtrackInner(depth+1, dupNums, numCnt, stack);
            for (int j = 0; j < i; j++) {
                stack.pop();
            }
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        backtrack2(nums, 0, " ", new Stack<>(), new HashSet<>());
        return result;
    }

    private void backtrack2(int[] nums, int depth, String key, Stack<Integer> stack, Set<String> keyExist) {
        if(depth==nums.length) {
            if(!keyExist.contains(key)) {
                result.add(new ArrayList<>(stack));
                keyExist.add(key);
            }
            return;
        }

        stack.push(nums[depth]);
        backtrack2(nums, depth+1, key+","+nums[depth], stack, keyExist);

        stack.pop();
        backtrack2(nums, depth+1, key, stack, keyExist);
    }

    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        backtrack3(nums, 0, new Stack<>());
        return result;
    }

    private void backtrack3(int[] nums, int depth, Stack<Integer> stack) {
        if(depth==nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        int num = nums[depth];
        stack.push(num);
        backtrack3(nums, depth+1, stack);

        stack.pop();
        while(depth<nums.length-1 && nums[depth+1]==num) depth++;
        backtrack3(nums, depth+1, stack);
    }
}
