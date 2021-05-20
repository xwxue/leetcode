package com.leetcode.solution.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HeapSort {
    public void sort(int[] arr){
        for(int i = arr.length / 2; i >=0; i--) {
            heapify(i, arr, arr.length);
        }
        int len = arr.length;
        for(int i = arr.length - 1; i > 0; i --) {
            swap(0, i, arr);
            heapify(0, arr, --len);
        }
    }

    private void heapify(int i, int[] arr, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int largest = i;

        if(left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != i) {
            swap(i, largest, arr);
            heapify(largest, arr, len);
        }
    }

    private void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,5,7,9,21,43,7,4,23,543,123};
//        int divide = new QuickSort().divide(0, arr.length - 1, arr);
//        System.out.println(divide);
        new HeapSort().sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

}
