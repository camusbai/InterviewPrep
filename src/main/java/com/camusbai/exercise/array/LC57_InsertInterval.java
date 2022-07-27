package com.camusbai.exercise.array;

public class LC57_InsertInterval {
    // key is using newInterval as benchmark, and then matching intervals against it one by one
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int i = 0, j = 0;
        while (i < intervals.length) {
            int[] interval = intervals[i];
            if (interval[0] < newInterval[0]) {
                if (interval[1] < newInterval[0]) {
                    result[j][0] = interval[0];
                    result[j][1] = interval[1];
                    j++;
                } else {
                    newInterval[0] = interval[0];
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                }
            } else if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                result[j][0] = newInterval[0];
                result[j][1] = newInterval[1];
                j++;
                break;
            }
            i++;
        }

        while (i < intervals.length) {
            result[j][0] = intervals[i][0];
            result[j][1] = intervals[i][1];
            i++;
            j++;
        }

        if (j == 0 || result[j - 1][1] < newInterval[0]) {
            result[j][0] = newInterval[0];
            result[j][1] = newInterval[1];
            j++;
        }

        if (j == result.length) {
            return result;
        } else {
            int[][] actualSize = new int[j][2];
            for (int k = 0; k < actualSize.length; k++) {
                actualSize[k][0] = result[k][0];
                actualSize[k][1] = result[k][1];
            }
            return actualSize;
        }
    }
}
