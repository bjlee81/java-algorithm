package com.bjlee81.median_of_two_sorted_arrays;

public class App {

    public static void main(String[] args) {

    }
}

class Solution {

    /**
     * 병합정렬 관련 문제
     * 
     * @param nums1 정렬된 배열
     * @param nums2 정렬된 배열
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 두개의 배열을 합하고 sorted array merge 한 후 중간의 두값에 대해 2등분하면 될듯??
        // 이미 sorted 된 값이 기제..

        int tSize = nums1.length + nums2.length;

        int[] arr = new int[tSize];

        int idx1 = 0;
        int idx2 = 0;
        int idxT = 0;

        for (idx1 = 0; idx1 < nums1.length; idx1++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;


            for (idx2 = 0; idx2 < nums2.length; idx2++) {

            }

        }


        return 0;
    }
}