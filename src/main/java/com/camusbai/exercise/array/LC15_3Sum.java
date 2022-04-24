package com.camusbai.exercise.array;

import java.util.*;
import java.util.stream.Collectors;

public class LC15_3Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        int[] nums2 = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        threeSum2(nums2).forEach(list-> System.out.println(Arrays.toString(list.toArray())));

    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        Integer prevNum1 = null;
        Integer prevNum2 = null;
        Set<Integer> foundForNum1 = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            if (foundForNum1.contains(num1)) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int targetSubSum = -num1;
            while (j < k) {
                int num2 = nums[j];
                int num3 = nums[k];
                int subSum = num2 + num3;
                if (subSum < targetSubSum) {
                    j++;
                } else if (subSum > targetSubSum) {
                    k--;
                } else {
                    if (prevNum1 == null || !prevNum1.equals(num1) || !prevNum2.equals(num2)) {
                        prevNum1 = num1;
                        prevNum2 = num2;
                        result.add(Arrays.asList(num1, num2, num3));
                    }
                    j++;
                    k--;
                    foundForNum1.add(num1);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> numToIndex = new HashMap<>();
        int idx = 0;
        for (int num : nums) {
            if (!numToIndex.containsKey(num)) {
                numToIndex.put(num, new ArrayList<>());
            }
            numToIndex.get(num).add(idx++);
        }

        Set<Triplet> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                int num3 = -(num1 + num2);
                if (numToIndex.containsKey(num3)) {
                    final int secIdx = j;
                    numToIndex.get(num3).stream().filter(index -> index > secIdx).findAny().ifPresent(number -> {
                        try {
                            set.add(new Triplet(num1, num2, num3));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }

        return set.stream().map(triplet -> Arrays.asList(triplet.min, triplet.median, triplet.max)).collect(Collectors.toList());
    }

    static class Triplet {
        int min;
        int median;
        int max;

        public Triplet(int num1, int num2, int num3) throws Exception {
            if (num1 + num2 + num3 != 0) {
                throw new Exception("sum isn't zero");
            }

            min = Math.min(Math.min(num1, num2), num3);
            max = Math.max(Math.max(num1, num2), num3);
            median = -(min + max);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            return prime * min + prime * median + prime * max;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Triplet)) {
                return false;
            }
            Triplet object = ((Triplet) obj);
            if (object.max == this.max && object.min == this.min) {
                return true;
            } else {
                return false;
            }
        }
    }
}
