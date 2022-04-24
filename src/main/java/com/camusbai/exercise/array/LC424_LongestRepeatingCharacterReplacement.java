package com.camusbai.exercise.array;

import java.util.*;

public class LC424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        int result = characterReplacement("EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH", 7);
        System.out.println(result);
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, List<List<Integer>>> charAndSegments = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charAndSegments.containsKey(c)) {
                List<List<Integer>> segments = new ArrayList<>();
                List<Integer> segment = new ArrayList<>();
                segment.add(i);
                segments.add(segment);
                charAndSegments.put(c, segments);
            } else {
                List<List<Integer>> segments = charAndSegments.get(c);
                List<Integer> lastSegment = segments.get(segments.size() - 1);
                Integer lastIdx = lastSegment.get(lastSegment.size() - 1);
                if (lastIdx.equals(i - 1)) {
                    lastSegment.add(i);
                } else {
                    List<Integer> segment = new ArrayList<>();
                    segment.add(i);
                    segments.add(segment);
                }
            }
        }

        int maxLength = 0;
        for (char c : charAndSegments.keySet()) {
            int remainingReplacement = k;
            int startingSegmentIdx = 0;
            List<List<Integer>> segments = charAndSegments.get(c);
            for (int i = 0; i < segments.size() - 1; i++) {
                List<Integer> current = segments.get(i);
                List<Integer> next = segments.get(i + 1);
                int replacementCost = next.get(0) - current.get(current.size() - 1) - 1;
                while (remainingReplacement < replacementCost && startingSegmentIdx < i) {
                    List<Integer> startingSegment = segments.get(startingSegmentIdx);
                    List<Integer> secondSegment = segments.get(startingSegmentIdx + 1);
                    int refund = secondSegment.get(0) - startingSegment.get(startingSegment.size() - 1) - 1;
                    remainingReplacement += refund;
                    startingSegmentIdx++;
                }
                if (remainingReplacement < replacementCost) {
                    int currentLength = current.size() + remainingReplacement;
                    maxLength = Math.max(maxLength, currentLength);
                    startingSegmentIdx++;
                } else {
                    remainingReplacement -= replacementCost;
                    int length = next.get(next.size() - 1) - segments.get(startingSegmentIdx).get(0) + 1 + remainingReplacement;
                    maxLength = Math.max(maxLength, length);
                }
            }

            List<Integer> lastSegment = segments.get(segments.size() - 1);
            if (remainingReplacement == k) {
                int lastSegmentLength = lastSegment.size() + remainingReplacement;
                maxLength = Math.max(maxLength, lastSegmentLength);
            } else {
                int lastLength = lastSegment.get(lastSegment.size() - 1) - segments.get(startingSegmentIdx).get(0) + 1 + remainingReplacement;
                maxLength = Math.max(maxLength, lastLength);
            }
        }
        maxLength = Math.min(maxLength, s.length());
        return maxLength;
    }
}
