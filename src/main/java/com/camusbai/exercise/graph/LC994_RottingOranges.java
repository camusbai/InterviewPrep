package com.camusbai.exercise.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC994_RottingOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        orangesRotting(grid);
    }

    public static int orangesRotting(int[][] grid) {
        List<Queue<Integer[]>> queues = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    Queue<Integer[]> q = new LinkedList<>();
                    q.offer(new Integer[]{i, j});
                    queues.add(q);
                }
            }
        }

        int depth = 0;
        int[][] offsets = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (true) {
            boolean rottenSpread = false;
            for (Queue<Integer[]> q : queues) {
                if (q.isEmpty()) continue;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Integer[] rotten = q.poll();
                    for (int[] offset : offsets) {
                        int x = rotten[0] + offset[0];
                        int y = rotten[1] + offset[1];
                        if (x < 0 || x == m || y < 0 || y == n) continue;
                        if (grid[x][y] == 1) {
                            rottenSpread = true;
                            grid[x][y] = 2;
                            q.offer(new Integer[]{x, y});
                        }
                    }
                }
            }
            if (!rottenSpread) break;
            depth++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return depth;
    }

    // Don't really need more than one queue
    public static int orangesRotting2(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Integer[]{i, j});
                }
            }
        }

        int depth = 0;
        int[][] offsets = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;
            for (int i = 0; i < size; i++) {
                Integer[] rotten = q.poll();
                for (int[] offset : offsets) {
                    int x = rotten[0] + offset[0];
                    int y = rotten[1] + offset[1];
                    if (x < 0 || x == m || y < 0 || y == n) continue;
                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new Integer[]{x, y});
                        spread = true;
                    }
                }
            }
            if (spread) depth++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return depth;
    }

    // this is somehow slower than the above when submitted to Leetcode
    public static int orangesRotting3(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Integer[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }

        int depth = 0;
        int[][] offsets = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty() && freshCnt > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer[] rotten = q.poll();
                for (int[] offset : offsets) {
                    int x = rotten[0] + offset[0];
                    int y = rotten[1] + offset[1];
                    if (x < 0 || x == m || y < 0 || y == n) continue;
                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshCnt--;
                        q.offer(new Integer[]{x, y});
                    }
                }
            }
            depth++;
        }

        return freshCnt == 0 ? depth : -1;
    }
}
