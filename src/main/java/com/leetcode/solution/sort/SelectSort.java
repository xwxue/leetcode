package com.leetcode.solution.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectSort {
    public void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int a = 0;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    a = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[a];
            arr[a] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,5,312,34,21,1,5,9, 8,342,321,21,32,321,45,32,76};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        new SelectSort().sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Arrays.sort(arr2);
        System.out.println(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
    }
}
