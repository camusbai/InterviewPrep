package com.camusbai.exercise.array;

import java.util.*;
import java.util.stream.Collectors;

public class LC347_TopKFreqElem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent_hashMap3(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent_hashMap3(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topKFrequent_hashMap3(new int[]{1, 2}, 2)));
    }
    public static int[] topKFrequent_hashMap1(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for( int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return count.entrySet().stream().sorted((elem1, elem2) -> elem2.getValue() - elem1.getValue()).limit(k).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }

    public static int[] topKFrequent_hashMap2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for( int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((num1, num2) -> count.get(num2) - count.get(num1));
        for (Integer num : count.keySet()) {
            q.offer(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(q.poll());
        }
        return result;
    }

    public static int[] topKFrequent_hashMap3(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] countToNums = new ArrayList[nums.length + 1];
        for (int num : count.keySet()) {
            int cnt = count.get(num);
            if (countToNums[cnt] == null) {
                countToNums[cnt] = new ArrayList<>();
            }
            countToNums[cnt].add(num);
        }

        int[] result = new int[k];
        for (int i = countToNums.length - 1, j = 0; i > 0 && j < k; i--) {
            List<Integer> freqNumbers = countToNums[i];
            if (freqNumbers != null) {
                for (int freqNum : freqNumbers) {
                    result[j++] = freqNum;
                }
            }
        }
        return result;
    }
}