package com.camusbai.exercise.array;

import java.util.Arrays;
import java.util.Collections;

public class LC875_KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed2(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int idx = piles.length - 1;
        int diff = h - piles.length;
        if (diff == 0) {
            return piles[idx];
        }


        while (idx > -1) {
            int k = piles[idx];
            int extraHr = 0;
            for (int i = idx; i < piles.length; i++) {
                int extra = (piles[i] / k) - 1 + (piles[i] % k == 0 ? 0 : 1);
                extraHr += extra;
            }
            if (extraHr > diff) {
                break;
            }
            idx--;
        }

        int lowerBound, upperBound;
        if (idx == -1) {
            lowerBound = 1;
            upperBound = piles[0];
        } else {
            lowerBound = piles[idx];
            upperBound = piles[idx + 1];
        }

        while (upperBound != lowerBound) {
            int k = (upperBound + lowerBound) / 2;
            int extraHr = 0;
            for (int i = idx + 1; i < piles.length; i++) {
                int extra = (piles[i] / k) - 1 + (piles[i] % k == 0 ? 0 : 1);
                extraHr += extra;
            }
            if (extraHr > diff) {
                lowerBound = k + 1;
            } else {
                upperBound = k;
            }
        }
        return upperBound;
    }

    public static int minEatingSpeed2(int[] piles, int h) {
        int maxPile = -1;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int lowerBound, upperBound;
        lowerBound = 1;
        upperBound = maxPile;
        int k = upperBound;
        int hours = 0;

        while (upperBound >= lowerBound) {
            k = (upperBound + lowerBound) / 2;
            hours = 0;
            for (int pile : piles) {
                int hour = (pile / k) + (pile % k == 0 ? 0 : 1);
                hours += hour;
            }
            if (hours > h) {
                lowerBound = k + 1;
            } else {
                upperBound = k - 1;
            }
        }
        if (hours > h) {
            return k + 1;
        } else {
            return k;
        }
    }
}