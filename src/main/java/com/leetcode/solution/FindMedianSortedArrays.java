package com.leetcode.solution;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if(a < nums1.length && b < nums2.length){
                if(nums1[a] < nums2[b]){
                    arr[i] = nums1[a++];
                }else{
                    arr[i] = nums2[b++];
                }
            } else if(a >= nums1.length){
                arr[i] = nums2[b++];
            } else {
                arr[i] = nums1[a++];
            }
        }
        int mid = arr.length / 2;
        if(arr.length % 2 == 0){
            return (arr[mid - 1] + arr[mid])/2.0;
        }else{
            return arr[mid];
        }
    }
}
