package com.bjlee.loop_sum;

import java.util.stream.IntStream;

public class Solution {
    private final int[] ints;
    private int sumVal;

    public Solution(int[] ints) {
        this.ints = ints;
        this.sumVal = 0;
    }


    public Solution sumForLoop() {
        for (int i = 0; i < ints.length; i++) {
            sumVal += ints[i];
        }

        return this;
    }

    public Solution sumForHalfLoop() {
        for (int i = 0; i < ints.length / 2; i++) {
            sumVal = sumVal + ints[i] + ints[i + ints.length / 2];
        }

        return this;
    }

    public Solution sumForHalfLoop2() {
        for (int i = 0; i < ints.length / 2; i++) {
            sumVal = sumVal + ints[i] + ints[ints.length - i - 1];
        }
        return this;
    }

    public Solution sumForSimple() {
        sumVal = ((ints[0] + ints[ints.length - 1]) * ints[ints.length - 1]) >>> 1;
        return this;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "sumVal=" + sumVal +
                '}';
    }

    public Solution sumStream() {
        sumVal = IntStream.rangeClosed(ints[0], ints[ints.length - 1]).sum();
        return this;
    }
}
