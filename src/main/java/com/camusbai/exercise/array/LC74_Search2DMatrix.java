package com.camusbai.exercise.array;

public class LC74_Search2DMatrix {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(input, 7));

        int[][] input2 = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}};
        System.out.println(searchMatrix2(input2, 9));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        int leftX = 0, leftY = 0, rightX = totalRow - 1, rightY = totalCol - 1;
        while (leftX < rightX || (leftX == rightX && leftY <= rightY)) {
            //int distance = (x1-x) * totalCol - (totalCol - y2 - 1) + (totalCol - y)
            int l_pos = leftX * totalCol + leftY;
            int r_pos = rightX * totalCol + rightY;
            int mid_pos = (l_pos + r_pos) / 2;
            int midX = mid_pos / totalCol;
            int midY = mid_pos % totalCol;
            if (matrix[midX][midY] < target) {
                leftX = (mid_pos + 1) / totalCol;
                leftY = (mid_pos + 1) % totalCol;
            } else if (matrix[midX][midY] > target) {
                rightX = (mid_pos - 1) / totalCol;
                rightY = (mid_pos - 1) % totalCol;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int top = 0, bot = matrix.length - 1;
        int colLength = matrix[0].length;
        while (top < bot) {
            int mid = (top + bot) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                if (matrix[mid][colLength - 1]<target) {
                    top = mid + 1;
                } else if (matrix[mid][colLength - 1] > target) {
                    top = mid;
                    break;
                } else {
                    return true;
                }
            }else{
                bot = mid - 1;
            }
        }

        int left = 0, right = colLength - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[top][mid] < target) {
                left = mid + 1;
            } else if (matrix[top][mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
