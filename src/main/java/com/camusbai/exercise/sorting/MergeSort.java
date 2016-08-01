package com.camusbai.exercise.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by camusbai on 7/3/16.
 */
public class MergeSort<T extends Comparable<T>> {
    public T[] sort(T[] array) {
        T[] newArr = Arrays.copyOf(array, array.length);
        partition(newArr, 0, array.length);

        return newArr;
    }

    private void partition(T[] array, int start, int end) {
        if (end - start > 1) {
            int mid = start + (end - start) / 2;
            partition(array, start, mid);
            partition(array, mid, end);

            merge(array, start, mid, end);
        }
    }

    private void merge(T[] array, int start, int mid, int end) {
        T[] leftArr = Arrays.copyOfRange(array, start, mid);
        T[] rightArr = Arrays.copyOfRange(array, mid, end);

        int i = 0, j = 0, idx=start;
        while (i < mid - start && j < end - mid) {
            if (leftArr[i].compareTo(rightArr[j]) < 0)
                array[idx] = leftArr[i++];
            else
                array[idx] = rightArr[j++];
            idx++;
        }
        while (i < mid - start) {
            array[idx++] = leftArr[i++];
        }
        while (j < end - mid) {
            array[idx++] = rightArr[j++];
        }
    }

    private void mergeInPlace(T[] array, int start, int mid, int end) {
        int i = start, j = mid, idx = start;
        Queue<T> leftQ = new LinkedList<>();
        Queue<T> rightQ = new LinkedList<>();


    }
}
