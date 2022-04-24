package com.camusbai.exercise.array;

public class LC42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int rainWaterSum = 0;
        if (height == null || height.length < 3) {
            return 0;
        }
        int iLeft = 0, iRight = height.length - 1;
        while (iLeft < height.length && height[iLeft] == 0) {
            iLeft++;
        }
        while (iRight > 0 && height[iRight] == 0) {
            iRight--;
        }
        int leftHighest = height[iLeft];
        int rightHighest = height[iRight];
        while (iLeft < iRight) {
            if (leftHighest < rightHighest) {
                if (leftHighest > height[iLeft]) {
                    rainWaterSum += (leftHighest - height[iLeft]);
                } else {
                    leftHighest = height[iLeft];
                }
                iLeft++;
            } else {
                if (rightHighest > height[iRight]) {
                    rainWaterSum += (rightHighest - height[iRight]);
                } else {
                    rightHighest = height[iRight];
                }
                iRight--;
            }
        }
        if (height[iLeft] < Math.min(leftHighest, rightHighest)) {
            rainWaterSum += (Math.min(leftHighest, rightHighest) - height[iLeft]);
        }
        return rainWaterSum;
    }

}
