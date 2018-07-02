package com.bjlee.zero_move_right;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class zero_move_right {

    private int[] arr;


    @BeforeEach
    void setUp() {
        arr = new int[]{1, 2, 3, 5, 0, 0, 4, 9, 8};
    }

    @Test
    void zeroMove() {
        int[] newArr = new int[arr.length];
        int j = 0;
        int i = 0;
        int rvIdx = arr.length - 1;
        while (j < arr.length) {
            if(arr[j]!=0) {
                newArr[i++] = arr[j];
            }

            j++;
        }

        // 1. Arrays.stream -> IntStream
        IntStream stream1 = Arrays.stream(newArr);
        stream1.forEach(x -> System.out.println(x));

        // 2. Stream.of -> Stream<int[]>
        Stream<int[]> temp = Stream.of(newArr);

        // Cant print Stream<int[]> directly, convert / flat it to IntStream
        IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
        intStream2.forEach(x -> System.out.println(x));

//        for (i = 0; i < arr.length; i++) {
//            if (arr[i] != 0) {
//                newArr[j] = arr[i];
//                j++;
//            } else {
//                newArr[rvIdx] = arr[i];
//                rvIdx--;
//            }
//        }
    }
}
