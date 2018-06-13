package com.bjlee.two_sum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    private static int[] givenArray = new int[]{2, 7, 11, 15};
    private static int targetNum = 9;

    public static void main(String[] args) {
        try {
            int[] sumIndex = twoSum(givenArray, targetNum);
            for (int aSumIndex : sumIndex) {
                log.info(String.valueOf(aSumIndex));
            }
        } catch (NullPointerException e) {
            log.error(e.toString());
        }
    }

    // case 1
    private static int[] twoSum(int[] nums, int target) {
        int j = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (j == nums.length - 1) {
                break;
            }
            if ((nums[i] + nums[j]) == target && i != j) {
                return new int[]{j, i};
            }

            if (i == nums.length - 1) {
                j++;
                i = 0;
            }
        }
        return new int[]{};
    }

    // case 2. target - given num


}
