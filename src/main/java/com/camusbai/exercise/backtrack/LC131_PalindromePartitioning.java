package com.camusbai.exercise.backtrack;

import java.util.*;

public class LC131_PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recursion(s, 0, new Stack<>());
        if(checkPalindrome(s, 0, s.length()-1)) {
            result.add(Collections.singletonList(s));
        }
        return result;
    }

    public void recursion(String s, int start, Stack<int[]> stack) {
        for (int i = start + 1; i < s.length(); i++) {
            if(checkPalindrome(s, start, i-1)) {
                stack.push(new int[]{start, i});
                if(checkPalindrome(s, i, s.length()-1)) {
                    List<String> partition = new ArrayList<>();
                    for (int[] part : stack) {
                        partition.add(s.substring(part[0], part[1]));
                    }
                    partition.add(s.substring(i));
                    result.add(partition);
                }
                recursion(s, i, stack);
                stack.pop();
            }
        }
    }

    public boolean checkPalindrome(String s, int start, int end) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end))  return false;
            start++; end--;
        }
        return true;
    }
}
