package com.leetcode.solution.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = divide(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }

    private int divide(int[] arr, int start, int end) {
        int j = start;
        int tmp;
        for (int i = start; i <= end; i++) {
            if(arr[i] < arr[end]) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j ++;
            }
        }
        tmp = arr[end];
        arr[end] = arr[j];
        arr[j] = tmp;
        return j;
    }


    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,5,312,34,21,1,5,9, 8,342,321,21,32,321,45,32,76};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
//        int divide = new QuickSort().divide(0, arr.length - 1, arr);
//        System.out.println(divide);
//        new QuickSort().divide(arr, 0, arr.length - 1);
        new QuickSort().sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Arrays.sort(arr2);
        System.out.println(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
    }

}
