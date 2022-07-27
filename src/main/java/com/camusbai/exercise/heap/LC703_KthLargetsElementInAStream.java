package com.camusbai.exercise.heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class LC703_KthLargetsElementInAStream {
    Queue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public LC703_KthLargetsElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
            minHeap.offer(num);
        }

        while(minHeap.size()>k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
