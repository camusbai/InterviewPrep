package com.camusbai.exercise.array;

import java.util.HashSet;
import java.util.Set;

public class LC36_ValidSodoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (!checkValue(val, set)) {
                    return false;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char val = board[i][j];
                if (!checkValue(val, set)) {
                    return false;
                }
            }
        }

        int[][] delta = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
        for (int n = 0; n < 9; n++) {
            int deltaX = delta[n][0];
            int deltaY = delta[n][1];
            Set<Character> set = new HashSet<>();
            for (int i = 0 + deltaX; i < 3 + deltaX; i++) {
                for (int j = 0 + deltaY; j < 3 + deltaY; j++) {
                    char val = board[i][j];
                    if (!checkValue(val, set)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkValue(char val, Set<Character> set) {
        if (val != '.') {
            int diff = val - '1';
            if (diff < 0 || diff > 8) {
                return false;
            }
            if (set.contains(val)) {
                return false;
            } else {
                set.add(val);
            }
        }
        return true;
    }
}