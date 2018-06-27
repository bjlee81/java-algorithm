package com.bjlee.sort;

import java.util.Arrays;

public class Sort {
    /**
     * n개의 데이터를 정렬할 때, 최악의 경우에는 O(n2)번의 비교를 수행하고, 평균적으로 O(n log n)번의 비교를 수행
     * 분할하여 교환하는 정렬방법을 사용
     * <p>
     * 1. 배열 가운데서 하나의 임의의 원소(element)를 골라 피벗으로 정함
     * 2. 피벗 좌측은 피벗보다 값이 작은 원소를 오게하고, 피벗 우측에는 값이 큰 원소들이 오도록 배열을 나눔 - 분할
     * - 피벗 좌측에서 피벗보다 큰 값을 찾는다.
     * - 피벗 우측에서 피벗보다 작은 값을 찾는다.
     * - 두 가지 경우가 만족하는 경우 교환한다.
     * - 마지막엔 피벗 값도 교환의 대상이 된다.
     * 3. 분할된 피벗은 고정한다.
     * 4. 분할된 두개의 배열에 위과정을 recursion 한다. 배열의 크기가 0이나 1이 될 때까지 반복 - 좌우교환이 일어날때까지
     *
     * @param arr   정렬이 필요한 배열
     * @param left  이동할 수 있는 왼쪽 기준점
     * @param right 이동할 수 있는 오른쪽 기준점
     */
    public void quickSort(int[] arr, int left, int right) {
        // 퀵정렬??
        int i = left;
        int j = right;
        int tmp;
        int pivot;

        // pivot 좌측에서 pivot 보다 큰 값을 찾는다 - while
        // pivot 우측에서 pivot 보다 작은 값을 찾는다. - while
        // 두 값을 교환한다.
        pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            // 좌우인덱스를 조정 후에 i,j 값이 역전되지 않았을 때 진행
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                System.out.println("pivot : " + pivot + ", arr : " + Arrays.toString(arr));
                i++;
                j--;
            }
        }

        // 좌측 분할 된 배열이 존재하면
        if (left < j)
            quickSort(arr, left, j);
        // 분할된 우측배열이 존재하면
        if (i < right)
            quickSort(arr, i, right);
    }

    /**
     * 선택 정렬
     *
     * 1. 주어진 전체 배열 중 최소값을 찾는다.
     * 2. 그 값을 맨 앞에 값과 교환한다.
     * 3. 그 다음 인덱스를 이동하고 위치에서 계속 진행한다.
     *
     * @param arr
     */
    public void selectionSort(int[] arr) {
        // 전체 배열을 순회
        int offSet = 0;
        int minIdx = 0;
        int tmp;

        while (offSet < arr.length) {
            int min = Integer.MAX_VALUE;
            for (int i = offSet; i < arr.length; i++) {
                // 기존 최소값 보다 작은 값을 찾고 min 에 설정
                if (min > arr[i]) {
                    min = arr[i];
                    minIdx = i;
                }

                // 맨마지막까지 찾았는데 가장 작으면 offSet 값에 입력
                if (i == arr.length - 1) {
                    tmp = arr[offSet];
                    arr[offSet] = min;
                    arr[minIdx] = tmp;
                    offSet++;
                }
            }
        }
    }

    /**
     * 삽입정렬
     *
     * @param arr
     */
    public void insertionSort(int[] arr) {
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