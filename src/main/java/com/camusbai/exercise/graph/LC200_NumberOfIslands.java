package com.camusbai.exercise.graph;

public class LC200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int totalNum = 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        for(int i=0;i<rowNum;i++) {
            for(int j=0;j<colNum;j++) {
                if(grid[i][j]=='0') continue;
                if(visited[i][j]) continue;
                int cntOfLand = backtrack(i, j, grid, visited);
                totalNum+= (cntOfLand>0?1:0);
            }
        }
        return totalNum;
    }

    private int backtrack(int i, int j, char[][] grid, boolean[][] visited) {
        if(i<0 || i==grid.length || j<0 || j==grid[0].length)   return 0;
        if(visited[i][j])   return 0;
        if(grid[i][j]=='0') return 0;

        visited[i][j] = true;
        int cnt = 1;
        cnt += backtrack(i, j-1, grid, visited);
        cnt += backtrack(i, j+1, grid, visited);
        cnt += backtrack(i-1, j, grid, visited);
        cnt += backtrack(i+1, j, grid, visited);
        return cnt;
    }
}
