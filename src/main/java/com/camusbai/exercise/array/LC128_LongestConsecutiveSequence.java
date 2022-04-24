package com.camusbai.exercise.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class LC128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
        }
        int num = heap.poll();
        int maxSeq = 1;
        int seq = 1;
        while (!heap.isEmpty()) {
            int num2 = heap.poll();
            if (num2 - num == 1) {
                seq++;
                if (seq > maxSeq) {
                    maxSeq = seq;
                }
            } else if (num2 != num) {
                seq = 1;
            }
            num = num2;
        }
        return maxSeq;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxSeq = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int seq = 1;
                while (set.contains(++num)) {
                    seq++;
                }
                if (seq > maxSeq) {
                    maxSeq = seq;
                }
            }
        }
        return maxSeq;
    }
}