package com.camusbai.exercise;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        getRank(Arrays.asList(1, 2, 3));
        int[][] data = new int[200000][2];
        System.out.println(Integer.MAX_VALUE);
        System.out.println(data[8888][1]);
        System.out.println(data[8888][0]);

        Map<Integer, Integer> m = new HashMap<>();
        m.remove(12);

        binarySearch(new int[]{1, 2}, 5);
    }

    public static List<Integer> getRank(List<Integer> inArray) {
//        Comparator.comparing(Document::getPdate)
//                .thenComparing(Document::getSubject)

        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>(Comparator.<Integer[]>comparingInt(a -> a[0]).reversed().thenComparing(a -> a[1]));
        for (int i = 0; i < inArray.size(); i++) {
            maxHeap.offer(new Integer[]{inArray.get(i), i});
        }
        Integer[] result = new Integer[inArray.size()];
        int rank = 1;
        while (!maxHeap.isEmpty()) {
            Integer[] pair = maxHeap.poll();
            result[pair[1]] = rank++;
        }
        return Arrays.asList(result);
    }

    public static int binarySearch(int[] input, int target) {
        int left = 0, right = input.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (input[mid] < target) left = mid+1;
            else right = mid;
        }
        return input[right] == target ? right : -1;
    }
}
