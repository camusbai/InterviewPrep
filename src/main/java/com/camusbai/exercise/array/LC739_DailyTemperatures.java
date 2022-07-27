package com.camusbai.exercise.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int max = 0;
        Map<Integer, Integer> tempToIdx = new HashMap<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i > -1; i--) {
            int currentTmp = temperatures[i];
            if (currentTmp >= max) {
                result[i] = 0;
                max = currentTmp;
            } else {
                int runner = currentTmp + 1;
                int lowestIdx = temperatures.length;
                while (runner != max + 1) {
                    if (tempToIdx.containsKey(runner)) {
                        lowestIdx = Math.min(lowestIdx, tempToIdx.get(runner));
                    }
                    runner++;
                }
                result[i] = lowestIdx - i;
            }
            tempToIdx.put(currentTmp, i);
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && currentTemp > stack.peek()[0]) {
                Integer[] record = stack.pop();
                int idx = record[1];
                result[idx] = i - idx;
            }
            stack.push(new Integer[]{currentTemp, i});
        }
        return result;
    }
}