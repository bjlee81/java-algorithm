package com.bjlee.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A sortTest")
class SortTest {
    int[] arr;
    Sort sort;

    @BeforeEach
    void setUp() {
        arr = new int[]{3, 7, 8, 5, 2, 1, 9, 6, 4, 0, 124, 543, 12, 26, 42, 10};
        sort = new Sort();
        System.out.println(Arrays.toString(arr));
    }

    @AfterEach
    void tearDown() {
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void quickSort() {
    }

    @Test
    void insertionSort() {
    }

    @Test
    @DisplayName("selection sort!")
    void selectionSort() {
        sort.selectionSort(arr);
    }
}