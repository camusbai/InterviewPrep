package com.camusbai.exercise.heap;

import java.util.HashMap;
import java.util.Map;

public class LC621_TaskScheduler {
    public static void main(String[] args) {
    }

    public int leastInterval(char[] tasks, int n) {
        if (n < 1) return tasks.length;

        Map<Character, Integer> charToCnt = new HashMap<>();
        int max = 0;
        for (char task : tasks) {
            int cnt = charToCnt.getOrDefault(task, 0) + 1;
            charToCnt.put(task, cnt);
            if (cnt > max) max = cnt;
        }
        final int finalMax = max;
        int maxOccurence = (int) charToCnt.entrySet().stream().filter(entry -> entry.getValue() == finalMax).count() - 1; //excluding the first max
        return max * (n + 1) - n + maxOccurence;
    }
}
