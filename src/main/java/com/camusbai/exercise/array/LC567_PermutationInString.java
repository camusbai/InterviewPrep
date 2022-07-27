package com.camusbai.exercise.array;

import java.util.HashMap;
import java.util.Map;

public class LC567_PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int iLeft = 0, charToMatch = s1.length();
        while (iLeft < s2.length() && !count.containsKey(s2.charAt(iLeft))) {
            iLeft++;
        }
        for (int iRight = iLeft; iRight < s2.length(); iRight++) {
            char c = s2.charAt(iRight);
            int cnt = count.getOrDefault(c, -1);
            if (cnt == 0) {
                while (s2.charAt(iLeft) != c) {
                    char charBack = s2.charAt(iLeft);
                    count.put(charBack, count.get(charBack) + 1);
                    iLeft++;
                    charToMatch++;
                }
                iLeft++;
            } else if (cnt == -1) {
                while (iLeft != iRight) {
                    char charBack = s2.charAt(iLeft);
                    count.put(charBack, count.get(charBack) + 1);
                    iLeft++;
                    charToMatch++;
                }
                iLeft++;
            } else {
                count.put(c, cnt - 1);
                charToMatch--;
                if (charToMatch == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
