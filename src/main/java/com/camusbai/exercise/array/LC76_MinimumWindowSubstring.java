package com.camusbai.exercise.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC76_MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("CDAABCODDD", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int iLeftResult = 0, iRightResult = s.length();
        int numCharToMatch = t.length();
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int iLeft = 0;
        while (!counts.containsKey(s.charAt(iLeft))) {
            iLeft++;
        }
        int iRight = iLeft;
        for (; iRight < s.length(); iRight++) {
            char current = s.charAt(iRight);
            if (counts.containsKey(current)) {
                int currentCount = counts.get(current);
                if (currentCount > 0) {
                    counts.put(current, currentCount - 1);
                    numCharToMatch--;
                    if (numCharToMatch == 0) { // found substring
                        if (iRight - iLeft + 1 < iRightResult - iLeftResult) {
                            iLeftResult = iLeft;
                            iRightResult = iRight + 1;
                        }
                        char leftChar = s.charAt(iLeft);
                        if (counts.get(leftChar) > -1) {
                            numCharToMatch++;
                        }
                        counts.put(leftChar, counts.get(leftChar) + 1);
                        iLeft++;
                        leftChar = s.charAt(iLeft);
                        while (iLeft < iRight && (!counts.containsKey(leftChar) || counts.get(leftChar) < 0)) {
                            if (counts.containsKey(leftChar)) {
                                counts.put(leftChar, counts.get(leftChar) + 1);
                            }
                            iLeft++;
                            leftChar = s.charAt(iLeft);
                        }
                        if (numCharToMatch == 0 && iRight - iLeft + 1 < iRightResult - iLeftResult) {
                            iLeftResult = iLeft;
                            iRightResult = iRight + 1;
                        }
                    }
                } else {
                    counts.put(current, currentCount - 1);
                }
            }
        }

        while (iLeft != iRight) {
            char leftChar = s.charAt(iLeft);
            if (!counts.containsKey(leftChar)) {
                iLeft++;
                continue;
            }

            if (counts.get(leftChar) >= 0) {
                numCharToMatch++;
            }
            counts.put(leftChar, counts.get(leftChar) + 1);

        }
        return s.substring(iLeftResult, iRightResult);
    }
}
