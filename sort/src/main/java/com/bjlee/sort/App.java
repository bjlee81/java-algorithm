package com.bjlee.sort;

public class App {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {3, 7, 8, 5, 2, 1, 9, 6, 4};

        // 최초엔 좌우를 양쪽 끝으로 설정
        sort.quickSort(arr, 0, arr.length - 1);
    }
}

