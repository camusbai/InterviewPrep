package com.camusbai.exercise.bitmanipulation;

public class LC268_MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
        int i=1, result=0;
        for(int num :nums){
            result = result + i - num;
            i++;
        }
        return result;
    }
}
