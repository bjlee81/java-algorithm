package com.bjlee81.median_of_two_sorted_arrays;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 3, 5, 4, 8, 12};
        int[] nums2 = new int[]{2, 7, 6, 10, 11, 9};
        solution.findMedianSortedArrays(nums1, nums2);

        solution.insertionSort(nums1);
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

        // 정렬되지 않았으면 정렬을 수행
//        sortArray(nums1, nums1[0], nums1[nums1.length-1]);
//        sortArray(nums2, nums2[0], nums2[nums2.length-1]);

        // 두개의 배열을 합하고 sorted array merge 한 후 중간의 두값에 대해 2등분하면 될듯??
        // 이미 sorted 된 값이 기제..

        // 1. 최종 병합될 배열을 사이즈만큼 생성
        // 2. 두 배열에 대해 제일 좌측요소부터 비교하여 작은 배열의 요소를 최종병합될 배열에 입력
        //      - 배열의 양끝에 최대값을 입력하여 계속 비교가능하도록 함
        // 3. 각 index를 증가
        // 4. 제일 마지막까지가면 병합완료. 증가된 index 값에 대한 배열값이 존재할 경우까지..


        int tSize = nums1.length + nums2.length;

        // array init
        int[] arr = new int[tSize];

        int i = 0;
        int j = 0;
        int z = 0;
        int max = Integer.MAX_VALUE;

        // 증가시키다보면 array 벗어나는 경우가 있어서 max 값을 주고 max값과 비교해서 좌측정렬로 함

        int a, b;

        while (i < nums1.length || j < nums2.length) {
            a = b = max;
            // while 조건에 대한 처리. index를 벗어난 값이라면??
            if (i < nums1.length) {
                a = nums1[i];
            }

            if (j < nums2.length) {
                b = nums2[j];
            }

            // 제일좌측
            if (a < b) {
                arr[z] = a;
                i = i + 1;
            } else if (a > b) {
                arr[z] = b;
                j = j + 1;
            }

            z = z + 1;
        }

        return (arr[tSize / 2] + arr[(tSize / 2) - 1]) / 2.0;
    }

    private void sortArray(int[] ints, int left, int right) {
        // 퀵정렬??
        int i, j, pivot, tmp;
        pivot = ints[ints.length / 2];

        for (int k = 1; k < ints.length; k++) {
            int curV = ints[k];
            int preV = k - 1;

            if (ints[preV] > curV) {
                ints[k] = ints[preV];
                preV--;
            }
        }
    }

    // 삽입정렬
    void insertionSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int temp = arr[index];
            int aux = index - 1;

            while ((aux >= 0) && (arr[aux] > temp)) {

                arr[aux + 1] = arr[aux];
                aux--;
            }
            arr[aux + 1] = temp;
        }
    }
}