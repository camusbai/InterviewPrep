package com.camusbai.exercise.array;

public class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] content = s.toCharArray();
        while (i < j) {
            char left = content[i];
            char right = content[j];
            if (!Character.isLetterOrDigit(left)) {
                i++;
            } else if (!Character.isLetterOrDigit(right)) {
                j--;
            } else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
