package com.leetcode.solution.search;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearch {
    public static int search(int[] arr, int num) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if(arr[mid] == num) {
                return mid;
            } else if(num > arr[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,5,312,34,21,1,5,9, 8,342,321,21,32,321,45,32,76};
        Arrays.sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(search(arr, 342));
    }
}
