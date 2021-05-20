package com.leetcode.solution.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
    public void sort(int[] arr){
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,5,312,34,21,1,5,9, 8,342,321,21,32,321,45,32,76};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        new BubbleSort().sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Arrays.sort(arr2);
        System.out.println(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
    }
}
