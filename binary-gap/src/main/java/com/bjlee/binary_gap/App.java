package com.bjlee.binary_gap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        App app = new App();
        int n = 2147483647;
        log.info("number : {}, max binary gap : {}", n, solution(2147483647));

    }

    private static int solution(int i) {
        int maxGap = 0;
        int curGap = 0;

        String binary = Integer.toBinaryString(i);
        log.info(binary);

        char[] chars = binary.toCharArray();
        boolean bMask = false;

        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == '1' && !bMask) {
                // 1이고 mask가 false 이면 gap 시작
                bMask = true;
                curGap = 0;
            } else if (chars[j] == '1' && bMask) {
                if (curGap > maxGap) {
                    maxGap = curGap;
                }
                curGap = 0;
                // 다음이 0이면 초기화
                if ((j + 1 < chars.length) && (chars[j + 1] != '0')) {
                    bMask = false;
                }
            } else if (chars[j] == '0' && bMask) {
                curGap++;

            }
        }

        return maxGap;
    }
}
