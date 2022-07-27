package com.camusbai.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String target, int left, int right, int n, List<String> result) {
        if (target.length() == n * 2) {
            result.add(target);
            return;
        }

        if (left < n) {
            backtrack(target + "(", left + 1, right, n, result);
        }
        if (right < left) {
            backtrack(target + ")", left, right+1, n, result);
        }
    }
}
