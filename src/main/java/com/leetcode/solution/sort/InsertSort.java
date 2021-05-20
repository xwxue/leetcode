package com.leetcode.solution.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertSort {
    public void sort(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            int a = i;
            for(int j = i - 1; j >= 0; j --) {
                if(arr[a] < arr[j]) {
                    tmp = arr[a];
                    arr[a] = arr[j];
                    arr[j] = tmp;
                    a = j;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,5,312,34,21,1,5,9, 8,342,321,21,32,321,45,32,76};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        new InsertSort().sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Arrays.sort(arr2);
        System.out.println(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
    }
}
