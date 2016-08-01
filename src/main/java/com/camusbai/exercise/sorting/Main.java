package com.camusbai.exercise.sorting;

import java.util.Arrays;

/**
 * Created by camusbai on 7/4/16.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{14, 22, 31, 4, 5, 32, 4, 12, 9};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] newArr = mergeSort.sort(arr);
        System.out.println(Arrays.toString(newArr));
    }
}