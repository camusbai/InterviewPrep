package com.camusbai.exercise.array;

import java.util.HashMap;
import java.util.Map;

public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));

    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int maxLength = 0;
        int iBegin = 0;
        Map<Character, Integer> charToIdx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToIdx.containsKey(c) && charToIdx.get(c) >= iBegin) {
                maxLength = Math.max(maxLength, i - iBegin);
                iBegin = charToIdx.get(c) + 1;
            }
            charToIdx.put(c, i);
        }
        maxLength = Math.max(maxLength, s.length() - iBegin);
        return maxLength;
    }
}
