package com.bjlee.loop_sum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class loop_sum {

    private int[] ints;
    private int sumVal = 0;
    Solution solution;

    @BeforeEach
    void setUp() {
        ints = new int[50000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }

        solution = new Solution(ints);

        System.out.println(solution.sumForLoop().toString());
    }

    @AfterEach
    void close() {
        sumVal = 0;
    }

    @Test
    void loopFirstTest() {
        System.out.println(solution.sumForLoop().toString());
    }

    @Test
    void loopSecondTest() {
        System.out.println(solution.sumForHalfLoop().toString());
    }

    @Test
    void loopThirdTest() {
        System.out.println(solution.sumForHalfLoop2().toString());
    }

    @Test
    void sumForSimple() {
        System.out.println(solution.sumForSimple().toString());
    }

    @Test
    void loopStreamTest() {
        System.out.println(solution.sumStream().toString());
    }

//    @Test
    void bitTest() {
        byte low = Byte.valueOf("01111111", 2); // The maximum byte value
        byte high = low; // This copies low.

        byte sum = (byte) (low + high); // The bit representation of this is 11111110, which, having a
        // leading 1, is negative. Consider this the worst case
        // overflow, since low and high can't be any larger.

        // 이동에 따른 빈공간을 모두 0으로 체움
        short mid = (short) (sum >>> 1); // This correctly gives us 01111111, fixing the overflow.

        System.out.println(sum / 2);
        System.out.println(mid);

        System.out.println(2 << 1); //4출력
        System.out.println(2 << 2); //8출력
        System.out.println(2 << 3); //16출력

        System.out.println(4 >> 1); //2출력
        System.out.println(4 >> 2); //1출력
    }


}
