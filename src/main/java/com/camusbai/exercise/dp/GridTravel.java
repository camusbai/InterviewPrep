package com.camusbai.exercise.dp;

public class GridTravel {
    public static long gridTravel(int m, int n) {
        long[][] cache = new long[m][n];
        return gridTraveller(m, n, cache);
    }

    private static long gridTraveller(int m, int n, long[][] cache) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        } else {
            if (cache[m - 1][n - 1] > 0) {
                return cache[m - 1][n - 1];
            }
            cache[m - 1][n - 1] = gridTraveller(m - 1, n, cache) + gridTraveller(m, n - 1, cache);
            return cache[m - 1][n - 1];
        }

    }

    public static void main(String[] args) {
        System.out.println(gridTravel(3,3));
        System.out.println(gridTravel(4,2));
        System.out.println(gridTravel(4,3));
        System.out.println(gridTravel(18,18));
    }
}
