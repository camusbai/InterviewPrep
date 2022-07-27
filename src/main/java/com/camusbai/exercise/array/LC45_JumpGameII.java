package com.camusbai.exercise.array;

public class LC45_JumpGameII {
    public static void main(String[] args) {
        int ret = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(ret);
    }

    public static int jump(int[] nums) {
        int current = 0;
        int jumps = 0;
        while(current<nums.length-1) {
            int nextPos = -1;
            int maxRange = -1;
            jumps++;
            for(int steps=nums[current];steps>0;steps--) {
                int pos = current + steps;
                if(pos+nums[pos]>maxRange) {
                    maxRange = pos+nums[pos];
                    nextPos = pos;
                }
                if(maxRange>nums.length-1) {
                    return ++jumps;
                }
            }
            current = nextPos;
        }
        return jumps;
    }
}
