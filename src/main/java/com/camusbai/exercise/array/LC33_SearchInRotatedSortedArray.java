package com.camusbai.exercise.array;

public class LC33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                if (nums[right] > nums[mid]) {
                    if (nums[right] > target) {
                        left = mid + 1;
                    } else if (nums[right] < target) {
                        right = mid - 1;
                    } else {
                        return right;
                    }
                } else if (nums[right] < nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                if (nums[left] < nums[mid]) {
                    if (nums[left] < target) {
                        right = mid - 1;
                    } else if (nums[left] > target) {
                        left = mid + 1;
                    } else {
                        return left;
                    }
                } else if (nums[left] > nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
