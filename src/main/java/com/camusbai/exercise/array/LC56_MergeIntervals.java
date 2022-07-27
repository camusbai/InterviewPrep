package com.camusbai.exercise.array;

import java.util.*;

public class LC56_MergeIntervals {
    public static void main(String[] args) {
        int[][] input = new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        merge2(input);
    }

    public static int[][] merge(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals) {
            int key = interval[0];
            int val = interval[1];
            if (!map.containsKey(key) || map.get(key) < val) {
                map.put(key, val);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator
                = map.entrySet().iterator();

        Map.Entry<Integer, Integer> prevEntry = null;
        while(iterator.hasNext()) {
            if(prevEntry==null) {
                prevEntry=iterator.next();
                continue;
            }

            Map.Entry<Integer, Integer> entry = iterator.next();
            if (prevEntry.getValue() >= entry.getKey()) {
                if (prevEntry.getValue() < entry.getValue()) {
                    prevEntry.setValue(entry.getValue());
                }
                iterator.remove();
            } else {
                prevEntry = entry;
            }
        }
        int[][] result = new int[map.size()][2];
        int i=0;
        for (Integer key : map.keySet()) {
            result[i++] = new int[]{key, map.get(key)};
        }
        return result;
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > current[1]) {
                result.add(current);
                current = intervals[i];
            } else {
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][2]);
    }
}
